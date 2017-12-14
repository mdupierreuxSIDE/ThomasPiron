package eu.side.thomaspiron.android.provider;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import android.util.Log;

import eu.side.thomaspiron.android.BuildConfig;
import eu.side.thomaspiron.android.provider.base.BaseSQLiteOpenHelperCallbacks;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleColumns;
import eu.side.thomaspiron.android.provider.lots.LotsColumns;
import eu.side.thomaspiron.android.provider.pointcontact.PointcontactColumns;

/**
 * Implement your custom database creation or upgrade code here.
 *
 * This file will not be overwritten if you re-run the content provider generator.
 */
public class TPSQLiteOpenHelperCallbacks extends BaseSQLiteOpenHelperCallbacks{
    private static final String TAG = TPSQLiteOpenHelperCallbacks.class.getSimpleName();

    public void onOpen(final Context context, final SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onOpen");
        // Insert your db open code here.
    }

    public void onPreCreate(final Context context, final SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onPreCreate");
        // Insert your db creation code here. This is called before your tables are created.
    }

    public void onPostCreate(final Context context, final SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onPostCreate");
        // Insert your db creation code here. This is called after your tables are created.è
    }

    public void onUpgrade(final Context context, final SQLiteDatabase db, final int oldVersion, final int newVersion) {
        Log.d(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion);
        if (BuildConfig.DEBUG) Log.d(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion);
        try {
            if (newVersion <= 2) {
                db.execSQL("ALTER TABLE " + EnsembleColumns.TABLE_NAME + " ADD COLUMN " + EnsembleColumns.DTDEBNOUVEAU + " INTEGER; ");
                db.execSQL("ALTER TABLE " + EnsembleColumns.TABLE_NAME + " ADD COLUMN " + EnsembleColumns.DTDEBREMISE + " INTEGER; ");
                db.execSQL("ALTER TABLE " + EnsembleColumns.TABLE_NAME + " ADD COLUMN " + EnsembleColumns.DTFINNOUVEAU + " INTEGER; ");
                db.execSQL("ALTER TABLE " + EnsembleColumns.TABLE_NAME + " ADD COLUMN " + EnsembleColumns.DTFINREMISE + " INTEGER; ");
                db.execSQL("ALTER TABLE " + EnsembleColumns.TABLE_NAME + " ADD COLUMN " + EnsembleColumns.DTFINPORTEOUVERTE + " INTEGER; ");
                db.execSQL("ALTER TABLE " + EnsembleColumns.TABLE_NAME + " ADD COLUMN " + EnsembleColumns.LIBELLEREMISE + " TEXT; ");
                db.execSQL("ALTER TABLE " + EnsembleColumns.TABLE_NAME + " ADD COLUMN " + EnsembleColumns.INFOPORTEOUVERTE + " TEXT; ");
            }
            if (newVersion <= 1) {
                db.execSQL("ALTER TABLE " + EnsembleColumns.TABLE_NAME + " ADD COLUMN " + EnsembleColumns.NBMEDIAS + " INTEGER; ");
                db.execSQL("ALTER TABLE " + EnsembleColumns.TABLE_NAME + " ADD COLUMN " + EnsembleColumns.NBPLANSIMPL + " INTEGER; ");
                db.execSQL("ALTER TABLE " + LotsColumns.TABLE_NAME + " ADD COLUMN " + LotsColumns.NBMEDIAS + " INTEGER; ");
                db.execSQL("ALTER TABLE " + LotsColumns.TABLE_NAME + " ADD COLUMN " + LotsColumns.NBPLANSIMPL + " INTEGER; ");
                db.execSQL("ALTER TABLE " + PointcontactColumns.TABLE_NAME + " ADD COLUMN " + PointcontactColumns.NBMEDIAS + " INTEGER; ");
            }
            db.execSQL("ALTER TABLE " + EnsembleColumns.TABLE_NAME + " ADD COLUMN " + EnsembleColumns.NBTRIPLEX + " INTEGER; ");
            db.execSQL("ALTER TABLE " + EnsembleColumns.TABLE_NAME + " ADD COLUMN " + EnsembleColumns.NBQUADRIPLEX + " INTEGER; ");

        }
        catch (SQLException e){
            if (BuildConfig.DEBUG) Log.d(TAG, "onUpgrade: "+e.getMessage());
        }
    }
}
