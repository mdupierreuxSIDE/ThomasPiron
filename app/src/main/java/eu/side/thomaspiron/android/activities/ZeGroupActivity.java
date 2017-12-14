package eu.side.thomaspiron.android.activities;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.squareup.picasso.Picasso;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.Utility.PrefUtils;
import eu.side.thomaspiron.android.fragments.PointContactListFragment;
import eu.side.thomaspiron.android.gcm.services.RegistrationIntentService;

public class ZeGroupActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_RECOVER_PLAY_SERVICES = 1001;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private PointContactListFragment pointContactFragment;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if(!getIntent().getBooleanExtra("FROM_DRAWER",false)) {
            navigateToDefaultScreen();
        }
*/
        setContentView(R.layout.activity_ze_group);

        /*if (checkGMS()){
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
        }*/


        setupDrawerLayout();
        initToolbar();
        View header = navigationView.getHeaderView(0);
        final ImageView avatar = (ImageView) header.findViewById(R.id.avatar);
        Picasso.with(this).load(R.drawable.drawer_logo_tp).into(avatar);
        final ImageView texte = (ImageView) header.findViewById(R.id.texte_tp);
        Picasso.with(this).load(R.drawable.drawer_texte_tp).into(texte);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Le groupe");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

        ImageView image = (ImageView) findViewById(R.id.image_ensemble);
        if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE || getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            //image.setImageResource(R.drawable.image_corporate_corde);
            Picasso.with(this).load(R.drawable.image_corporate_corde)
                    .into(image);
        }

        else{
            Picasso.with(this).load(R.drawable.main_mobile).into(image);
        }
        //Picasso.with(this).load("http://www.thomas-piron.eu/images/banniere/groupe/corporate.jpg").into(image);
        TextView txtGroupe = (TextView) findViewById(R.id.group_presentation);
        txtGroupe.setText(getString(R.string.group_presentation_string));

        TextView txtGroupeDesc = (TextView)findViewById(R.id.group_desc);
        txtGroupeDesc.setText(getString(R.string.ze_group_desc));

        Button btnApparts = (Button) findViewById(R.id.btnApparts);
        btnApparts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("MENU_SEL", R.id.drawer_apparts);
                startActivity(intent);
            }
        });

        Button btnMaisons = (Button) findViewById(R.id.btnMaisons);
        btnMaisons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("MENU_SEL", R.id.drawer_home);
                startActivity(intent);
                finish();
            }
        });
    }

    //they forced me to do it
    private void navigateToDefaultScreen() {
        Integer defaultScreen = PrefUtils.getDefaultScreen(this);
        if (defaultScreen != 0){
            Intent intent;
            intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("MENU_SEL", defaultScreen);
            startActivity(intent);
            finish();
        }
    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Toolbar height needs to be known before establishing the initial offset
        /*toolbar.post(new Runnable() {
            @Override public void run() {
                ScrollManager manager = new ScrollManager();
                manager.attach(recyclerView);
                manager.addView(toolbar, ScrollManager.Direction.UP);
                manager.addView(fab, ScrollManager.Direction.DOWN);
                manager.setInitialOffset(toolbar.getHeight());
            }
        });*/
    }


    private void setupDrawerLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                Intent intent;
                switch (menuItem.getItemId()) {
                    case R.id.drawer_home2:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_home2);
                        startActivity(intent);
                        break;
                    case R.id.drawer_home:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_home);
                        startActivity(intent);
                        break;
                    case R.id.drawer_apparts:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_apparts);
                        startActivity(intent);
                        break;
                    case R.id.drawer_inspiration:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_inspiration);
                        startActivity(intent);
                        break;
                    case R.id.drawer_contact:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_contact);
                        startActivity(intent);
                        break;
                    case R.id.drawer_group:
                        Intent intent1 = new Intent(getApplicationContext(), ZeGroupActivity.class);
                        intent1.putExtra("FROM_DRAWER", true);
                        startActivity(intent1);
                        break;
                    case R.id.drawer_news:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_news);
                        startActivity(intent);
                        break;
                    case R.id.drawer_point_contact:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_point_contact);
                        startActivity(intent);
                        break;
                    /*case R.id.drawer_point_contact_appart:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_point_contact_appart);
                        startActivity(intent);
                        break;*/
                    case R.id.drawer_follow_us:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_follow_us);
                        startActivity(intent);
                        break;
                    case R.id.drawer_my_pref:
                        intent = new Intent(getApplicationContext(),PrefsActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
                finish();
                drawerLayout.closeDrawers();
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_inspiration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //checkGMS();

        if (navigationView != null ){
            navigationView.getMenu().getItem(7).setChecked(true);
        }
        /*if (checkGMS()){
            // Start IntentService to register this application with GCM.
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
        }*/
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public boolean checkGMS(){
        int statusCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(ZeGroupActivity.this);
        boolean hasGms = true;
        if( statusCode != ConnectionResult.SUCCESS)
        {
            hasGms = false;
            Log.e("statuscode", statusCode + "");
            if(GooglePlayServicesUtil.isUserRecoverableError(statusCode))
            {
                Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(statusCode,ZeGroupActivity.this,REQUEST_CODE_RECOVER_PLAY_SERVICES);

                // If Google Play services can provide an error dialog
                if (errorDialog != null) {
                    errorDialog.show();
                }
            }
            else
            {
                Snackbar.make(findViewById(R.id.main_content), getString(R.string.toast_google_play_services_not_found), Snackbar.LENGTH_SHORT).show();
            }
        }
        return hasGms;
    }
}
