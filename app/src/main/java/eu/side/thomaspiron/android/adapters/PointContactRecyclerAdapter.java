package eu.side.thomaspiron.android.adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.model.Maison;
import eu.side.thomaspiron.android.model.PointContact;

/**
 * Created by mdupierreux1 on 1/12/15.
 */
public class PointContactRecyclerAdapter extends RecyclerView.Adapter<PointContactRecyclerAdapter.ViewHolder> implements View.OnClickListener {
    private static String LOG_TAG = PointContactRecyclerAdapter.class.getSimpleName();
    private List<PointContact> items;
    private OnItemClickListener onItemClickListener;
    private Context context;
    private boolean viewList;

    public PointContactRecyclerAdapter(List<PointContact> items, Context context, boolean viewList) {
        this.items = items;
        this.context = context;
        this.viewList = viewList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //cardview_image_text
        int layoutType = viewList ? R.layout.houses_list_cell : R.layout.cardview_image_text;
        View v = LayoutInflater.from(parent.getContext()).inflate(layoutType, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        PointContact item = items.get(position);
        holder.text.setText(item.getTypePointContact() +" à "+ item.getPostLoc());
        holder.textDesc.setText(item.getAdresse());
        holder.image.setImageBitmap(null);
        //if (item.getPermanenceFr() != null) holder.textToSell.setText(Html.fromHtml("<ul>"+item.get()+"</ul>"));
        //Log.d(LOG_TAG, "" + item.getCptEpl());
        /*Glide.with(context)
                .load(Utility.formatImageThumbUrl(item.getCptEpl()))
                .centerCrop()
                .crossFade()
                .into(holder.image);*/
        Picasso.with(context).load(Utility.formatImageThumbPointContact(item.getIdPointContact(),item.getTitre())).
                into(holder.image);
        holder.itemView.setTag(item);
    }

    @Override public int getItemCount() {
        if (items != null) {
            return items.size();
        }
        else{
            return 0;
        }
    }

    @Override public void onClick(final View v) {
        // Give some time to the ripple to finish the effect
        if (onItemClickListener != null) {
            new Handler().postDelayed(new Runnable() {
                @Override public void run() {
                    onItemClickListener.onItemClick(v, (PointContact) v.getTag());
                }
            }, 5);
        }
    }

    public void setData(List<PointContact> data) {
        if (data != null) {
            items = data;
        }
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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

        @Override
        public void onClick(View v) {

        }
    }

    public interface OnItemClickListener {

        void onItemClick(View view, PointContact maison);

    }
}
