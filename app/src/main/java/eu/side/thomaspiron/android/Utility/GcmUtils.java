package eu.side.thomaspiron.android.Utility;

import android.content.Context;

import java.util.LinkedList;
import java.util.List;

import eu.side.thomaspiron.android.BuildConfig;
import eu.side.thomaspiron.android.activities.StreetViewActivity;
import eu.side.thomaspiron.android.gcm.GcmClient.GcmClient;
import eu.side.thomaspiron.android.gcm.dto.RegisterFluxForDeviceDTO;


/**
 * Created by mdupierreux1 on 8/02/16.
 */
public class GcmUtils {

    public static void registerCategory(Context context, String category){
        List<String> cat = new LinkedList<>();
        cat.add(category);
        RegisterFluxForDeviceDTO registerFluxForDeviceDTO = new RegisterFluxForDeviceDTO();
        registerFluxForDeviceDTO.setFluxUidList(cat);
        registerFluxForDeviceDTO.setApplicationUid(BuildConfig.APPUID);
        registerFluxForDeviceDTO.setDeviceUid(PrefUtils.getDeviceUID(context));
        /*GcmClient.getTpApiClient(context).registerCategory(registerFluxForDeviceDTO, new Callback() {
            @Override
            public void success(Object o, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });*/
    }

    public static void registerAllCategories(Context context, List<String> cat) {
        RegisterFluxForDeviceDTO registerFluxForDeviceDTO = new RegisterFluxForDeviceDTO();
        registerFluxForDeviceDTO.setFluxUidList(cat);
        registerFluxForDeviceDTO.setApplicationUid(BuildConfig.APPUID);
        registerFluxForDeviceDTO.setDeviceUid(PrefUtils.getDeviceUID(context));
        /*GcmClient.getTpApiClient(context).registerCategory(registerFluxForDeviceDTO, new Callback() {
            @Override
            public void success(Object o, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });*/
    }
}
