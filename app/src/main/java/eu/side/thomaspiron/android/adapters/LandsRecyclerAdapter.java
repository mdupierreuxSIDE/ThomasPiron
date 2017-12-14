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

import com.squareup.picasso.Picasso;

import java.util.List;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.model.Land;

/**
 * Created by mdupierreux1 on 5/08/15.
 */
public class LandsRecyclerAdapter extends RecyclerView.Adapter<LandsRecyclerAdapter.ViewHolder> implements View.OnClickListener {
    private static String LOG_TAG = RecyclerViewAdapter.class.getSimpleName();
    private boolean viewList;
    private List<Land> items;
    private OnItemClickListener onItemClickListener;
    private Context context;


    public LandsRecyclerAdapter(List<Land> items, Context context, boolean viewType) {
        this.items = items;
        this.context = context;
        this.viewList = viewType;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutType = viewList ? R.layout.houses_list_cell : R.layout.cardview_image_text;
        View v = LayoutInflater.from(parent.getContext()).inflate(layoutType, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        Land item = items.get(position);
        holder.text.setText(item.getLibCommercialFr());
        holder.textDesc.setText(item.getPostLoc() + " - "+item.getAdresse());
        holder.textToSell.setText(Utility.formatItemsLands(item, context));
        holder.image.setImageBitmap(null);
        Log.d(LOG_TAG, "" + item.getCptEpl());
        Picasso.with(context).load(Utility.formatImageThumbUrl(item.getCptEpl())).into(holder.image);
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
                    onItemClickListener.onItemClick(v, (Land) v.getTag());
                }
            }, 200);
        }
    }

    public void setData(List<Land> data) {
        if (data != null) {
            items = data;
        }
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;
        public TextView textDesc;
        public TextView textToSell;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.card_thumbnail_image);
            text = (TextView) itemView.findViewById(R.id.info_text);
            textDesc = (TextView) itemView.findViewById(R.id.desc_text);
            textToSell = (TextView) itemView.findViewById(R.id.tosell_text);
        }
    }

    public interface OnItemClickListener {

        void onItemClick(View view, Land viewModel);

    }
}
