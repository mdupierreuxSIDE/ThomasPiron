package eu.side.thomaspiron.android.provider.ensemble;

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
 * ensemble
 */
@SuppressWarnings("unused")
public class EnsembleColumns implements BaseColumns {
    public static final String TABLE_NAME = "ensemble";
    public static final Uri CONTENT_URI = Uri.parse(TPProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String SOCICODE = "SociCode";

    public static final String CPTEPL = "CptEpl";

    public static final String DIVICODE = "DiviCode";

    public static final String ENSECODE = "EnseCode";

    public static final String ADRESSE = "Adresse";

    public static final String POSTLOC = "PostLoc";

    public static final String POSTCODE = "PostCode";

    public static final String ENSEDESC = "EnseDesc";

    public static final String LIBCOMMERCIALFR = "LibCommercialFr";

    public static final String LIBCOMMERCIALEN = "LibCommercialEn";

    public static final String LATITUDE = "Latitude";

    public static final String LONGITUDE = "Longitude";

    public static final String DESCRIPTIONDISTANCEFR = "DescriptionDistanceFr";

    public static final String DESCRIPTIONDISTANCEEN = "DescriptionDistanceEn";

    public static final String TOTUNIT = "TotUnit";

    public static final String TERRAINMIN = "TerrainMin";

    public static final String TERRAINMAX = "TerrainMax";

    public static final String TERRAINSPP = "TerrainsPP";

    public static final String TERRAINSPC = "TerrainsPC";

    public static final String TERRAINSEC = "TerrainsEC";

    public static final String MAISONSEC = "MaisonsEC";

    public static final String MAISONSC = "MaisonsC";

    public static final String SURFMIN = "SurfMin";

    public static final String SURFMAX = "SurfMax";

    public static final String NBSTUDIOS = "NbStudios";

    public static final String NBAPPARTS = "NbApparts";

    public static final String NBPENTHOUSES = "NbPenthouses";

    public static final String NBDUPLEX = "NbDuplex";

    public static final String NBCOMMERCES = "NbCommerces";

    public static final String NBBUREAUX = "NbBureaux";

    public static final String NBTERRAINSDISPO = "NbTerrainsDispo";

    public static final String MAISON = "Maison";

    public static final String APPART = "Appart";

    public static final String TERRAIN = "Terrain";

    public static final String PROVINCE = "Province";

    public static final String IDPOINTCONTACT = "idPointContact";

    public static final String NBMEDIAS = "nbMedias";

    public static final String NBPLANSIMPL = "nbPlansImpl";

    public static final String DTDEBNOUVEAU = "dtDebNouveau";

    public static final String DTDEBREMISE = "dtDebRemise";

    public static final String DTFINNOUVEAU = "dtFinNouveau";

    public static final String DTFINPORTEOUVERTE = "dtFinPorteOuverte";

    public static final String DTFINREMISE = "dtFinRemise";

    public static final String INFOPORTEOUVERTE = "infoPorteOuverte";

    public static final String LIBELLEREMISE = "libelleRemise";

    public static final String NBTRIPLEX = "nbTriplex";

    public static final String NBQUADRIPLEX = "nbQuadriplex";


    public static final String DEFAULT_ORDER = null;

    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            SOCICODE,
            CPTEPL,
            DIVICODE,
            ENSECODE,
            ADRESSE,
            POSTLOC,
            POSTCODE,
            ENSEDESC,
            LIBCOMMERCIALFR,
            LIBCOMMERCIALEN,
            LATITUDE,
            LONGITUDE,
            DESCRIPTIONDISTANCEFR,
            DESCRIPTIONDISTANCEEN,
            TOTUNIT,
            TERRAINMIN,
            TERRAINMAX,
            TERRAINSPP,
            TERRAINSPC,
            TERRAINSEC,
            MAISONSEC,
            MAISONSC,
            SURFMIN,
            SURFMAX,
            NBSTUDIOS,
            NBAPPARTS,
            NBPENTHOUSES,
            NBDUPLEX,
            NBCOMMERCES,
            NBBUREAUX,
            NBTERRAINSDISPO,
            MAISON,
            APPART,
            TERRAIN,
            PROVINCE,
            IDPOINTCONTACT,
            NBMEDIAS,
            NBPLANSIMPL,
            DTDEBNOUVEAU,
            DTDEBREMISE,
            DTFINNOUVEAU,
            DTFINPORTEOUVERTE,
            DTFINREMISE,
            INFOPORTEOUVERTE,
            LIBELLEREMISE,
            NBTRIPLEX,
            NBQUADRIPLEX
    };

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(SOCICODE) || c.contains("." + SOCICODE)) return true;
            if (c.equals(CPTEPL) || c.contains("." + CPTEPL)) return true;
            if (c.equals(DIVICODE) || c.contains("." + DIVICODE)) return true;
            if (c.equals(ENSECODE) || c.contains("." + ENSECODE)) return true;
            if (c.equals(ADRESSE) || c.contains("." + ADRESSE)) return true;
            if (c.equals(POSTLOC) || c.contains("." + POSTLOC)) return true;
            if (c.equals(POSTCODE) || c.contains("." + POSTCODE)) return true;
            if (c.equals(ENSEDESC) || c.contains("." + ENSEDESC)) return true;
            if (c.equals(LIBCOMMERCIALFR) || c.contains("." + LIBCOMMERCIALFR)) return true;
            if (c.equals(LIBCOMMERCIALEN) || c.contains("." + LIBCOMMERCIALEN)) return true;
            if (c.equals(LATITUDE) || c.contains("." + LATITUDE)) return true;
            if (c.equals(LONGITUDE) || c.contains("." + LONGITUDE)) return true;
            if (c.equals(DESCRIPTIONDISTANCEFR) || c.contains("." + DESCRIPTIONDISTANCEFR)) return true;
            if (c.equals(DESCRIPTIONDISTANCEEN) || c.contains("." + DESCRIPTIONDISTANCEEN)) return true;
            if (c.equals(TOTUNIT) || c.contains("." + TOTUNIT)) return true;
            if (c.equals(TERRAINMIN) || c.contains("." + TERRAINMIN)) return true;
            if (c.equals(TERRAINMAX) || c.contains("." + TERRAINMAX)) return true;
            if (c.equals(TERRAINSPP) || c.contains("." + TERRAINSPP)) return true;
            if (c.equals(TERRAINSPC) || c.contains("." + TERRAINSPC)) return true;
            if (c.equals(TERRAINSEC) || c.contains("." + TERRAINSEC)) return true;
            if (c.equals(MAISONSEC) || c.contains("." + MAISONSEC)) return true;
            if (c.equals(MAISONSC) || c.contains("." + MAISONSC)) return true;
            if (c.equals(SURFMIN) || c.contains("." + SURFMIN)) return true;
            if (c.equals(SURFMAX) || c.contains("." + SURFMAX)) return true;
            if (c.equals(NBSTUDIOS) || c.contains("." + NBSTUDIOS)) return true;
            if (c.equals(NBAPPARTS) || c.contains("." + NBAPPARTS)) return true;
            if (c.equals(NBPENTHOUSES) || c.contains("." + NBPENTHOUSES)) return true;
            if (c.equals(NBDUPLEX) || c.contains("." + NBDUPLEX)) return true;
            if (c.equals(NBCOMMERCES) || c.contains("." + NBCOMMERCES)) return true;
            if (c.equals(NBBUREAUX) || c.contains("." + NBBUREAUX)) return true;
            if (c.equals(NBTERRAINSDISPO) || c.contains("." + NBTERRAINSDISPO)) return true;
            if (c.equals(MAISON) || c.contains("." + MAISON)) return true;
            if (c.equals(APPART) || c.contains("." + APPART)) return true;
            if (c.equals(TERRAIN) || c.contains("." + TERRAIN)) return true;
            if (c.equals(PROVINCE) || c.contains("." + PROVINCE)) return true;
            if (c.equals(IDPOINTCONTACT) || c.contains("." + IDPOINTCONTACT)) return true;
            if (c.equals(NBMEDIAS) || c.contains("." + NBMEDIAS)) return true;
            if (c.equals(NBPLANSIMPL) || c.contains("." + NBPLANSIMPL)) return true;
            if (c.equals(DTDEBNOUVEAU) || c.contains("." + DTDEBNOUVEAU)) return true;
            if (c.equals(DTDEBREMISE) || c.contains("." + DTDEBREMISE)) return true;
            if (c.equals(DTFINNOUVEAU) || c.contains("." + DTFINNOUVEAU)) return true;
            if (c.equals(DTFINPORTEOUVERTE) || c.contains("." + DTFINPORTEOUVERTE)) return true;
            if (c.equals(DTFINREMISE) || c.contains("." + DTFINREMISE)) return true;
            if (c.equals(INFOPORTEOUVERTE) || c.contains("." + INFOPORTEOUVERTE)) return true;
            if (c.equals(LIBELLEREMISE) || c.contains("." + LIBELLEREMISE)) return true;
            if (c.equals(NBTRIPLEX) || c.contains("." + NBTRIPLEX)) return true;
            if (c.equals(NBQUADRIPLEX) || c.contains("." + NBQUADRIPLEX)) return true;
        }
        return false;
    }

}
