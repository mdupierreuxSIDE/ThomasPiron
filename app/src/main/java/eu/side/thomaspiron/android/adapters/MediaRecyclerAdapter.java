package eu.side.thomaspiron.android.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import eu.side.thomaspiron.android.R;

/**
 * Created by mdupierreux1 on 31/08/15.
 */
public class MediaRecyclerAdapter extends RecyclerView.Adapter<MediaRecyclerAdapter.ViewHolder> implements View.OnClickListener {

    private List<String> items;
    private OnItemClickListener onItemClickListener;

    public MediaRecyclerAdapter(List<String> items) {
        this.items = items;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.media_item, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }


    @Override public void onBindViewHolder(final ViewHolder holder, int position) {
        String item = items.get(position);
        holder.image.setImageBitmap(null);
       //  holder.itemView.setVisibility(View.GONE);
        Picasso.with(holder.image.getContext()).load(item).into(holder.image);
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
                    onItemClickListener.onItemClick(v, (String) v.getTag());
                }
            }, 200);
        }
    }

    public void setData(List<String> urls) {
        this.items = urls;
        notifyDataSetChanged();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            text = (TextView) itemView.findViewById(R.id.text);
        }
    }

    public interface OnItemClickListener {

        void onItemClick(View view, String viewModel);

    }
}

