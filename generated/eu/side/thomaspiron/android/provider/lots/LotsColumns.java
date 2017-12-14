package eu.side.thomaspiron.android.provider.lots;

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
 * lot
 */
@SuppressWarnings("unused")
public class LotsColumns implements BaseColumns {
    public static final String TABLE_NAME = "lots";
    public static final Uri CONTENT_URI = Uri.parse(TPProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String LOTDESC = "lotDesc";

    public static final String CPTEPL = "cptEpl";

    public static final String JARDIN = "jardin";

    public static final String BALCON = "balcon";

    public static final String CHAMBRES = "chambres";

    public static final String FACADESNBR = "facadesNbr";

    public static final String ORIENTATION = "orientation";

    public static final String STATUTLOT = "statutLot";

    public static final String SURFTER = "surfTer";

    public static final String SURFHAB = "surfHab";

    public static final String CODEETAGE = "codeEtage";

    public static final String LIBELLEFR = "libelleFR";

    public static final String ENSECODE = "enseCode";

    public static final String SOCICODE = "sociCode";

    public static final String PEBCLASSEENERGETIQUE = "pebClasseEnergetique";

    public static final String NBMEDIAS = "nbMedias";

    public static final String NBPLANSIMPL = "nbPlansImpl";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            LOTDESC,
            CPTEPL,
            JARDIN,
            BALCON,
            CHAMBRES,
            FACADESNBR,
            ORIENTATION,
            STATUTLOT,
            SURFTER,
            SURFHAB,
            CODEETAGE,
            LIBELLEFR,
            ENSECODE,
            SOCICODE,
            PEBCLASSEENERGETIQUE,
            NBMEDIAS,
            NBPLANSIMPL
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(LOTDESC) || c.contains("." + LOTDESC)) return true;
            if (c.equals(CPTEPL) || c.contains("." + CPTEPL)) return true;
            if (c.equals(JARDIN) || c.contains("." + JARDIN)) return true;
            if (c.equals(BALCON) || c.contains("." + BALCON)) return true;
            if (c.equals(CHAMBRES) || c.contains("." + CHAMBRES)) return true;
            if (c.equals(FACADESNBR) || c.contains("." + FACADESNBR)) return true;
            if (c.equals(ORIENTATION) || c.contains("." + ORIENTATION)) return true;
            if (c.equals(STATUTLOT) || c.contains("." + STATUTLOT)) return true;
            if (c.equals(SURFTER) || c.contains("." + SURFTER)) return true;
            if (c.equals(SURFHAB) || c.contains("." + SURFHAB)) return true;
            if (c.equals(CODEETAGE) || c.contains("." + CODEETAGE)) return true;
            if (c.equals(LIBELLEFR) || c.contains("." + LIBELLEFR)) return true;
            if (c.equals(ENSECODE) || c.contains("." + ENSECODE)) return true;
            if (c.equals(SOCICODE) || c.contains("." + SOCICODE)) return true;
            if (c.equals(PEBCLASSEENERGETIQUE) || c.contains("." + PEBCLASSEENERGETIQUE)) return true;
            if (c.equals(NBMEDIAS) || c.contains("." + NBMEDIAS)) return true;
            if (c.equals(NBPLANSIMPL) || c.contains("." + NBPLANSIMPL)) return true;
        }
        return false;
    }

}
