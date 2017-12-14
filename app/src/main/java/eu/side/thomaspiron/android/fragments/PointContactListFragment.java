package eu.side.thomaspiron.android.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.greenrobot.event.EventBus;
import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.ThomasPironApplication;
import eu.side.thomaspiron.android.Utility.Const;
import eu.side.thomaspiron.android.Utility.PrefUtils;
import eu.side.thomaspiron.android.activities.EnsembleDetailActivity;
import eu.side.thomaspiron.android.activities.MapsActivity;
import eu.side.thomaspiron.android.activities.MapsActivityPointContact;
import eu.side.thomaspiron.android.activities.PointContactDetailActivity;
import eu.side.thomaspiron.android.adapters.HousesRecyclerAdapter;
import eu.side.thomaspiron.android.adapters.PointContactRecyclerAdapter;
import eu.side.thomaspiron.android.decorators.DividerItemDecoration;
import eu.side.thomaspiron.android.events.HousesSyncedEvent;
import eu.side.thomaspiron.android.loaders.MaisonLoader;
import eu.side.thomaspiron.android.loaders.PointContactLoader;
import eu.side.thomaspiron.android.model.Apartment;
import eu.side.thomaspiron.android.model.Land;
import eu.side.thomaspiron.android.model.Maison;
import eu.side.thomaspiron.android.model.PointContact;
import eu.side.thomaspiron.android.services.ApiCallService;
import eu.side.thomaspiron.android.spinner.NiceSpinner;

/**
 * Created by mdupierreux1 on 1/12/15.
 */
