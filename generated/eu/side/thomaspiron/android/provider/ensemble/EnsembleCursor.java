package eu.side.thomaspiron.android.provider.ensemble;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import eu.side.thomaspiron.android.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code ensemble} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class EnsembleCursor extends AbstractCursor implements EnsembleModel {
    public EnsembleCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(EnsembleColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code socicode} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSocicode() {
        String res = getStringOrNull(EnsembleColumns.SOCICODE);
        return res;
    }

    /**
     * Get the {@code cptepl} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCptepl() {
        String res = getStringOrNull(EnsembleColumns.CPTEPL);
        return res;
    }

    /**
     * Get the {@code divicode} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDivicode() {
        String res = getStringOrNull(EnsembleColumns.DIVICODE);
        return res;
    }

    /**
     * Get the {@code ensecode} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getEnsecode() {
        String res = getStringOrNull(EnsembleColumns.ENSECODE);
        return res;
    }

    /**
     * Get the {@code adresse} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getAdresse() {
        String res = getStringOrNull(EnsembleColumns.ADRESSE);
        return res;
    }

    /**
     * Get the {@code postloc} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPostloc() {
        String res = getStringOrNull(EnsembleColumns.POSTLOC);
        return res;
    }

    /**
     * Get the {@code postcode} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPostcode() {
        String res = getStringOrNull(EnsembleColumns.POSTCODE);
        return res;
    }

    /**
     * Get the {@code ensedesc} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getEnsedesc() {
        String res = getStringOrNull(EnsembleColumns.ENSEDESC);
        return res;
    }

    /**
     * Get the {@code libcommercialfr} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLibcommercialfr() {
        String res = getStringOrNull(EnsembleColumns.LIBCOMMERCIALFR);
        return res;
    }

    /**
     * Get the {@code libcommercialen} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLibcommercialen() {
        String res = getStringOrNull(EnsembleColumns.LIBCOMMERCIALEN);
        return res;
    }

    /**
     * Get the {@code latitude} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Double getLatitude() {
        Double res = getDoubleOrNull(EnsembleColumns.LATITUDE);
        return res;
    }

    /**
     * Get the {@code longitude} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Double getLongitude() {
        Double res = getDoubleOrNull(EnsembleColumns.LONGITUDE);
        return res;
    }

    /**
     * Get the {@code descriptiondistancefr} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDescriptiondistancefr() {
        String res = getStringOrNull(EnsembleColumns.DESCRIPTIONDISTANCEFR);
        return res;
    }

    /**
     * Get the {@code descriptiondistanceen} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDescriptiondistanceen() {
        String res = getStringOrNull(EnsembleColumns.DESCRIPTIONDISTANCEEN);
        return res;
    }

    /**
     * Get the {@code totunit} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getTotunit() {
        Integer res = getIntegerOrNull(EnsembleColumns.TOTUNIT);
        return res;
    }

    /**
     * Get the {@code terrainmin} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTerrainmin() {
        String res = getStringOrNull(EnsembleColumns.TERRAINMIN);
        return res;
    }

    /**
     * Get the {@code terrainmax} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTerrainmax() {
        String res = getStringOrNull(EnsembleColumns.TERRAINMAX);
        return res;
    }

    /**
     * Get the {@code terrainspp} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getTerrainspp() {
        Integer res = getIntegerOrNull(EnsembleColumns.TERRAINSPP);
        return res;
    }

    /**
     * Get the {@code terrainspc} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getTerrainspc() {
        Integer res = getIntegerOrNull(EnsembleColumns.TERRAINSPC);
        return res;
    }

    /**
     * Get the {@code terrainsec} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getTerrainsec() {
        Integer res = getIntegerOrNull(EnsembleColumns.TERRAINSEC);
        return res;
    }

    /**
     * Get the {@code maisonsec} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getMaisonsec() {
        Integer res = getIntegerOrNull(EnsembleColumns.MAISONSEC);
        return res;
    }

    /**
     * Get the {@code maisonsc} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getMaisonsc() {
        Integer res = getIntegerOrNull(EnsembleColumns.MAISONSC);
        return res;
    }

    /**
     * Get the {@code surfmin} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSurfmin() {
        String res = getStringOrNull(EnsembleColumns.SURFMIN);
        return res;
    }

    /**
     * Get the {@code surfmax} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSurfmax() {
        String res = getStringOrNull(EnsembleColumns.SURFMAX);
        return res;
    }

    /**
     * Get the {@code nbstudios} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbstudios() {
        Integer res = getIntegerOrNull(EnsembleColumns.NBSTUDIOS);
        return res;
    }

    /**
     * Get the {@code nbapparts} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbapparts() {
        Integer res = getIntegerOrNull(EnsembleColumns.NBAPPARTS);
        return res;
    }

    /**
     * Get the {@code nbpenthouses} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbpenthouses() {
        Integer res = getIntegerOrNull(EnsembleColumns.NBPENTHOUSES);
        return res;
    }

    /**
     * Get the {@code nbduplex} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbduplex() {
        Integer res = getIntegerOrNull(EnsembleColumns.NBDUPLEX);
        return res;
    }

    /**
     * Get the {@code nbcommerces} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbcommerces() {
        Integer res = getIntegerOrNull(EnsembleColumns.NBCOMMERCES);
        return res;
    }

    /**
     * Get the {@code nbbureaux} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbbureaux() {
        Integer res = getIntegerOrNull(EnsembleColumns.NBBUREAUX);
        return res;
    }

    /**
     * Get the {@code nbterrainsdispo} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbterrainsdispo() {
        Integer res = getIntegerOrNull(EnsembleColumns.NBTERRAINSDISPO);
        return res;
    }

    /**
     * Get the {@code maison} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getMaison() {
        Boolean res = getBooleanOrNull(EnsembleColumns.MAISON);
        return res;
    }

    /**
     * Get the {@code appart} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getAppart() {
        Boolean res = getBooleanOrNull(EnsembleColumns.APPART);
        return res;
    }

    /**
     * Get the {@code terrain} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getTerrain() {
        Boolean res = getBooleanOrNull(EnsembleColumns.TERRAIN);
        return res;
    }

    /**
     * Get the {@code province} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getProvince() {
        String res = getStringOrNull(EnsembleColumns.PROVINCE);
        return res;
    }

    /**
     * Get the {@code idpointcontact} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getIdpointcontact() {
        Integer res = getIntegerOrNull(EnsembleColumns.IDPOINTCONTACT);
        return res;
    }

    /**
     * Get the {@code nbmedias} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbmedias() {
        Integer res = getIntegerOrNull(EnsembleColumns.NBMEDIAS);
        return res;
    }

    /**
     * Get the {@code nbplansimpl} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbplansimpl() {
        Integer res = getIntegerOrNull(EnsembleColumns.NBPLANSIMPL);
        return res;
    }

    /**
     * Get the {@code dtdebnouveau} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Date getDtdebnouveau() {
        Date res = getDateOrNull(EnsembleColumns.DTDEBNOUVEAU);
        return res;
    }

    /**
     * Get the {@code dtdebremise} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Date getDtdebremise() {
        Date res = getDateOrNull(EnsembleColumns.DTDEBREMISE);
        return res;
    }

    /**
     * Get the {@code dtfinnouveau} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Date getDtfinnouveau() {
        Date res = getDateOrNull(EnsembleColumns.DTFINNOUVEAU);
        return res;
    }

    /**
     * Get the {@code dtfinporteouverte} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Date getDtfinporteouverte() {
        Date res = getDateOrNull(EnsembleColumns.DTFINPORTEOUVERTE);
        return res;
    }

    /**
     * Get the {@code dtfinremise} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Date getDtfinremise() {
        Date res = getDateOrNull(EnsembleColumns.DTFINREMISE);
        return res;
    }

    /**
     * Get the {@code infoporteouverte} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getInfoporteouverte() {
        String res = getStringOrNull(EnsembleColumns.INFOPORTEOUVERTE);
        return res;
    }

    /**
     * Get the {@code libelleremise} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLibelleremise() {
        String res = getStringOrNull(EnsembleColumns.LIBELLEREMISE);
        return res;
    }

    /**
     * Get the {@code nbtriplex} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbtriplex() {
        Integer res = getIntegerOrNull(EnsembleColumns.NBTRIPLEX);
        return res;
    }

    /**
     * Get the {@code nbquadriplex} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbquadriplex() {
        Integer res = getIntegerOrNull(EnsembleColumns.NBQUADRIPLEX);
        return res;
    }
}
