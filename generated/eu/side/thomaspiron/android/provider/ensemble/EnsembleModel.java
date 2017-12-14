package eu.side.thomaspiron.android.provider.ensemble;

// @formatter:off
import eu.side.thomaspiron.android.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * ensemble
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface EnsembleModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code socicode} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSocicode();

    /**
     * Get the {@code cptepl} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCptepl();

    /**
     * Get the {@code divicode} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDivicode();

    /**
     * Get the {@code ensecode} value.
     * Can be {@code null}.
     */
    @Nullable
    String getEnsecode();

    /**
     * Get the {@code adresse} value.
     * Can be {@code null}.
     */
    @Nullable
    String getAdresse();

    /**
     * Get the {@code postloc} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPostloc();

    /**
     * Get the {@code postcode} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPostcode();

    /**
     * Get the {@code ensedesc} value.
     * Can be {@code null}.
     */
    @Nullable
    String getEnsedesc();

    /**
     * Get the {@code libcommercialfr} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLibcommercialfr();

    /**
     * Get the {@code libcommercialen} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLibcommercialen();

    /**
     * Get the {@code latitude} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getLatitude();

    /**
     * Get the {@code longitude} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getLongitude();

    /**
     * Get the {@code descriptiondistancefr} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDescriptiondistancefr();

    /**
     * Get the {@code descriptiondistanceen} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDescriptiondistanceen();

    /**
     * Get the {@code totunit} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getTotunit();

    /**
     * Get the {@code terrainmin} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTerrainmin();

    /**
     * Get the {@code terrainmax} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTerrainmax();

    /**
     * Get the {@code terrainspp} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getTerrainspp();

    /**
     * Get the {@code terrainspc} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getTerrainspc();

    /**
     * Get the {@code terrainsec} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getTerrainsec();

    /**
     * Get the {@code maisonsec} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getMaisonsec();

    /**
     * Get the {@code maisonsc} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getMaisonsc();

    /**
     * Get the {@code surfmin} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSurfmin();

    /**
     * Get the {@code surfmax} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSurfmax();

    /**
     * Get the {@code nbstudios} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getNbstudios();

    /**
     * Get the {@code nbapparts} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getNbapparts();

    /**
     * Get the {@code nbpenthouses} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getNbpenthouses();

    /**
     * Get the {@code nbduplex} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getNbduplex();

    /**
     * Get the {@code nbcommerces} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getNbcommerces();

    /**
     * Get the {@code nbbureaux} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getNbbureaux();

    /**
     * Get the {@code nbterrainsdispo} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getNbterrainsdispo();

    /**
     * Get the {@code maison} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getMaison();

    /**
     * Get the {@code appart} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getAppart();

    /**
     * Get the {@code terrain} value.
     * Can be {@code null}.
     */
    @Nullable
    Boolean getTerrain();

    /**
     * Get the {@code province} value.
     * Can be {@code null}.
     */
    @Nullable
    String getProvince();

    /**
     * Get the {@code idpointcontact} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getIdpointcontact();

    /**
     * Get the {@code nbmedias} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getNbmedias();

    /**
     * Get the {@code nbplansimpl} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getNbplansimpl();

    /**
     * Get the {@code dtdebnouveau} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getDtdebnouveau();

    /**
     * Get the {@code dtdebremise} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getDtdebremise();

    /**
     * Get the {@code dtfinnouveau} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getDtfinnouveau();

    /**
     * Get the {@code dtfinporteouverte} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getDtfinporteouverte();

    /**
     * Get the {@code dtfinremise} value.
     * Can be {@code null}.
     */
    @Nullable
    Date getDtfinremise();

    /**
     * Get the {@code infoporteouverte} value.
     * Can be {@code null}.
     */
    @Nullable
    String getInfoporteouverte();

    /**
     * Get the {@code libelleremise} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLibelleremise();

    /**
     * Get the {@code nbtriplex} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getNbtriplex();

    /**
     * Get the {@code nbquadriplex} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getNbquadriplex();
}
