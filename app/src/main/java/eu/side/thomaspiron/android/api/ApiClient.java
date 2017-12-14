package eu.side.thomaspiron.android.api;

import android.content.Context;

import org.json.JSONObject;

import java.util.List;

import eu.side.thomaspiron.android.BuildConfig;
import eu.side.thomaspiron.android.RESTService.TpService;
import eu.side.thomaspiron.android.fragments.UnitListFragment;
import eu.side.thomaspiron.android.model.APModele;
import eu.side.thomaspiron.android.model.Apartment;
import eu.side.thomaspiron.android.model.Contact;
import eu.side.thomaspiron.android.model.EplMedia;
import eu.side.thomaspiron.android.model.Lot;
import eu.side.thomaspiron.android.model.Maison;
import eu.side.thomaspiron.android.model.PointContact;
import eu.side.thomaspiron.android.model.PointInteret;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mdupierreux1 on 5/08/15.
 */
public class ApiClient {
    private static String ENDPOINT_ADDRESS = BuildConfig.ENDPOINT_ADDRESS;
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ENDPOINT_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    TpService tpService = retrofit.create(TpService.class);

    public void getMaison(Callback<List<Maison>> callback){
        Call<List<Maison>> call = tpService.getHousesFromApiAsync();
        call.enqueue(callback);
    }

    public void getAparts(Callback<List<Apartment>> callback){
        Call<List<Apartment>> call = tpService.getApartmentsFromApiAsync();
        call.enqueue(callback);
    }

    public void getInspiration(Callback<List<APModele>> callback){
        Call<List<APModele>> call = tpService.getAPModelesAsync();
        call.enqueue(callback);
    }
    public void getPointInteret(Callback<List<PointInteret>> callback){
        Call<List<PointInteret>> call = tpService.getPointInteretAsync();
        call.enqueue(callback);
    }

    public void getPointContact(Callback<List<PointContact>> callback){
        Call<List<PointContact>> call = tpService.getPointContactAsync();
        call.enqueue(callback);
    }

    public void postContact(Callback<JSONObject> callback, Contact contact){
        Call<JSONObject> call = tpService.postContact(contact);
        call.enqueue(callback);
    }

    public void getLotsFromEnsemble(String enseCode, String socicode, Callback<List<Lot>> callback) {
        Call<List<Lot>> call = tpService.getLotsFromEnsembleAsync(enseCode,socicode);
        call.enqueue(callback);
    }

    public void getEplMedia(String size, String epl, String type, Callback<List<EplMedia>> callback){
        Call<List<EplMedia>> call = tpService.getEplMedia(size,epl,type);
        call.enqueue(callback);
    }

    public void getEplMediaReference(String size, String epl, String type, Callback<List<EplMedia>> callback){
        Call<List<EplMedia>> call = tpService.getEplMediaReference(size,epl,type);
        call.enqueue(callback);
    }
}
