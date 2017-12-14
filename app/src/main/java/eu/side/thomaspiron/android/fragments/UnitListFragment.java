package eu.side.thomaspiron.android.fragments;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.ThomasPironApplication;
import eu.side.thomaspiron.android.Utility.AnalyticsUtility;
import eu.side.thomaspiron.android.Utility.PrefUtils;
import eu.side.thomaspiron.android.adapters.RecyclerViewAdapter;
import eu.side.thomaspiron.android.adapters.UnitsRecyclerAdapter;
import eu.side.thomaspiron.android.api.ApiClient;
import eu.side.thomaspiron.android.events.LotsSyncedEvent;
import eu.side.thomaspiron.android.loaders.UnitLoader;
import eu.side.thomaspiron.android.model.APModele;
import eu.side.thomaspiron.android.model.Lot;
import eu.side.thomaspiron.android.provider.lots.LotsColumns;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class UnitListFragment extends Fragment implements Callback<List<Lot>>, LoaderManager.LoaderCallbacks<List<Lot>>{
    private static final String ARG_CODE_ETAGE = "codeetage";
    private static final String ARG_ENSE_CODE = "ensecode";
    private static final String ARG_SOCI_CODE = "socicode";
    private static final String ARG_POSITION = "position";
    private static final String ARG_MAISON = "isMaison";
    private static final int LOT_LOADER_ID = 5;
    private static String LOG_TAG = UnitListFragment.class.getSimpleName();
    private List<Lot> mLots = new ArrayList<>();
    private RecyclerView recyclerView;
    private TextView tvNoData;
    private UnitsRecyclerAdapter unitsRecyclerAdapter;
    private String codeetage, socicode,ensecode;
    private Boolean isMaison = false;
    private int position;
    private String mSortorder;
    private String mFilter;
    private AnalyticsUtility mAnalyticsUtility;
    private ApiClient apiClient;

    public static UnitListFragment newInstance (String codeetage, String enseCode, String sociCode, int position,Boolean isMaison){
        Bundle args = new Bundle();
        args.putString(ARG_CODE_ETAGE, codeetage);
        args.putString(ARG_ENSE_CODE, enseCode);
        args.putString(ARG_SOCI_CODE, sociCode);
        args.putInt(ARG_POSITION, position);
        args.putBoolean(ARG_MAISON,isMaison);
        UnitListFragment fragment = new UnitListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public UnitListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAnalyticsUtility = AnalyticsUtility.getAnalyticsUtility(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_unit_list, container, false);
        setHasOptionsMenu(true);
        ensecode = getArguments().getString(ARG_ENSE_CODE);
        socicode = getArguments().getString(ARG_SOCI_CODE);
        codeetage = getArguments().getString(ARG_CODE_ETAGE);
        position = getArguments().getInt(ARG_POSITION);
        isMaison = getArguments().getBoolean(ARG_MAISON);
        initRecyclerView(rootView);
        tvNoData = (TextView) rootView.findViewById(R.id.empty_view);
        mLots = new ArrayList<>();
        //loadLots(ensecode, socicode);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);


    }

    @Override
    public void onResume() {
        super.onResume();
        AnalyticsUtility.getAnalyticsUtility(getActivity()).sendScreenName(LOG_TAG+ " - "+ensecode);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSortorder = LotsColumns.STATUTLOT + " asc ";
        mFilter = LotsColumns.STATUTLOT + " = ' '";
        getLoaderManager().initLoader(LOT_LOADER_ID + position, null, this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_unit_list, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dispoPremier:
                mSortorder = LotsColumns.STATUTLOT + " asc";
                mFilter = "("+LotsColumns.STATUTLOT + " = ' ' OR "+LotsColumns.STATUTLOT + " = '') ";
                PrefUtils.setUnitsFilter(getContext(),mFilter);
                getLoaderManager().restartLoader(LOT_LOADER_ID + position, null, this);
                AnalyticsUtility.getAnalyticsUtility(getActivity()).sendEvent("action","sort","disponibles");
                break;
            case R.id.venduPremier:
                mSortorder = LotsColumns.STATUTLOT + " desc";
                mFilter = LotsColumns.STATUTLOT + " = 'V'";
                PrefUtils.setUnitsFilter(getContext(),mFilter);
                getLoaderManager().restartLoader(LOT_LOADER_ID + position, null, this);
                AnalyticsUtility.getAnalyticsUtility(getActivity()).sendEvent("action", "sort", "vendus");
                break;
            case R.id.all:
                mSortorder = LotsColumns.STATUTLOT + " asc";
                mFilter = "";
                PrefUtils.setUnitsFilter(getContext(),mFilter);
                getLoaderManager().restartLoader(LOT_LOADER_ID + position, null, this);
                AnalyticsUtility.getAnalyticsUtility(getActivity()).sendEvent("action", "sort", "tous");
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void initRecyclerView(View v){
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 1));
        unitsRecyclerAdapter = new UnitsRecyclerAdapter(mLots,getActivity());
        recyclerView.setAdapter(unitsRecyclerAdapter);
    }





    private void loadLots(String enseCode, String socicode){
        apiClient = new ApiClient();
        apiClient.getLotsFromEnsemble(enseCode,socicode,this);
    }

    @Override
    public Loader<List<Lot>> onCreateLoader(int id, Bundle args) {
        return new UnitLoader(getActivity().getApplicationContext(),codeetage,socicode,ensecode,mSortorder,PrefUtils.getUnitsFilter(getContext()),isMaison);
    }

    @Override
    public void onLoadFinished(Loader<List<Lot>> loader, List<Lot> data) {
        if (data.size() == 0){
            recyclerView.setVisibility(View.GONE);
            tvNoData.setVisibility(View.VISIBLE);
        }
        else{
            recyclerView.setVisibility(View.VISIBLE);
            tvNoData.setVisibility(View.GONE);
            unitsRecyclerAdapter.setData(data);
            unitsRecyclerAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Lot>> loader) {
        //getLoaderManager().restartLoader(LOT_LOADER_ID+position, null, this);
        unitsRecyclerAdapter.setData(null);
    }

    public void onEvent(LotsSyncedEvent event){
        if (event.getMessage().isEmpty()) {
            getLoaderManager().restartLoader(LOT_LOADER_ID + position, null, this);
        }
        else{
            Snackbar.make(getView(),"Erreur de connexion",Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResponse(Call<List<Lot>> call, Response<List<Lot>> response) {
        for(int i = 0 ; i < response.body().size();i++){
            if(response.body().get(i).getLibEtage().equals(codeetage)){
                mLots.add(response.body().get(i));
            }
        }
        unitsRecyclerAdapter.setData(mLots);
        unitsRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(Call<List<Lot>> call, Throwable throwable) {
        Log.d(LOG_TAG, throwable.getMessage()+ " - " + throwable.getCause());
    }
}
