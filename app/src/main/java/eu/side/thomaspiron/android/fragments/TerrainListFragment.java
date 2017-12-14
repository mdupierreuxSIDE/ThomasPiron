package eu.side.thomaspiron.android.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.ThomasPironApplication;
import eu.side.thomaspiron.android.activities.EnsembleDetailActivity;
import eu.side.thomaspiron.android.adapters.LandsRecyclerAdapter;
import eu.side.thomaspiron.android.decorators.DividerItemDecoration;
import eu.side.thomaspiron.android.events.HousesSyncedEvent;
import eu.side.thomaspiron.android.loaders.TerrainLoader;
import eu.side.thomaspiron.android.model.BaseModel;
import eu.side.thomaspiron.android.model.Land;

/**
 * A simple {@link Fragment} subclass.
 */
public class TerrainListFragment extends Fragment implements LandsRecyclerAdapter.OnItemClickListener,
        LoaderManager.LoaderCallbacks<List<Land>>{

    private static String LOG_TAG = TerrainLoader.class.getSimpleName();
    private static int TERRAINS_LOADER_ID = 2;

    private RecyclerView recyclerView;
    private List<Land> terrains = new ArrayList<>();

    private LandsRecyclerAdapter landsRecyclerAdapter;
    private Tracker mTracker;
    private String mProvince="";
    private TextView tvNoData;
    private DividerItemDecoration divider;


    public TerrainListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(TERRAINS_LOADER_ID, null, this);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);


    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(LOG_TAG, "Setting screen name: " + LOG_TAG);
        mTracker.setScreenName("Fragment :" + LOG_TAG);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST);
        ThomasPironApplication application = (ThomasPironApplication) getActivity().getApplication();
        mTracker = application.getDefaultTracker();
        setHasOptionsMenu(true);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
     //   EventBus.getDefault().register(this);
        return inflater.inflate(R.layout.fragment_terrain_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();
        tvNoData = (TextView) view.findViewById(R.id.empty_view);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_fragment_ensembles, menu);
        SharedPreferences prefs = getActivity().getSharedPreferences("VIEW",Context.MODE_PRIVATE);
        Boolean viewList = prefs.getBoolean("VIEW_LIST",false);
        if(!viewList){//si c'était liste -> on doit changer l'icone
            menu.findItem(R.id.viewType).setIcon(R.drawable.ic_view_list_white_24dp);
        }
        else{
            menu.findItem(R.id.viewType).setIcon(R.drawable.ic_view_module_white_24dp);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.viewType:
                SharedPreferences prefs = getActivity().getSharedPreferences("VIEW",Context.MODE_PRIVATE);
                Boolean viewList = prefs.getBoolean("VIEW_LIST",false);
                if(viewList){//si c'était liste -> on doit changer l'icone
                    item.setIcon(R.drawable.ic_view_list_white_24dp);
                }
                else{
                    item.setIcon(R.drawable.ic_view_module_white_24dp);
                }
                prefs.edit().putBoolean("VIEW_LIST",!viewList).commit();
                configureRecyclerViewItems(recyclerView, !viewList);
                return  true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.recycler);
        SharedPreferences prefs = getActivity().getSharedPreferences("VIEW", Context.MODE_PRIVATE);
        Boolean showList = prefs.getBoolean("VIEW_LIST", false);
        configureRecyclerViewItems(recyclerView, showList);


        Log.d(LOG_TAG, "In initRecyclerView");
    }

    private void configureRecyclerViewItems(RecyclerView recyclerView, Boolean viewList){

        if(viewList){
            recyclerView.addItemDecoration(divider);
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 1));
        }
        else{
            recyclerView.removeItemDecoration(divider);
            if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >=
                    Configuration.SCREENLAYOUT_SIZE_LARGE) {
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));
            }
            else{
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 1));
            }
        }
        landsRecyclerAdapter = new LandsRecyclerAdapter(terrains,getActivity().getApplicationContext(),viewList);
        landsRecyclerAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(landsRecyclerAdapter);

    }


    @Override
    public Loader<List<Land>> onCreateLoader(int id, Bundle args) {
        return new TerrainLoader(getActivity().getApplicationContext(),mProvince);
    }

    @Override
    public void onLoadFinished(Loader<List<Land>> loader, List<Land> data) {
        if(data.size() == 0){
            recyclerView.setVisibility(View.GONE);
            tvNoData.setVisibility(View.VISIBLE);
            if (mProvince.equals("")){
                tvNoData.setText("Chargement...");
            }
            else{
                tvNoData.setText("Pas de terrains en province de "+mProvince);
            }
        }
        else {
            terrains = data;
            recyclerView.setVisibility(View.VISIBLE);
            tvNoData.setVisibility(View.GONE);
            landsRecyclerAdapter.setData(data);
            landsRecyclerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Land>> loader) {

    }

    @Override
    public void onItemClick(View view, Land viewModel) {
        EnsembleDetailActivity.navigateToTerrain((AppCompatActivity) getActivity(), view.findViewById(R.id.card_thumbnail_image), viewModel);
    }

    public void onEvent(HousesSyncedEvent event){
        Log.d(LOG_TAG, "onEvent");
        getLoaderManager().restartLoader(TERRAINS_LOADER_ID, null, this);
    }
}
