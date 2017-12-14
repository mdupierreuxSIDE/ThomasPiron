package eu.side.thomaspiron.android.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.psdev.licensesdialog.LicensesDialog;
import de.psdev.licensesdialog.licenses.ApacheSoftwareLicense20;
import de.psdev.licensesdialog.model.Notice;
import de.psdev.licensesdialog.model.Notices;
import eu.side.thomaspiron.android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener {


    public SettingsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Load the preferences from an XML resource
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        Preference pref;
        PackageInfo pInfo = null;
        String version = "";
        try {
            pInfo = getActivity().getApplicationContext().getPackageManager().getPackageInfo(getActivity().getApplicationContext().getPackageName(), 0);
            version = pInfo.versionName + " - "+pInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        pref = findPreference("pref_version");
        pref.setSummary(version);

        pref = findPreference("pref_licenses");
        pref.setOnPreferenceClickListener(this);

        pref = findPreference("pref_side");
        pref.setOnPreferenceClickListener(this);
    }


    @Override
    public boolean onPreferenceClick(Preference preference) {
        if(preference.getKey().equals("pref_licenses")){
            final Notices notices = new Notices();
            notices.addNotice(new Notice("EventBus","https://github.com/greenrobot/EventBus/","greenrobot",new ApacheSoftwareLicense20()));
            notices.addNotice(new Notice("Retrofit","https://github.com/square/retrofit/","Copyright 2013 Square, Inc.",new ApacheSoftwareLicense20()));
            new LicensesDialog.Builder(getActivity()).setNotices(notices).setIncludeOwnLicense(true).build().show();
        }
        if(preference.getKey().equals("pref_side")){
            String url = "http://www.side.eu";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        return false;
    }
}
