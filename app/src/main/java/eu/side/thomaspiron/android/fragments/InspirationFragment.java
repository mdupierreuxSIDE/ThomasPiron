package eu.side.thomaspiron.android.fragments;


import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import org.w3c.dom.Text;

import java.util.List;

import de.greenrobot.event.EventBus;
import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.ThomasPironApplication;
import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.adapters.InspirationRecyclerAdapter;
import eu.side.thomaspiron.android.events.InspirationsSyncedEvent;
import eu.side.thomaspiron.android.loaders.APLoader;
import eu.side.thomaspiron.android.model.APModele;
import eu.side.thomaspiron.android.services.ApiCallService;

/**
 * A simple {@link Fragment} subclass.
 */
public class InspirationFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<APModele>>, SwipeRefreshLayout.OnRefreshListener {
    public static final String ARG_PRICE_MIN = "ARG_PRICE_MIN";
    public static final String ARG_PRICE_MAX = "ARG_PRICE_MAX";
    private static final String ARG_PRICE_CAT = "ARG_PRICE_CAT";
    private static final String LOG_TAG = InspirationFragment.class.getSimpleName();


    private String priceMax, priceMin;
    private RecyclerView recyclerView;
    private InspirationRecyclerAdapter inspirationRecyclerAdapter;
    private List<APModele> apmodeles;
    private int mPriceCat;
    private Tracker mTracker;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public static InspirationFragment newInstance(String priceMin, String priceMax, int priceCat) {
        Bundle args = new Bundle();
        args.putString(ARG_PRICE_MIN, priceMin);
        args.putString(ARG_PRICE_MAX, priceMax);
        args.putInt(ARG_PRICE_CAT, priceCat);
        InspirationFragment fragment = new InspirationFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public InspirationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        priceMin = getArguments().getString(ARG_PRICE_MIN);
        priceMax = getArguments().getString(ARG_PRICE_MAX);
        mPriceCat = getArguments().getInt(ARG_PRICE_CAT);
        ThomasPironApplication application = (ThomasPironApplication) getActivity().getApplication();
        mTracker = application.getDefaultTracker();

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
        mTracker.setScreenName("Fragment : " + LOG_TAG+ " Price cat : "+mPriceCat);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_inspiration, container, false);
        initSwipeRefreshLayout(rootView);
        return rootView;
    }

    private void initSwipeRefreshLayout(View v) {
        mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.activity_main_swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();
        getActivity().getSupportLoaderManager().initLoader(4 + mPriceCat, null, this);
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.recycler);
        if ((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE) {
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));
        }
        else{
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 1));
        }
        inspirationRecyclerAdapter = new InspirationRecyclerAdapter(apmodeles,getActivity().getApplicationContext());
        recyclerView.setAdapter(inspirationRecyclerAdapter);
        Log.d(LOG_TAG, "In initRecyclerView");
    }

    @Override
    public Loader<List<APModele>> onCreateLoader(int id, Bundle args) {
        Log.d(LOG_TAG, "onCreateLoader");
        return new APLoader(getActivity().getApplicationContext(),mPriceCat);
    }

    @Override
    public void onLoadFinished(Loader<List<APModele>> loader, List<APModele> data) {
        for (int i = 0 ; i < data.size(); i++){
            Log.d(LOG_TAG,"onLoadFinished : "+ data.get(i).getNumero());
        }
        inspirationRecyclerAdapter.setData(data);
        inspirationRecyclerAdapter.notifyDataSetChanged();
        if(mSwipeRefreshLayout != null)mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onLoaderReset(Loader<List<APModele>> loader) {
        Log.d(LOG_TAG, "onLoaderReset");
        inspirationRecyclerAdapter.setData(null);
    }

    public void onEvent(InspirationsSyncedEvent event){
        Log.d(LOG_TAG,"onEvent");
        getLoaderManager().restartLoader(4 + mPriceCat, null, this);
    }

    @Override
    public void onRefresh() {
        Intent serviceIntent = new Intent(getActivity(), ApiCallService.class);
        getActivity().startService(serviceIntent);
    }
}
