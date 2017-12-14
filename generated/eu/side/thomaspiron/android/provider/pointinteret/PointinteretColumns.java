package eu.side.thomaspiron.android.provider.pointinteret;

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
 * point interet
 */
@SuppressWarnings("unused")
public class PointinteretColumns implements BaseColumns {
    public static final String TABLE_NAME = "pointinteret";
    public static final Uri CONTENT_URI = Uri.parse(TPProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String IDINTERET = "idInteret";

    public static final String LIBELLEFR = "libelleFr";

    public static final String LIBELLEEN = "libelleEn";

    public static final String IDPAYS = "idPays";

    public static final String EMAIL = "email";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            IDINTERET,
            LIBELLEFR,
            LIBELLEEN,
            IDPAYS,
            EMAIL
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(IDINTERET) || c.contains("." + IDINTERET)) return true;
            if (c.equals(LIBELLEFR) || c.contains("." + LIBELLEFR)) return true;
            if (c.equals(LIBELLEEN) || c.contains("." + LIBELLEEN)) return true;
            if (c.equals(IDPAYS) || c.contains("." + IDPAYS)) return true;
            if (c.equals(EMAIL) || c.contains("." + EMAIL)) return true;
        }
        return false;
    }

}
