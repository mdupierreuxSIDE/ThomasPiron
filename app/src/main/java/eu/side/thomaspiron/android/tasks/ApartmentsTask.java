package eu.side.thomaspiron.android.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import eu.side.thomaspiron.android.Utility.Utility;
import eu.side.thomaspiron.android.api.ApiClient;
import eu.side.thomaspiron.android.model.Apartment;
import eu.side.thomaspiron.android.model.Land;

/**
 * Created by mdupierreux1 on 5/08/15.
 */
public class ApartmentsTask extends AsyncTask<Void,Void,List<Apartment>> {

    private final Context mContext;
    private String LOG_TAG = HousesTask.class.getSimpleName();

    public ApartmentsTask(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    protected List<Apartment> doInBackground(Void... params) {
        List<Apartment> apartments = new ArrayList<>();
        if (Utility.isNetworkAvailable(mContext)){
            //apartments = ApiClient.getTpApiClient(mContext).getApartmentsFromApi();
        }
        return apartments;
    }

    @Override
    protected void onPostExecute(List<Apartment> apartments) {
        super.onPostExecute(apartments);
    }
}
