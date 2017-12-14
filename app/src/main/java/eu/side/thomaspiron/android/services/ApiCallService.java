package eu.side.thomaspiron.android.services;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import de.greenrobot.event.EventBus;
import eu.side.thomaspiron.android.api.ApiClient;
import eu.side.thomaspiron.android.events.ApartmentsSyncedEvent;
import eu.side.thomaspiron.android.events.HousesSyncedEvent;
import eu.side.thomaspiron.android.events.InspirationsSyncedEvent;
import eu.side.thomaspiron.android.events.LandsSyncedEvent;
import eu.side.thomaspiron.android.model.APModele;
import eu.side.thomaspiron.android.model.Apartment;
import eu.side.thomaspiron.android.model.Land;
import eu.side.thomaspiron.android.model.Maison;
import eu.side.thomaspiron.android.model.PointContact;
import eu.side.thomaspiron.android.model.PointInteret;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleColumns;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleContentValues;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleSelection;
import eu.side.thomaspiron.android.provider.inspiration.InspirationColumns;
import eu.side.thomaspiron.android.provider.inspiration.InspirationContentValues;
import eu.side.thomaspiron.android.provider.pointcontact.PointcontactColumns;
import eu.side.thomaspiron.android.provider.pointcontact.PointcontactContentValues;
import eu.side.thomaspiron.android.provider.pointinteret.PointinteretColumns;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mdupierreux1 on 20/08/15.
 */
public class ApiCallService extends IntentService{

    private static String LOG_TAG = ApiCallService.class.getSimpleName();
    public static ApiClient apiClient = null;


    public ApiCallService() {
        super(ApiCallService.class.getName());
        if (apiClient == null){
            apiClient= new ApiClient();
        }
    }



    protected void onHandleIntent(Intent intent) {
        Log.d(LOG_TAG, "onHandleIntent");
        loadPointInteret();
        loadPointContact();
        loadMaison();
        loadAppartements();
        //loadTerrains();
        loadInspiration();
    }


