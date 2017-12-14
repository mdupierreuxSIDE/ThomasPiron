package eu.side.thomaspiron.android.gcm.GcmClient;

import android.content.Context;

import eu.side.thomaspiron.android.BuildConfig;
import eu.side.thomaspiron.android.gcm.interfaces.RegisterDeviceInterface;

/**
 * Created by mdupierreux1 on 21/09/15.
 */
public class GcmClient {
    private static String GCM_ENDPOINT_ADDRESS = BuildConfig.GCM_ENDPOINT_ADDRESS;
    private static RegisterDeviceInterface GcmApiClient;

    public static RegisterDeviceInterface getTpApiClient(Context context){
        /*if (GcmApiClient == null){
            RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(GCM_ENDPOINT_ADDRESS).build();
            GcmApiClient = restAdapter.create(RegisterDeviceInterface.class);
        }*/
        return GcmApiClient;
    }
}
