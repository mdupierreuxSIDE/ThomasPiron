package eu.side.thomaspiron.android.Utility;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by mdupierreux1 on 2/09/15.
 */
public class Const {

    private static final String mailUN = "botun@thomas-piron.eu";
    private static final String mailMR = "botmr@thomas-piron.eu";
    private static final String mailReno = "info@tprenovation.be";
    public static final String PREF_PROVINCE_FILTER = "pref_province_filter";
    public static final String PREF_UNITS_FILTER = "pref_units_filter";
    public static final String PREF_SEARCH_FILTER = "pref_search_filter";
    public static final String PREF_GCM_PROVINCE = "pref_gcm_province";
    public static final String PREF_GCM_PROVINCE_ID = "pref_gcm_province_list_id";
    public static final String PREF_GCM_PROVINCE_LIB = "pref_gcm_province_list_lib";
    public static final String PREF_DEVICE_UID = "pref_device_uid";
    public static final String PREF_GCM_TYPEBIEN_ID = "pref_gcm_typebien_list_id";
    public static final String PREF_GCM_TYPEBIEN_LIB ="pref_gcm_typebien_list_lib";
    public static final String PREF_GCM_TYPEBIEN = "pref_gcm_typebien";

    public static LinkedList<String> PROVINCES= new LinkedList<>(Arrays.asList("Toutes les provinces", "Bruxelles","Brabant Flamand", "Brabant Wallon", "Hainaut", "Liège","Luxembourg","Namur"));
    public static LinkedList<String> TYPES_BIEN = new LinkedList<>(Arrays.asList("Appartements","Maisons"));
    public static String getMailUN() {
        return mailUN;
    }

    public static String getMailMR() {
        return mailMR;
    }

    public static String getMailReno() {
        return mailReno;
    }

    //INTENT CONSTANTS
    public static final String INTENT_MAPS_IS_HOUSE = "house";

    //PREFERENCES CONSTANTS
    public static String PREF_DEFAULT_SCREEN = "pref_default_screen";
}