    private void loadMaison(){

        apiClient.getMaison(new Callback<List<Maison>>() {
            @Override
            public void onResponse(Call<List<Maison>> call, Response<List<Maison>> response) {
                /*String selection = EnsembleColumns.CPTEPL +" like '01UN%' AND "+EnsembleColumns.POSTCODE + " like 'B%' and "
                        +EnsembleColumns.TERRAINSPC +" > 0 ";
*/
                //String selection = EnsembleColumns.CPTEPL +" like '01UN%' AND "+EnsembleColumns.POSTCODE + " like 'B%' ";
                if (response.body() != null) {
                    String selection = EnsembleColumns.MAISON + " = 1 ";

                    getApplicationContext().getContentResolver().delete(EnsembleColumns.CONTENT_URI, selection, null);

                    Vector<ContentValues> cVVector = new Vector<>(response.body().size());

                    for (Maison maison : response.body()) {
                        ContentValues cv = new ContentValues();
                        cv.put(EnsembleColumns.ADRESSE, maison.getAdresse());
                        cv.put(EnsembleColumns.ENSECODE, maison.getEnseCode());
                        cv.put(EnsembleColumns.DESCRIPTIONDISTANCEEN, maison.getDescriptionDistanceEN());
                        cv.put(EnsembleColumns.DESCRIPTIONDISTANCEFR, maison.getDescriptionDistanceFR());
                        cv.put(EnsembleColumns.DIVICODE, maison.getDivicode());
                        cv.put(EnsembleColumns.ENSEDESC, maison.getEnseDesc());
                        cv.put(EnsembleColumns.LATITUDE, maison.getLatitude());
                        cv.put(EnsembleColumns.LIBCOMMERCIALEN, maison.getLibCommercialEn());
                        cv.put(EnsembleColumns.LIBCOMMERCIALFR, maison.getLibCommercialFr());
                        cv.put(EnsembleColumns.LONGITUDE, maison.getLongitude());
                        cv.put(EnsembleColumns.MAISON, true);
                        cv.put(EnsembleColumns.MAISONSC, maison.getMaisonsC());
                        cv.put(EnsembleColumns.MAISONSEC, maison.getMaisonsEC());
                        cv.put(EnsembleColumns.TOTUNIT, maison.getTotUnit());
                        cv.put(EnsembleColumns.TERRAINSPP, maison.getTerrainsPP());
                        cv.put(EnsembleColumns.TERRAINSPC, maison.getTerrainsPC());
                        cv.put(EnsembleColumns.SURFMIN, maison.getTerrainMin());
                        cv.put(EnsembleColumns.SURFMAX, maison.getTerrainMax());
                        cv.put(EnsembleColumns.SOCICODE, maison.getSociCode());
                        cv.put(EnsembleColumns.POSTCODE, maison.getPostCode());
                        cv.put(EnsembleColumns.POSTLOC, maison.getPostLoc());
                        cv.put(EnsembleColumns.CPTEPL, maison.getCptEpl());
                        cv.put(EnsembleColumns.PROVINCE, maison.getProvince());
                        cv.put(EnsembleColumns.IDPOINTCONTACT, maison.getIdPointContact());
                        cv.put(EnsembleColumns.NBMEDIAS, maison.getNbMedias());
                        cv.put(EnsembleColumns.NBPLANSIMPL, maison.getNbPlansImpl());
                        if (maison.getDtDebNouveau() != null)
                            cv.put(EnsembleColumns.DTDEBNOUVEAU, maison.getDtDebNouveau());
                        if (maison.getDtDebRemise() != null)
                            cv.put(EnsembleColumns.DTDEBREMISE, maison.getDtDebRemise());
                        if (maison.getDtFinNouveau() != null)
                            cv.put(EnsembleColumns.DTFINNOUVEAU, maison.getDtFinNouveau());
                        if (maison.getDtFinPorteOuverte() != null)
                            cv.put(EnsembleColumns.DTFINPORTEOUVERTE, maison.getDtFinPorteOuverte());
                        if (maison.getDtFinRemise() != null)
                            cv.put(EnsembleColumns.DTFINREMISE, maison.getDtFinRemise());
                        cv.put(EnsembleColumns.LIBELLEREMISE, maison.getLibelleRemise());
                        cv.put(EnsembleColumns.INFOPORTEOUVERTE, maison.getInfoPorteOuverte());
                        cVVector.add(cv);
                    }
                    if (cVVector.size() > 0) {
                        ContentValues[] cvArray = new ContentValues[cVVector.size()];
                        cVVector.toArray(cvArray);
                        getApplicationContext().getContentResolver().bulkInsert(EnsembleColumns.CONTENT_URI, cvArray);

                    }
                    EventBus.getDefault().post(new HousesSyncedEvent(""));

                }
            }
            @Override
            public void onFailure(Call<List<Maison>> call, Throwable throwable) {
                String errorStr = throwable.getMessage() != null ? throwable.getMessage() : "Error";
                Log.d(LOG_TAG, errorStr);
                EventBus.getDefault().post(new HousesSyncedEvent(errorStr));
            }
        });
    }

