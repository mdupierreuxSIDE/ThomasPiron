package eu.side.thomaspiron.android.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.adapters.ApartmentsRecyclerAdapter;
import eu.side.thomaspiron.android.adapters.NewsRecyclerAdapter;
import eu.side.thomaspiron.android.api.WebsiteApiClient;
import eu.side.thomaspiron.android.decorators.DividerItemDecoration;
import eu.side.thomaspiron.android.model.Apartment;
import eu.side.thomaspiron.android.model.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by mdupierreux1 on 1/12/15.
 */
public class ActuListFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, Callback<List<News>>,NewsRecyclerAdapter.OnItemClickListener {

    private TextView tvNoData;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private DividerItemDecoration divider;
    private List<News> news = new LinkedList<>();
    private NewsRecyclerAdapter newsRecyclerAdapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_actu_list,container,false);
        initSwipeRefreshLayout(v);
        return v;
    }

    private void initSwipeRefreshLayout(View v) {
        mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.activity_main_swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();
        //WebsiteApiClient.getWebsiteApiClient(getContext()).getNewsFromWebsiteAsync(this);
        tvNoData = (TextView) view.findViewById(R.id.empty_view);
    }

    private void initRecyclerView() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.recycler);
        SharedPreferences prefs = getActivity().getSharedPreferences("VIEW", Context.MODE_PRIVATE);
        Boolean showList = prefs.getBoolean("VIEW_LIST", false);
        configureRecyclerViewItems(recyclerView, showList);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuItem item = menu.findItem(R.id.action_maps);
        item.setVisible(false);
        item = menu.findItem(R.id.action_search);
        if(item != null) item.setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onRefresh() {
       // WebsiteApiClient.getWebsiteApiClient(getContext()).getNewsFromWebsiteAsync(this);
    }

    private void configureRecyclerViewItems(RecyclerView recyclerView, Boolean viewList){

        /*if(viewList){
            recyclerView.addItemDecoration(divider);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
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
        }*/
        recyclerView.removeItemDecoration(divider);
        if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_XLARGE) {

            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        }
        else{
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        }
        newsRecyclerAdapter = new NewsRecyclerAdapter(news,getActivity().getApplicationContext(),viewList);
        newsRecyclerAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(newsRecyclerAdapter);

    }


    @Override
    public void onItemClick(View view, News viewModel) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(getResources().getColor(R.color.primary));
        CustomTabsIntent customTabsIntent = builder.build();

        customTabsIntent.launchUrl(getActivity(), Uri.parse("http://www.thomas-piron.eu/fr/actualite/"+viewModel.getAlias()));
    }

    @Override
    public void onResponse(Call<List<News>> call, Response<List<News>> response) {
        newsRecyclerAdapter.setData(response.body());
        newsRecyclerAdapter.notifyDataSetChanged();
        if(mSwipeRefreshLayout != null) mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onFailure(Call<List<News>> call, Throwable throwable) {
        if(mSwipeRefreshLayout != null) mSwipeRefreshLayout.setRefreshing(false);

    }
}
