package eu.side.thomaspiron.android.loaders;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import eu.side.thomaspiron.android.model.Apartment;
import eu.side.thomaspiron.android.model.Ensemble;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleColumns;

/**
 * Created by mdupierreux1 on 10/08/15.
 */
public class AppartLoader extends AsyncTaskLoader<List<Apartment>>{

    private String mSearchText;
    private List<Apartment> mData;
    private Cursor mCursor;
    private static String LOG_TAG = AppartLoader.class.getSimpleName();
    private String mProvince;

    public AppartLoader(Context context,String province){
        super(context);
        this.mProvince = province;
    }

    public AppartLoader(Context applicationContext, String province, String mSearchText) {
        super(applicationContext);
        this.mProvince = province;
        this.mSearchText = mSearchText;
    }

    @Override
    public List<Apartment> loadInBackground() {
        List<Apartment> data = new ArrayList<>();

        if (mCursor != null && !mCursor.isClosed()) mCursor.close();
        mCursor = queryTPProvider(getContext(), mProvince,mSearchText);
        while (mCursor.moveToNext()){
            Apartment apartment = getAppartFromCursor(mCursor);

            if (apartment != null){
                Log.d(LOG_TAG, "loadinbackground " + apartment.getCptEpl());
                data.add(apartment);
            }
        }
        return data;
    }

    private static Cursor queryTPProvider(Context context, String province, String searchText){
        String[] projection = {
                EnsembleColumns.ENSECODE,//0
                EnsembleColumns.ENSEDESC,//1
                EnsembleColumns.NBAPPARTS,//2
                EnsembleColumns.NBBUREAUX,//3
                EnsembleColumns.NBCOMMERCES,//4
                EnsembleColumns.NBDUPLEX,//5
                EnsembleColumns.NBPENTHOUSES,//6
                EnsembleColumns.NBSTUDIOS,//7
                EnsembleColumns.CPTEPL,//8
                EnsembleColumns.LIBCOMMERCIALFR,//9
                EnsembleColumns.POSTLOC,//10
                EnsembleColumns.POSTCODE,//11
                EnsembleColumns.ADRESSE,//12
                EnsembleColumns.SOCICODE, //13
                EnsembleColumns.DIVICODE,//14
                EnsembleColumns.SURFMAX, //15
                EnsembleColumns.SURFMIN, //16
                EnsembleColumns.PROVINCE, //17
                EnsembleColumns.LATITUDE, //18
                EnsembleColumns.LONGITUDE, //19
                EnsembleColumns.NBMEDIAS, //20
                EnsembleColumns.NBPLANSIMPL, //21
                EnsembleColumns.LIBELLEREMISE, //22
                EnsembleColumns.DTDEBREMISE, //23
                EnsembleColumns.DTFINREMISE, //24
                EnsembleColumns.INFOPORTEOUVERTE, //25
                EnsembleColumns.DTFINPORTEOUVERTE, //26
                EnsembleColumns.DTDEBNOUVEAU, //27
                EnsembleColumns.DTFINNOUVEAU, // 28
                EnsembleColumns.NBTRIPLEX, // 29
                EnsembleColumns.NBQUADRIPLEX // 30

        };

        if (searchText == null) searchText = "";
        StringBuilder sb = new StringBuilder("(")
                //.append(EnsembleColumns.CPTEPL)
                /*.append(" like '09MR%' OR ")
                .append(EnsembleColumns.CPTEPL)
                .append(" like '18MR%' OR ")
                .append(EnsembleColumns.CPTEPL)
                .append(" like '1UN%') AND ")*/
                .append(EnsembleColumns.APPART)
                .append(" = ").append(" 1) AND ")
                .append(EnsembleColumns.POSTCODE)
                .append(" like 'B%'").append(" AND (")
                .append(EnsembleColumns.POSTLOC)
                .append(" like '%")
                .append(searchText.replaceAll("'"," "))
                .append("%'")
                .append(" AND ")
                .append(EnsembleColumns.PROVINCE)
                .append(" like '%")
                .append(province)
                .append("%')");


        String selection = sb.toString();
        String[] selectionArg = {"1","09"};
        String sortOrder = EnsembleColumns.PROVINCE+","+EnsembleColumns.ENSECODE;
        return context.getContentResolver().query(EnsembleColumns.CONTENT_URI,projection,selection,null,sortOrder);
    }

    public static  Apartment getAppartFromCursor(Cursor cursor){
        Apartment apartment = new Apartment();
        apartment.setEnseCode(cursor.getString(0));
        apartment.setEnseDesc(cursor.getString(1));
        apartment.setNbApparts(cursor.getInt(2));
        apartment.setNbBureaux(cursor.getInt(3));
        apartment.setNbCommerces(cursor.getInt(4));
        apartment.setNbDuplex(cursor.getInt(5));
        apartment.setNbPenthouses(cursor.getInt(6));
        apartment.setNbStudios(cursor.getInt(7));
        apartment.setCptEpl(cursor.getString(8));
        apartment.setLibCommercialFr(cursor.getString(9));
        apartment.setPostLoc(cursor.getString(10));
        apartment.setPostCode(cursor.getString(11));
        apartment.setAdresse(cursor.getString(12));
        apartment.setSociCode(cursor.getString(13));
        apartment.setDivicode(cursor.getString(14));
        apartment.setSurfMax(cursor.getString(15));
        apartment.setSurfMin(cursor.getString(16));
        apartment.setProvince(cursor.getString(17));
        apartment.setLatitude(cursor.getDouble(18));
        apartment.setLongitude(cursor.getDouble(19));
        apartment.setNbMedias(cursor.getInt(20));
        apartment.setNbPlansImpl(cursor.getInt(21));
        apartment.setLibelleRemise(cursor.getString(22));
        apartment.setDtDebRemise(cursor.getLong(23));
        apartment.setDtFinRemise(cursor.getLong(24));
        apartment.setInfoPorteOuverte(cursor.getString(25));
        apartment.setDtFinPorteOuverte(cursor.getLong(26));
        apartment.setDtDebNouveau(cursor.getLong(27));
        apartment.setDtFinNouveau(cursor.getLong(28));
        apartment.setNbTriplex(cursor.getInt(29));
        apartment.setNbQuadriplex(cursor.getInt(30));
        return apartment;
    }

    @Override
    public void deliverResult(List<Apartment> data) {
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
    public void onCanceled(List<Apartment> data) {
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
