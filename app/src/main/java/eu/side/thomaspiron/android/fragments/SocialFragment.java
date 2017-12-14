package eu.side.thomaspiron.android.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import eu.side.thomaspiron.android.R;


public class SocialFragment extends Fragment implements View.OnClickListener {


    public SocialFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_social, container, false);
        setUpNav(v);
        return v;
    }

    private void setUpNav(View v) {
        ImageButton ibF = (ImageButton)v.findViewById(R.id.ibFacebook);
        ImageButton ibG = (ImageButton)v.findViewById(R.id.ibGoogle);
        ImageButton ibI = (ImageButton)v.findViewById(R.id.ibInstagram);
        ImageButton ibL = (ImageButton)v.findViewById(R.id.ibLinkedin);
        ImageButton ibP = (ImageButton)v.findViewById(R.id.ibPinterest);
        ImageButton ibS = (ImageButton)v.findViewById(R.id.ibSite);
        ImageButton ibY = (ImageButton)v.findViewById(R.id.ibYoutube);

        ibF.setOnClickListener(this);
        ibG.setOnClickListener(this);
        ibI.setOnClickListener(this);
        ibL.setOnClickListener(this);
        ibP.setOnClickListener(this);
        ibS.setOnClickListener(this);
        ibY.setOnClickListener(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuItem item = menu.findItem(R.id.action_maps);
        item.setVisible(false);
        item = menu.findItem(R.id.action_search);
        if(item != null) item.setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onClick(View v) {
        String navUrl = "";
        switch (v.getId()){
            case R.id.ibFacebook:
                navUrl = "https://www.facebook.com/thomasetpiron";
                break;
            case R.id.ibGoogle:
                navUrl = "https://plus.google.com/u/0/114551710247594723419/posts/p/pub";
                break;
            case R.id.ibInstagram:
                navUrl = "https://www.instagram.com/thomasetpiron/";
                break;
            case R.id.ibLinkedin:
                navUrl = "https://www.linkedin.com/company/thomas-&-piron";
                break;
            case R.id.ibPinterest:
                navUrl = "https://www.pinterest.com/thomasetpiron/";
                break;
            case R.id.ibSite:
                navUrl = "http://www.thomas-piron.eu/";
                break;
            case R.id.ibYoutube:
                navUrl = "https://www.youtube.com/user/ThomasEtPiron";
                break;

        }
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(navUrl));
        startActivityForResult(i, 0);
    }
}
