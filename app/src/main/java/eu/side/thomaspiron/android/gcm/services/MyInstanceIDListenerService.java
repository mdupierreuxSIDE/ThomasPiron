package eu.side.thomaspiron.android.gcm.services;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by mdupierreux1 on 21/09/15.
 */
public class MyInstanceIDListenerService extends InstanceIDListenerService {

        private static final String TAG = "MyInstanceIDLS";

        /**
         * Called if InstanceID token is updated. This may occur if the security of
         * the previous token had been compromised. This call is initiated by the
         * InstanceID provider.
         */
        // [START refresh_token]
        @Override
        public void onTokenRefresh() {
            // Fetch updated Instance ID token and notify our app's server of any changes (if applicable).
            Intent intent = new Intent(this, RegistrationIntentService.class);
            startService(intent);
        }
        // [END refresh_token]
}
