package eu.side.thomaspiron.android.gcm.interfaces;

import java.util.List;


import eu.side.thomaspiron.android.gcm.Constant;
import eu.side.thomaspiron.android.gcm.dto.CategoryDeviceDTO;
import eu.side.thomaspiron.android.gcm.dto.DeviceRegistrationDTO;
import eu.side.thomaspiron.android.gcm.dto.RegisterFluxForDeviceDTO;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by qgerain on 14/08/15.
 */
public interface RegisterDeviceInterface {

    /*@Headers(Constant.XAUTHAPPHEADER+": "+ Constant.XAUTHAPPHEADER_VALUE)
    @POST("/pushnotificationserver/api/rest/v1/device/register")
    String registerDevice(@Body DeviceRegistrationDTO dto);*/

    @Headers(Constant.XAUTHAPPHEADER+": "+ Constant.XAUTHAPPHEADER_VALUE)
    @POST("/api/rest/v1/device/register")
    String registerDevice(@Body DeviceRegistrationDTO dto);

    @Headers(Constant.XAUTHAPPHEADER+": "+ Constant.XAUTHAPPHEADER_VALUE)
    @POST("/api/rest/v1/device/flux/register")
    void registerCategory(@Body RegisterFluxForDeviceDTO dto, Callback<String> callback);

    @Headers(Constant.XAUTHAPPHEADER+": "+ Constant.XAUTHAPPHEADER_VALUE)
    @GET("/api/rest/v1/device/category/list")
    List<CategoryDeviceDTO> getCategoryList(@Query("appuid") String appUid);


}
