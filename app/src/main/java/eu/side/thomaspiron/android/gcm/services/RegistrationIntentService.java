package eu.side.thomaspiron.android.gcm.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gms.gcm.GcmPubSub;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import eu.side.thomaspiron.android.BuildConfig;
import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.Utility.GcmUtils;
import eu.side.thomaspiron.android.Utility.PrefUtils;
import eu.side.thomaspiron.android.api.ApiClient;
import eu.side.thomaspiron.android.gcm.GcmClient.GcmClient;
import eu.side.thomaspiron.android.gcm.GcmPreferences.GcmPreferences;
import eu.side.thomaspiron.android.gcm.dto.CategoryDeviceDTO;
import eu.side.thomaspiron.android.gcm.dto.DeviceRegistrationDTO;
import eu.side.thomaspiron.android.gcm.dto.FluxDeviceDTO;
import eu.side.thomaspiron.android.gcm.dto.RegisterFluxForDeviceDTO;

/**
 * Created by mdupierreux1 on 21/09/15.
 */
public class RegistrationIntentService extends IntentService {
    private static final String TAG = "RegistrationIntentServ";
    private static final String[] TOPICS = {"global"};

    public RegistrationIntentService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        try {
            // [START register_for_gcm]
            // Initially this call goes out to the network to retrieve the token, subsequent calls
            // are local.
            // [START get_token]
            InstanceID instanceID = InstanceID.getInstance(this);
            String token = instanceID.getToken(getString(R.string.gcm_defaultSenderId),
                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
            // [END get_token]
            Log.i(TAG, "GCM Registration Token:" + token);

            sendRegistrationToServer(token);

            // Subscribe to topic channels
            subscribeTopics(token);

            // You should store a boolean that indicates whether the generated token has been
            // sent to your server. If the boolean is false, send the token to your server,
            // otherwise your server should have already received the token.
            sharedPreferences.edit().putBoolean(GcmPreferences.SENT_TOKEN_TO_SERVER, true).apply();
            // [END register_for_gcm]
        } catch (Exception e) {
            Log.d(TAG, "Failed to complete token refresh", e);
            // If an exception happens while fetching the new token or updating our registration data
            // on a third-party server, this ensures that we'll attempt the update at a later time.
            sharedPreferences.edit().putBoolean(GcmPreferences.SENT_TOKEN_TO_SERVER, false).apply();
        }
        // Notify UI that registration has completed, so the progress indicator can be hidden.
        Intent registrationComplete = new Intent(GcmPreferences.REGISTRATION_COMPLETE);
        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);
    }


    private void sendRegistrationToServer(String token) {
        DeviceRegistrationDTO registrationDTO = new DeviceRegistrationDTO();
        registrationDTO.setOs("Android");
        registrationDTO.setApplicationUid(BuildConfig.APPUID);
        registrationDTO.setDeviceType(Build.MODEL);
        registrationDTO.setDeviceUniqueId(Build.SERIAL);
        registrationDTO.setGcmRegisterToken(token);
        registrationDTO.setLocale(Locale.getDefault().getLanguage());
        registrationDTO.setOsVersion(Build.VERSION.RELEASE);
        registrationDTO.setApplicationVersion(BuildConfig.VERSION_NAME);

        String result = GcmClient.getTpApiClient(getApplicationContext()).registerDevice(registrationDTO);
        PrefUtils.setDeviceUid(getApplicationContext(),result);
        List<CategoryDeviceDTO> categoryDeviceDTOList = GcmClient.getTpApiClient(getApplicationContext()).getCategoryList(BuildConfig.APPUID);

        RegisterFluxForDeviceDTO registerFluxForDeviceDTO = new RegisterFluxForDeviceDTO();
        List<String> cat = new LinkedList<>();
        StringBuilder sbId = new StringBuilder();
        StringBuilder sbLib = new StringBuilder();


        /*provinces*/
        for (FluxDeviceDTO fluxDeviceDTO : categoryDeviceDTOList.get(0).getFluxList()) {
            cat.add(fluxDeviceDTO.getElementUid());
            sbId.append(fluxDeviceDTO.getElementUid()).append(",");
            sbLib.append(fluxDeviceDTO.getName()).append(",");
        }
        PrefUtils.setGcmProvinceListId(getApplicationContext(), sbId.toString());
        PrefUtils.setGcmProvinceListLib(getApplicationContext(),sbLib.toString());

        //Types de bien
        cat = new LinkedList<>();
        sbId = new StringBuilder();
        sbLib = new StringBuilder();
        for (FluxDeviceDTO fluxDeviceDTO : categoryDeviceDTOList.get(1).getFluxList()) {
            cat.add(fluxDeviceDTO.getElementUid());
            sbId.append(fluxDeviceDTO.getElementUid()).append(",");
            sbLib.append(fluxDeviceDTO.getName()).append(",");
        }
        PrefUtils.setGcmTypeBienListId(getApplicationContext(), sbId.toString());
        PrefUtils.setGcmTypeBienListLib(getApplicationContext(), sbLib.toString());
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        //si le user a pas modifié
        if(!prefs.contains("pref_enable_news")) {
            cat = new LinkedList<>();
            cat.add("fcdc2937-d485-11e5-bf4a-fa163e99fc74");
            GcmUtils.registerAllCategories(getApplicationContext(), cat);
        }
    }

    // [START subscribe_topics]
    private void subscribeTopics(String token) throws IOException {
        GcmPubSub pubSub = GcmPubSub.getInstance(this);
        for (String topic : TOPICS) {
            pubSub.subscribe(token, "/topics/" + topic, null);
        }
    }
    // [END subscribe_topics]
}
