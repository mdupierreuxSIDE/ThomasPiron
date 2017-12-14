/*
 * Copyright (C) 2015 Antonio Leiva
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
import com.bumptech.glide.signature.StringSignature;

import java.util.List;
import java.util.UUID;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.model.BaseModel;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements View.OnClickListener {
    private static String LOG_TAG = RecyclerViewAdapter.class.getSimpleName();
    private List<BaseModel> items;
    private OnItemClickListener onItemClickListener;
    private Context context;

    public RecyclerViewAdapter(List<BaseModel> items, Context context) {
        this.items = items;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_image_text, parent, false);
        v.setOnClickListener(this);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        BaseModel item = items.get(position);
        holder.text.setText(item.getText());
        holder.image.setImageBitmap(null);
        Log.d(LOG_TAG,""+item.getImage());
        Glide.with(context)
                .load(item.getImage())
                .centerCrop()
                .crossFade()
                .signature(new StringSignature(UUID.randomUUID().toString()))
                .into(holder.image);
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
                    onItemClickListener.onItemClick(v, (BaseModel) v.getTag());
                }
            }, 200);
        }
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.card_thumbnail_image);
            text = (TextView) itemView.findViewById(R.id.info_text);
        }
    }

    public interface OnItemClickListener {

        void onItemClick(View view, BaseModel viewModel);

    }
}
