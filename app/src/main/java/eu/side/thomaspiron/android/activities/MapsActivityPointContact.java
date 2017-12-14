package eu.side.thomaspiron.android.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.Utility.Const;
import eu.side.thomaspiron.android.Utility.PermissionUtils;
import eu.side.thomaspiron.android.loaders.AppartLoader;
import eu.side.thomaspiron.android.loaders.MaisonLoader;
import eu.side.thomaspiron.android.loaders.PointContactLoader;
import eu.side.thomaspiron.android.model.Apartment;
import eu.side.thomaspiron.android.model.Maison;
import eu.side.thomaspiron.android.model.PointContact;

public class MapsActivityPointContact extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnInfoWindowClickListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,LocationListener {

    private static final int POINT_CONTACT_LOADER_ID = 11;
    private static final int MY_LOCATION_REQUEST_CODE = 1;
    private String mFilter = "";
    private GoogleMap gMap;
    private boolean mPermissionDenied;
    private RecyclerView mRecyclerView;
    private ArrayList<PointContactMarker> markers;
    private String mTypePC;

    private LoaderManager.LoaderCallbacks<List<PointContact>> pcLoaderListener = new LoaderManager.LoaderCallbacks<List<PointContact>>() {
        @Override
        public Loader<List<PointContact>> onCreateLoader(int id, Bundle args) {
            return new PointContactLoader(getApplicationContext(), mTypePC);
        }

        @Override
        public void onLoadFinished(Loader<List<PointContact>> loader, List<PointContact> data) {
            if (gMap != null) {
                deleteMarkers();
                markers = new ArrayList<>();
                for (PointContact pointContact : data) {
                    if (pointContact.getLatitude() != 0 && pointContact.getLongitude() != 0) {
                        Marker marker = gMap.addMarker(new MarkerOptions()
                                .position(new LatLng(pointContact.getLatitude(), pointContact.getLongitude()))
                                .title(pointContact.getTypePointContact() + " à "+ pointContact.getTitre())
                                .icon(BitmapDescriptorFactory
                                        .fromResource(R.drawable.icon_point_contact)));
                        markers.add(new PointContactMarker(marker, pointContact, marker.getId()));
                    }
                }
            }
        }

        @Override
        public void onLoaderReset(Loader<List<PointContact>> loader) {

        }
    };
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private LocationRequest mLocationRequest;
    private Marker mCurrLocation;
    private Tracker mTracker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        initToolbar();
        mTypePC = getIntent().getStringExtra(Const.INTENT_MAPS_IS_HOUSE);
        initMap();
    }


    public void initMap() {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext()) == ConnectionResult.SUCCESS) {
            MapFragment map = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
            map.getMapAsync(this);
        }

    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Carte");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_maps, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.filter150km:
                mFilter = "150 km";
                showOrHideMarker(markers, 150);
                getSupportActionBar().setSubtitle(mFilter);
                break;
            case R.id.filter100km:
                mFilter = "100 km";
                showOrHideMarker(markers, 100);
                getSupportActionBar().setSubtitle(mFilter);
                break;
            case R.id.filter75km:
                mFilter = "75 km";
                showOrHideMarker(markers, 75);
                getSupportActionBar().setSubtitle(mFilter);
                break;
            case R.id.filter50km:
                mFilter = "50 km";
                showOrHideMarker(markers, 50);
                getSupportActionBar().setSubtitle(mFilter);
                break;
            case R.id.filter25km:
                mFilter = "25 km";
                showOrHideMarker(markers, 25);
                getSupportActionBar().setSubtitle(mFilter);
                break;
            case R.id.filter10km:
                mFilter = "10 km";
                showOrHideMarker(markers, 10);
                getSupportActionBar().setSubtitle(mFilter);
                break;
            case R.id.filter5km:
                mFilter = "5 km";
                showOrHideMarker(markers, 5);
                getSupportActionBar().setSubtitle(mFilter);
                break;
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        gMap.setOnMyLocationButtonClickListener(this);
        gMap.setOnInfoWindowClickListener(this);
        buildGoogleApiClient();
        mGoogleApiClient.connect();

        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(50.8504500, 4.3487800), (float) 7.5);
        gMap.animateCamera(cameraUpdate);
        getSupportLoaderManager().initLoader(POINT_CONTACT_LOADER_ID, null, pcLoaderListener);

    }

    public void enableMyLocation(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                    mGoogleApiClient);
            gMap.setMyLocationEnabled(true);
            updateLocation();
            mLocationRequest = new LocationRequest();
            mLocationRequest.setInterval(4000); //5 seconds
            mLocationRequest.setFastestInterval(3000); //3 seconds
            mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
            mLocationRequest.setSmallestDisplacement(1000F); //1/10 meter
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

        }
        else{
            PermissionUtils.requestPermission(this, MY_LOCATION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, false);
        }
    }

    public void updateLocation(){
        if(mLastLocation != null) {

            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()), (float) 7.5);
            gMap.animateCamera(cameraUpdate);
        }
    }

    @Override
    public void onLocationChanged(Location location) {

        //remove previous current location marker and add new one at current position
        if (mCurrLocation != null) {
            mCurrLocation.remove();
        }
        updateLocation();


        //If you only need one location, unregister the listener
        if(mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode != MY_LOCATION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            //showMissingPermissionError();
            mPermissionDenied = false;
        }
    }

    /**
     * Displays a dialog with error message explaining that the location permission is missing.
     */
    private void showMissingPermissionError() {
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }

    public void deleteMarkers(){
        gMap.clear();
    }


    public void showOrHideMarker(ArrayList<PointContactMarker> markers, int radius){
        for (PointContactMarker marker : markers){
            marker.getMarker().setVisible(isInRadius(marker.getMarker().getPosition(), radius));
        }
    }

    private boolean isInRadius(LatLng latLng, int radius){
        if (mLastLocation != null){
            Location location = new Location("");
            location.setLatitude(latLng.latitude);
            location.setLongitude(latLng.longitude);
            return mLastLocation.distanceTo(location) <= radius * 1000;
        }
        return true;
    }

    public void buildGoogleApiClient(){
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        PointContactMarker pcMarker = null;
        Boolean find = false;
        for (int i = 0; i < markers.size() && !find; i++) {
            if (markers.get(i).getMarker().getId().equals(marker.getId())) {
                find = true;
                pcMarker = markers.get(i);
            }
        }
        if (pcMarker != null) {
            PointContactDetailActivity.navigate(this, null, pcMarker.getPointContact());
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        enableMyLocation();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    class PointContactMarker{
        private Marker marker;
        private PointContact pointContact;
        private String markerId;

        public PointContactMarker(Marker marker, PointContact pointContact) {
            this.marker = marker;
            this.pointContact = pointContact;
        }

        public PointContactMarker(Marker marker, PointContact pointContact, String markerId) {
            this.marker = marker;
            this.pointContact = pointContact;
            this.markerId = markerId;
        }

        public Marker getMarker() {
            return marker;
        }

        public void setMarker(Marker marker) {
            this.marker = marker;
        }

        public PointContact getPointContact() {
            return pointContact;
        }

        public void setPointContact(PointContact pointContact) {
            this.pointContact = pointContact;
        }

        public String getMarkerId() {
            return markerId;
        }

        public void setMarkerId(String markerId) {
            this.markerId = markerId;
        }
    }

}