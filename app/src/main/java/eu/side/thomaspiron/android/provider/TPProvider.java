package eu.side.thomaspiron.android.provider;

// @formatter:off
import java.util.Arrays;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import eu.side.thomaspiron.android.BuildConfig;
import eu.side.thomaspiron.android.provider.base.BaseContentProvider;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleColumns;
import eu.side.thomaspiron.android.provider.inspiration.InspirationColumns;
import eu.side.thomaspiron.android.provider.lots.LotsColumns;
import eu.side.thomaspiron.android.provider.pointcontact.PointcontactColumns;
import eu.side.thomaspiron.android.provider.pointinteret.PointinteretColumns;

public class TPProvider extends BaseContentProvider {
    private static final String TAG = TPProvider.class.getSimpleName();

    private static final boolean DEBUG = BuildConfig.LOG_DEBUG_PROVIDER;

    private static final String TYPE_CURSOR_ITEM = "vnd.android.cursor.item/";
    private static final String TYPE_CURSOR_DIR = "vnd.android.cursor.dir/";

    public static final String AUTHORITY = "eu.side.thomaspiron.android.provider";
    public static final String CONTENT_URI_BASE = "content://" + AUTHORITY;

    private static final int URI_TYPE_ENSEMBLE = 0;
    private static final int URI_TYPE_ENSEMBLE_ID = 1;

    private static final int URI_TYPE_INSPIRATION = 2;
    private static final int URI_TYPE_INSPIRATION_ID = 3;

    private static final int URI_TYPE_LOTS = 4;
    private static final int URI_TYPE_LOTS_ID = 5;

    private static final int URI_TYPE_POINTCONTACT = 6;
    private static final int URI_TYPE_POINTCONTACT_ID = 7;

