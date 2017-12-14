package eu.side.thomaspiron.android.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.appinvite.AppInviteInvitation;
import com.squareup.picasso.Picasso;

import eu.side.thomaspiron.android.ThomasPironApplication;
import eu.side.thomaspiron.android.Utility.AnalyticsUtility;
import eu.side.thomaspiron.android.Utility.PrefUtils;
import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.fragments.ActuListFragment;
import eu.side.thomaspiron.android.fragments.HomeFragment;
import eu.side.thomaspiron.android.fragments.PointContactListFragment;
import eu.side.thomaspiron.android.fragments.PrefFragment;
import eu.side.thomaspiron.android.fragments.SocialFragment;
import eu.side.thomaspiron.android.gcm.services.RegistrationIntentService;
import io.fabric.sdk.android.Fabric;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.fragments.AppartListFragment;
import eu.side.thomaspiron.android.fragments.CardRecyclerFragment;
import eu.side.thomaspiron.android.fragments.ContactFragment;
import eu.side.thomaspiron.android.fragments.TerrainListFragment;
import eu.side.thomaspiron.android.services.ApiCallService;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String MENU_SEL = "MENU_SEL";

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 0;
    private static final int REQUEST_INVITE = 42;

    private DrawerLayout drawerLayout;
    private View content;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CardRecyclerFragment cardRecyclerFragment;
    private AppartListFragment appartListFragment;
    private TerrainListFragment terrainListFragment;
    private ContactFragment contactFragment;
    private NavigationView navigationView;
    private int mMenuSel;
    private Tracker mTracker;
    private String mSubject,mCptepl,mDest;
    private Boolean isInspiration;
    private ActuListFragment actuListFragment;
    private PointContactListFragment pointContactFragment;
    private HomeFragment homeFragment;
    private SocialFragment socialFragment;
    private MenuItem mPreviousMenuItem;
    private ShareActionProvider mShareActionProvider;
    private PreferenceFragment prefFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        // Obtain the shared Tracker instance.
        //mTracker = ((ThomasPironApplication) getApplication()).getDefaultTracker();
        //mTracker = application.getDefaultTracker();
        mMenuSel = R.id.drawer_home2;
        setContentView(R.layout.activity_main);
        content = findViewById(R.id.content);

        int defaultScreen = PrefUtils.getDefaultScreen(this);
        switch(defaultScreen){
            case 0:
                mMenuSel = R.id.drawer_home;
                break;
            case 1:
                mMenuSel = R.id.drawer_apparts;
                break;
            default:
                break;
        }
        if(getIntent().hasExtra("MENU_SEL")){
            mMenuSel = getIntent().getIntExtra("MENU_SEL",mMenuSel);
        }
        if (getIntent().hasExtra("SUBJECT")){
            mSubject = getIntent().getStringExtra("SUBJECT");
            mCptepl = getIntent().getStringExtra("CPT_EPL");
            mDest = getIntent().getStringExtra("DEST");
            if (getIntent().hasExtra("INSPIRATION")) {
                isInspiration = getIntent().getBooleanExtra("INSPIRATION", false);
            }
        }
        if (savedInstanceState != null) {
            //mMenuSel = getIntent().getIntExtra("MENU_SEL", R.id.drawer_home); //todo save onSaveInstance
            mMenuSel = savedInstanceState.getInt(MENU_SEL);
        }
        /**/


        initToolbar();
        setupDrawerLayout();
        View header = navigationView.getHeaderView(0);
        final ImageView avatar = (ImageView) header.findViewById(R.id.avatar);
        Picasso.with(this).load(R.drawable.drawer_logo_tp).into(avatar);
        final ImageView texte = (ImageView) header.findViewById(R.id.texte_tp);
        Picasso.with(this).load(R.drawable.drawer_texte_tp).into(texte);
        //firstSelectDrawer();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (System.currentTimeMillis() >  prefs.getLong("LAST_TIME_SYNC",0)+86400000 ) { //86400000
            Intent serviceIntent = new Intent(this, ApiCallService.class);
            startService(serviceIntent);

            SharedPreferences.Editor editor = prefs.edit();
            editor.putLong("LAST_TIME_SYNC", System.currentTimeMillis());
            editor.commit();
        }
        startService(new Intent(this, RegistrationIntentService.class));
    }


    private void firstSelectDrawer() {
        Bundle bundle;
        switch (mMenuSel){
            case R.id.drawer_home2:
                mMenuSel = R.id.drawer_home2;
                homeFragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content, homeFragment).commit();
                getSupportActionBar().setTitle(R.string.title_home);
                navigationView.getMenu().getItem(0).setChecked(true);
                break;
            case R.id.drawer_home:
                if (cardRecyclerFragment == null) {
                    cardRecyclerFragment = new CardRecyclerFragment();
                    bundle = new Bundle();
                    bundle.putInt("LOT_TYPE", 1);
                    cardRecyclerFragment.setArguments(bundle);
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.content,cardRecyclerFragment).commit();
                getSupportActionBar().setTitle(R.string.title_house);
                navigationView.getMenu().getItem(1).setChecked(true);
                break;
            case R.id.drawer_apparts:
                if (appartListFragment == null) {
                    appartListFragment = new AppartListFragment();
                    bundle = new Bundle();
                    bundle.putInt("LOT_TYPE", 3);
                    appartListFragment.setArguments(bundle);
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.content,appartListFragment).commit();
                getSupportActionBar().setTitle(R.string.title_apart);
                navigationView.getMenu().getItem(2).setChecked(true);
                break;
            case R.id.drawer_inspiration:
                Intent intent = new Intent(getApplicationContext(),InspirationActivity.class);
                startActivity(intent);
                navigationView.getMenu().getItem(3).setChecked(true);
                finish();
                break;
            case R.id.drawer_contact:
                if (contactFragment == null) {
                    contactFragment = new ContactFragment();
                    bundle = new Bundle();
                    bundle.putString("CONTACT_SUBJECT",mSubject);
                    bundle.putString("CPT_EPL",mCptepl);
                    bundle.putString("DEST",mDest);
                    if(isInspiration != null) {
                        bundle.putBoolean("INSPIRATION", isInspiration);
                    }
                    contactFragment.setArguments(bundle);
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.content, contactFragment).commit();
                getSupportActionBar().setTitle(R.string.drawer_contact);
                navigationView.getMenu().getItem(4).setChecked(true);
                /*navigationView.getMenu().getItem(4).setChecked(true);
                navigationView.getMenu().getItem(4).getSubMenu().getItem(0).setChecked(true);
*/
                break;
            case R.id.drawer_news:
                mMenuSel = R.id.drawer_news;
                actuListFragment = new ActuListFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content, actuListFragment).commit();
                getSupportActionBar().setTitle(getString(R.string.drawer_string_news));
                navigationView.getMenu().getItem(6).setChecked(true);
                break;

            case R.id.drawer_point_contact:
                mMenuSel = R.id.drawer_point_contact;
                /*pointContactFragment = new PointContactListFragment();
                bundle = new Bundle();
                bundle.putString("TYPE_POINT_CONTACT", "Maison expo");
                pointContactFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content, pointContactFragment).commit();
                getSupportActionBar().setTitle(getString(R.string.string_drawer_point_contact));*/
                Intent intentM = new Intent(getApplicationContext(), MeetUsActivity.class);
                startActivity(intentM);
                navigationView.getMenu().getItem(4).setChecked(true);
                finish();
                /*navigationView.getMenu().getItem(4).setChecked(true);
                navigationView.getMenu().getItem(4).getSubMenu().getItem(2).setChecked(true);
*/

                navigationView.getMenu().getItem(5).setChecked(true);
                break;
            /*case R.id.drawer_point_contact_appart:
                mMenuSel = R.id.drawer_point_contact_appart;
                pointContactFragment = new PointContactListFragment();
                bundle = new Bundle();
                bundle.putString("TYPE_POINT_CONTACT", "Appartement témoin");
                pointContactFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.content, pointContactFragment).commit();
                getSupportActionBar().setTitle(getString(R.string.string_drawer_point_contact_apart));
                navigationView.getMenu().getItem(4).setChecked(true);
                navigationView.getMenu().getItem(4).getSubMenu().getItem(1).setChecked(true);

                break;*/
            case R.id.drawer_follow_us:
                mMenuSel = R.id.drawer_follow_us;
                socialFragment = new SocialFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content, socialFragment).commit();
                getSupportActionBar().setTitle(getString(R.string.string_drawer_follow_us));
                navigationView.getMenu().getItem(8).setChecked(true);
                break;
            case R.id.drawer_my_pref:
                mMenuSel = R.id.drawer_home2;
                homeFragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content, homeFragment).commit();
                getSupportActionBar().setTitle(R.string.title_home);
                navigationView.getMenu().getItem(0).setChecked(true);
                break;
            default:
                /*if (cardRecyclerFragment == null) {
                    cardRecyclerFragment = new CardRecyclerFragment();
                    bundle = new Bundle();
                    bundle.putInt("LOT_TYPE", 1);
                    cardRecyclerFragment.setArguments(bundle);
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.content,cardRecyclerFragment).commit();
                getSupportActionBar().setTitle(R.string.title_house);
                navigationView.getMenu().getItem(0).setChecked(true);
                break;*/


        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG, "Setting screen name: " + LOG_TAG);
        AnalyticsUtility.getAnalyticsUtility(this).sendScreenName(LOG_TAG);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firstSelectDrawer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //menu.findItem(R.id.action_refresh).setVisible(BuildConfig.DEBUG);
