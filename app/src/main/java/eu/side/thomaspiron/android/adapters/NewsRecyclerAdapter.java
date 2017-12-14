package eu.side.thomaspiron.android.adapters;

import android.content.Context;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.model.Apartment;
import eu.side.thomaspiron.android.model.News;

/**
 * Created by mdupierreux1 on 1/12/15.
 */
public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> implements View.OnClickListener {
    private static String LOG_TAG = RecyclerViewAdapter.class.getSimpleName();
    private List<News> items;
    private OnItemClickListener onItemClickListener;
    private Context context;
    private boolean viewList;

    public NewsRecyclerAdapter(List<News> items, Context context, boolean viewType) {
        this.items = items;
        this.context = context;
        this.viewList = viewType;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutType = R.layout.cardview_actus;
        View v = LayoutInflater.from(parent.getContext()).inflate(layoutType, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News item = items.get(position);
        holder.text.setText(item.getTitle());
        holder.textDesc.setText(item.getIntrotext() != null ? Html.fromHtml(item.getIntrotext()) : "");
        Picasso.with(holder.ivNews.getContext()).load(Utility.formatUrlImageNews(item.getImage())).into(holder.ivNews);
        holder.itemView.setTag(item);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onClick(final View v) {
        // Give some time to the ripple to finish the effect
        if (onItemClickListener != null) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    onItemClickListener.onItemClick(v, (News) v.getTag());
                }
            }, 200);
        }
    }

    public void setData(List<News> data) {
        if (data != null) {
            items = data;
        }
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;
        public TextView textDesc;
        public ImageView ivNews;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.info_text);
            textDesc = (TextView) itemView.findViewById(R.id.desc_text);
            ivNews = (ImageView)itemView.findViewById(R.id.card_thumbnail_image);
        }
    }

    public interface OnItemClickListener {

        void onItemClick(View view, News viewModel);

    }
}