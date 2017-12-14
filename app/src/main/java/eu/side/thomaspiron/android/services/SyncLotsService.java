package eu.side.thomaspiron.android.services;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import java.util.List;
import java.util.Vector;

import de.greenrobot.event.EventBus;
import eu.side.thomaspiron.android.api.ApiClient;
import eu.side.thomaspiron.android.events.LotsSyncedEvent;
import eu.side.thomaspiron.android.model.Lot;
import eu.side.thomaspiron.android.provider.lots.LotsColumns;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static eu.side.thomaspiron.android.services.ApiCallService.apiClient;

/**
 * Created by mdupierreux1 on 26/08/15.
 */
public class SyncLotsService extends IntentService implements Callback<List<Lot>> {

    private String mEnseCode, mSociCode;
    private Context context;

    public SyncLotsService(String mEnseCode, String mSociCode, Context context) {
        super(SyncLotsService.class.getName());
        this.mEnseCode = mEnseCode;
        this.mSociCode = mSociCode;
        this.context = context;
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public SyncLotsService(String name) {
        super(name);
    }

    public SyncLotsService(){
        super(SyncLotsService.class.getName());
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if(intent.hasExtra("ENSE_CODE") && intent.hasExtra("SOCI_CODE")) {
            mEnseCode = intent.getStringExtra("ENSE_CODE");
            mSociCode = intent.getStringExtra("SOCI_CODE");
            loadLots();
        }
    }

    public void loadLots(){
        apiClient = new ApiClient();
        apiClient.getLotsFromEnsemble(mEnseCode,mSociCode,this);
    }

    @Override
    public void onResponse(Call<List<Lot>> call, Response<List<Lot>> response) {
        if (response.body() != null) {
            Vector<ContentValues> cVVector = new Vector<ContentValues>(response.body().size());
            for (Lot lot : response.body()) {
                ContentValues contentValues = new ContentValues();

                contentValues.put(LotsColumns.BALCON, lot.getBalcon());
                contentValues.put(LotsColumns.CHAMBRES, lot.getChambres());
                contentValues.put(LotsColumns.CODEETAGE, lot.getCodeEtage());
                contentValues.put(LotsColumns.CPTEPL, lot.getCptepl());
                contentValues.put(LotsColumns.FACADESNBR, lot.getFacades());
                contentValues.put(LotsColumns.JARDIN, lot.getJardin());
                contentValues.put(LotsColumns.LIBELLEFR, lot.getLibEtage());
                contentValues.put(LotsColumns.LOTDESC, lot.getLotDesc());
                contentValues.put(LotsColumns.ORIENTATION, lot.getOrientation());
                contentValues.put(LotsColumns.STATUTLOT, lot.getStatut());
                contentValues.put(LotsColumns.SURFTER, lot.getSurfTerrain());
                contentValues.put(LotsColumns.ENSECODE, mEnseCode);
                contentValues.put(LotsColumns.SOCICODE, mSociCode);
                contentValues.put(LotsColumns.PEBCLASSEENERGETIQUE, lot.getPebClasseEnergetique());
                contentValues.put(LotsColumns.SURFHAB, lot.getSurfHab());
                contentValues.put(LotsColumns.NBMEDIAS, lot.getNbMedias());
                contentValues.put(LotsColumns.NBPLANSIMPL, lot.getNbPlansImpl());
                cVVector.add(contentValues);

            }

            if (cVVector.size() > 0) {
                ContentValues[] cvArray = new ContentValues[cVVector.size()];
                cVVector.toArray(cvArray);
                getApplicationContext().getContentResolver().bulkInsert(LotsColumns.CONTENT_URI, cvArray);

            }
        }
        EventBus.getDefault().post(new LotsSyncedEvent(""));
    }

    @Override
    public void onFailure(Call<List<Lot>> call, Throwable throwable) {
        EventBus.getDefault().post(new LotsSyncedEvent(throwable.getMessage()));
    }

}
