package eu.side.thomaspiron.android.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.activities.ContactActivity;
import eu.side.thomaspiron.android.activities.MainActivity;
import eu.side.thomaspiron.android.activities.MediaGridActivity;
import eu.side.thomaspiron.android.model.APModele;

import static eu.side.thomaspiron.android.R.layout.cardview_inspiration;

/**
 * Created by mdupierreux1 on 18/08/15.
 */
public class InspirationRecyclerAdapter extends RecyclerView.Adapter<InspirationRecyclerAdapter.ViewHolder>{
    private static String LOG_TAG = InspirationRecyclerAdapter.class.getSimpleName();
    private List<APModele> items;
    private Context context;


    public InspirationRecyclerAdapter(List<APModele> items, Context context){
        this.items = items;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(cardview_inspiration, parent, false);
        ViewHolder vh = new ViewHolder(v, new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                int id = view.getId();
                switch (id){
                    case R.id.butto_download_plan:
                        /*String url = Utility.formatDownloadAPPlan(items.get(pos).getNumero_simplifie());
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        v.getContext().startActivity(i);*/

                        Intent intent = new Intent(context,ContactActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_contact);
                        intent.putExtra("SUBJECT", new StringBuilder(Utility.formatAPTitle(items.get(pos).getNumero_simplifie())).toString());
                        intent.putExtra("CPT_EPL",items.get(pos).getNumero_simplifie());
                        intent.putExtra("INSPIRATION",true);
                        String dest;
                        dest = "m.dupierreux@side.eu";
                        intent.putExtra("DEST",dest);
                        v.getContext().startActivity(intent);
                        break;
                    case R.id.butto_share_url:
                        String shareurl =Utility.getShareUrlAP(items.get(pos).getIdAPModele());
                        Intent share = new Intent(android.content.Intent.ACTION_SEND);
                        share.setType("text/plain");

                        // Add data to the intent, the receiving app will decide
                        // what to do with it.
                        share.putExtra(Intent.EXTRA_SUBJECT, "Thomas & Piron");
                        share.putExtra(Intent.EXTRA_TEXT, shareurl);

                        v.getContext().startActivity(Intent.createChooser(share, "Share link!"));
                        break;
                    case R.id.card_thumbnail_image:
                        MediaGridActivity.navigateToMediaAP(v.getContext(),items.get(pos).getClient());
                }
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        APModele apModele = items.get(position);
        holder.tvName.setText(Utility.formatAPTitle(apModele.getNumero_simplifie()));
        Picasso.with(context).load(Utility.formatImageAPThumbUrl(apModele)).into(holder.ivThumb);
    }

    @Override
    public int getItemCount() {
        if (items != null) {
            return items.size();
        }
        else{
            return 0;
        }
    }


    public void setData(List<APModele> data){
        if (data != null){
            items = data;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView ivThumb;
        public TextView tvName;
        public ImageButton buttonDl;
        public ImageButton buttonShare;
        public OnItemClickListener onItemClickListener;

        public ViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            ivThumb = (ImageView) itemView.findViewById(R.id.card_thumbnail_image);
            tvName = (TextView) itemView.findViewById(R.id.info_text);
            buttonDl = (ImageButton) itemView.findViewById(R.id.butto_download_plan);
            buttonDl.setOnClickListener(this);
            buttonShare = (ImageButton) itemView.findViewById(R.id.butto_share_url);
            buttonShare.setOnClickListener(this);
            ivThumb.setOnClickListener(this);
            this.onItemClickListener = onItemClickListener;
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(v,getAdapterPosition());
        }
    }

    public interface OnItemClickListener {

        void onItemClick(View view, int pos);

    }
}
