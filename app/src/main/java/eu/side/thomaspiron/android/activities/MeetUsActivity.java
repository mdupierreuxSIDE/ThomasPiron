package eu.side.thomaspiron.android.activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appinvite.AppInviteInvitation;
import com.squareup.picasso.Picasso;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.adapters.InspirationPagerAdapter;
import eu.side.thomaspiron.android.fragments.PointContactListFragment;

public class MeetUsActivity extends AppCompatActivity {

    private static final int REQUEST_INVITE = 42;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private DrawerLayout drawerLayout;
    private View content;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet_us);
        initToolbar();
        setupDrawerLayout();
        View header = navigationView.getHeaderView(0);
        final ImageView avatar = (ImageView) header.findViewById(R.id.avatar);
        Picasso.with(this).load(R.drawable.drawer_logo_tp).into(avatar);
        final ImageView texte = (ImageView) header.findViewById(R.id.texte_tp);
        Picasso.with(this).load(R.drawable.drawer_texte_tp).into(texte);
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager()));

        // Give the TabLayout the ViewPager
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


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
                        finish();
                        break;
                    case R.id.drawer_home:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_home);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.drawer_apparts:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_apparts);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.drawer_inspiration:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_inspiration);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.drawer_contact:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_contact);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.drawer_group:
                        Intent intent1 = new Intent(getApplicationContext(), ZeGroupActivity.class);
                        intent1.putExtra("FROM_DRAWER", true);
                        startActivity(intent1);
                        finish();
                        break;
                    case R.id.drawer_point_contact:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_point_contact);
                        startActivity(intent);
                        finish();
                        break;
                    /*case R.id.drawer_point_contact_appart:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_point_contact_appart);
                        startActivity(intent);
                        break;*/
                    case R.id.drawer_news:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_news);
                        startActivity(intent);
                        break;
                    case R.id.drawer_follow_us:
                        intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("MENU_SEL", R.id.drawer_follow_us);
                        startActivity(intent);
                        finish();
                        break;
                    case R.id.drawer_my_pref:
                        intent = new Intent(getApplicationContext(),PrefsActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    default:
                        break;
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });
        getSupportActionBar().setTitle(R.string.title_meet_us);

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

        }

        return super.onOptionsItemSelected(item);
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (navigationView != null ){
            navigationView.getMenu().getItem(5).setChecked(true);
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_meet_us2, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }




    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            PointContactListFragment pointContactFragment;
            Bundle bundle;
            switch(position){
                case 0:
                    pointContactFragment = new PointContactListFragment();
                    bundle = new Bundle();
                    bundle.putString("TYPE_POINT_CONTACT", "Appartement témoin");
                    pointContactFragment.setArguments(bundle);
                    break;
                case 1:
                    pointContactFragment = new PointContactListFragment();
                    bundle = new Bundle();
                    bundle.putString("TYPE_POINT_CONTACT", "Maison expo");
                    pointContactFragment.setArguments(bundle);
                    break;
                default:
                    pointContactFragment = new PointContactListFragment();
                    break;
            }
            return pointContactFragment;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "APPARTEMENTS TéMOINS";
                case 1:
                    return "Maisons expo";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
