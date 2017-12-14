package eu.side.thomaspiron.android.provider;

// @formatter:off
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import eu.side.thomaspiron.android.provider.base.BaseSQLiteOpenHelperCallbacks;
import eu.side.thomaspiron.android.provider.TPSQLiteOpenHelperCallbacks;
import eu.side.thomaspiron.android.BuildConfig;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleColumns;
import eu.side.thomaspiron.android.provider.inspiration.InspirationColumns;
import eu.side.thomaspiron.android.provider.lots.LotsColumns;
import eu.side.thomaspiron.android.provider.pointcontact.PointcontactColumns;
import eu.side.thomaspiron.android.provider.pointinteret.PointinteretColumns;

public class TPSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = TPSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "thomaspiron.db";
    private static final int DATABASE_VERSION = 53;
    private static TPSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final BaseSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    public static final String SQL_CREATE_TABLE_ENSEMBLE = "CREATE TABLE IF NOT EXISTS "
            + EnsembleColumns.TABLE_NAME + " ( "
            + EnsembleColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + EnsembleColumns.SOCICODE + " TEXT, "
            + EnsembleColumns.CPTEPL + " TEXT, "
            + EnsembleColumns.DIVICODE + " TEXT, "
            + EnsembleColumns.ENSECODE + " TEXT, "
            + EnsembleColumns.ADRESSE + " TEXT, "
            + EnsembleColumns.POSTLOC + " TEXT, "
            + EnsembleColumns.POSTCODE + " TEXT, "
            + EnsembleColumns.ENSEDESC + " TEXT, "
            + EnsembleColumns.LIBCOMMERCIALFR + " TEXT, "
            + EnsembleColumns.LIBCOMMERCIALEN + " TEXT, "
            + EnsembleColumns.LATITUDE + " REAL, "
            + EnsembleColumns.LONGITUDE + " REAL, "
            + EnsembleColumns.DESCRIPTIONDISTANCEFR + " TEXT, "
            + EnsembleColumns.DESCRIPTIONDISTANCEEN + " TEXT, "
            + EnsembleColumns.TOTUNIT + " INTEGER, "
            + EnsembleColumns.TERRAINMIN + " TEXT, "
            + EnsembleColumns.TERRAINMAX + " TEXT, "
            + EnsembleColumns.TERRAINSPP + " INTEGER, "
            + EnsembleColumns.TERRAINSPC + " INTEGER, "
            + EnsembleColumns.TERRAINSEC + " INTEGER, "
            + EnsembleColumns.MAISONSEC + " INTEGER, "
            + EnsembleColumns.MAISONSC + " INTEGER, "
            + EnsembleColumns.SURFMIN + " TEXT, "
            + EnsembleColumns.SURFMAX + " TEXT, "
            + EnsembleColumns.NBSTUDIOS + " INTEGER, "
            + EnsembleColumns.NBAPPARTS + " INTEGER, "
            + EnsembleColumns.NBPENTHOUSES + " INTEGER, "
            + EnsembleColumns.NBDUPLEX + " INTEGER, "
            + EnsembleColumns.NBCOMMERCES + " INTEGER, "
            + EnsembleColumns.NBBUREAUX + " INTEGER, "
            + EnsembleColumns.NBTERRAINSDISPO + " INTEGER, "
            + EnsembleColumns.MAISON + " INTEGER, "
            + EnsembleColumns.APPART + " INTEGER, "
            + EnsembleColumns.TERRAIN + " INTEGER, "
            + EnsembleColumns.PROVINCE + " TEXT, "
            + EnsembleColumns.IDPOINTCONTACT + " INTEGER, "
            + EnsembleColumns.NBMEDIAS + " INTEGER, "
            + EnsembleColumns.NBPLANSIMPL + " INTEGER, "
            + EnsembleColumns.DTDEBNOUVEAU + " INTEGER, "
            + EnsembleColumns.DTDEBREMISE + " INTEGER, "
            + EnsembleColumns.DTFINNOUVEAU + " INTEGER, "
            + EnsembleColumns.DTFINPORTEOUVERTE + " INTEGER, "
            + EnsembleColumns.DTFINREMISE + " INTEGER, "
            + EnsembleColumns.INFOPORTEOUVERTE + " TEXT, "
            + EnsembleColumns.LIBELLEREMISE + " TEXT, "
            + EnsembleColumns.NBTRIPLEX + " INTEGER, "
            + EnsembleColumns.NBQUADRIPLEX + " INTEGER "
            + ", CONSTRAINT uq_soci_divi_ensecode UNIQUE (SociCode, DiviCode,EnseCode) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_INSPIRATION = "CREATE TABLE IF NOT EXISTS "
            + InspirationColumns.TABLE_NAME + " ( "
            + InspirationColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + InspirationColumns.DATE + " TEXT, "
            + InspirationColumns.NUMERO + " TEXT, "
            + InspirationColumns.NUMEROSIMPLIFIE + " TEXT, "
            + InspirationColumns.CLIENT + " TEXT, "
            + InspirationColumns.PRIX + " REAL, "
            + InspirationColumns.TOPOGRAPHIE + " TEXT, "
            + InspirationColumns.GARAGE + " TEXT, "
            + InspirationColumns.CARPORT + " TEXT, "
            + InspirationColumns.CAVE + " TEXT, "
            + InspirationColumns.PRO + " TEXT, "
            + InspirationColumns.PAREMENT + " TEXT, "
            + InspirationColumns.TOITURE1 + " TEXT, "
            + InspirationColumns.TOITURE2 + " TEXT, "
            + InspirationColumns.CHASSIS + " TEXT, "
            + InspirationColumns.INVEST + " INTEGER, "
            + InspirationColumns.CHAMBREREZ + " TEXT, "
            + InspirationColumns.IDAPMODELE + " INTEGER "
            + ", CONSTRAINT uq_numero UNIQUE (numero) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_LOTS = "CREATE TABLE IF NOT EXISTS "
            + LotsColumns.TABLE_NAME + " ( "
            + LotsColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + LotsColumns.LOTDESC + " TEXT, "
            + LotsColumns.CPTEPL + " TEXT, "
            + LotsColumns.JARDIN + " TEXT, "
            + LotsColumns.BALCON + " TEXT, "
            + LotsColumns.CHAMBRES + " TEXT, "
            + LotsColumns.FACADESNBR + " TEXT, "
            + LotsColumns.ORIENTATION + " TEXT, "
            + LotsColumns.STATUTLOT + " TEXT, "
            + LotsColumns.SURFTER + " TEXT, "
            + LotsColumns.SURFHAB + " TEXT, "
            + LotsColumns.CODEETAGE + " TEXT, "
            + LotsColumns.LIBELLEFR + " TEXT, "
            + LotsColumns.ENSECODE + " TEXT, "
            + LotsColumns.SOCICODE + " TEXT, "
            + LotsColumns.PEBCLASSEENERGETIQUE + " TEXT, "
            + LotsColumns.NBMEDIAS + " INTEGER, "
            + LotsColumns.NBPLANSIMPL + " INTEGER "
            + ", CONSTRAINT uq_cptepl UNIQUE (cptEpl) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_POINTCONTACT = "CREATE TABLE IF NOT EXISTS "
            + PointcontactColumns.TABLE_NAME + " ( "
            + PointcontactColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PointcontactColumns.IDPOINTCONTACT + " INTEGER, "
            + PointcontactColumns.TYPEPOINTCONTACT + " TEXT, "
            + PointcontactColumns.TITRE + " TEXT, "
            + PointcontactColumns.ADRESSE + " TEXT, "
            + PointcontactColumns.POSTLOC + " TEXT, "
            + PointcontactColumns.POSTCODE + " TEXT, "
            + PointcontactColumns.TEL + " TEXT, "
            + PointcontactColumns.PERMANENCEFR + " TEXT, "
            + PointcontactColumns.LATITUDE + " REAL, "
            + PointcontactColumns.LONGITUDE + " REAL, "
            + PointcontactColumns.NBMEDIAS + " INTEGER "
            + ", CONSTRAINT uq_idpointcontact UNIQUE (idPointContact) ON CONFLICT REPLACE"
            + " );";

    public static final String SQL_CREATE_TABLE_POINTINTERET = "CREATE TABLE IF NOT EXISTS "
            + PointinteretColumns.TABLE_NAME + " ( "
            + PointinteretColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PointinteretColumns.IDINTERET + " INTEGER, "
            + PointinteretColumns.LIBELLEFR + " TEXT, "
            + PointinteretColumns.LIBELLEEN + " TEXT, "
            + PointinteretColumns.IDPAYS + " INTEGER, "
            + PointinteretColumns.EMAIL + " TEXT "
            + ", CONSTRAINT uq_idinteret UNIQUE (idInteret) ON CONFLICT REPLACE"
            + " );";


    public static TPSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static TPSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static TPSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new TPSQLiteOpenHelper(context);
    }

    private TPSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new TPSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static TPSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new TPSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private TPSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new TPSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.LOG_DEBUG_PROVIDER) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_ENSEMBLE);
        db.execSQL(SQL_CREATE_TABLE_INSPIRATION);
        db.execSQL(SQL_CREATE_TABLE_LOTS);
        db.execSQL(SQL_CREATE_TABLE_POINTCONTACT);
        db.execSQL(SQL_CREATE_TABLE_POINTINTERET);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
