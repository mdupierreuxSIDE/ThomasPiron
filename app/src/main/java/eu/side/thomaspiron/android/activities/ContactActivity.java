package eu.side.thomaspiron.android.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.fragments.ContactFragment;

public class ContactActivity extends AppCompatActivity {

    private ContactFragment contactFragment ;
    private String mSubject;
    private String mDest;
    private String mCptepl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initToolbar();
        Boolean isInspiration = false;
        if (getIntent().hasExtra("SUBJECT")){
            mSubject = getIntent().getStringExtra("SUBJECT");
            mCptepl = getIntent().getStringExtra("CPT_EPL");
            mDest = getIntent().getStringExtra("DEST");

            if (getIntent().hasExtra("INSPIRATION")) {
                isInspiration = getIntent().getBooleanExtra("INSPIRATION", false);
            }
        }

        if (contactFragment == null) {
            contactFragment = new ContactFragment();
            Bundle bundle = new Bundle();
            bundle.putString("CONTACT_SUBJECT",mSubject);
            bundle.putString("CPT_EPL",mCptepl);
            bundle.putString("DEST",mDest);
            if(isInspiration != null) {
                bundle.putBoolean("INSPIRATION", isInspiration);
            }
            contactFragment.setArguments(bundle);
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.content, contactFragment).commit();
    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Contact");
        }
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
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
