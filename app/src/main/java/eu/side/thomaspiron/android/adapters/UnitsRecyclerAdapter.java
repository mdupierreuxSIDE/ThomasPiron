package eu.side.thomaspiron.android.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import eu.side.thomaspiron.android.Utility.AnalyticsUtility;
import eu.side.thomaspiron.android.Utility.Const;
import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.activities.ContactActivity;
import eu.side.thomaspiron.android.activities.MainActivity;
import eu.side.thomaspiron.android.activities.MediaGridActivity;
import eu.side.thomaspiron.android.model.Land;
import eu.side.thomaspiron.android.model.Lot;

/**
 * Created by mdupierreux1 on 11/08/15.
 */
public class UnitsRecyclerAdapter extends RecyclerView.Adapter<UnitsRecyclerAdapter.ViewHolder> {

    private String LOG_TAG = UnitsRecyclerAdapter.class.getSimpleName();
    private List<Lot> items;
    private Activity context;

    public UnitsRecyclerAdapter(List<Lot> items, Activity context){
        this.items = items;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_unit_list, parent, false);
        return new ViewHolder(v, new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                switch (view.getId()) {
                    case R.id.ibDownload:
                        String subject = Utility.formatSubject(new StringBuilder(items.get(pos).getLotDesc()).append(" - ").append(items.get(pos).getEnsecode()).toString());
                        Intent intent = new Intent(context, ContactActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_contact);
                        intent.putExtra("SUBJECT", subject);
                        intent.putExtra("CPT_EPL", items.get(pos).getCptepl());
                        intent.putExtra("INSPIRATION", false);
                        String dest;
                        if (Integer.parseInt(items.get(pos).getFacades()) == 0) {
                            dest = Const.getMailMR();
                        } else {
                            dest = Const.getMailUN();
                        }
                        intent.putExtra("DEST", dest);
                        v.getContext().startActivity(intent);
                        AnalyticsUtility.getAnalyticsUtility(context).sendEvent("action","contact",subject);
                        break;
                    case R.id.ibImages:
                        MediaGridActivity.navigateToMedia((AppCompatActivity)context, items.get(pos).getCptepl(),items.get(pos).getNbMedias(),items.get(pos).getNbPlansImpl());
                        AnalyticsUtility.getAnalyticsUtility(context).sendEvent("action", "images", items.get(pos).getCptepl());
                        break;
                }
            }
        });

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Lot item = items.get(position);

        if(Integer.parseInt(item.getFacades()) == 0) {
            holder.unitLib.setText(item.getLotDesc().trim()+ " - "+item.getSurfHab() + "m\u00B2" );
            holder.unitDetail.setText("Jardin/Balcon "+item.getBalcon().trim()+ " m\u00B2 - " + item.getChambres()+ " chambre(s)");
        }else{
            holder.unitLib.setText(item.getLotDesc().trim() + " - "+item.getSurfTerrain()+" m\u00B2" );
            holder.unitDetail.setText(item.getFacades()+" façades - Orientation "+item.getOrientation()+"");
        }

        if(item.getStatut().equals("V")){
            holder.unitDispo.setText("VENDU");
            holder.unitDispo.setTextColor(Color.RED);
            holder.btnPlan.setVisibility(View.GONE);
            holder.btnPix.setEnabled(false);
            holder.btnPix.setVisibility(View.GONE);

        }
        if(item.getStatut().equals("R")){
            holder.unitDispo.setText("RESERVE");
            holder.unitDispo.setTextColor(Color.GRAY);
            holder.btnPlan.setEnabled(false);
            holder.btnPlan.setVisibility(View.GONE);

            holder.btnPix.setEnabled(false);
            holder.btnPix.setVisibility(View.GONE);
        }
        if(item.getStatut().equals("") || item.getStatut().equals(" ")){
            holder.unitDispo.setText("DISPONIBLE");
            holder.unitDispo.setTextColor(context.getResources().getColor(R.color.lot_avail));
            holder.btnPlan.setEnabled(true);
            holder.btnPlan.setVisibility(View.VISIBLE);
            if(item.getNbMedias() > 0 || item.getNbPlansImpl() > 0){
                holder.btnPix.setEnabled(true);
                holder.btnPix.setVisibility(View.VISIBLE);
            }

        }

        if (item.getNbMedias() == 0){
            holder.btnPix.setVisibility(View.GONE);
        }
        if (!item.getPebClasseEnergetique().equals("")) {
            String pebUrl = Utility.formatPebUrl(item.getPebClasseEnergetique());
            Log.d(LOG_TAG, pebUrl);
            Picasso.with(context).load(pebUrl).into(holder.ivPeb);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setData(List<Lot> data) {
        if (data != null) {
            items = data;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView unitLib, unitDetail, unitDispo;
        private ImageButton btnPlan, btnPix;
        private ImageView ivPeb;
        public OnItemClickListener onItemClickListener;

        public ViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            unitLib = (TextView)itemView.findViewById(R.id.txtUnitLib);
            unitDetail = (TextView)itemView.findViewById(R.id.txtUnitDetail);
            unitDispo = (TextView)itemView.findViewById(R.id.txtUnitDispo);
            btnPlan = (ImageButton)itemView.findViewById(R.id.ibDownload);
            btnPix = (ImageButton)itemView.findViewById(R.id.ibImages);
            ivPeb = (ImageView) itemView.findViewById(R.id.ivPeb);
            btnPlan.setOnClickListener(this);
            btnPix.setOnClickListener(this);
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
