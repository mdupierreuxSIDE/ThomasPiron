package eu.side.thomaspiron.android.activities;

import android.content.Intent;
import android.media.Image;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import eu.side.thomaspiron.android.R;

public class MediaDetailActivity extends AppCompatActivity {

    public static void navigateToMedia(AppCompatActivity appCompatActivity, String url){
        Intent intent = new Intent(appCompatActivity, MediaDetailActivity.class);
        intent.putExtra("URL_IMAGE",url);
        ActivityCompat.startActivity(appCompatActivity, intent, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_detail);
        initToolbar();
        ImageView iv = (ImageView) findViewById(R.id.image);
        Picasso.with(this).load(getIntent().getStringExtra("URL_IMAGE")).into(iv);

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


    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setElevation(0);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Images");
        }
    }


}