    private static final int URI_TYPE_POINTINTERET = 8;
    private static final int URI_TYPE_POINTINTERET_ID = 9;



    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, EnsembleColumns.TABLE_NAME, URI_TYPE_ENSEMBLE);
        URI_MATCHER.addURI(AUTHORITY, EnsembleColumns.TABLE_NAME + "/#", URI_TYPE_ENSEMBLE_ID);
        URI_MATCHER.addURI(AUTHORITY, InspirationColumns.TABLE_NAME, URI_TYPE_INSPIRATION);
        URI_MATCHER.addURI(AUTHORITY, InspirationColumns.TABLE_NAME + "/#", URI_TYPE_INSPIRATION_ID);
        URI_MATCHER.addURI(AUTHORITY, LotsColumns.TABLE_NAME, URI_TYPE_LOTS);
        URI_MATCHER.addURI(AUTHORITY, LotsColumns.TABLE_NAME + "/#", URI_TYPE_LOTS_ID);
        URI_MATCHER.addURI(AUTHORITY, PointcontactColumns.TABLE_NAME, URI_TYPE_POINTCONTACT);
        URI_MATCHER.addURI(AUTHORITY, PointcontactColumns.TABLE_NAME + "/#", URI_TYPE_POINTCONTACT_ID);
        URI_MATCHER.addURI(AUTHORITY, PointinteretColumns.TABLE_NAME, URI_TYPE_POINTINTERET);
        URI_MATCHER.addURI(AUTHORITY, PointinteretColumns.TABLE_NAME + "/#", URI_TYPE_POINTINTERET_ID);
    }

    @Override
    protected SQLiteOpenHelper createSqLiteOpenHelper() {
        return TPSQLiteOpenHelper.getInstance(getContext());
    }

    @Override
    protected boolean hasDebug() {
        return DEBUG;
    }

    @Override
    public String getType(Uri uri) {
        int match = URI_MATCHER.match(uri);
        switch (match) {
            case URI_TYPE_ENSEMBLE:
                return TYPE_CURSOR_DIR + EnsembleColumns.TABLE_NAME;
            case URI_TYPE_ENSEMBLE_ID:
                return TYPE_CURSOR_ITEM + EnsembleColumns.TABLE_NAME;

            case URI_TYPE_INSPIRATION:
                return TYPE_CURSOR_DIR + InspirationColumns.TABLE_NAME;
            case URI_TYPE_INSPIRATION_ID:
                return TYPE_CURSOR_ITEM + InspirationColumns.TABLE_NAME;

            case URI_TYPE_LOTS:
                return TYPE_CURSOR_DIR + LotsColumns.TABLE_NAME;
            case URI_TYPE_LOTS_ID:
                return TYPE_CURSOR_ITEM + LotsColumns.TABLE_NAME;

            case URI_TYPE_POINTCONTACT:
                return TYPE_CURSOR_DIR + PointcontactColumns.TABLE_NAME;
            case URI_TYPE_POINTCONTACT_ID:
                return TYPE_CURSOR_ITEM + PointcontactColumns.TABLE_NAME;

            case URI_TYPE_POINTINTERET:
                return TYPE_CURSOR_DIR + PointinteretColumns.TABLE_NAME;
            case URI_TYPE_POINTINTERET_ID:
                return TYPE_CURSOR_ITEM + PointinteretColumns.TABLE_NAME;

        }
        return null;
    }

    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        if (DEBUG) Log.d(TAG, "insert uri=" + uri + " values=" + values);
        return super.insert(uri, values);
    }

    @Override
    public int bulkInsert(@NonNull Uri uri, @NonNull ContentValues[] values) {
        if (DEBUG) Log.d(TAG, "bulkInsert uri=" + uri + " values.length=" + values.length);
        return super.bulkInsert(uri, values);
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "update uri=" + uri + " values=" + values + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.update(uri, values, selection, selectionArgs);
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        if (DEBUG) Log.d(TAG, "delete uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs));
        return super.delete(uri, selection, selectionArgs);
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (DEBUG)
            Log.d(TAG, "query uri=" + uri + " selection=" + selection + " selectionArgs=" + Arrays.toString(selectionArgs) + " sortOrder=" + sortOrder
                    + " groupBy=" + uri.getQueryParameter(QUERY_GROUP_BY) + " having=" + uri.getQueryParameter(QUERY_HAVING) + " limit=" + uri.getQueryParameter(QUERY_LIMIT));
        return super.query(uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    protected QueryParams getQueryParams(Uri uri, String selection, String[] projection) {
        QueryParams res = new QueryParams();
        String id = null;
        int matchedId = URI_MATCHER.match(uri);
        switch (matchedId) {
            case URI_TYPE_ENSEMBLE:
            case URI_TYPE_ENSEMBLE_ID:
                res.table = EnsembleColumns.TABLE_NAME;
                res.idColumn = EnsembleColumns._ID;
                res.tablesWithJoins = EnsembleColumns.TABLE_NAME;
                res.orderBy = EnsembleColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_INSPIRATION:
            case URI_TYPE_INSPIRATION_ID:
                res.table = InspirationColumns.TABLE_NAME;
                res.idColumn = InspirationColumns._ID;
                res.tablesWithJoins = InspirationColumns.TABLE_NAME;
                res.orderBy = InspirationColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_LOTS:
            case URI_TYPE_LOTS_ID:
                res.table = LotsColumns.TABLE_NAME;
                res.idColumn = LotsColumns._ID;
                res.tablesWithJoins = LotsColumns.TABLE_NAME;
                res.orderBy = LotsColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_POINTCONTACT:
            case URI_TYPE_POINTCONTACT_ID:
                res.table = PointcontactColumns.TABLE_NAME;
                res.idColumn = PointcontactColumns._ID;
                res.tablesWithJoins = PointcontactColumns.TABLE_NAME;
                res.orderBy = PointcontactColumns.DEFAULT_ORDER;
                break;

            case URI_TYPE_POINTINTERET:
            case URI_TYPE_POINTINTERET_ID:
                res.table = PointinteretColumns.TABLE_NAME;
                res.idColumn = PointinteretColumns._ID;
                res.tablesWithJoins = PointinteretColumns.TABLE_NAME;
                res.orderBy = PointinteretColumns.DEFAULT_ORDER;
                break;

            default:
                throw new IllegalArgumentException("The uri '" + uri + "' is not supported by this ContentProvider");
        }

        switch (matchedId) {
            case URI_TYPE_ENSEMBLE_ID:
            case URI_TYPE_INSPIRATION_ID:
            case URI_TYPE_LOTS_ID:
            case URI_TYPE_POINTCONTACT_ID:
            case URI_TYPE_POINTINTERET_ID:
                id = uri.getLastPathSegment();
        }
        if (id != null) {
            if (selection != null) {
                res.selection = res.table + "." + res.idColumn + "=" + id + " and (" + selection + ")";
            } else {
                res.selection = res.table + "." + res.idColumn + "=" + id;
            }
        } else {
            res.selection = selection;
        }
        return res;
    }
}
