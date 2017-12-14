package eu.side.thomaspiron.android.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.fragments.PrefFragment;


public class PrefsActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private PrefFragment prefFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);
        toolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.string_menu_pref));
        prefFragment = new PrefFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.content, prefFragment)
                .commit();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()){
            case android.R.id.home:
                //onBackPressed();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("MENU_SEL", R.id.drawer_my_pref);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
