package eu.side.thomaspiron.android.adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.api.ApiClient;
import eu.side.thomaspiron.android.model.Apartment;
import eu.side.thomaspiron.android.model.BaseModel;
import eu.side.thomaspiron.android.model.EplMedia;
import eu.side.thomaspiron.android.model.Maison;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static eu.side.thomaspiron.android.services.ApiCallService.apiClient;

/**
 * Created by mdupierreux1 on 5/08/15.
 */
public class ApartmentsRecyclerAdapter extends RecyclerView.Adapter<ApartmentsRecyclerAdapter.ViewHolder> implements View.OnClickListener {
    private static String LOG_TAG = RecyclerViewAdapter.class.getSimpleName();
    private List<Apartment> items;
    private OnItemClickListener onItemClickListener;
    private Context context;
    private boolean viewList;

    public ApartmentsRecyclerAdapter(List<Apartment> items, Context context, boolean viewType) {
        this.items = items;
        this.context = context;
        this.viewList = viewType;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutType = viewList ? R.layout.ensemble_list_item : R.layout.cardview_ensemble_list;
        View v = LayoutInflater.from(parent.getContext()).inflate(layoutType, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(final ViewHolder holder, int position) {
        final Apartment item = items.get(position);
        holder.text.setText(item.getLibCommercialFr() != null ? item.getLibCommercialFr() : "");
        holder.textDesc.setText(item.getPostLoc() + " - "+item.getAdresse());
        holder.textToSell.setText(Utility.formatItemsApartmentsSingleLine(item, context));
        if(item.getDtDebRemise() != null && item.getDtFinRemise() != null && System.currentTimeMillis() >= item.getDtDebRemise() && System.currentTimeMillis() <= item.getDtFinRemise()) {
            holder.textLibelleRemise.setText(item.getLibelleRemise());
            holder.textLibelleRemise.setVisibility(View.VISIBLE);
        }
        else{
            holder.textLibelleRemise.setVisibility(View.INVISIBLE);
        }
        if(item.getDtDebNouveau() != null && item.getDtFinNouveau() != null &&  item.getDtDebNouveau() <= System.currentTimeMillis() && item.getDtFinNouveau() >= System.currentTimeMillis()){
            holder.ivNew.setVisibility(View.VISIBLE);
        }
        else{
            holder.ivNew.setVisibility(View.GONE);
        }

        if(item.getInfoPorteOuverte() != null && !item.getInfoPorteOuverte().isEmpty() && item.getDtFinPorteOuverte() >= System.currentTimeMillis()){
            holder.textPorte.setVisibility(View.VISIBLE);
        }
        else{
            holder.textPorte.setVisibility(View.GONE);
        }
        holder.image.setImageBitmap(null);

        if (apiClient == null) {
            apiClient = new ApiClient();
        }
        apiClient.getEplMediaReference("800", item.getCptEpl(), "MEDIA", new Callback<List<EplMedia>>() {
            @Override
            public void onResponse(Call<List<EplMedia>> call, Response<List<EplMedia>> response) {
                Picasso.with(context)
                        .load(response.body().get(0).getUrl()).into(holder.image);

            }

            @Override
            public void onFailure(Call<List<EplMedia>> call, Throwable throwable) {

            }
        });

        //Picasso.with(holder.image.getContext()).load(item.getImage()).into(holder.image);
        holder.itemView.setTag(item);
    }

    @Override public int getItemCount() {
        return items.size();
    }

    @Override public void onClick(final View v) {
        // Give some time to the ripple to finish the effect
        if (onItemClickListener != null) {
            new Handler().postDelayed(new Runnable() {
                @Override public void run() {
                    onItemClickListener.onItemClick(v, (Apartment) v.getTag());
                }
            }, 200);
        }
    }

    public void setData(List<Apartment> data) {
        if (data != null) {
            items = data;
        }
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public ImageView ivNew;
        public TextView text;
        public TextView textDesc;
        public TextView textToSell;
        public TextView textLibelleRemise;
        public TextView textPorte;
        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.card_thumbnail_image);
            text = (TextView) itemView.findViewById(R.id.info_text);
            textDesc = (TextView) itemView.findViewById(R.id.desc_text);
            textToSell = (TextView) itemView.findViewById(R.id.tosell_text);
            textLibelleRemise = (TextView)itemView.findViewById(R.id.libelle_remise_text);
            textPorte = (TextView)itemView.findViewById(R.id.tv_portes);
            ivNew = (ImageView)itemView.findViewById(R.id.iv_nouveau);
        }
    }

    public interface OnItemClickListener {

        void onItemClick(View view, Apartment viewModel);

    }
}