public class PointContactListFragment extends Fragment implements PointContactRecyclerAdapter.OnItemClickListener,
        LoaderManager.LoaderCallbacks<List<PointContact>>, AdapterView.OnItemSelectedListener, SwipeRefreshLayout.OnRefreshListener {

    private static final String PROVINCE_FILTER = "pref_province";
    private static String LOG_TAG = PointContactListFragment.class.getSimpleName();
    private static int MAISONS_LOADER_ID = 10;
    private String typePointContact;
    private RecyclerView recyclerView;

    private List<PointContact> pointContacts = new LinkedList<>();

    private PointContactRecyclerAdapter pointContactRecyclerAdapter;
    private Tracker mTracker;
    private TextView tvNoData;

    private String mProvince = "";
    private DividerItemDecoration divider;
    private LinkedList<String> dataset;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public PointContactListFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //getActivity().getLoaderManager().initLoader(MAISONS_LOADER_ID, null, this);
        Log.d(LOG_TAG, "after init loader");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST);
        if (getArguments() != null) {
            typePointContact = getArguments().getString("TYPE_POINT_CONTACT", "Appartement témoin");
        }
        ThomasPironApplication application = (ThomasPironApplication) getActivity().getApplication();
        mTracker = application.getDefaultTracker();
        setHasOptionsMenu(true);
        PrefUtils.setDefaultScreen(getContext(), R.id.drawer_home);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //EventBus.getDefault().register(this);
        //return inflater.inflate(R.layout.fragment_card_recycler, container, false);
        View v = inflater.inflate(R.layout.fragment_list_pointcontact, container, false);
        tvNoData = (TextView) v.findViewById(R.id.empty_view);
        getLoaderManager().initLoader(MAISONS_LOADER_ID, null, this);
        initSwipeRefreshLayout(v);
        return v;
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu_fragment_ensembles, menu);
        SharedPreferences prefs = getActivity().getSharedPreferences("VIEW", Context.MODE_PRIVATE);
        Boolean viewList = prefs.getBoolean("VIEW_LIST", true);
        MenuItem item = menu.findItem(R.id.action_search);
        if(item != null) item.setVisible(false);
        if (!viewList) {//si c'était liste -> on doit changer l'icone
            menu.findItem(R.id.viewType).setIcon(R.drawable.ic_view_list_white_24dp);
        } else {
            menu.findItem(R.id.viewType).setIcon(R.drawable.ic_view_module_white_24dp);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.viewType:
                SharedPreferences prefs = getActivity().getSharedPreferences("VIEW", Context.MODE_PRIVATE);
                Boolean viewList = prefs.getBoolean("VIEW_LIST", true);
                if (viewList) {//si c'était liste -> on doit changer l'icone
                    item.setIcon(R.drawable.ic_view_list_white_24dp);
                } else {
                    item.setIcon(R.drawable.ic_view_module_white_24dp);
                }
                prefs.edit().putBoolean("VIEW_LIST", !viewList).commit();
                configureRecyclerViewItems(recyclerView, !viewList);
                return true;
            case R.id.action_maps:
                Intent intent = new Intent(getActivity().getApplicationContext(), MapsActivityPointContact.class);
                intent.putExtra(Const.INTENT_MAPS_IS_HOUSE, typePointContact);
                getActivity().startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private String getProvince() {
        int position = PrefUtils.getProvinceFilter(getContext());
        switch (position) {
            case 0:
                mProvince = "";
                break;
            default:
                mProvince = Const.PROVINCES.get(position);
                break;
        }
        return mProvince;
    }

    public String checkProvince(String province, boolean checked) {
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        String prefProv = sharedPreferences.getString(PROVINCE_FILTER, "");
        if (!prefProv.equals("")) {
            if (checked) {
                prefProv += "," + province;
            } else {
                prefProv = prefProv.replace(province + ",", "").replace(province, "").replace("(,", "(");
                prefProv = prefProv.replace(province, "");
            }

        } else {
            prefProv = province;
        }
        sharedPreferences.edit().putString(PROVINCE_FILTER, prefProv).commit();
        String filtreProvince = " Province in (" + prefProv + ")";
        return filtreProvince;
    }

    //public String checkAllProvince()

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();

    }

    private void initSwipeRefreshLayout(View v) {
        mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.activity_main_swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.recycler);
        SharedPreferences prefs = getActivity().getSharedPreferences("VIEW", Context.MODE_PRIVATE);
        Boolean showList = prefs.getBoolean("VIEW_LIST", true);
        configureRecyclerViewItems(recyclerView, showList);


        Log.d(LOG_TAG, "In initRecyclerView");
    }

    private void configureRecyclerViewItems(RecyclerView recyclerView, Boolean viewList) {

        if (viewList) {
            recyclerView.addItemDecoration(divider);
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 1));
        } else {
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
        pointContactRecyclerAdapter = new PointContactRecyclerAdapter(pointContacts, getActivity().getApplicationContext(), viewList);
        pointContactRecyclerAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(pointContactRecyclerAdapter);

    }


    @Override
    public void onItemClick(View view, PointContact pc) {
        PointContactDetailActivity.navigate((AppCompatActivity) getActivity(), view.findViewById(R.id.card_thumbnail_image), pc);
    }

    @Override
    public Loader<List<PointContact>> onCreateLoader(int id, Bundle args) {
        Log.d(LOG_TAG, "onCreateLoader");
        return new PointContactLoader(getActivity().getApplicationContext(), typePointContact);
    }

    @Override
    public void onLoadFinished(Loader<List<PointContact>> loader, List<PointContact> data) {
        if (data.size() == 0) {
            tvNoData.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            if (mProvince.equals("")) {
                tvNoData.setText("Chargement...");
            } else {
                tvNoData.setText("Pas de maisons en province de " + mProvince);
            }
        } else {
            pointContacts = data;
            recyclerView.setVisibility(View.VISIBLE);
            tvNoData.setVisibility(View.GONE);
            pointContactRecyclerAdapter.setData(data);
            pointContactRecyclerAdapter.notifyDataSetChanged();
        }

        if (mSwipeRefreshLayout != null) mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoaderReset(Loader<List<PointContact>> loader) {
        Log.d(LOG_TAG, "onLoaderReset");
        pointContactRecyclerAdapter.setData(null);
    }


    public void onEvent(HousesSyncedEvent event) {
        Log.d(LOG_TAG, "onEvent");
        if (event.getErrorMsg().equals("")) {
            getLoaderManager().restartLoader(MAISONS_LOADER_ID, null, this);
        } else {
            Snackbar.make(getView(), R.string.error_bad_network, Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        PrefUtils.setProvinceFilter(getContext(), position);
        getLoaderManager().restartLoader(MAISONS_LOADER_ID, null, this);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onRefresh() {
        Intent serviceIntent = new Intent(getActivity(), ApiCallService.class);
        getActivity().startService(serviceIntent);
    }
}