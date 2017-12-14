package eu.side.thomaspiron.android.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.adapters.MediaRecyclerAdapter;
import eu.side.thomaspiron.android.api.ApiClient;
import eu.side.thomaspiron.android.model.EplMedia;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static eu.side.thomaspiron.android.services.ApiCallService.apiClient;

public class MediaGridActivity extends AppCompatActivity implements MediaRecyclerAdapter.OnItemClickListener, Callback<List<EplMedia>> {

    private List<String> urls;
    private MediaRecyclerAdapter adapter;
    private RecyclerView rvImages;
    private String cptepl;

    public static void navigateToMedia(AppCompatActivity appCompatActivity, String cptepl, Integer nbMedias, Integer nbPlans){
        Intent intent = new Intent(appCompatActivity, MediaGridActivity.class);
        intent.putExtra("CPT_EPL",cptepl);
        intent.putExtra("NB_MEDIAS",nbMedias);
        intent.putExtra("NB_PLANS",nbPlans);
        ActivityCompat.startActivity(appCompatActivity, intent, null);
    }

    public static void navigateToMediaAP(Context context, String client){
        Intent intent = new Intent(context,MediaGridActivity.class);
        intent.putExtra("AP", client);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_grid);

        initToolbar();
        rvImages = (RecyclerView) findViewById(R.id.recycler);
        urls = new ArrayList<>();
        cptepl = getIntent().getStringExtra("CPT_EPL");
        /*if (cptepl != null && !cptepl.isEmpty()) {
            urls = Utility.getListMediasPlansLot(cptepl, getIntent().getIntExtra("NB_MEDIAS", 0), getIntent().getIntExtra("NB_PLANS", 0));
        }*/
        String apClient = getIntent().getStringExtra("AP");
        /*if (apClient != null && !apClient.isEmpty()){
            urls = Utility.getAPFacades(apClient);
        }*/

        urls = new LinkedList<>();

        if (apiClient == null) {
            apiClient = new ApiClient();
        }
        apiClient.getEplMedia("1200", cptepl,"MEDIA", this);

        rvImages.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        //rvImages.setLayoutManager(new StaggeredGridLayoutManager(2,GridLayoutManager.VERTICAL));
        adapter = new MediaRecyclerAdapter(urls);

        rvImages.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Images");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onItemClick(View view, String viewModel) {
        MediaDetailActivity.navigateToMedia(this,viewModel);
    }

    @Override
    public void onResponse(Call<List<EplMedia>> call, Response<List<EplMedia>> response) {
        for (EplMedia eplMedia : response.body()) {
            urls.add(eplMedia.getUrl());
        }
        adapter.setData(urls);
        if (response.body().size() > 0 && response.body().get(0).getType().equals("MEDIA"))
            apiClient.getEplMedia("1200",cptepl,"PLANIMPL", this);

    }

    @Override
    public void onFailure(Call<List<EplMedia>> call, Throwable throwable) {

    }
}
