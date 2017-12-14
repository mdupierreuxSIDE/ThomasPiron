package eu.side.thomaspiron.android.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.api.ApiClient;
import eu.side.thomaspiron.android.model.Maison;

/**
 * Created by mdupierreux1 on 5/08/15.
 */
public class HousesTask extends AsyncTask<Void,Void,List<Maison>> {

    private final Context mContext;
    private String LOG_TAG = HousesTask.class.getSimpleName();

    public HousesTask(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    protected List<Maison> doInBackground(Void... params) {
        List<Maison> maisons = new ArrayList<>();
        if (Utility.isNetworkAvailable(mContext)){
            //maisons = ApiClient.getTpApiClient(mContext).getHousesFromApi();
        }
        return  maisons;
    }

    @Override
    protected void onPostExecute(List<Maison> maisons) {
        super.onPostExecute(maisons);
        for (int i = 0; i < maisons.size();i++){
            Log.d(LOG_TAG,i+"- HousesTask : "+maisons.get(i).getCptEpl());
        }
    }
}
