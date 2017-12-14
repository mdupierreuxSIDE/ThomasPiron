package eu.side.thomaspiron.android.fragments;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;


import java.util.LinkedList;
import java.util.List;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.Utility.Const;
import eu.side.thomaspiron.android.Utility.GcmUtils;
import eu.side.thomaspiron.android.Utility.PrefUtils;
import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.gcm.GcmClient.GcmClient;

/**
 * Created by mdupierreux1 on 7/12/15.
 */
public class PrefFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener {


    public PrefFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences_gen);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        Preference pref = findPreference("pref_bien");
        if(prefs.contains(Const.PREF_GCM_TYPEBIEN)) {
            pref.setSummary(PrefUtils.getGcmTypeBienListLib(getActivity().getApplicationContext())[PrefUtils.getGcmPTypeBien(getActivity().getApplicationContext())]);
        }
        pref.setOnPreferenceClickListener(this);

        pref = findPreference("pref_province");
        if(prefs.contains(Const.PREF_GCM_PROVINCE)) {
            pref.setSummary(PrefUtils.getGcmProvinceListLib(getActivity().getApplicationContext())[PrefUtils.getGcmProvince(getActivity().getApplicationContext())]);
        }
        pref.setOnPreferenceClickListener(this);

        pref = findPreference("pref_enable_news");
        if(!prefs.contains("pref_enable_news")) ((CheckBoxPreference)pref).setChecked(true);
        pref.setOnPreferenceClickListener(this);

        pref = findPreference("pref_licenses");
        //pref.setOnPreferenceClickListener(this);

        pref = findPreference("pref_side");
        //pref.setOnPreferenceClickListener(this);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().setBackgroundColor(Color.WHITE);
        getView().setClickable(true);
    }

    @Override
    public boolean onPreferenceClick(final Preference preference) {
        if (preference.getKey().equals("pref_bien")){
            showTypesBienDialog();
            //preference.setSummary(Utility.getTypeBienPrefered(getActivity().getApplicationContext()));
        }
        if (preference.getKey().equals("pref_province")){
            showProvincesDialogForGcm();
            //preference.setSummary(Utility.getProvincePrefered(getActivity().getApplicationContext()));
        }
        if(preference.getKey().equals("pref_enable_news")){
            register();
        }
        return false;
    }

    private void showTypesBienDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.pref_bien_summary)
                .setItems(PrefUtils.getGcmTypeBienListLib(getActivity().getApplicationContext()), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        PrefUtils.setGcmTypeBien(getActivity().getApplicationContext(), which);
                        findPreference("pref_bien").setSummary(PrefUtils.getGcmTypeBienListLib(getActivity().getApplicationContext())[which]);
                        register();
                    }
                });
        builder.create().show();
    }

    private void showProvincesDialogForGcm(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.pref_province_summary)
                .setItems(PrefUtils.getGcmProvinceListLib(getActivity().getApplicationContext()), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        PrefUtils.setGcmProvince(getActivity().getApplicationContext(), which);
                        findPreference("pref_province").setSummary(PrefUtils.getGcmProvinceListLib(getActivity().getApplicationContext())[which]);
                        register();
                    }
                });
        builder.create().show();
    }

    private void register(){
        List<String> cat = new LinkedList<>();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        if(prefs.contains(Const.PREF_GCM_TYPEBIEN)){
            cat.add(PrefUtils.getGcmTypeBienListId(getActivity().getApplicationContext())[PrefUtils.getGcmPTypeBien(getActivity().getApplicationContext())]);
        }
        if(prefs.contains(Const.PREF_GCM_PROVINCE)){
            cat.add(PrefUtils.getGcmProvinceListId(getActivity().getApplicationContext())[PrefUtils.getGcmProvince(getActivity().getApplicationContext())]);
        }
        if(prefs.getBoolean("pref_enable_news", true)){
            cat.add("fcdc2937-d485-11e5-bf4a-fa163e99fc74");
        }
        else{
            cat.add("01a765a0-d486-11e5-bf4a-fa163e99fc74");
        }
        GcmUtils.registerAllCategories(getActivity().getApplicationContext(),cat);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}