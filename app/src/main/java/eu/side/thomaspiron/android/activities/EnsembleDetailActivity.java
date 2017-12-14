package eu.side.thomaspiron.android.activities;

import android.Manifest;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.transition.Slide;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

import android.support.v7.graphics.Palette;

import org.w3c.dom.Text;

import java.util.LinkedList;
import java.util.List;

import de.greenrobot.event.EventBus;
import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.ThomasPironApplication;
import eu.side.thomaspiron.android.Utility.Const;
import eu.side.thomaspiron.android.Utility.PermissionUtils;
import eu.side.thomaspiron.android.Utility.UlTagHandler;
import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.adapters.SlidingImageAdapter;
import eu.side.thomaspiron.android.api.ApiClient;
import eu.side.thomaspiron.android.carousel.Carousel;
import eu.side.thomaspiron.android.carousel.CarouselImageListener;
import eu.side.thomaspiron.android.events.LotsSyncedEvent;
import eu.side.thomaspiron.android.loaders.EnsembleLoader;
import eu.side.thomaspiron.android.model.Apartment;
import eu.side.thomaspiron.android.model.Ensemble;
import eu.side.thomaspiron.android.model.EplMedia;
import eu.side.thomaspiron.android.model.Land;
import eu.side.thomaspiron.android.model.Maison;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleColumns;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleCursor;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleSelection;
import eu.side.thomaspiron.android.provider.pointcontact.PointcontactCursor;
import eu.side.thomaspiron.android.provider.pointcontact.PointcontactSelection;
import eu.side.thomaspiron.android.services.ApiCallService;
import eu.side.thomaspiron.android.services.SyncLotsService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnsembleDetailActivity extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback
        , LoaderManager.LoaderCallbacks<List<Ensemble>>,OnStreetViewPanoramaReadyCallback, CarouselImageListener, Callback<List<EplMedia>> {

    private static final String EXTRA_IMAGE = "eu.side.thomaspiron.android.extraImage";
    private static final String EXTRA_TITLE = "eu.side.thomaspiron.android.extraTitle";
    private static final String EXTRA_ENSECODE = "eu.side.thomaspiron.andorid.extraEnseCode";
    private static final String EXTRA_SOCICODE = "eu.side.thomaspiron.andorid.extraSociCode";
    private static final String LOG_TAG = EnsembleDetailActivity.class.getSimpleName();
    private static final String EXTRA_TYPE = "eu.side.thomaspiron.andorid.extraType";
    private static final String EXTRA_CPTEPL = "eu.side.thomaspiron.andorid.extraCptEpl";
    private static final int ENSEMBLE_LOADER_ID = 12;
    private static final int MY_LOCATION_REQUEST_CODE = 0;
    private static final String EXTRA_NBMEDIAS = "eu.side.thomaspiron.andorid.extraNbMedias";
    private static final String EXTRA_NBPLANS = "eu.side.thomaspiron.andorid.extraNbPlans";
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private TextView txtDesc,txtNom,txtNbLot,txtSurfTerrain, getTxtSurfTerrainLib,txtNumTel;
    private String enseCode, socicode, mType,cptepl, itemTitle;
    private Button btnUnit,btnMedia, btnContact;
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
    private Handler handler;
    private Animator pagerAnimation;
    private Runnable viewPagerVisibleScroll;
    private StreetViewPanoramaFragment streetViewPanoramaFragment;
    private CardView cardStreet;
    private Button btnNav;
    private Button btnStreet;
    private String[] urlsString;
    private List<Uri> urls;
    private TextView txtMaisonExpo;
    private TextView txtMaisonExpoHoraire;
    private TextView txtMaisonExpoRue;
    private static ApiClient apiClient;


    public static void navigate(AppCompatActivity activity, View transitionImage, Maison maison) {
        Intent intent = new Intent(activity, EnsembleDetailActivity.class);
        intent.putExtra(EXTRA_IMAGE, Utility.formatImageThumbUrl(maison.getCptEpl()));
        intent.putExtra(EXTRA_TITLE, maison.getPostLoc() + " | "+ maison.getAdresse());
        intent.putExtra(EXTRA_ENSECODE,maison.getEnseCode());
        intent.putExtra(EXTRA_SOCICODE,maison.getSociCode());
        intent.putExtra(EXTRA_NBMEDIAS,maison.getNbMedias());
        intent.putExtra(EXTRA_NBPLANS,maison.getNbPlansImpl());
        intent.putExtra(EXTRA_CPTEPL,maison.getCptEpl());
        intent.putExtra(EXTRA_TYPE,"house");
        if(transitionImage != null) {
            //ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionImage, EXTRA_IMAGE);
            //ActivityCompat.startActivity(activity, intent, options.toBundle());
            ActivityCompat.startActivity(activity, intent,null);
        }
        else {
            ActivityCompat.startActivity(activity, intent,null);
        }
    }

    public static void navigateToAppart(AppCompatActivity activity, View transitionImage, Apartment apartment) {
        Intent intent = new Intent(activity, EnsembleDetailActivity.class);
        intent.putExtra(EXTRA_IMAGE, Utility.formatImageThumbUrl(apartment.getCptEpl()));
        intent.putExtra(EXTRA_TITLE, apartment.getPostLoc() + " | "+ apartment.getAdresse());
        intent.putExtra(EXTRA_ENSECODE,apartment.getEnseCode());
        intent.putExtra(EXTRA_SOCICODE,apartment.getSociCode());
        intent.putExtra(EXTRA_NBMEDIAS,apartment.getNbMedias());
        intent.putExtra(EXTRA_NBPLANS,apartment.getNbPlansImpl());
        intent.putExtra(EXTRA_CPTEPL,apartment.getCptEpl());
        intent.putExtra(EXTRA_TYPE, "apart");
        if(transitionImage != null) {
            //ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionImage, EXTRA_IMAGE);
            //ActivityCompat.startActivity(activity, intent, options.toBundle());
            ActivityCompat.startActivity(activity, intent,null);
        }
        else{
            ActivityCompat.startActivity(activity, intent,null);
        }

    }

    public static void navigateToTerrain(AppCompatActivity activity, View transitionImage, Land land) {
        Intent intent = new Intent(activity, EnsembleDetailActivity.class);
        intent.putExtra(EXTRA_IMAGE, Utility.formatImageThumbUrl(land.getCptEpl()));
        intent.putExtra(EXTRA_TITLE, land.getPostLoc() + " | "+ land.getAdresse());
        intent.putExtra(EXTRA_ENSECODE,land.getEnseCode());
        intent.putExtra(EXTRA_SOCICODE,land.getSociCode());
        intent.putExtra(EXTRA_TYPE,"land");
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionImage, EXTRA_IMAGE);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThomasPironApplication application = (ThomasPironApplication) getApplication();
        mTracker = application.getDefaultTracker();
        initActivityTransitions();
        setContentView(R.layout.activity_ensemble_detail);

        itemTitle = getIntent().getStringExtra(EXTRA_TITLE);
        enseCode = getIntent().getStringExtra(EXTRA_ENSECODE);
        socicode = getIntent().getStringExtra(EXTRA_SOCICODE);
        mType = getIntent().getStringExtra(EXTRA_TYPE);
        cptepl = getIntent().getStringExtra(EXTRA_CPTEPL);

        TextView title = (TextView) findViewById(R.id.title);
        title.setText(itemTitle);
        txtNumTel = (TextView) findViewById(R.id.txtTel);
        txtDesc = (TextView) findViewById(R.id.txtEnseDesc);
        txtNbLot = (TextView) findViewById(R.id.txtNbLots);
        txtNom = (TextView) findViewById(R.id.txtNomProj);
        txtSurfTerrain = (TextView) findViewById(R.id.txtSurfTerrain);
        txtMaisonExpo = (TextView) findViewById(R.id.tvMaisonExpo);
        txtMaisonExpoRue = (TextView) findViewById(R.id.tvMaisonExpoRue);
        txtMaisonExpoHoraire = (TextView) findViewById(R.id.tvMaisonExpoHoraire);
        getTxtSurfTerrainLib = (TextView) findViewById(R.id.txtSurfTerrainLib);
        mFAB = (FloatingActionButton) findViewById(R.id.fab);
        fillDescCard();



        //ViewCompat.setTransitionName(findViewById(R.id.app_bar_layout), EXTRA_IMAGE); //--> TOdo a verifier
        //supportPostponeEnterTransition();

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(itemTitle);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        getSupportLoaderManager().initLoader(ENSEMBLE_LOADER_ID, null, this);



    }



    private void loadViewPager() {
        if (apiClient == null) {
            apiClient = new ApiClient();
        }
        apiClient.getEplMedia("1200",cptepl,"MEDIA", this);

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

        animator.setDuration(2000 / pageCount); // remove divider if you want to make each transition have the same speed as single page transition
        animator.setRepeatCount(pageCount);

        return animator;
    }

    private void loadEnsemble(final Ensemble ensemble){
        String libCommercial;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            libCommercial = Html.fromHtml(ensemble.getLibCommercialFr(),Html.FROM_HTML_MODE_LEGACY).toString();
        } else {
            libCommercial = Html.fromHtml(ensemble.getLibCommercialFr()).toString();
        }
        txtNom.setText(libCommercial);
        txtNom.setMovementMethod(LinkMovementMethod.getInstance());
        if (!ensemble.getDescriptionDistanceFR().isEmpty()) {
            String descriptionDistance = ensemble.getDescriptionDistanceFR();
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
               txtDesc.setText((Html.fromHtml(ensemble.getDescriptionDistanceFR(),Html.FROM_HTML_MODE_LEGACY)));
            } else {
                txtDesc.setText(Html.fromHtml(ensemble.getDescriptionDistanceFR()));
            }
            txtDesc.setMovementMethod(LinkMovementMethod.getInstance());

        }
        else{
            txtDesc.setVisibility(View.GONE);
        }
        mLat = ensemble.getLatitude();
        mLong = ensemble.getLongitude();
        mName = ensemble.getEnseDesc();
        TextView tvPorte = (TextView)findViewById(R.id.tvInfoPorte);
        TextView tvRemise = (TextView)findViewById(R.id.libelle_remise_text);
        if(ensemble.getInfoPorteOuverte() != null && !ensemble.getInfoPorteOuverte().isEmpty() && ensemble.getDtFinPorteOuverte() >= System.currentTimeMillis()){
            tvPorte.setText("Portes ouvertes "+ensemble.getInfoPorteOuverte());
            tvPorte.setVisibility(View.VISIBLE);
        }
        else{
            tvPorte.setVisibility(View.GONE);
        }
        if(ensemble.getDtDebRemise() != null && ensemble.getDtFinRemise() != null && System.currentTimeMillis() >= ensemble.getDtDebRemise() && System.currentTimeMillis() <= ensemble.getDtFinRemise()) {
            tvRemise.setText(ensemble.getLibelleRemise());
            tvRemise.setVisibility(View.VISIBLE);
        }
        else{
            tvRemise.setVisibility(View.GONE);
        }


        if(mType.equals("house")){
            txtNbLot.setText(Utility.formatItemsHouses((Maison) ensemble, getApplicationContext()));
            txtSurfTerrain.setText(((Maison) ensemble).getTerrainMin() + " à "+((Maison) ensemble).getTerrainMax() + " m\u00B2");
        }
        else{
            txtNbLot.setText(Utility.formatItemsApartments((Apartment) ensemble,getApplicationContext()));
            txtSurfTerrain.setText(((Apartment) ensemble).getSurfMin() + " à " + ((Apartment) ensemble).getSurfMax() + " m\u00B2");

        }

        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shareurl = Utility.getShareUrlEnsemble(ensemble.getEnseCode(), ensemble.getCptEpl(), ensemble.getSociCode(), mType);
                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");

                // Add data to the intent, the receiving app will decide
                // what to do with it.
                share.putExtra(Intent.EXTRA_SUBJECT, "Thomas & Piron");
                share.putExtra(Intent.EXTRA_TEXT, shareurl);

                startActivity(Intent.createChooser(share, "Share link!"));

                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Action")
                        .setAction("Share Ensemble")
                        .setLabel(enseCode)
                        .build());
            }
        });
        loadPoinContact(ensemble.getIdPointContact());
    }

    private void loadPoinContact(Integer idPC){
        PointcontactSelection wherePc = new PointcontactSelection();
        wherePc.idpointcontact(idPC);
        PointcontactCursor pcCursor = wherePc.query(getContentResolver());
        if(pcCursor.moveToNext()){
            TextView tvPhone = (TextView) findViewById(R.id.tvPhone_point_contact);
            tvPhone.setText(Utility.formatTelNumber(pcCursor.getTel()));
            txtMaisonExpo.setText(pcCursor.getTypepointcontact() + " "+ pcCursor.getTitre());
            txtMaisonExpoRue.setText(pcCursor.getAdresse());
            String maisonExpoHoraire;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                maisonExpoHoraire = Html.fromHtml(pcCursor.getPermanencefr(),Html.FROM_HTML_MODE_LEGACY).toString();
            }
            else{
                maisonExpoHoraire = Html.fromHtml(pcCursor.getPermanencefr()).toString();
            }
            txtMaisonExpoHoraire.setText(maisonExpoHoraire.replace("\n\n","\n"));
        }
    }


    private void loadLots() {
        Intent serviceIntent = new Intent(this, SyncLotsService.class);
        serviceIntent.putExtra("ENSE_CODE", enseCode);
        serviceIntent.putExtra("SOCI_CODE", socicode);
        startService(serviceIntent);
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
        handler = new Handler();
        viewPagerVisibleScroll = new Runnable() {
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
        loadViewPager();
        loadLots();
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
        handler.removeCallbacks(viewPagerVisibleScroll);
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

    private void applyPalette(Palette palette) {
        int primaryDark = getResources().getColor(R.color.accent);
        int primary = getResources().getColor(R.color.accent);
        collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(primary));
        collapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(primaryDark));
        setupFAB(mFAB, palette);
        supportStartPostponedEnterTransition();
    }

    private void setupFAB(FloatingActionButton fab, Palette palette) {
        int lightVibrantColor = palette.getLightVibrantColor(getResources().getColor(R.color.primary));
        int vibrantColor = palette.getVibrantColor(getResources().getColor(R.color.primary));

        fab.setRippleColor(lightVibrantColor);
        fab.setBackgroundTintList(ColorStateList.valueOf(vibrantColor));

    }

    private void fillDescCard(){

            getTxtSurfTerrainLib.setText("SURFACE:");
            btnUnit = (Button) findViewById(R.id.show_units);
            if(btnUnit != null){
                btnUnit.setOnClickListener(this);
            }
            btnMedia = (Button) findViewById(R.id.show_images);
            if(btnMedia != null){
                btnMedia.setOnClickListener(this);
            }
            btnContact = (Button) findViewById(R.id.show_contact_ensemble);
            if(btnContact != null){
                btnContact.setOnClickListener(this);
            }
        btnNav = (Button) findViewById(R.id.btnNav);
        if(btnNav!=null){
            btnNav.setOnClickListener(this);
        }

        btnStreet = (Button) findViewById(R.id.btnStreet);
        if(btnStreet != null){
            btnStreet.setOnClickListener(this);
        }



    }

    private void initMap() {

        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext())  == ConnectionResult.SUCCESS){
            //MapFragment map = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
            map = new MapFragment();
            getFragmentManager().beginTransaction().replace(R.id.content,map).commit();
            map.getMapAsync(this);
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
           // mPermissionDenied = true;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.show_units:
                UnitListActivity.navigateToLots(this,enseCode,socicode,mType);
                break;
            case R.id.show_images:
                MediaGridActivity.navigateToMedia(this,cptepl,getIntent().getIntExtra(EXTRA_NBMEDIAS,0),getIntent().getIntExtra(EXTRA_NBPLANS,0));
                break;
            case R.id.show_contact_ensemble:
                Intent intent = new Intent(getApplicationContext(),ContactActivity.class);
                intent.putExtra("MENU_SEL", R.id.drawer_contact);
                intent.putExtra("SUBJECT", new StringBuilder("Information à propos d\'un projet: ").append(itemTitle).toString());
                intent.putExtra("CPT_EPL",cptepl);
                intent.putExtra("INSPIRATION",false);
                String dest;
                if (cptepl.startsWith("1UN") || cptepl.contains("MR") ){
                    dest = Const.getMailMR();
                }
                else{
                    dest = Const.getMailUN();
                }
                intent.putExtra("DEST", dest);
                v.getContext().startActivity(intent);
                break;
            case R.id.btnNav:
                Uri gmmIntentUri = Uri.parse("google.navigation:q="+mLat+","+mLong);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
                break;
            case R.id.btnStreet:
                StreetViewActivity.navigate(this,mLat,mLong);
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
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(mLat, mLong), 14);
        gMap.animateCamera(cameraUpdate);
        Marker m = gMap.addMarker(new MarkerOptions()
                .position(new LatLng(mLat, mLong))
                .icon(BitmapDescriptorFactory
                        .fromResource(mType.equals("apart") ?  R.drawable.icon_appart : R.drawable.icon_maison))
                .title(mName));
    }

    @Override
    public Loader<List<Ensemble>> onCreateLoader(int id, Bundle args) {
        StringBuilder filterBuilder = new StringBuilder();
        filterBuilder.append("(")
                .append(EnsembleColumns.CPTEPL)
                .append("=")
                .append("'")
                .append(cptepl)
                .append("'")
                .append(")");
        return new EnsembleLoader(getApplicationContext(),filterBuilder.toString(),mType.equals("house"));
    }

    @Override
    public void onLoadFinished(Loader<List<Ensemble>> loader, List<Ensemble> data) {
        loadEnsemble(data.get(0));
        initMap();
        //initStreetView();
    }

    /*private void initStreetView() {
        cardStreet = (CardView)findViewById(R.id.cardStreetView);
        streetViewPanoramaFragment = (StreetViewPanoramaFragment) getFragmentManager().findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);
    }*/

    @Override
    public void onLoaderReset(Loader<List<Ensemble>> loader) {

    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        streetViewPanorama.setPosition(new LatLng(mLat, mLong), 150);
        StreetViewPanoramaLocation loc = streetViewPanorama.getLocation();
        /*if(loc == null && streetViewPanoramaFragment != null){
            cardStreet.setVisibility(View.GONE);
        }*/
    }

    @Override
    public void setImageForPosition(int position, ImageView imageView) {

    }

    @Override
    public void onResponse(Call<List<EplMedia>> call, Response<List<EplMedia>> response) {
        urlsString = new String[response.body().size()];
        for (int i = 0; i < response.body().size(); i++) {
            urlsString[i] = response.body().get(i).getUrl();
        }
        //        urlsString = Utility.getListMediasEnsemble(cptepl,getIntent().getIntExtra(EXTRA_NBMEDIAS,1));
        slidingImageAdapter = new SlidingImageAdapter(urlsString,getApplicationContext());
        viewPager = (ViewPager)findViewById(R.id.pager);
        cpt = 0;
        viewPager.setAdapter(slidingImageAdapter);
        viewPager.setClipToPadding(false);



        handler.post(viewPagerVisibleScroll);
        /*viewPager.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                handler.removeCallbacks(viewPagerVisibleScroll);
                return false;
            }
        });
        animatePagerTransition(true,slidingImageAdapter.getCount());


        viewPager.setPageMargin(-550);
        viewPager.setPadding(0, 0, 1000, 0);*/

    }

    @Override
    public void onFailure(Call<List<EplMedia>> call, Throwable throwable) {

    }
}
