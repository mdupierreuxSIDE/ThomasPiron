package eu.side.thomaspiron.android.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.Utility.Utility;

public class StreetViewActivity extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback {

    private static final String EXTRA_LAT = "latitude";
    private static final String EXTRA_LONG = "longitude";
    private StreetViewPanoramaFragment streetViewPanoramaFragment;
    private double mLong;
    private double mLat;

    public static void navigate(AppCompatActivity activity,double lat,double longit){
        Intent intent = new Intent(activity, StreetViewActivity.class);
        intent.putExtra(EXTRA_LAT, lat);
        intent.putExtra(EXTRA_LONG,longit);
        ActivityCompat.startActivity(activity, intent, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mLat = getIntent().getDoubleExtra(EXTRA_LAT,0);
        mLong = getIntent().getDoubleExtra(EXTRA_LONG,0);
        initToolbar();
        initStreetView();
    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Street View");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        streetViewPanorama.setPosition(new LatLng(mLat, mLong), 150);
        StreetViewPanoramaLocation loc = streetViewPanorama.getLocation();
    }


    private void initStreetView() {
        streetViewPanoramaFragment = (StreetViewPanoramaFragment) getFragmentManager().findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);
    }
}
