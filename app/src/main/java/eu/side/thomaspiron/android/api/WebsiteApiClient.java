package eu.side.thomaspiron.android.api;

import android.content.Context;

import eu.side.thomaspiron.android.BuildConfig;
import eu.side.thomaspiron.android.RESTService.TpService;
import eu.side.thomaspiron.android.RESTService.WebsiteService;

/**
 * Created by mdupierreux1 on 1/12/15.
 */
public class WebsiteApiClient {
    private static String ENDPOINT_ADDRESS = "http://www.thomas-piron.eu";
    private static WebsiteService websiteApiClient;

    public static WebsiteService getWebsiteApiClient(Context context){
        /*if (websiteApiClient == null){
            RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(ENDPOINT_ADDRESS).build();
            websiteApiClient = restAdapter.create(WebsiteService.class);
        }*/

        return websiteApiClient;
    }
}