    private void loadAppartements(){

        apiClient.getAparts(new Callback<List<Apartment>>() {
            @Override
            public void onResponse(Call<List<Apartment>> call, Response<List<Apartment>> response) {
                //String selection = EnsembleColumns.CPTEPL +" like '09MR%' OR "+EnsembleColumns.CPTEPL +" like '18MR%' OR "+EnsembleColumns.CPTEPL +" like '1UN%'";
                if (response.body() != null ) {
                    String selection = EnsembleColumns.APPART +" = 1";
                    getApplicationContext().getContentResolver().delete(EnsembleColumns.CONTENT_URI,selection,null);

                    Vector<ContentValues> cVVector = new Vector<ContentValues>(response.body().size());
                    for (Apartment apartment : response.body()) {
                        ContentValues cv = new ContentValues();
                        cv.put(EnsembleColumns.ENSECODE, apartment.getEnseCode());
                        cv.put(EnsembleColumns.DESCRIPTIONDISTANCEEN, apartment.getDescriptionDistanceEN());
                        cv.put(EnsembleColumns.DESCRIPTIONDISTANCEFR, apartment.getDescriptionDistanceFR());
                        cv.put(EnsembleColumns.DIVICODE, apartment.getDivicode());
                        cv.put(EnsembleColumns.ENSEDESC, apartment.getEnseDesc());
                        cv.put(EnsembleColumns.LATITUDE, apartment.getLatitude());
                        cv.put(EnsembleColumns.LIBCOMMERCIALEN, apartment.getLibCommercialEn());
                        cv.put(EnsembleColumns.LIBCOMMERCIALFR, apartment.getLibCommercialFr());
                        cv.put(EnsembleColumns.LONGITUDE, apartment.getLongitude());
                        cv.put(EnsembleColumns.APPART, true);
                        cv.put(EnsembleColumns.ADRESSE, apartment.getAdresse());
                        cv.put(EnsembleColumns.SURFMIN, apartment.getSurfMin());
                        cv.put(EnsembleColumns.SURFMAX, apartment.getSurfMax());
                        cv.put(EnsembleColumns.TOTUNIT, apartment.getTotUnit());
                        cv.put(EnsembleColumns.NBAPPARTS, apartment.getNbApparts());
                        cv.put(EnsembleColumns.NBBUREAUX, apartment.getNbBureaux());
                        cv.put(EnsembleColumns.NBCOMMERCES, apartment.getNbCommerces());
                        cv.put(EnsembleColumns.NBDUPLEX, apartment.getNbDuplex());
                        cv.put(EnsembleColumns.NBPENTHOUSES, apartment.getNbPenthouses());
                        cv.put(EnsembleColumns.NBSTUDIOS, apartment.getNbStudios());
                        cv.put(EnsembleColumns.SOCICODE, apartment.getSociCode());
                        cv.put(EnsembleColumns.POSTCODE, apartment.getPostCode());
                        cv.put(EnsembleColumns.POSTLOC, apartment.getPostLoc());
                        cv.put(EnsembleColumns.CPTEPL, apartment.getCptEpl());
                        cv.put(EnsembleColumns.PROVINCE, apartment.getProvince());
                        cv.put(EnsembleColumns.IDPOINTCONTACT, apartment.getIdPointContact());
                        cv.put(EnsembleColumns.NBMEDIAS, apartment.getNbMedias());
                        cv.put(EnsembleColumns.NBPLANSIMPL, apartment.getNbPlansImpl());
                        cv.put(EnsembleColumns.NBTRIPLEX,apartment.getNbTriplex());
                        cv.put(EnsembleColumns.NBQUADRIPLEX,apartment.getNbQuadriplex()
                        );
                        if (apartment.getDtDebNouveau() != null)
                            cv.put(EnsembleColumns.DTDEBNOUVEAU, apartment.getDtDebNouveau());
                        if (apartment.getDtDebRemise() != null)
                            cv.put(EnsembleColumns.DTDEBREMISE, apartment.getDtDebRemise());
                        if (apartment.getDtFinNouveau() != null)
                            cv.put(EnsembleColumns.DTFINNOUVEAU, apartment.getDtFinNouveau());
                        if (apartment.getDtFinPorteOuverte() != null)
                            cv.put(EnsembleColumns.DTFINPORTEOUVERTE, apartment.getDtFinPorteOuverte());
                        if (apartment.getDtFinRemise() != null)
                            cv.put(EnsembleColumns.DTFINREMISE, apartment.getDtFinRemise());
                        cv.put(EnsembleColumns.LIBELLEREMISE, apartment.getLibelleRemise());
                        cv.put(EnsembleColumns.INFOPORTEOUVERTE, apartment.getInfoPorteOuverte());
                        cVVector.add(cv);
                    }

                    if (cVVector.size() > 0) {
                        ContentValues[] cvArray = new ContentValues[cVVector.size()];
                        cVVector.toArray(cvArray);
                        getApplicationContext().getContentResolver().bulkInsert(EnsembleColumns.CONTENT_URI, cvArray);

                    }
                    EventBus.getDefault().post(new ApartmentsSyncedEvent(""));
                }
            }

            @Override
            public void onFailure(Call<List<Apartment>> call, Throwable throwable) {
                String errorStr = throwable.getMessage() != null ? throwable.getMessage() : "Error";
                Log.d(LOG_TAG, errorStr);
                EventBus.getDefault().post(new ApartmentsSyncedEvent(errorStr));
            }
        });
    }