// Fetch and store ShareActionProvider
        /*MenuItem item = menu.findItem(R.id.action_share_app);
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
        String playStoreLink = "https://play.google.com/store/apps/details?id=" +
                getPackageName();
        String yourShareText = "Install this app " + playStoreLink;
        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain").setText(yourShareText).getIntent();
        setShareIntent(shareIntent);*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                hideKeyboard();
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_prefs:
                Intent intent1 = new Intent(this,PrefsActivity.class);
                startActivity(intent1);
                return true;
            case R.id.action_share_app:
                /*String playStoreLink = "https://play.google.com/store/apps/details?id=" +
                        getPackageName();
                String yourShareText = "" + playStoreLink;
                Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                        .setType("text/plain").setText(yourShareText).getIntent();
                shareIntent.setAction(Intent.ACTION_SEND);
                startActivity(shareIntent);*/
                Intent intentInvite = new AppInviteInvitation.IntentBuilder(getString(R.string.invitation_title))
                        .setMessage(getString(R.string.invitation_message))
                        //.setDeepLink(Uri.parse(getString(R.string.invitation_deep_link)))
                        //.setCustomImage(Uri.parse(getString(R.string.invitation_custom_image)))
                        //.setCallToActionText(getString(R.string.invitation_cta))
                        .build();
                startActivityForResult(intentInvite, REQUEST_INVITE);
                return true;
            case R.id.action_policy:
                String policyUrl = "http://www.side.eu/apps/policy/confidentialite.html";
                Intent policyIntent = new Intent(Intent.ACTION_VIEW);
                policyIntent.setData(Uri.parse(policyUrl));
                startActivity(policyIntent);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setElevation(0);
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

    @Override
    public void onBackPressed() {
        if (appartListFragment != null && appartListFragment.searchView != null && appartListFragment.searchView.isSearchOpen()) {
            appartListFragment.searchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }

    private void setupDrawerLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                if (mPreviousMenuItem != null) {
                    mPreviousMenuItem.setChecked(false);
                }
                mPreviousMenuItem = menuItem;

                Bundle bundle;
                switch (menuItem.getItemId()) {
                    case R.id.drawer_home2:
                        mMenuSel = R.id.drawer_home2;
                        homeFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, homeFragment).commit();
                        getSupportActionBar().setTitle(R.string.title_home);
                        AnalyticsUtility.getAnalyticsUtility(getParent()).sendEvent("action", "drawer", "quick menu");
                        break;
                    case R.id.drawer_home:
                        mMenuSel = R.id.drawer_home;
                        cardRecyclerFragment = new CardRecyclerFragment();
                        bundle = new Bundle();
                        bundle.putInt("LOT_TYPE", 1);
                        cardRecyclerFragment.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, cardRecyclerFragment).commit();
                        getSupportActionBar().setTitle(R.string.title_house);
                        AnalyticsUtility.getAnalyticsUtility(getParent()).sendEvent("action", "drawer", "maisons");
                        break;
                    case R.id.drawer_apparts:
                        mMenuSel = R.id.drawer_apparts;
                        appartListFragment = new AppartListFragment();
                        bundle = new Bundle();
                        bundle.putInt("LOT_TYPE", 3);
                        appartListFragment.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, appartListFragment).commit();
                        getSupportActionBar().setTitle(R.string.title_apart);
                        AnalyticsUtility.getAnalyticsUtility(getParent()).sendEvent("action", "drawer", "appartements");
                        break;
                    case R.id.drawer_inspiration:
                        Intent intent = new Intent(getApplicationContext(), InspirationActivity.class);
                        startActivity(intent);
                        AnalyticsUtility.getAnalyticsUtility(getParent()).sendEvent("action", "drawer", "inspiration");
                        finish();
                        break;
                    case R.id.drawer_contact:

                        /*navigationView.getMenu().getItem(4).getSubMenu().getItem(1).setChecked(false);
                        navigationView.getMenu().getItem(4).getSubMenu().getItem(2).setChecked(false);*/
                        mMenuSel = R.id.drawer_contact;
                        contactFragment = new ContactFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, contactFragment).commit();
                        getSupportActionBar().setTitle("Contact");
                        AnalyticsUtility.getAnalyticsUtility(getParent()).sendEvent("action", "drawer", "contact");
                        break;
                    case R.id.drawer_group:
                        mMenuSel = R.id.drawer_group;
                        Intent intent1 = new Intent(getApplicationContext(),ZeGroupActivity.class);
                        intent1.putExtra("FROM_DRAWER", true);
                        startActivity(intent1);
                        AnalyticsUtility.getAnalyticsUtility(getParent()).sendEvent("action", "drawer", "groupe");
                        finish();
                        break;
                    case R.id.drawer_news:
                        mMenuSel = R.id.drawer_news;
                        actuListFragment = new ActuListFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, actuListFragment).commit();
                        getSupportActionBar().setTitle(getString(R.string.drawer_string_news));
                        AnalyticsUtility.getAnalyticsUtility(getParent()).sendEvent("action", "drawer", "news");
                        break;
                    case R.id.drawer_point_contact:
                        Intent intentM = new Intent(getApplicationContext(), MeetUsActivity.class);
                        startActivity(intentM);
                        /*navigationView.getMenu().getItem(4).getSubMenu().getItem(0).setChecked(false);
                        navigationView.getMenu().getItem(4).getSubMenu().getItem(1).setChecked(false);
                        mMenuSel = R.id.drawer_point_contact;
                        pointContactFragment = new PointContactListFragment();
                        bundle = new Bundle();
                        bundle.putString("TYPE_POINT_CONTACT", "Maison expo");
                        pointContactFragment.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, pointContactFragment).commit();
                        getSupportActionBar().setTitle(getString(R.string.string_drawer_point_contact));*/
                        AnalyticsUtility.getAnalyticsUtility(getParent()).sendEvent("action", "drawer", "maisons expo");
                        finish();
                        break;
                    /*case R.id.drawer_point_contact_appart:

                        navigationView.getMenu().getItem(4).getSubMenu().getItem(0).setChecked(false);
                        navigationView.getMenu().getItem(4).getSubMenu().getItem(2).setChecked(false);
                        mMenuSel = R.id.drawer_point_contact_appart;
                        pointContactFragment = new PointContactListFragment();
                        bundle = new Bundle();
                        bundle.putString("TYPE_POINT_CONTACT", "Appartement témoin");
                        pointContactFragment.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, pointContactFragment).commit();
                        getSupportActionBar().setTitle(getString(R.string.string_drawer_point_contact_apart));
                        AnalyticsUtility.getAnalyticsUtility(getParent()).sendEvent("action", "drawer", "appartements temoin");
                        break;*/
                    case R.id.drawer_follow_us:
                        mMenuSel = R.id.drawer_follow_us;
                        socialFragment = new SocialFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.content, socialFragment).commit();
                        getSupportActionBar().setTitle(getString(R.string.string_drawer_follow_us));
                        AnalyticsUtility.getAnalyticsUtility(getParent()).sendEvent("action", "drawer", "suivez-nous");
                        break;
                    case R.id.drawer_my_pref:
                        mMenuSel = R.id.drawer_my_pref;
                        Intent intentPref = new Intent(getApplicationContext(),PrefsActivity.class);
                        startActivity(intentPref);
                        finish();
                        break;
                    default:
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }


    private void setupTabLayout(){
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        viewPager = (ViewPager) findViewById(R.id.pager);

        viewPager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    // Call to update the share intent
    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }

    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CardRecyclerFragment();
                case 1:
                default:
                    return new CardRecyclerFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "MAISONS";
                case 1:
                default:
                    return "TERRAINS";
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(MENU_SEL, mMenuSel);
    }


    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }


    @Override
    /**
     * Bug found in some when toolbar is half-way collapsed and a touch is made on image (some phones only)
     */
    public boolean dispatchTouchEvent(MotionEvent ev) {
        try {
            return super.dispatchTouchEvent(ev);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(LOG_TAG, "onActivityResult: requestCode=" + requestCode + ", resultCode=" + resultCode);

        if (requestCode == REQUEST_INVITE) {
            if (resultCode == RESULT_OK) {
                // Check how many invitations were sent and log a message
                // The ids array contains the unique invitation ids for each invitation sent
                // (one for each contact select by the user). You can use these for analytics
                // as the ID will be consistent on the sending and receiving devices.
                String[] ids = AppInviteInvitation.getInvitationIds(resultCode, data);
                //Log.d(LOG_TAG, getString(R.string.sent_invitations_fmt, ids.length));
                //Snackbar.make(findViewById(R.id.main_content), R.string.snack_invites_sent,Snackbar.LENGTH_SHORT).show();
            } else {
                // Sending failed or it was canceled, show failure message to the user
                //showMessage(getString(R.string.send_failed));
            }
        }
    }

}
