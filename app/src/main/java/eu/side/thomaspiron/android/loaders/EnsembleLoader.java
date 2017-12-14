package eu.side.thomaspiron.android.loaders;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import eu.side.thomaspiron.android.model.Apartment;
import eu.side.thomaspiron.android.model.Ensemble;
import eu.side.thomaspiron.android.model.Maison;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleColumns;

/**
 * Created by mdupierreux1 on 8/12/15.
 */
public class EnsembleLoader extends AsyncTaskLoader<List<Ensemble>> {

    private List<Ensemble> mData;
    private String mFilter;
    private Cursor mCursor;
    private boolean isMaison;
    private static String LOG_TAG = MaisonLoader.class.getSimpleName();

    public EnsembleLoader(Context context, String filter, boolean isMaison) {
        super(context);
        this.mFilter = filter;
        this.isMaison = isMaison;
    }

    @Override
    public List<Ensemble> loadInBackground() {
        List<Ensemble> data = new ArrayList<>();
        if (mCursor != null && !mCursor.isClosed()) mCursor.close();
        mCursor = queryTPProvider(getContext(), mFilter);
        while (mCursor.moveToNext()) {
            Ensemble ensemble = getEnsembleFromCursor(mCursor, isMaison);

            if (ensemble != null) {
                Log.d(LOG_TAG, "loadinbackground " + ensemble.getCptEpl());
                data.add(ensemble);
            }
        }
        return data;
    }

    private static Cursor queryTPProvider(Context context, String filter) {
        String[] projection = {
                EnsembleColumns.ENSECODE,//0
                EnsembleColumns.ENSEDESC,//1
                EnsembleColumns.TERRAINSEC,//2
                EnsembleColumns.TERRAINSPC,//3
                EnsembleColumns.TERRAINSPP,//4
                EnsembleColumns.MAISONSC,//5
                EnsembleColumns.MAISONSEC,//6
                EnsembleColumns.CPTEPL,//7
                EnsembleColumns.LIBCOMMERCIALFR,//8
                EnsembleColumns.POSTLOC,//9
                EnsembleColumns.POSTCODE,//10
                EnsembleColumns.ADRESSE,//11
                EnsembleColumns.TERRAINMIN,//12
                EnsembleColumns.TERRAINMAX, //13
                EnsembleColumns.SOCICODE, //14
                EnsembleColumns.DIVICODE, //15
                EnsembleColumns.SURFMAX, //16
                EnsembleColumns.SURFMIN, //17
                EnsembleColumns.PROVINCE, //18
                EnsembleColumns.LATITUDE, //19
                EnsembleColumns.LONGITUDE, //20
                EnsembleColumns.NBMEDIAS, //21
                EnsembleColumns.NBPLANSIMPL,//22
                EnsembleColumns.NBAPPARTS,//23
                EnsembleColumns.NBBUREAUX,//24
                EnsembleColumns.NBCOMMERCES,//25
                EnsembleColumns.NBDUPLEX,//26
                EnsembleColumns.NBPENTHOUSES,//27
                EnsembleColumns.NBSTUDIOS,//28
                EnsembleColumns.DESCRIPTIONDISTANCEFR, //29
                EnsembleColumns.IDPOINTCONTACT, //30
                EnsembleColumns.LIBELLEREMISE, //31
                EnsembleColumns.DTDEBREMISE, //32
                EnsembleColumns.DTFINREMISE, //33
                EnsembleColumns.INFOPORTEOUVERTE, //34
                EnsembleColumns.DTFINPORTEOUVERTE, //35
                EnsembleColumns.NBTRIPLEX, //36
                EnsembleColumns.NBQUADRIPLEX //37
        };

        String selection = EnsembleColumns.POSTCODE + " like 'B%' and "
                + filter;
        String sortOrder = EnsembleColumns.PROVINCE + "," + EnsembleColumns.ENSECODE;
        return context.getContentResolver().query(EnsembleColumns.CONTENT_URI, projection, selection, null, sortOrder);
    }

