package eu.side.thomaspiron.android.activities;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.adapters.AppartPagerAdapter;
import eu.side.thomaspiron.android.api.ApiClient;
import eu.side.thomaspiron.android.fragments.UnitListFragment;
import eu.side.thomaspiron.android.model.Ensemble;
import eu.side.thomaspiron.android.model.Lot;
import eu.side.thomaspiron.android.provider.lots.LotsColumns;
import eu.side.thomaspiron.android.provider.lots.LotsCursor;
import eu.side.thomaspiron.android.provider.lots.LotsSelection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UnitListActivity extends AppCompatActivity implements Callback<List<Lot>> {

    private static final String LOG_TAG = UnitListActivity.class.getSimpleName();
    private UnitListFragment unitListFragment;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private List<String> mListeEtages = new ArrayList<>();

    private String mEnseCode, mSociCode;
    private String mType;

    public static void navigateToLots(AppCompatActivity appCompatActivity, String enseCode,String socicode, String type){
        Intent intent = new Intent(appCompatActivity, UnitListActivity.class);
        intent.putExtra("ENSE_CODE",enseCode);
        intent.putExtra("SOCI_CODE", socicode);
        intent.putExtra("TYPE",type);
        ActivityCompat.startActivity(appCompatActivity, intent, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mEnseCode = getIntent().getStringExtra("ENSE_CODE");
        mSociCode =  getIntent().getStringExtra("SOCI_CODE");
        mType = getIntent().getStringExtra("TYPE");
        loadLots(mEnseCode, mSociCode);

        if(mListeEtages.size() == 1){
            setContentView(R.layout.activity_unit_list_house);
            initFragment();
        }
        else{
            setContentView(R.layout.activity_unit_list_appart);
            initPager();
        }

        initToolbar();
    }

    private void initFragment() {
        UnitListFragment unitListFragment =UnitListFragment.newInstance(mListeEtages.get(0),mEnseCode,mSociCode,0, mType.equals("house"));
        getSupportFragmentManager().beginTransaction().replace(R.id.content, unitListFragment).commit();
    }

    private void loadLots(String enseCode, String socicode){
        //ApiClient.getTpApiClient(getApplicationContext()).getLotsFromEnsembleAsync(enseCode, socicode, this);

        LotsSelection lotsSelection = new LotsSelection();
        lotsSelection.ensecode(enseCode).and().socicode(socicode).groupBy("libelleFR").orderBy(LotsColumns.CODEETAGE + " asc ");
        LotsCursor c = lotsSelection.query(getContentResolver(), new String[]{"libelleFR"});
        while (c.moveToNext()){
            Log.d(LOG_TAG, c.getLibellefr());
            mListeEtages.add(c.getLibellefr());
        }
    }

    private void initPager(){
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new AppartPagerAdapter(getSupportFragmentManager(),
                UnitListActivity.this, mListeEtages,mEnseCode,mSociCode, mType.equals("house")));
        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_unit_list, menu);
        return true;
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
    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Biens");
        }
    }


    @Override
    public void onResponse(Call<List<Lot>> call, Response<List<Lot>> response) {

    }

    @Override
    public void onFailure(Call<List<Lot>> call, Throwable throwable) {
        Snackbar.make(findViewById(R.id.main_content),"Vérifiez votre connexion Internet",Snackbar.LENGTH_LONG).show();
    }
}
