package eu.side.thomaspiron.android.gcm.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.google.android.gms.gcm.GcmListenerService;

import eu.side.thomaspiron.android.R;
import eu.side.thomaspiron.android.Utility.Const;
import eu.side.thomaspiron.android.Utility.PrefUtils;
import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.activities.EnsembleDetailActivity;
import eu.side.thomaspiron.android.activities.MainActivity;
import eu.side.thomaspiron.android.activities.ZeGroupActivity;
import eu.side.thomaspiron.android.model.Maison;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleCursor;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleSelection;

/**
 * Created by mdupierreux1 on 21/09/15.
 */
public class TPGcmListenerService extends GcmListenerService {

        private static final String TAG = "MyGcmListenerService";
    private static final String EXTRA_IMAGE = "eu.side.thomaspiron.android.extraImage";
    private static final String EXTRA_TITLE = "eu.side.thomaspiron.android.extraTitle";
    private static final String EXTRA_ENSECODE = "eu.side.thomaspiron.andorid.extraEnseCode";
    private static final String EXTRA_SOCICODE = "eu.side.thomaspiron.andorid.extraSociCode";
    private static final String EXTRA_TYPE = "eu.side.thomaspiron.andorid.extraType";
    private static final String EXTRA_CPTEPL = "eu.side.thomaspiron.andorid.extraCptEpl";
    private static final String EXTRA_NBMEDIAS = "eu.side.thomaspiron.andorid.extraNbMedias";
    private static final String EXTRA_NBPLANS = "eu.side.thomaspiron.andorid.extraNbPlans";
        /**
         * Called when message is received.
         *
         * @param from SenderID of the sender.
         * @param data Data bundle containing message data as key/value pairs.
         *             For Set of keys use data.keySet().
         */
        // [START receive_message]
        @Override
        public void onMessageReceived(String from, Bundle data) {
            String message = data.getString("message");
            Log.d(TAG, "From: " + from);
            Log.d(TAG, "Message: " + message);

            if (from.startsWith("/topics/")) {
                // message received from some topic.
            } else {
                // normal downstream message.
            }

            // [START_EXCLUDE]
            /**
             * Production applications would usually process the message here.
             * Eg: - Syncing with server.
             *     - Store message in local database.
             *     - Update UI.
             */

            /**
             * In some cases it may be useful to show a notification indicating to the user
             * that a message was received.
             */
            sendNotification(message,data.getString("title"),data.getString("cptepl"),data.getString("typeBien"),data.getString("province"),data.getString("url"));
            // [END_EXCLUDE]
        }


    /**
     * Create and show a simple notification containing the received GCM message.
     *
     * @param message GCM message received.
     */
    private void sendNotification(String message,String title,String cptepl,String typeBien,String province, String url) {
        Intent intent = new Intent(this,MainActivity.class);
        if(cptepl != null && !cptepl.equals("")){
            EnsembleSelection selection = new EnsembleSelection();
            selection.cptepl(cptepl);
            EnsembleCursor c  = selection.query(getContentResolver());
            if(c.moveToNext()) {
                intent = new Intent(this, EnsembleDetailActivity.class);
                if (typeBien.equals("maison")) {
                    intent.putExtra(EXTRA_IMAGE, Utility.formatImageThumbUrl(c.getCptepl()));
                    intent.putExtra(EXTRA_TITLE, c.getPostloc() + " | " + c.getAdresse());
                    intent.putExtra(EXTRA_ENSECODE, c.getEnsecode());
                    intent.putExtra(EXTRA_SOCICODE, c.getSocicode());
                    intent.putExtra(EXTRA_NBMEDIAS, c.getNbmedias());
                    intent.putExtra(EXTRA_NBPLANS, c.getNbplansimpl());
                    intent.putExtra(EXTRA_CPTEPL, c.getCptepl());
                    intent.putExtra(EXTRA_TYPE, "house");
                } else {
                    intent.putExtra(EXTRA_IMAGE, Utility.formatImageThumbUrl(c.getCptepl()));
                    intent.putExtra(EXTRA_TITLE, c.getPostloc() + " | " + c.getAdresse());
                    intent.putExtra(EXTRA_ENSECODE, c.getEnsecode());
                    intent.putExtra(EXTRA_SOCICODE, c.getSocicode());
                    intent.putExtra(EXTRA_NBMEDIAS, c.getNbmedias());
                    intent.putExtra(EXTRA_NBPLANS, c.getNbplansimpl());
                    intent.putExtra(EXTRA_CPTEPL, c.getCptepl());
                    intent.putExtra(EXTRA_TYPE, "apart");
                }
            }
        }
        else{
            if (typeBien != null && !typeBien.equals("")){
                if(typeBien.equals("maison")){
                    PrefUtils.setDefaultScreen(getApplicationContext(),0);
                }
                else{
                    PrefUtils.setDefaultScreen(getApplicationContext(),1);
                }
                if(province != null && !province.equals("")){
                    Boolean find = false;
                    for (int i = 0; i < Const.PROVINCES.size() && !find; i++) {
                        if (province.equals(Const.PROVINCES.get(i))){
                            find = true;
                            PrefUtils.setProvinceFilter(getApplicationContext(),i);
                        }
                    }

                }
            }
        }

        if (url != null && !url.equals("")){
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.logo_tp_transparent1)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
    }
}
