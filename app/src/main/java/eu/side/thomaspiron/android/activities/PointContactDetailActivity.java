package eu.side.thomaspiron.android.activities;

import android.Manifest;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.transition.Slide;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.util.Util;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.lang.reflect.Array;
import java.util.List;

import de.greenrobot.event.EventBus;
import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.ThomasPironApplication;
import eu.side.thomaspiron.android.Utility.PermissionUtils;
import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.adapters.SlidingImageAdapter;
import eu.side.thomaspiron.android.events.LotsSyncedEvent;
import eu.side.thomaspiron.android.model.PointContact;

/**
 * Created by mdupierreux1 on 1/12/15.
 */
public class PointContactDetailActivity extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback {

    private static final String EXTRA_IMAGE = "eu.side.thomaspiron.android.extraImage";
    private static final String EXTRA_TITLE = "eu.side.thomaspiron.android.extraTitle";
    private static final String EXTRA_ENSECODE = "eu.side.thomaspiron.andorid.extraEnseCode";
    private static final String EXTRA_SOCICODE = "eu.side.thomaspiron.andorid.extraSociCode";
    private static final String EXTRA_ADRESS = "eu.side.thomaspiron.andorid.extraAddress";
    private static final String LOG_TAG = PointContactDetailActivity.class.getSimpleName();
    private static final String EXTRA_TYPE = "eu.side.thomaspiron.andorid.extraType";
    private static final String EXTRA_TEL = "eu.side.thomaspiron.andorid.extraTel";
    private static final String EXTRA_OUVERTURE = "eu.side.thomaspiron.andorid.extraOuverture";
    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 0;
    private static final int MY_LOCATION_REQUEST_CODE = 0;
    private static final String EXTRA_LAT = "lat";
    private static final String EXTRA_LON = "lon";
    private static final String EXTRA_ID = "id";
    private static final String EXTRA_LOC ="loc";
    private static final String EXTRA_NBMEDIAS = "nbMedias";
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private TextView txtAdresse,txtTel,txtOuv,txtTitle;
    private String enseCode, socicode, mType,cptepl, itemTitle;
    private GoogleMap gMap = null;
    private MapFragment map = null;
    private FloatingActionButton mFAB;
    private Tracker mTracker;
    private String mName;
    private double mLat, mLong;
    private SlidingImageAdapter slidingImageAdapter;
    private int cpt = 0;
    private ViewPager viewPager;
    private int oldDragPosition = 0;
    private Handler handler = new Handler();
    private Animator pagerAnimation;
    private Runnable viewPagerVisibleScroll = new Runnable() {
        @Override
        public void run() {
            if(cpt <= slidingImageAdapter.getCount()-1)
            {
                viewPager.setCurrentItem(cpt, true);
                handler.postDelayed(viewPagerVisibleScroll, 2000);
                cpt++;
            }
            else{
                viewPager.setCurrentItem(0, true);
                handler.postDelayed(viewPagerVisibleScroll, 2000);
                cpt = 0;
            }
        }
    };


