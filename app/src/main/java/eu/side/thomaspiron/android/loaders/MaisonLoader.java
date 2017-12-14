package eu.side.thomaspiron.android.loaders;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import eu.side.thomaspiron.android.model.Maison;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleColumns;

/**
 * Created by mdupierreux1 on 7/08/15.
 */
public class MaisonLoader extends AsyncTaskLoader<List<Maison>> {

    private List<Maison> mData;
    private String mProvince;
    private Cursor mCursor;
    private String mSearchText;
    private static String LOG_TAG = MaisonLoader.class.getSimpleName();

    public MaisonLoader(Context context, String province){
        super(context);
        this.mProvince = province;
    }

    public MaisonLoader(Context applicationContext, String province, String mSearchText) {
        super(applicationContext);
        this.mProvince = province;
        this.mSearchText = mSearchText;
    }

    @Override
    public List<Maison> loadInBackground() {
        List<Maison> data = new ArrayList<>();
        if (mCursor != null && !mCursor.isClosed()) mCursor.close();
        mCursor = queryTPProvider(getContext(), mProvince,mSearchText);
        while (mCursor.moveToNext()){
            Maison maison = getMaisonFromCursor(mCursor);

            if (maison != null){
                Log.d(LOG_TAG,"loadinbackground " + maison.getCptEpl());
                data.add(maison);
            }
        }
        return data;
    }

    private static Cursor queryTPProvider(Context context, String province, String searchText){
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
                EnsembleColumns.NBPLANSIMPL, //22
                EnsembleColumns.LIBELLEREMISE, //23
                EnsembleColumns.DTDEBREMISE,//24
                EnsembleColumns.DTFINREMISE, //25
                EnsembleColumns.DTDEBNOUVEAU, //26
                EnsembleColumns.DTFINNOUVEAU, //27
                EnsembleColumns.INFOPORTEOUVERTE, //28
                EnsembleColumns.DTFINPORTEOUVERTE // 29

        };

        if (searchText == null) searchText = "";
        StringBuilder sb = new StringBuilder("(")
                //.append(EnsembleColumns.CPTEPL)
                //.append(" like '01UN%') AND ")
                .append(EnsembleColumns.MAISON)
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

        //String selection = EnsembleColumns.CPTEPL +" like '01UN%' AND "+EnsembleColumns.POSTCODE + " like 'B%' and "
       //         +EnsembleColumns.TERRAINSPC +" > 0 and Province like '%"+province+"%'";
       // String[] selectionArg = {"1"};
        String sortOrder = EnsembleColumns.PROVINCE+","+EnsembleColumns.ENSECODE;
        return context.getContentResolver().query(EnsembleColumns.CONTENT_URI,projection,selection,null,sortOrder);
    }

    private static Maison getMaisonFromCursor(Cursor cursor){
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
        maison.setTerrainMax(cursor.getString(16));
        maison.setTerrainMax(cursor.getString(17));
        maison.setProvince(cursor.getString(18));
        maison.setLatitude(cursor.getDouble(19));
        maison.setLongitude(cursor.getDouble(20));
        maison.setNbMedias(cursor.getInt(21));
        maison.setNbPlansImpl(cursor.getInt(22));
        maison.setLibelleRemise(cursor.getString(23));
        maison.setDtDebRemise(cursor.getLong(24));
        maison.setDtFinRemise(cursor.getLong(25));
        maison.setDtDebNouveau(cursor.getLong(26));
        maison.setDtFinNouveau(cursor.getLong(27));
        maison.setInfoPorteOuverte(cursor.getString(28));
        maison.setDtFinPorteOuverte(cursor.getLong(29));
        return maison;
    }

    @Override
    public void deliverResult(List<Maison> data) {
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
    public void onCanceled(List<Maison> data) {
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
