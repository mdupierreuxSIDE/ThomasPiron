package eu.side.thomaspiron.android.RESTService;



import org.json.JSONObject;

import java.util.List;

import eu.side.thomaspiron.android.model.EplMedia;
import eu.side.thomaspiron.android.model.APModele;
import eu.side.thomaspiron.android.model.Apartment;
import eu.side.thomaspiron.android.model.Contact;
import eu.side.thomaspiron.android.model.Land;
import eu.side.thomaspiron.android.model.Lot;
import eu.side.thomaspiron.android.model.Maison;
import eu.side.thomaspiron.android.model.PointContact;
import eu.side.thomaspiron.android.model.PointInteret;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mdupierreux1 on 5/08/15.
 */
public interface TpService {
    @Headers("X-Authorization-App: VFBBcHBsaWNhdGlvblNlcnZlckFwcEF1dGhvcml6YXRpb24kSURFMjAxNQ==")
    @GET("v2/maison/list")
    Call<List<Maison>> getHousesFromApiAsync();

    @Headers("X-Authorization-App: VFBBcHBsaWNhdGlvblNlcnZlckFwcEF1dGhvcml6YXRpb24kSURFMjAxNQ==")
    @GET("v3/appart/list")
    Call<List<Apartment>> getApartmentsFromApiAsync();

    @Headers("X-Authorization-App: VFBBcHBsaWNhdGlvblNlcnZlckFwcEF1dGhvcml6YXRpb24kSURFMjAxNQ==")
    @GET("v1/terrain")
    void getLandsFromApiAsync(Callback<List<Land>> callback);

    @Headers("X-Authorization-App: VFBBcHBsaWNhdGlvblNlcnZlckFwcEF1dGhvcml6YXRpb24kSURFMjAxNQ==")
    @GET("v1/lot/bycode")
    Call<List<Lot>> getLotsFromEnsembleAsync(@Query("code") String enseCode, @Query("socicode") String socicode);

    @Headers("X-Authorization-App: VFBBcHBsaWNhdGlvblNlcnZlckFwcEF1dGhvcml6YXRpb24kSURFMjAxNQ==")
    @GET("v1/apmodele/listinprice")
    void getAPModelesPriceAsync(@Query("min") String min, @Query("max") String max, Callback<List<APModele>> callback);

    @Headers("X-Authorization-App: VFBBcHBsaWNhdGlvblNlcnZlckFwcEF1dGhvcml6YXRpb24kSURFMjAxNQ==")
    @GET("v1/apmodele/list")
    Call<List<APModele>> getAPModelesAsync();

    @Headers("X-Authorization-App: VFBBcHBsaWNhdGlvblNlcnZlckFwcEF1dGhvcml6YXRpb24kSURFMjAxNQ==")
    @GET("v1/projet/listinteret")
    Call<List<PointInteret>> getPointInteretAsync();

    @Headers("X-Authorization-App: VFBBcHBsaWNhdGlvblNlcnZlckFwcEF1dGhvcml6YXRpb24kSURFMjAxNQ==")
    @GET("v1/projet/listinteretcountry")
    Call<List<PointInteret>> getPointInteretCountryAsync(@Query("pays") String pays);

    @Headers("X-Authorization-App: VFBBcHBsaWNhdGlvblNlcnZlckFwcEF1dGhvcml6YXRpb24kSURFMjAxNQ==")
    @GET("v1/projet/listpointcontact")
    Call<List<PointContact>> getPointContactAsync();

    @Headers("X-Authorization-App: VFBBcHBsaWNhdGlvblNlcnZlckFwcEF1dGhvcml6YXRpb24kSURFMjAxNQ==")
    @GET("v1/projet/listpointcontactfiltered")
    void getPointContactFilteredAsync(@Query("type") Integer type,Callback<List<PointContact>> callback);


    @Headers("X-Authorization-App: VFBBcHBsaWNhdGlvblNlcnZlckFwcEF1dGhvcml6YXRpb24kSURFMjAxNQ==")
    @GET("v1/files/list/size/{size}/epl/{cptepl}/type/{type}")
    Call<List<EplMedia>> getEplMedia(@Path("size") String size, @Path("cptepl") String cptepl, @Path("type") String type);

    @Headers("X-Authorization-App: VFBBcHBsaWNhdGlvblNlcnZlckFwcEF1dGhvcml6YXRpb24kSURFMjAxNQ==")
    @GET("v1/files/reference/size/{size}/epl/{cptepl}/type/{type}")
    Call<List<EplMedia>> getEplMediaReference(@Path("size") String size, @Path("cptepl") String cptepl, @Path("type") String type);

    @Headers("X-Authorization-App: VFBBcHBsaWNhdGlvblNlcnZlckFwcEF1dGhvcml6YXRpb24kSURFMjAxNQ==")
    @POST("v1/contact/post")
    Call<JSONObject> postContact(@Body Contact contact);


}
