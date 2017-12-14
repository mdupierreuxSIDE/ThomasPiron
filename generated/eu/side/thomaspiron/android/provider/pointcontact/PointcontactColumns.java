package eu.side.thomaspiron.android.provider.pointcontact;

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
 * point contact
 */
@SuppressWarnings("unused")
public class PointcontactColumns implements BaseColumns {
    public static final String TABLE_NAME = "pointcontact";
    public static final Uri CONTENT_URI = Uri.parse(TPProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String IDPOINTCONTACT = "idPointContact";

    public static final String TYPEPOINTCONTACT = "typePointContact";

    public static final String TITRE = "titre";

    public static final String ADRESSE = "adresse";

    public static final String POSTLOC = "postLoc";

    public static final String POSTCODE = "postCode";

    public static final String TEL = "tel";

    public static final String PERMANENCEFR = "permanenceFr";

    public static final String LATITUDE = "latitude";

    public static final String LONGITUDE = "longitude";

    public static final String NBMEDIAS = "nbMedias";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            IDPOINTCONTACT,
            TYPEPOINTCONTACT,
            TITRE,
            ADRESSE,
            POSTLOC,
            POSTCODE,
            TEL,
            PERMANENCEFR,
            LATITUDE,
            LONGITUDE,
            NBMEDIAS
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(IDPOINTCONTACT) || c.contains("." + IDPOINTCONTACT)) return true;
            if (c.equals(TYPEPOINTCONTACT) || c.contains("." + TYPEPOINTCONTACT)) return true;
            if (c.equals(TITRE) || c.contains("." + TITRE)) return true;
            if (c.equals(ADRESSE) || c.contains("." + ADRESSE)) return true;
            if (c.equals(POSTLOC) || c.contains("." + POSTLOC)) return true;
            if (c.equals(POSTCODE) || c.contains("." + POSTCODE)) return true;
            if (c.equals(TEL) || c.contains("." + TEL)) return true;
            if (c.equals(PERMANENCEFR) || c.contains("." + PERMANENCEFR)) return true;
            if (c.equals(LATITUDE) || c.contains("." + LATITUDE)) return true;
            if (c.equals(LONGITUDE) || c.contains("." + LONGITUDE)) return true;
            if (c.equals(NBMEDIAS) || c.contains("." + NBMEDIAS)) return true;
        }
        return false;
    }

}
