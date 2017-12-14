package eu.side.thomaspiron.android.loaders;

import android.support.v4.content.AsyncTaskLoader;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import eu.side.thomaspiron.android.model.Lot;
import eu.side.thomaspiron.android.provider.lots.LotsColumns;

/**
 * Created by mdupierreux1 on 10/08/15.
 */
public class UnitLoader extends AsyncTaskLoader<List<Lot>> {

    private static String LOG_TAG = UnitLoader.class.getSimpleName();
    private List<Lot> mData;
    private Cursor mCursor;
    private String mEtage, mSocicode, mEnseCode, mSortOrder,mFilter;
    private Boolean mMaison = false;

    public UnitLoader(Context context, String etage, String socicode, String ensecode, String sortOrder){
        super(context);
        mEtage = etage;
        mEnseCode = ensecode;
        mSocicode = socicode;
        mSortOrder = sortOrder;
    }

    public UnitLoader(Context context, String mEtage, String mSocicode, String mEnseCode, String mSortOrder, String mFilter, Boolean mMaison) {
        super(context);
        this.mEtage = mEtage;
        this.mSocicode = mSocicode;
        this.mEnseCode = mEnseCode;
        this.mSortOrder = mSortOrder;
        this.mFilter = mFilter;
        this.mMaison = mMaison;
    }

    public UnitLoader(Context context, List<Lot> mData, Cursor mCursor, String mEtage, String mSocicode, String mEnseCode, String mSortOrder, String mFilter, Boolean mMaison) {
        super(context);
        this.mData = mData;
        this.mCursor = mCursor;
        this.mEtage = mEtage;
        this.mSocicode = mSocicode;
        this.mEnseCode = mEnseCode;
        this.mSortOrder = mSortOrder;
        this.mFilter = mFilter;
        this.mMaison = mMaison;
    }

    @Override
    public List<Lot> loadInBackground() {
        List<Lot> data = new ArrayList<>();
        if (mCursor != null && !mCursor.isClosed()) mCursor.close();
        mCursor = queryTPPRoviderLots(getContext());
        while(mCursor.moveToNext()){
            Lot lot = getLotFromCursor(mCursor);
            if(lot != null){
                data.add(lot);
            }
        }
        return data;
    }

    private Lot getLotFromCursor(Cursor mCursor) {
        Lot lot = new Lot();
        lot.setBalcon(mCursor.getString(5));
        lot.setSurfTerrain(mCursor.getString(0));
        lot.setSurfHab(mCursor.getString(4));
        lot.setStatut(mCursor.getString(1));
        lot.setLotDesc(mCursor.getString(2));
        lot.setFacades(mCursor.getString(3));
        lot.setSurfHab(mCursor.getString(4));
        lot.setChambres(mCursor.getString(6));
        lot.setOrientation(mCursor.getString(7));
        lot.setPebClasseEnergetique(mCursor.getString(8));
        lot.setEnsecode(mCursor.getString(9));
        lot.setCptepl(mCursor.getString(10));
        lot.setNbMedias(mCursor.getInt(11));
        lot.setNbPlansImpl(mCursor.getInt(12));
        return lot;

    }

    private Cursor queryTPPRoviderLots(Context context){
        String[] projection = {
            LotsColumns.SURFTER, //0
            LotsColumns.STATUTLOT, //1
                LotsColumns.LOTDESC, //2
                LotsColumns.FACADESNBR, //3
                LotsColumns.SURFHAB,//4
                LotsColumns.BALCON,//5
                LotsColumns.CHAMBRES,//6
                LotsColumns.ORIENTATION,//7
                LotsColumns.PEBCLASSEENERGETIQUE,//8
                LotsColumns.ENSECODE, //9
                LotsColumns.CPTEPL, //10
                LotsColumns.NBMEDIAS, //11
                LotsColumns.NBPLANSIMPL //12
        };
        String filter = "";
        if (!mFilter.equals("")) filter = " AND "+mFilter;
        String etageFilter ="";
        if(!mEtage.equals("")) etageFilter = new StringBuilder(" AND ").append(LotsColumns.LIBELLEFR).append(" = '").append(mEtage).append("'").toString();
        String maisonFilter = mMaison ? " > 0 " : " = 0 ";
        StringBuilder sb = new StringBuilder(LotsColumns.ENSECODE).append(" = '").append(mEnseCode).append("'")
                .append(" AND ")
                .append(LotsColumns.SOCICODE).append(" = '").append(mSocicode).append("' AND ")
                .append(LotsColumns.FACADESNBR ).append(maisonFilter)
                .append(filter)
                .append(etageFilter);
        String selection = sb.toString();
        mSortOrder += " , "+LotsColumns.LOTDESC+ " asc";
        return context.getContentResolver().query(LotsColumns.CONTENT_URI,projection,selection,null,mSortOrder);

    }

    @Override
    public void deliverResult(List<Lot> data) {
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
    public void onCanceled(List<Lot> data) {
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
