package eu.side.thomaspiron.android.Utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import eu.side.thomaspiron.android.provider.lots.LotsColumns;

/**
 * Created by mdupierreux1 on 25/11/15.
 */
public class PrefUtils {

    private static void setPrefString(Context c,String key,String value){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(c);
        prefs.edit().putString(key, value).commit();
    }

    public static Integer getDefaultScreen(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(Const.PREF_DEFAULT_SCREEN,3);
    }

    public static void setDefaultScreen(Context context, Integer screen){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putInt(Const.PREF_DEFAULT_SCREEN, screen).commit();
    }

    public static Integer getProvinceFilter(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(Const.PREF_PROVINCE_FILTER, 0);
    }
    public static void setProvinceFilter(Context context, Integer province){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putInt(Const.PREF_PROVINCE_FILTER,province).commit();
    }

    public static String getUnitsFilter(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Const.PREF_UNITS_FILTER, LotsColumns.STATUTLOT + " = ' '");
    }

    public static void setUnitsFilter(Context context, String filter){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString(Const.PREF_UNITS_FILTER, filter).commit();
    }

    public static String getSearchText(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Const.PREF_SEARCH_FILTER, "");
    }
    public static void setSearchtext(Context context, String searchtext){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString(Const.PREF_SEARCH_FILTER,searchtext).commit();
    }

    //Provinces

    public static String[] getGcmProvinceListId(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Const.PREF_GCM_PROVINCE_ID, "").split(",");
    }

    public static void setGcmProvinceListId(Context context, String province){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString(Const.PREF_GCM_PROVINCE_ID,province).commit();
    }
    public static String[] getGcmProvinceListLib(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Const.PREF_GCM_PROVINCE_LIB, "").split(",");
    }

    public static void setGcmProvinceListLib(Context context, String province){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString(Const.PREF_GCM_PROVINCE_LIB,province).commit();
    }
    public static int getGcmProvince(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(Const.PREF_GCM_PROVINCE, 0);
    }

    public static void setGcmProvince(Context context, int province){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putInt(Const.PREF_GCM_PROVINCE, province).commit();
    }

    //TypeBien

    public static String[] getGcmTypeBienListId(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Const.PREF_GCM_TYPEBIEN_ID, "").split(",");
    }

    public static void setGcmTypeBienListId(Context context, String province){
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            prefs.edit().putString(Const.PREF_GCM_TYPEBIEN_ID,province).commit();
    }
    public static String[] getGcmTypeBienListLib(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Const.PREF_GCM_TYPEBIEN_LIB, "").split(",");
    }

    public static void setGcmTypeBienListLib(Context context, String province){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString(Const.PREF_GCM_TYPEBIEN_LIB,province).commit();
    }
    public static int getGcmPTypeBien(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt(Const.PREF_GCM_TYPEBIEN, 0);
    }

    public static void setGcmTypeBien(Context context, int province){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putInt(Const.PREF_GCM_TYPEBIEN, province).commit();
    }



    public static void setDeviceUid(Context applicationContext, String result) {
        setPrefString(applicationContext, Const.PREF_DEVICE_UID, result);
    }



    public static String getDeviceUID(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Const.PREF_DEVICE_UID, "");
    }
}
