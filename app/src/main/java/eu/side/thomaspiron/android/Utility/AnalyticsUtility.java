package eu.side.thomaspiron.android.Utility;

import android.app.Activity;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import eu.side.thomaspiron.android.ThomasPironApplication;

/**
 * Created by mdupierreux1 on 22/01/16.
 */
public class AnalyticsUtility {

    private static Tracker mTracker;
    private static AnalyticsUtility mAnalyticsUtility;

    public AnalyticsUtility() {
    }

    public AnalyticsUtility(Activity activity) {
        ThomasPironApplication application = (ThomasPironApplication) activity.getApplication();
        mTracker = application.getDefaultTracker();
    }

    public static AnalyticsUtility getAnalyticsUtility(Activity activity){
        if(mAnalyticsUtility == null){
            mAnalyticsUtility = new AnalyticsUtility(activity);
        }
        return mAnalyticsUtility;
    }



    public static Tracker getDefaultTracker(Activity activity){
        ThomasPironApplication application = (ThomasPironApplication) activity.getApplication();
        return application.getDefaultTracker();
    }

    public void sendScreenName(String screenName){
        mTracker.setScreenName(screenName);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    public void sendEvent(String category,String action, String label){
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(action)
                .setLabel(label)
                .build());
    }
}
