package eu.side.thomaspiron.android.provider.inspiration;

// @formatter:off
import android.net.Uri;
import android.provider.BaseColumns;

import eu.side.thomaspiron.android.provider.TPProvider;
import eu.side.thomaspiron.android.provider.base.AbstractSelection;
import eu.side.thomaspiron.android.provider.ensemble.EnsembleColumns;
import eu.side.thomaspiron.android.provider.inspiration.InspirationColumns;
import eu.side.thomaspiron.android.provider.lots.LotsColumns;
import eu.side.thomaspiron.android.provider.pointcontact.PointcontactColumns;
import eu.side.thomaspiron.android.provider.pointinteret.PointinteretColumns;

/**
 * inspiration
 */
@SuppressWarnings("unused")
public class InspirationColumns implements BaseColumns {
    public static final String TABLE_NAME = "inspiration";
    public static final Uri CONTENT_URI = Uri.parse(TPProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String DATE = "date";

    public static final String NUMERO = "numero";

    public static final String NUMEROSIMPLIFIE = "numeroSimplifie";

    public static final String CLIENT = "client";

    public static final String PRIX = "prix";

    public static final String TOPOGRAPHIE = "topographie";

    public static final String GARAGE = "garage";

    public static final String CARPORT = "carport";

    public static final String CAVE = "cave";

    public static final String PRO = "pro";

    public static final String PAREMENT = "parement";

    public static final String TOITURE1 = "toiture1";

    public static final String TOITURE2 = "toiture2";

    public static final String CHASSIS = "chassis";

    public static final String INVEST = "invest";

    public static final String CHAMBREREZ = "chambrerez";

    public static final String IDAPMODELE = "idAPModele";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            DATE,
            NUMERO,
            NUMEROSIMPLIFIE,
            CLIENT,
            PRIX,
            TOPOGRAPHIE,
            GARAGE,
            CARPORT,
            CAVE,
            PRO,
            PAREMENT,
            TOITURE1,
            TOITURE2,
            CHASSIS,
            INVEST,
            CHAMBREREZ,
            IDAPMODELE
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(DATE) || c.contains("." + DATE)) return true;
            if (c.equals(NUMERO) || c.contains("." + NUMERO)) return true;
            if (c.equals(NUMEROSIMPLIFIE) || c.contains("." + NUMEROSIMPLIFIE)) return true;
            if (c.equals(CLIENT) || c.contains("." + CLIENT)) return true;
            if (c.equals(PRIX) || c.contains("." + PRIX)) return true;
            if (c.equals(TOPOGRAPHIE) || c.contains("." + TOPOGRAPHIE)) return true;
            if (c.equals(GARAGE) || c.contains("." + GARAGE)) return true;
            if (c.equals(CARPORT) || c.contains("." + CARPORT)) return true;
            if (c.equals(CAVE) || c.contains("." + CAVE)) return true;
            if (c.equals(PRO) || c.contains("." + PRO)) return true;
            if (c.equals(PAREMENT) || c.contains("." + PAREMENT)) return true;
            if (c.equals(TOITURE1) || c.contains("." + TOITURE1)) return true;
            if (c.equals(TOITURE2) || c.contains("." + TOITURE2)) return true;
            if (c.equals(CHASSIS) || c.contains("." + CHASSIS)) return true;
            if (c.equals(INVEST) || c.contains("." + INVEST)) return true;
            if (c.equals(CHAMBREREZ) || c.contains("." + CHAMBREREZ)) return true;
            if (c.equals(IDAPMODELE) || c.contains("." + IDAPMODELE)) return true;
        }
        return false;
    }

}