    private static Ensemble getEnsembleFromCursor(Cursor cursor, boolean isMaison) {
        if (isMaison) {
            Maison maison = new Maison();
            maison.setEnseCode(cursor.getString(0));
            maison.setEnseDesc(cursor.getString(1));
            maison.setTerrainsPC(cursor.getInt(3));
            maison.setTerrainsPP(cursor.getInt(4));
            maison.setMaisonsC(cursor.getInt(5));
            maison.setMaisonsEC(cursor.getInt(6));
            maison.setCptEpl(cursor.getString(7));
            maison.setLibCommercialFr(cursor.getString(8));
            maison.setPostLoc(cursor.getString(9));
            maison.setPostCode(cursor.getString(10));
            maison.setAdresse(cursor.getString(11));
            maison.setTerrainMax(cursor.getString(13));
            maison.setTerrainMin(cursor.getString(12));
            maison.setSociCode(cursor.getString(14));
            maison.setDivicode(cursor.getString(15));
            maison.setTerrainMin(cursor.getString(17));
            maison.setTerrainMax(cursor.getString(16));
            maison.setProvince(cursor.getString(18));
            maison.setLatitude(cursor.getDouble(19));
            maison.setLongitude(cursor.getDouble(20));
            maison.setNbMedias(cursor.getInt(21));
            maison.setNbPlansImpl(cursor.getInt(22));
            maison.setDescriptionDistanceFR(cursor.getString(29));
            maison.setIdPointContact(cursor.getInt(30));
            maison.setLibelleRemise(cursor.getString(31));
            maison.setDtDebRemise(cursor.getLong(32));
            maison.setDtFinRemise(cursor.getLong(33));
            maison.setInfoPorteOuverte(cursor.getString(34));
            maison.setDtFinPorteOuverte(cursor.getLong(35));
            return maison;
        } else {
            Apartment apartment = new Apartment();
            apartment.setEnseCode(cursor.getString(0));
            apartment.setEnseDesc(cursor.getString(1));
            apartment.setNbApparts(cursor.getInt(23));
            apartment.setNbBureaux(cursor.getInt(24));
            apartment.setNbCommerces(cursor.getInt(25));
            apartment.setNbDuplex(cursor.getInt(26));
            apartment.setNbPenthouses(cursor.getInt(27));
            apartment.setNbStudios(cursor.getInt(28));
            apartment.setCptEpl(cursor.getString(7));
            apartment.setLibCommercialFr(cursor.getString(8));
            apartment.setPostLoc(cursor.getString(9));
            apartment.setPostCode(cursor.getString(10));
            apartment.setAdresse(cursor.getString(11));
            apartment.setSociCode(cursor.getString(14));
            apartment.setDivicode(cursor.getString(15));
            apartment.setSurfMin(cursor.getString(17));
            apartment.setSurfMax(cursor.getString(16));
            apartment.setProvince(cursor.getString(18));
            apartment.setLatitude(cursor.getDouble(19));
            apartment.setLongitude(cursor.getDouble(20));
            apartment.setNbMedias(cursor.getInt(21));
            apartment.setNbPlansImpl(cursor.getInt(22));
            apartment.setDescriptionDistanceFR(cursor.getString(29));
            apartment.setIdPointContact(cursor.getInt(30));
            apartment.setLibelleRemise(cursor.getString(31));
            apartment.setDtDebRemise(cursor.getLong(32));
            apartment.setDtFinRemise(cursor.getLong(33));
            apartment.setInfoPorteOuverte(cursor.getString(34));
            apartment.setDtFinPorteOuverte(cursor.getLong(35));
            apartment.setNbTriplex(cursor.getInt(36));
            apartment.setNbQuadriplex(cursor.getInt(37));
            return apartment;
        }
    }

    @Override
    public void deliverResult(List<Ensemble> data) {
        mData = data;

        if (isStarted()) {
            super.deliverResult(data);
        }
    }

    @Override
    protected void onStartLoading() {
        if (mData != null) {
            deliverResult(mData);
        }

        if (takeContentChanged() || mData == null) {
            forceLoad();
        }
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onReset() {
        onStopLoading();
        releaseResources();
    }

    @Override
    public void onCanceled(List<Ensemble> data) {
        super.onCanceled(data);
        releaseResources();
    }

    private void releaseResources() {
        mData = null;
        if (mCursor != null) {
            if (!mCursor.isClosed()) mCursor.close();
            mCursor = null;
        }
    }
}