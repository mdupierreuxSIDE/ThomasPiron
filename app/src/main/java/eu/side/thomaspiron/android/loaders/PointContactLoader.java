package eu.side.thomaspiron.android.loaders;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.AsyncTaskLoader;

import java.util.ArrayList;
import java.util.List;

import eu.side.thomaspiron.android.model.PointContact;
import eu.side.thomaspiron.android.provider.pointcontact.PointcontactColumns;

/**
 * Created by mdupierreux1 on 1/12/15.
 */
public class PointContactLoader extends AsyncTaskLoader<List<PointContact>> {

    private List<PointContact> mData;
    private Cursor mCursor;
    private static String LOG_TAG = AppartLoader.class.getSimpleName();
    private String typePointContact;

    public PointContactLoader(Context context,String typePointContact){
        super(context);
        this.typePointContact = typePointContact;
    }

    @Override
    public List<PointContact> loadInBackground() {
        List<PointContact> data = new ArrayList<>();

        if (mCursor != null && !mCursor.isClosed()) mCursor.close();
        mCursor = queryTPProvider(getContext(), typePointContact);
        while (mCursor.moveToNext()){
            PointContact pointContact = getPointContactFromCursor(mCursor);

            if (pointContact != null){
                data.add(pointContact);
            }
        }
        return data;
    }

    private static Cursor queryTPProvider(Context context, String typePointContact){
        String[] projection = {
                PointcontactColumns.TYPEPOINTCONTACT,//0
                PointcontactColumns.ADRESSE,//1
                PointcontactColumns.LATITUDE,//2
                PointcontactColumns.LONGITUDE,//3
                PointcontactColumns.PERMANENCEFR,//4
                PointcontactColumns.POSTCODE,//5
                PointcontactColumns.POSTLOC,//6
                PointcontactColumns.TEL,//7
                PointcontactColumns.TITRE,//8
                PointcontactColumns.IDPOINTCONTACT,//9
                PointcontactColumns.NBMEDIAS//10

        };

        String selection = PointcontactColumns.TYPEPOINTCONTACT +" = '"+typePointContact+"' AND "+PointcontactColumns.POSTCODE +" LIKE 'B%'";
        String sortOrder = PointcontactColumns.POSTLOC+","+PointcontactColumns.POSTCODE;
        return context.getContentResolver().query(PointcontactColumns.CONTENT_URI,projection,selection,null,sortOrder);
    }

    public static  PointContact getPointContactFromCursor(Cursor cursor){
        PointContact pointContact = new PointContact();
        pointContact.setTypePointContact(cursor.getString(0));
        pointContact.setAdresse(cursor.getString(1));
        pointContact.setLatitude(cursor.getDouble(2));
        pointContact.setLongitude(cursor.getDouble(3));
        pointContact.setPermanenceFr(cursor.getString(4));
        pointContact.setPostCode(cursor.getString(5));
        pointContact.setPostLoc(cursor.getString(6));
        pointContact.setTel(cursor.getString(7));
        pointContact.setTitre(cursor.getString(8));
        pointContact.setIdPointContact(cursor.getInt(9));
        pointContact.setNbMedias(cursor.getInt(10));
        return pointContact;
    }

    @Override
    public void deliverResult(List<PointContact> data) {
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
    public void onCanceled(List<PointContact> data) {
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
