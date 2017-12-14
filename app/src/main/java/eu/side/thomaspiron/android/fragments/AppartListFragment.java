package eu.side.thomaspiron.android.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import de.greenrobot.event.EventBus;
import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.ThomasPironApplication;
import eu.side.thomaspiron.android.Utility.Const;
import eu.side.thomaspiron.android.Utility.PrefUtils;
import eu.side.thomaspiron.android.activities.EnsembleDetailActivity;
import eu.side.thomaspiron.android.activities.MapsActivity;
import eu.side.thomaspiron.android.adapters.ApartmentsRecyclerAdapter;
import eu.side.thomaspiron.android.decorators.DividerItemDecoration;
import eu.side.thomaspiron.android.events.ApartmentsSyncedEvent;
import eu.side.thomaspiron.android.loaders.AppartLoader;
import eu.side.thomaspiron.android.model.Apartment;
import eu.side.thomaspiron.android.services.ApiCallService;
import eu.side.thomaspiron.android.spinner.NiceSpinner;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppartListFragment extends Fragment implements ApartmentsRecyclerAdapter.OnItemClickListener,
        LoaderManager.LoaderCallbacks<List<Apartment>>, AdapterView.OnItemSelectedListener, SwipeRefreshLayout.OnRefreshListener, MaterialSearchView.OnQueryTextListener, MaterialSearchView.SearchViewListener {

    private static String LOG_TAG = AppartListFragment.class.getSimpleName();
    private static int APPARTS_LOADER_ID = 1;


    private int typeLot;
    private RecyclerView recyclerView;
    private List<Apartment> apartments = new ArrayList<>();

    private ApartmentsRecyclerAdapter apartmentsRecyclerAdapter;
    private Tracker mTracker;
    private String mProvince = "";
    private TextView tvNoData;
    private DividerItemDecoration divider;
    private LinkedList<String> dataset;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    //searchview
    public MaterialSearchView searchView;
    private String mSearchText;

    public AppartListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST);
        ThomasPironApplication application = (ThomasPironApplication) getActivity().getApplication();
        mTracker = application.getDefaultTracker();
        setHasOptionsMenu(true);
        PrefUtils.setSearchtext(getContext(),"");
        //PrefUtils.setDefaultScreen(getContext(), R.id.drawer_apparts);


    }

    @Override
    public void onStart() {
        super.onStart();
        PrefUtils.setDefaultScreen(getContext(), 1);
        EventBus.getDefault().register(this);
        getLoaderManager().initLoader(APPARTS_LOADER_ID, null, this);


    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(LOG_TAG, "Setting screen name: " + LOG_TAG);
        mTracker.setScreenName("Fragment :" + LOG_TAG);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //EventBus.getDefault().register(this);
        View v = inflater.inflate(R.layout.fragment_appart_list, container, false);
        //View v = inflater.inflate(R.layout.fragment_list_appart_w_search, container, false);
        NiceSpinner niceSpinner = (NiceSpinner) v.findViewById(R.id.nice_spinner);
        if(niceSpinner != null) {
            niceSpinner.attachDataSource(Const.PROVINCES);
            niceSpinner.setOnItemSelectedListener(this);
            niceSpinner.setSelectedIndex(PrefUtils.getProvinceFilter(getContext()));
        }


        //PrefUtils.setProvinceFilter(getContext(), 0);
        //getLoaderManager().restartLoader(APPARTS_LOADER_ID, null, this);
        initSwipeRefreshLayout(v);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initSearchView(view);
        initRecyclerView();
        tvNoData = (TextView) view.findViewById(R.id.empty_view);
    }

    private void initSearchView(View view) {
        searchView = (MaterialSearchView)getActivity().findViewById(R.id.search_view);
        if(searchView != null) {
            searchView.setOnQueryTextListener(this);
            searchView.setOnSearchViewListener(this);
            searchView.setVoiceSearch(false);
            searchView.setEllipsize(true);
            searchView.setHint("Localité");
            //searchView.setSuggestions(Const.PROVINCES.toArray(new String[Const.PROVINCES.size()]));
        }
    }

    private void initSwipeRefreshLayout(View v){
        mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.activity_main_swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_fragment_ensembles, menu);
        if (getActivity() != null) {
            SharedPreferences prefs = getActivity().getSharedPreferences("VIEW", Context.MODE_PRIVATE);
            Boolean viewList = prefs.getBoolean("VIEW_LIST", true);
            if (!viewList) {//si c'était liste -> on doit changer l'icone
                menu.findItem(R.id.viewType).setIcon(R.drawable.ic_view_list_white_24dp);
            } else {
                menu.findItem(R.id.viewType).setIcon(R.drawable.ic_view_module_white_24dp);
            }
            MenuItem item = menu.findItem(R.id.action_search);
            searchView.setMenuItem(item);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.viewType:
                SharedPreferences prefs = getActivity().getSharedPreferences("VIEW",Context.MODE_PRIVATE);
                Boolean viewList = prefs.getBoolean("VIEW_LIST",true);
                if(viewList){//si c'était liste -> on doit changer l'icone
                    item.setIcon(R.drawable.ic_view_list_white_24dp);
                }
                else{
                    item.setIcon(R.drawable.ic_view_module_white_24dp);
                }
                prefs.edit().putBoolean("VIEW_LIST",!viewList).commit();
                configureRecyclerViewItems(recyclerView, !viewList);
                break;
            case R.id.action_maps:
                Intent intent = new Intent(getActivity().getApplicationContext(),MapsActivity.class);
                intent.putExtra(Const.INTENT_MAPS_IS_HOUSE,false);
                getActivity().startActivity(intent);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.recycler);
        SharedPreferences prefs = getActivity().getSharedPreferences("VIEW", Context.MODE_PRIVATE);
        Boolean showList = prefs.getBoolean("VIEW_LIST", true);
        configureRecyclerViewItems(recyclerView, showList);


        Log.d(LOG_TAG, "In initRecyclerView");
    }

    private void configureRecyclerViewItems(RecyclerView recyclerView, Boolean viewList){

        if(viewList){
            recyclerView.addItemDecoration(divider);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        }
        else{
            recyclerView.removeItemDecoration(divider);
            if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >
                    Configuration.SCREENLAYOUT_SIZE_XLARGE) {

                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
            }
            else{
                if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >=
                        Configuration.SCREENLAYOUT_SIZE_LARGE){
                    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                }
                else {
                    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
                }
            }
        }
        apartmentsRecyclerAdapter = new ApartmentsRecyclerAdapter(apartments,getActivity().getApplicationContext(),viewList);
        apartmentsRecyclerAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(apartmentsRecyclerAdapter);

    }




    private String getProvince(){
        int position = PrefUtils.getProvinceFilter(getContext());
        switch (position){
            case 0:
                mProvince = "";
                break;
            default:
                mProvince = Const.PROVINCES.get(position);
                break;
        }
        return mProvince;
    }

    private String getSearchText(){
        return PrefUtils.getSearchText(getContext());
    }


    @Override
    public void onItemClick(View view, Apartment viewModel) {
        EnsembleDetailActivity.navigateToAppart((AppCompatActivity) getActivity(), view.findViewById(R.id.card_thumbnail_image), viewModel);
    }

    @Override
    public Loader<List<Apartment>> onCreateLoader(int id, Bundle args) {
        return new AppartLoader(getActivity().getApplicationContext(),getProvince(),getSearchText());
    }

    @Override
    public void onLoadFinished(Loader<List<Apartment>> loader, List<Apartment> data) {
        if(data.size() == 0){
            mSwipeRefreshLayout.setVisibility(View.GONE);
            tvNoData.setVisibility(View.VISIBLE);
            if (mProvince.equals("")){
                tvNoData.setText("Chargement...");
            }
            else{
                tvNoData.setText("Pas d\'appartements en province de "+mProvince);
            }
        }
        else {
            apartments = data;
            mSwipeRefreshLayout.setVisibility(View.VISIBLE);
            tvNoData.setVisibility(View.GONE);
            apartmentsRecyclerAdapter.setData(data);
            apartmentsRecyclerAdapter.notifyDataSetChanged();
        }
        if(mSwipeRefreshLayout != null) mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoaderReset(Loader<List<Apartment>> loader) {
        apartmentsRecyclerAdapter.setData(null);
    }

    public void onEvent(ApartmentsSyncedEvent event){
        Log.d(LOG_TAG, "onEvent");
        getLoaderManager().restartLoader(APPARTS_LOADER_ID, null, this);
        if(mSwipeRefreshLayout != null) mSwipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        PrefUtils.setProvinceFilter(getContext(),position);
        getLoaderManager().restartLoader(APPARTS_LOADER_ID, null, this);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onRefresh() {
        Intent serviceIntent = new Intent(getActivity(), ApiCallService.class);
        getActivity().startService(serviceIntent);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        PrefUtils.setSearchtext(getContext(),query);
        getLoaderManager().restartLoader(APPARTS_LOADER_ID,null,this);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        PrefUtils.setSearchtext(getContext(),newText);
        getLoaderManager().restartLoader(APPARTS_LOADER_ID,null,this);
        return false;
    }

    @Override
    public void onSearchViewShown() {

    }

    @Override
    public void onSearchViewClosed() {

    }
}
