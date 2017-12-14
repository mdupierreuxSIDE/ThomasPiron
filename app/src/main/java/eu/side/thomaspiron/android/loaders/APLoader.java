package eu.side.thomaspiron.android.loaders;

import android.support.v4.content.AsyncTaskLoader;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import eu.side.thomaspiron.android.model.APModele;
import eu.side.thomaspiron.android.provider.inspiration.InspirationColumns;

/**
 * Created by mdupierreux1 on 18/08/15.
 */
public class APLoader extends AsyncTaskLoader<List<APModele>>{

    private List<APModele> mData;
    private Cursor mCursor;
    private static  String LOG_TAG = APLoader.class.getSimpleName();
    private int priceCat;

    public APLoader(Context context, int priceCat){
        super(context);
        this.priceCat = priceCat;
    }

    @Override
    public List<APModele> loadInBackground() {
        List<APModele> data = new ArrayList<>();
        if (mCursor != null && !mCursor.isClosed()) mCursor.close();
        mCursor = queryTPProvider(getContext());
        while (mCursor.moveToNext()){
            APModele apModele = getAPModeleFromCursor(mCursor);

            if (apModele != null){
                Log.d(LOG_TAG, "loadinbackground " + apModele.getNumero());
                data.add(apModele);
            }
        }
        return data;
    }

    private Cursor queryTPProvider(Context context) {
        String[] projection = {
                InspirationColumns.NUMERO,
                InspirationColumns.NUMEROSIMPLIFIE,
                InspirationColumns.CLIENT,
                InspirationColumns.IDAPMODELE
        };
        String selection;
        switch (priceCat){
            case 1:
                selection = InspirationColumns.PRIX +" < 200001";
                break;
            case 2:
                selection = InspirationColumns.PRIX +" < 250001 AND "+InspirationColumns.PRIX +" > 200000 ";
                break;
            case 3:
                selection = InspirationColumns.PRIX +" < 300001 AND "+InspirationColumns.PRIX +" > 250001 ";
                break;
            case 4:
                selection = InspirationColumns.PRIX +" < 350001 AND "+InspirationColumns.PRIX +" > 300001 ";
                break;
            case 5:
                selection = InspirationColumns.PRIX +" > 350001 ";
                break;
            case 6:
                selection = InspirationColumns.PRIX +" > 400000 ";
                break;

            default:
                selection = "";
                break;
        }
        StringBuilder sb = new StringBuilder(selection);
        sb.append(" AND "+InspirationColumns.NUMEROSIMPLIFIE + " != \"\"");
        String sortOrder = InspirationColumns.IDAPMODELE;
        return context.getContentResolver().query(InspirationColumns.CONTENT_URI,projection,sb.toString(),null,sortOrder);
    }

    private APModele getAPModeleFromCursor(Cursor cursor) {
        APModele apModele = new APModele();
        apModele.setNumero(cursor.getString(0));
        apModele.setNumero_simplifie(cursor.getString(1));
        apModele.setClient(cursor.getString(2));
        apModele.setIdAPModele(cursor.getInt(3));
        return apModele;
    }

    @Override
    public void deliverResult(List<APModele> data) {
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
    public void onCanceled(List<APModele> data) {
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