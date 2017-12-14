package eu.side.thomaspiron.android.fragments;

import android.content.Context;
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
import android.widget.TextView;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.Utility.AnalyticsUtility;
import eu.side.thomaspiron.android.activities.MainActivity;
import eu.side.thomaspiron.android.activities.ZeGroupActivity;


public class HomeFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String LOG_TAG = HomeFragment.class.getSimpleName();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        AnalyticsUtility.getAnalyticsUtility(getActivity()).sendScreenName(LOG_TAG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_home, container, false);
        initImageButtons(v);
        return v;
    }

    private void initImageButtons(View v) {
        ImageButton imageButton = (ImageButton)v.findViewById(R.id.appart_quick);
        ImageButton imageButtonM = (ImageButton)v.findViewById(R.id.maison_quick);
        ImageButton imageButtonI = (ImageButton)v.findViewById(R.id.inspi_quick);
        ImageButton imageButtonS = (ImageButton)v.findViewById(R.id.social_quick);
        ImageButton imageButtonC = (ImageButton)v.findViewById(R.id.contact_quick);
        ImageButton imageButtonG = (ImageButton)v.findViewById(R.id.groupe_quick);

        imageButton.setOnClickListener(this);
        imageButtonC.setOnClickListener(this);
        imageButtonG.setOnClickListener(this);
        imageButtonI.setOnClickListener(this);
        imageButtonM.setOnClickListener(this);
        imageButtonS.setOnClickListener(this);
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
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.appart_quick:
                intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                intent.putExtra("MENU_SEL", R.id.drawer_apparts);
                AnalyticsUtility.getAnalyticsUtility(getActivity()).sendEvent("action", "quick menu", "appartements");
                startActivity(intent);
                if(getActivity() != null) getActivity().finish();
                break;
            case R.id.maison_quick:
                intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                intent.putExtra("MENU_SEL", R.id.drawer_home);
                AnalyticsUtility.getAnalyticsUtility(getActivity()).sendEvent("action", "quick menu", "maisons");
                startActivity(intent);
                if(getActivity() != null) getActivity().finish();
                break;
            case R.id.inspi_quick:
                intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                intent.putExtra("MENU_SEL", R.id.drawer_inspiration);
                AnalyticsUtility.getAnalyticsUtility(getActivity()).sendEvent("action", "quick menu", "inspiration");
                startActivity(intent);
                if(getActivity() != null) getActivity().finish();
                break;
            case R.id.social_quick:
                intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                intent.putExtra("MENU_SEL", R.id.drawer_follow_us);
                AnalyticsUtility.getAnalyticsUtility(getActivity()).sendEvent("action", "quick menu", "suivez-nous");
                startActivity(intent);
                if(getActivity() != null) getActivity().finish();
                break;
            case R.id.contact_quick:
                intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                intent.putExtra("MENU_SEL", R.id.drawer_contact);
                AnalyticsUtility.getAnalyticsUtility(getActivity()).sendEvent("action", "quick menu", "contact");
                startActivity(intent);
                if(getActivity() != null) getActivity().finish();
                break;
            case R.id.groupe_quick:
                Intent intent1 = new Intent(getActivity().getApplicationContext(), ZeGroupActivity.class);
                intent1.putExtra("FROM_DRAWER", true);
                AnalyticsUtility.getAnalyticsUtility(getActivity()).sendEvent("action", "quick menu", "groupe");
                startActivity(intent1);
                if(getActivity() != null) getActivity().finish();
                break;
        }
    }
}
