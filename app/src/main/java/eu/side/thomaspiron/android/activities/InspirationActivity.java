package eu.side.thomaspiron.android.activities;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.adapters.InspirationPagerAdapter;
import eu.side.thomaspiron.android.fragments.AppartListFragment;
import eu.side.thomaspiron.android.fragments.CardRecyclerFragment;
import eu.side.thomaspiron.android.fragments.ContactFragment;
import eu.side.thomaspiron.android.fragments.PointContactListFragment;
import eu.side.thomaspiron.android.fragments.TerrainListFragment;

public class InspirationActivity extends AppCompatActivity {

    private static final String LOG_TAG = InspirationActivity.class.getSimpleName();
    private DrawerLayout drawerLayout;
    private View content;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private CardRecyclerFragment cardRecyclerFragment;
    private AppartListFragment appartListFragment;
    private TerrainListFragment terrainListFragment;
    private ContactFragment contactFragment;
    private NavigationView navigationView;
    private PointContactListFragment pointContactFragment;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspiration);
        initToolbar();
        setupDrawerLayout();
        View header = navigationView.getHeaderView(0);
        final ImageView avatar = (ImageView) header.findViewById(R.id.avatar);
        Picasso.with(this).load(R.drawable.drawer_logo_tp).into(avatar);
        final ImageView texte = (ImageView) header.findViewById(R.id.texte_tp);
        Picasso.with(this).load(R.drawable.drawer_texte_tp).into(texte);
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new InspirationPagerAdapter(getSupportFragmentManager(),
                InspirationActivity.this));

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
                        Intent intent1 = new Intent(getApplicationContext(),ZeGroupActivity.class);
                        intent1.putExtra("FROM_DRAWER",true);
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
                        finish();
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
        getSupportActionBar().setTitle(R.string.title_inspiration);

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
        if (navigationView != null ){
            navigationView.getMenu().getItem(3).setChecked(true);
        }
    }

}
