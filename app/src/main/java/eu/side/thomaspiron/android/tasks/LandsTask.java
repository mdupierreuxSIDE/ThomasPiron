package eu.side.thomaspiron.android.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.api.ApiClient;
import eu.side.thomaspiron.android.model.Land;
import eu.side.thomaspiron.android.model.Maison;

/**
 * Created by mdupierreux1 on 5/08/15.
 */
public class LandsTask extends AsyncTask<Void,Void,List<Land>> {

    private final Context mContext;
    private String LOG_TAG = HousesTask.class.getSimpleName();

    public LandsTask(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    protected List<Land> doInBackground(Void... params) {
        List<Land> lands = new ArrayList<>();
        if (Utility.isNetworkAvailable(mContext)){
            //lands = ApiClient.getTpApiClient(mContext).getLandsFromApi();
        }
        return lands;
    }

    @Override
    protected void onPostExecute(List<Land> lands) {
        super.onPostExecute(lands);
    }
}
