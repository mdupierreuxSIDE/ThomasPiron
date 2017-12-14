package eu.side.thomaspiron.android.loaders;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import eu.side.thomaspiron.android.model.Land;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleColumns;

/**
 * Created by mdupierreux1 on 10/08/15.
 */
public class TerrainLoader extends AsyncTaskLoader<List<Land>>{

    private List<Land> mData;
    private Cursor mCursor;
    private static String LOG_TAG = TerrainLoader.class.getSimpleName();
    private String mProvince;

    public TerrainLoader(Context context,String province){
        super(context);
        this.mProvince = province;
    }


    @Override
    public List<Land> loadInBackground() {
        List<Land> data = new ArrayList<>();
        if (mCursor != null && !mCursor.isClosed()) mCursor.close();
        mCursor = queryTPProvider(getContext(), mProvince);
        while (mCursor.moveToNext()){
            Land land = getTerrainFromCursor(mCursor);

            if (land != null){
                Log.d(LOG_TAG, "loadinbackground " + land.getCptEpl());
                data.add(land);
            }
        }
        return data;
    }

    private static Cursor queryTPProvider(Context context, String province){
        String[] projection = {
                EnsembleColumns.ENSECODE,//0
                EnsembleColumns.ENSEDESC,//1
                EnsembleColumns.NBTERRAINSDISPO,//2
                EnsembleColumns.CPTEPL,//3
                EnsembleColumns.LIBCOMMERCIALFR,//4
                EnsembleColumns.POSTLOC,//5
                EnsembleColumns.POSTCODE,//6
                EnsembleColumns.ADRESSE,//7
                EnsembleColumns.SOCICODE, //8
                EnsembleColumns.DIVICODE, // 9
                EnsembleColumns.PROVINCE // 10
        };

        String selection = EnsembleColumns.TERRAINSPP + " > 0 AND "+EnsembleColumns.POSTCODE + " like 'B%' and Province like '%"+province+"%' ";
        String sortOrder = EnsembleColumns.PROVINCE+","+EnsembleColumns.ENSECODE;
        return context.getContentResolver().query(EnsembleColumns.CONTENT_URI,projection,selection,null,sortOrder);
    }

    private static Land getTerrainFromCursor(Cursor cursor){
        Land land = new Land();
        land.setEnseCode(cursor.getString(0));
        land.setEnseDesc(cursor.getString(1));
        land.setNbTerrainsDispo(cursor.getInt(2));
        land.setCptEpl(cursor.getString(3));
        land.setLibCommercialFr(cursor.getString(4));
        land.setPostLoc(cursor.getString(5));
        land.setPostCode(cursor.getString(6));
        land.setAdresse(cursor.getString(7));
        land.setSociCode(cursor.getString(8));
        land.setDivicode(cursor.getString(9));
        land.setProvince(cursor.getString(10));
        return land;
    }

    @Override
    public void deliverResult(List<Land> data) {
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
    public void onCanceled(List<Land> data) {
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