    public static void navigate(AppCompatActivity activity, View transitionImage, PointContact pc) {
        Intent intent = new Intent(activity, PointContactDetailActivity.class);
        intent.putExtra(EXTRA_IMAGE, Utility.formatImageThumbPointContact(pc.getIdPointContact(), pc.getPostLoc()));
        intent.putExtra(EXTRA_TITLE,pc.getTypePointContact() +" à "+pc.getTitre() );
        intent.putExtra(EXTRA_ADRESS, pc.getAdresse());
        intent.putExtra(EXTRA_LOC, pc.getTitre());
        intent.putExtra(EXTRA_TEL, pc.getTel());
        intent.putExtra(EXTRA_OUVERTURE, pc.getPermanenceFr());
        intent.putExtra(EXTRA_TYPE, pc.getTypePointContact());
        intent.putExtra(EXTRA_LAT, pc.getLatitude());
        intent.putExtra(EXTRA_LON, pc.getLongitude());
        intent.putExtra(EXTRA_ID, pc.getIdPointContact());
        intent.putExtra(EXTRA_NBMEDIAS,pc.getNbMedias());
        if(transitionImage != null) {
            //ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionImage, EXTRA_IMAGE);
            //ActivityCompat.startActivity(activity, intent, options.toBundle());
            ActivityCompat.startActivity(activity, intent,null);
        }
        else {
            ActivityCompat.startActivity(activity, intent,null);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThomasPironApplication application = (ThomasPironApplication) getApplication();
        mTracker = application.getDefaultTracker();
        itemTitle = getIntent().getStringExtra(EXTRA_TITLE);
        mType = getIntent().getStringExtra(EXTRA_TYPE);
        initActivityTransitions();
        setContentView(R.layout.activity_point_contact_detail);


        //---
        txtTitle = (TextView) findViewById(R.id.title);
        txtAdresse = (TextView) findViewById(R.id.txtAdresse);
        txtTel = (TextView) findViewById(R.id.txtTel);
        txtOuv = (TextView) findViewById(R.id.txtOuv);
        mFAB = (FloatingActionButton) findViewById(R.id.fab);
        fillDescCard();


        ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), EXTRA_IMAGE); //--> TOdo a verifier
        //supportPostponeEnterTransition();

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(itemTitle);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        loadViewPager();

    }

    private void loadViewPager() {
        List<String> urls = Utility.getListImageThumbPointContact(getIntent().getIntExtra(EXTRA_ID, 1)
                , getIntent().getStringExtra(EXTRA_LOC)
                , getIntent().getIntExtra(EXTRA_NBMEDIAS,0));
        slidingImageAdapter = new SlidingImageAdapter(urls.toArray(new String[urls.size()]),getApplicationContext());
        viewPager = (ViewPager)findViewById(R.id.pager);
        cpt = 0;
        viewPager.setAdapter(slidingImageAdapter);
        viewPager.setClipToPadding(false);
        handler.post(viewPagerVisibleScroll);
        //animatePagerTransition(true,slidingImageAdapter.getCount());


        //viewPager.setPageMargin(-550);
        //viewPager.setPadding(0, 0, 1000, 0);
    }

    private void animatePagerTransition(final boolean forward, int pageCount) {
        // if previous animation have not finished we can get exception
        if (pagerAnimation != null) {
            pagerAnimation.cancel();
        }
        pagerAnimation = getPagerTransitionAnimation(forward, pageCount);
        if (viewPager.beginFakeDrag()) {    // checking that started drag correctly
            pagerAnimation.start();
        }
    }

    private Animator getPagerTransitionAnimation(final boolean forward, int pageCount) {
        ValueAnimator animator = ValueAnimator.ofInt(0, viewPager.getWidth() - 1);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                viewPager.endFakeDrag();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                viewPager.endFakeDrag();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                viewPager.endFakeDrag();
                oldDragPosition = 0;
                viewPager.beginFakeDrag();
            }
        });

        animator.setInterpolator(new AccelerateInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int dragPosition = (Integer) animation.getAnimatedValue();
                int dragOffset = dragPosition - oldDragPosition;
                oldDragPosition = dragPosition;
                viewPager.fakeDragBy(dragOffset * (forward ? -1 : 1));
            }
        });

        animator.setDuration(4000 ); // remove divider if you want to make each transition have the same speed as single page transition
        animator.setRepeatCount(pageCount);

        return animator;
    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.i(LOG_TAG, "Setting screen name: " + LOG_TAG);
        mTracker.setScreenName("Activity : " + LOG_TAG + " Interest : " + enseCode);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);


    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (handler!= null) {
            handler.removeCallbacks(viewPagerVisibleScroll);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_ensemble_detail, menu);
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

    private void initActivityTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            Slide transition = new Slide();
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            getWindow().setEnterTransition(transition);
            getWindow().setReturnTransition(transition);
        }
    }



    private void fillDescCard(){
        txtTitle.setText(itemTitle);
        txtAdresse.setText(getIntent().getStringExtra(EXTRA_ADRESS));
        if (getIntent().getStringExtra(EXTRA_OUVERTURE) != null) {
            String permanence = Html.fromHtml(getIntent().getStringExtra(EXTRA_OUVERTURE)).toString();
            txtOuv.setText(Utility.formatMultiLineText(permanence));
        }

        txtTel.setText(Utility.formatTelNumber(getIntent().getStringExtra(EXTRA_TEL)));
        mLat = getIntent().getDoubleExtra(EXTRA_LAT,0);
        mLong = getIntent().getDoubleExtra(EXTRA_LON,0);
        initMap();

        //onFabClick
        mFAB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
               String shareurl = Utility.getSharUrlExpo(getIntent().getIntExtra(EXTRA_ID, 1), getIntent().getStringExtra(EXTRA_LOC),getIntent().getStringExtra(EXTRA_TYPE));
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                    share.setType("text/plain");

                    // Add data to the intent, the receiving app will decide
                    // what to do with it.
                    share.putExtra(Intent.EXTRA_SUBJECT, "Thomas & Piron");
                    share.putExtra(Intent.EXTRA_TEXT, shareurl);

                    startActivity(Intent.createChooser(share, "Share link!"));
                }
            });
    }

    private void initMap() {

        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext())  == ConnectionResult.SUCCESS){
            map = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
            if (map != null) {
                map.getMapAsync(this);
            }
        }
        else{
            Snackbar.make(findViewById(R.id.coordinator), R.string.string_error_no_gms, Snackbar.LENGTH_SHORT).show();
        }
    }
    public void enableMyLocation(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            gMap.setMyLocationEnabled(true);
        }
        else{
            PermissionUtils.requestPermission(this, MY_LOCATION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode != MY_LOCATION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
        } else {
            // Display the missing permission error dialog when the fragments resume.
            // mPermissionDenied = true;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
           default:
               break;

        }
    }

    public void onEvent(LotsSyncedEvent event){
        if (!event.getMessage().isEmpty()) {
            Snackbar.make(findViewById(R.id.coordinator), "Erreur de connexion", Snackbar.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        if (gMap != null){
            gMap.getUiSettings().setMyLocationButtonEnabled(true);
            MapsInitializer.initialize(this);
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(mLat, mLong), 14);
            gMap.animateCamera(cameraUpdate);
            Marker m = gMap.addMarker(new MarkerOptions()
                    .position(new LatLng(mLat, mLong))
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.icon_point_contact))
                    .title(mName));
        }
    }
}