    private void loadInspiration() {

        apiClient.getInspiration(new Callback<List<APModele>>() {
            @Override
            public void onResponse(Call<List<APModele>> call, Response<List<APModele>> response) {
                getApplicationContext().getContentResolver().delete(InspirationColumns.CONTENT_URI,"",null);
                Vector<ContentValues> cVVector = new Vector<ContentValues>(response.body().size());
                for (APModele apModele : response.body()) {
                    ContentValues cv = new ContentValues();
                    cv.put(InspirationColumns.NUMERO,apModele.getNumero());
                    cv.put(InspirationColumns.NUMEROSIMPLIFIE,apModele.getNumero_simplifie());
                    cv.put(InspirationColumns.CLIENT,apModele.getClient());
                    cv.put(InspirationColumns.PRIX,apModele.getPrix());
                    cv.put(InspirationColumns.IDAPMODELE, apModele.getIdAPModele());
                    cVVector.add(cv);
                }

                if ( cVVector.size() > 0 ) {
                    ContentValues[] cvArray = new ContentValues[cVVector.size()];
                    cVVector.toArray(cvArray);
                    getApplicationContext().getContentResolver().bulkInsert(InspirationColumns.CONTENT_URI, cvArray);

                }
                EventBus.getDefault().post(new InspirationsSyncedEvent(""));

            }

            @Override
            public void onFailure(Call<List<APModele>> call, Throwable throwable) {
                String errorStr = throwable.getMessage() != null ? throwable.getMessage() : "Error";
                Log.d(LOG_TAG, errorStr);
                EventBus.getDefault().post(new InspirationsSyncedEvent(errorStr));
            }
        });
    }

    public void loadPointInteret() {

        apiClient.getPointInteret(new Callback<List<PointInteret>>() {
            @Override
            public void onResponse(Call<List<PointInteret>> call, Response<List<PointInteret>> response) {
                getContentResolver().delete(PointcontactColumns.CONTENT_URI,"",null);

                Vector<ContentValues> cVVector = new Vector<ContentValues>(response.body().size());
                for (PointInteret pointInteret : response.body()) {
                    ContentValues cv = new ContentValues();
                    cv.put(PointinteretColumns.LIBELLEFR,pointInteret.getLibelleFr());
                    cv.put(PointinteretColumns.LIBELLEEN,pointInteret.getLibelleEn());
                    cv.put(PointinteretColumns.EMAIL,pointInteret.getEmail());
                    cv.put(PointinteretColumns.IDPAYS,pointInteret.getIdPays());
                    cv.put(PointinteretColumns.IDINTERET,pointInteret.getIdInteret());
                    cVVector.add(cv);
                }

                if ( cVVector.size() > 0 ) {
                    ContentValues[] cvArray = new ContentValues[cVVector.size()];
                    cVVector.toArray(cvArray);
                    getApplicationContext().getContentResolver().bulkInsert(PointinteretColumns.CONTENT_URI, cvArray);

                }
            }

            @Override
            public void onFailure(Call<List<PointInteret>> call, Throwable throwable) {

            }
        });
    }

    public void loadPointContact(){

        apiClient.getPointContact(new Callback<List<PointContact>>() {
            @Override
            public void onResponse(Call<List<PointContact>> call, Response<List<PointContact>> response) {
                getContentResolver().delete(PointcontactColumns.CONTENT_URI,"",null);

                Vector<ContentValues> cVVector = new Vector<ContentValues>(response.body().size());
                PointcontactContentValues values;
                for (PointContact pc : response.body()) {
                    ContentValues cv = new ContentValues();
                    cv.put(PointcontactColumns.IDPOINTCONTACT,pc.getIdPointContact());
                    cv.put(PointcontactColumns.TYPEPOINTCONTACT,pc.getTypePointContact());
                    cv.put(PointcontactColumns.TITRE,pc.getTitre());
                    cv.put(PointcontactColumns.ADRESSE,pc.getAdresse());
                    cv.put(PointcontactColumns.POSTLOC,pc.getPostLoc());
                    cv.put(PointcontactColumns.POSTCODE,pc.getPostCode());
                    cv.put(PointcontactColumns.TEL,pc.getTel());
                    cv.put(PointcontactColumns.LATITUDE,pc.getLatitude());
                    cv.put(PointcontactColumns.LONGITUDE, pc.getLongitude());
                    cv.put(PointcontactColumns.PERMANENCEFR,pc.getPermanenceFr());
                    cv.put(PointcontactColumns.NBMEDIAS,pc.getNbMedias());

                    cVVector.add(cv);
                }
                if ( cVVector.size() > 0 ) {
                    ContentValues[] cvArray = new ContentValues[cVVector.size()];
                    cVVector.toArray(cvArray);
                    getApplicationContext().getContentResolver().bulkInsert(PointcontactColumns.CONTENT_URI, cvArray);

                }
            }

            @Override
            public void onFailure(Call<List<PointContact>> call, Throwable throwable) {

            }
        });
    }
}
