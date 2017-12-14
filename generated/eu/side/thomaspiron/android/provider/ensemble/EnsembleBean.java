package eu.side.thomaspiron.android.provider.ensemble;

// @formatter:off
import eu.side.thomaspiron.android.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * ensemble
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class EnsembleBean implements EnsembleModel {
    private long mId;
    private String mSocicode;
    private String mCptepl;
    private String mDivicode;
    private String mEnsecode;
    private String mAdresse;
    private String mPostloc;
    private String mPostcode;
    private String mEnsedesc;
    private String mLibcommercialfr;
    private String mLibcommercialen;
    private Double mLatitude;
    private Double mLongitude;
    private String mDescriptiondistancefr;
    private String mDescriptiondistanceen;
    private Integer mTotunit;
    private String mTerrainmin;
    private String mTerrainmax;
    private Integer mTerrainspp;
    private Integer mTerrainspc;
    private Integer mTerrainsec;
    private Integer mMaisonsec;
    private Integer mMaisonsc;
    private String mSurfmin;
    private String mSurfmax;
    private Integer mNbstudios;
    private Integer mNbapparts;
    private Integer mNbpenthouses;
    private Integer mNbduplex;
    private Integer mNbcommerces;
    private Integer mNbbureaux;
    private Integer mNbterrainsdispo;
    private Boolean mMaison;
    private Boolean mAppart;
    private Boolean mTerrain;
    private String mProvince;
    private Integer mIdpointcontact;
    private Integer mNbmedias;
    private Integer mNbplansimpl;
    private Date mDtdebnouveau;
    private Date mDtdebremise;
    private Date mDtfinnouveau;
    private Date mDtfinporteouverte;
    private Date mDtfinremise;
    private String mInfoporteouverte;
    private String mLibelleremise;
    private Integer mNbtriplex;
    private Integer mNbquadriplex;

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        return mId;
    }

    /**
     * Primary key.
     */
    public void setId(long id) {
        mId = id;
    }

    /**
     * Get the {@code socicode} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSocicode() {
        return mSocicode;
    }

    /**
     * Set the {@code socicode} value.
     * Can be {@code null}.
     */
    public void setSocicode(@Nullable String socicode) {
        mSocicode = socicode;
    }

    /**
     * Get the {@code cptepl} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCptepl() {
        return mCptepl;
    }

    /**
     * Set the {@code cptepl} value.
     * Can be {@code null}.
     */
    public void setCptepl(@Nullable String cptepl) {
        mCptepl = cptepl;
    }

    /**
     * Get the {@code divicode} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDivicode() {
        return mDivicode;
    }

    /**
     * Set the {@code divicode} value.
     * Can be {@code null}.
     */
    public void setDivicode(@Nullable String divicode) {
        mDivicode = divicode;
    }

    /**
     * Get the {@code ensecode} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getEnsecode() {
        return mEnsecode;
    }

    /**
     * Set the {@code ensecode} value.
     * Can be {@code null}.
     */
    public void setEnsecode(@Nullable String ensecode) {
        mEnsecode = ensecode;
    }

    /**
     * Get the {@code adresse} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getAdresse() {
        return mAdresse;
    }

    /**
     * Set the {@code adresse} value.
     * Can be {@code null}.
     */
    public void setAdresse(@Nullable String adresse) {
        mAdresse = adresse;
    }

    /**
     * Get the {@code postloc} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPostloc() {
        return mPostloc;
    }

    /**
     * Set the {@code postloc} value.
     * Can be {@code null}.
     */
    public void setPostloc(@Nullable String postloc) {
        mPostloc = postloc;
    }

    /**
     * Get the {@code postcode} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPostcode() {
        return mPostcode;
    }

    /**
     * Set the {@code postcode} value.
     * Can be {@code null}.
     */
    public void setPostcode(@Nullable String postcode) {
        mPostcode = postcode;
    }

    /**
     * Get the {@code ensedesc} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getEnsedesc() {
        return mEnsedesc;
    }

    /**
     * Set the {@code ensedesc} value.
     * Can be {@code null}.
     */
    public void setEnsedesc(@Nullable String ensedesc) {
        mEnsedesc = ensedesc;
    }

    /**
     * Get the {@code libcommercialfr} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLibcommercialfr() {
        return mLibcommercialfr;
    }

    /**
     * Set the {@code libcommercialfr} value.
     * Can be {@code null}.
     */
    public void setLibcommercialfr(@Nullable String libcommercialfr) {
        mLibcommercialfr = libcommercialfr;
    }

    /**
     * Get the {@code libcommercialen} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLibcommercialen() {
        return mLibcommercialen;
    }

    /**
     * Set the {@code libcommercialen} value.
     * Can be {@code null}.
     */
    public void setLibcommercialen(@Nullable String libcommercialen) {
        mLibcommercialen = libcommercialen;
    }

    /**
     * Get the {@code latitude} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Double getLatitude() {
        return mLatitude;
    }

    /**
     * Set the {@code latitude} value.
     * Can be {@code null}.
     */
    public void setLatitude(@Nullable Double latitude) {
        mLatitude = latitude;
    }

    /**
     * Get the {@code longitude} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Double getLongitude() {
        return mLongitude;
    }

    /**
     * Set the {@code longitude} value.
     * Can be {@code null}.
     */
    public void setLongitude(@Nullable Double longitude) {
        mLongitude = longitude;
    }

    /**
     * Get the {@code descriptiondistancefr} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDescriptiondistancefr() {
        return mDescriptiondistancefr;
    }

    /**
     * Set the {@code descriptiondistancefr} value.
     * Can be {@code null}.
     */
    public void setDescriptiondistancefr(@Nullable String descriptiondistancefr) {
        mDescriptiondistancefr = descriptiondistancefr;
    }

    /**
     * Get the {@code descriptiondistanceen} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDescriptiondistanceen() {
        return mDescriptiondistanceen;
    }

    /**
     * Set the {@code descriptiondistanceen} value.
     * Can be {@code null}.
     */
    public void setDescriptiondistanceen(@Nullable String descriptiondistanceen) {
        mDescriptiondistanceen = descriptiondistanceen;
    }

    /**
     * Get the {@code totunit} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getTotunit() {
        return mTotunit;
    }

    /**
     * Set the {@code totunit} value.
     * Can be {@code null}.
     */
    public void setTotunit(@Nullable Integer totunit) {
        mTotunit = totunit;
    }

    /**
     * Get the {@code terrainmin} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTerrainmin() {
        return mTerrainmin;
    }

    /**
     * Set the {@code terrainmin} value.
     * Can be {@code null}.
     */
    public void setTerrainmin(@Nullable String terrainmin) {
        mTerrainmin = terrainmin;
    }

    /**
     * Get the {@code terrainmax} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTerrainmax() {
        return mTerrainmax;
    }

    /**
     * Set the {@code terrainmax} value.
     * Can be {@code null}.
     */
    public void setTerrainmax(@Nullable String terrainmax) {
        mTerrainmax = terrainmax;
    }

    /**
     * Get the {@code terrainspp} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getTerrainspp() {
        return mTerrainspp;
    }

    /**
     * Set the {@code terrainspp} value.
     * Can be {@code null}.
     */
    public void setTerrainspp(@Nullable Integer terrainspp) {
        mTerrainspp = terrainspp;
    }

    /**
     * Get the {@code terrainspc} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getTerrainspc() {
        return mTerrainspc;
    }

    /**
     * Set the {@code terrainspc} value.
     * Can be {@code null}.
     */
    public void setTerrainspc(@Nullable Integer terrainspc) {
        mTerrainspc = terrainspc;
    }

    /**
     * Get the {@code terrainsec} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getTerrainsec() {
        return mTerrainsec;
    }

    /**
     * Set the {@code terrainsec} value.
     * Can be {@code null}.
     */
    public void setTerrainsec(@Nullable Integer terrainsec) {
        mTerrainsec = terrainsec;
    }

    /**
     * Get the {@code maisonsec} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getMaisonsec() {
        return mMaisonsec;
    }

    /**
     * Set the {@code maisonsec} value.
     * Can be {@code null}.
     */
    public void setMaisonsec(@Nullable Integer maisonsec) {
        mMaisonsec = maisonsec;
    }

    /**
     * Get the {@code maisonsc} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getMaisonsc() {
        return mMaisonsc;
    }

    /**
     * Set the {@code maisonsc} value.
     * Can be {@code null}.
     */
    public void setMaisonsc(@Nullable Integer maisonsc) {
        mMaisonsc = maisonsc;
    }

    /**
     * Get the {@code surfmin} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSurfmin() {
        return mSurfmin;
    }

    /**
     * Set the {@code surfmin} value.
     * Can be {@code null}.
     */
    public void setSurfmin(@Nullable String surfmin) {
        mSurfmin = surfmin;
    }

    /**
     * Get the {@code surfmax} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSurfmax() {
        return mSurfmax;
    }

    /**
     * Set the {@code surfmax} value.
     * Can be {@code null}.
     */
    public void setSurfmax(@Nullable String surfmax) {
        mSurfmax = surfmax;
    }

    /**
     * Get the {@code nbstudios} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbstudios() {
        return mNbstudios;
    }

    /**
     * Set the {@code nbstudios} value.
     * Can be {@code null}.
     */
    public void setNbstudios(@Nullable Integer nbstudios) {
        mNbstudios = nbstudios;
    }

    /**
     * Get the {@code nbapparts} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbapparts() {
        return mNbapparts;
    }

    /**
     * Set the {@code nbapparts} value.
     * Can be {@code null}.
     */
    public void setNbapparts(@Nullable Integer nbapparts) {
        mNbapparts = nbapparts;
    }

    /**
     * Get the {@code nbpenthouses} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbpenthouses() {
        return mNbpenthouses;
    }

    /**
     * Set the {@code nbpenthouses} value.
     * Can be {@code null}.
     */
    public void setNbpenthouses(@Nullable Integer nbpenthouses) {
        mNbpenthouses = nbpenthouses;
    }

    /**
     * Get the {@code nbduplex} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbduplex() {
        return mNbduplex;
    }

    /**
     * Set the {@code nbduplex} value.
     * Can be {@code null}.
     */
    public void setNbduplex(@Nullable Integer nbduplex) {
        mNbduplex = nbduplex;
    }

    /**
     * Get the {@code nbcommerces} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbcommerces() {
        return mNbcommerces;
    }

    /**
     * Set the {@code nbcommerces} value.
     * Can be {@code null}.
     */
    public void setNbcommerces(@Nullable Integer nbcommerces) {
        mNbcommerces = nbcommerces;
    }

    /**
     * Get the {@code nbbureaux} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbbureaux() {
        return mNbbureaux;
    }

    /**
     * Set the {@code nbbureaux} value.
     * Can be {@code null}.
     */
    public void setNbbureaux(@Nullable Integer nbbureaux) {
        mNbbureaux = nbbureaux;
    }

    /**
     * Get the {@code nbterrainsdispo} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbterrainsdispo() {
        return mNbterrainsdispo;
    }

    /**
     * Set the {@code nbterrainsdispo} value.
     * Can be {@code null}.
     */
    public void setNbterrainsdispo(@Nullable Integer nbterrainsdispo) {
        mNbterrainsdispo = nbterrainsdispo;
    }

    /**
     * Get the {@code maison} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getMaison() {
        return mMaison;
    }

    /**
     * Set the {@code maison} value.
     * Can be {@code null}.
     */
    public void setMaison(@Nullable Boolean maison) {
        mMaison = maison;
    }

    /**
     * Get the {@code appart} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getAppart() {
        return mAppart;
    }

    /**
     * Set the {@code appart} value.
     * Can be {@code null}.
     */
    public void setAppart(@Nullable Boolean appart) {
        mAppart = appart;
    }

    /**
     * Get the {@code terrain} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Boolean getTerrain() {
        return mTerrain;
    }

    /**
     * Set the {@code terrain} value.
     * Can be {@code null}.
     */
    public void setTerrain(@Nullable Boolean terrain) {
        mTerrain = terrain;
    }

    /**
     * Get the {@code province} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getProvince() {
        return mProvince;
    }

    /**
     * Set the {@code province} value.
     * Can be {@code null}.
     */
    public void setProvince(@Nullable String province) {
        mProvince = province;
    }

    /**
     * Get the {@code idpointcontact} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getIdpointcontact() {
        return mIdpointcontact;
    }

    /**
     * Set the {@code idpointcontact} value.
     * Can be {@code null}.
     */
    public void setIdpointcontact(@Nullable Integer idpointcontact) {
        mIdpointcontact = idpointcontact;
    }

    /**
     * Get the {@code nbmedias} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbmedias() {
        return mNbmedias;
    }

    /**
     * Set the {@code nbmedias} value.
     * Can be {@code null}.
     */
    public void setNbmedias(@Nullable Integer nbmedias) {
        mNbmedias = nbmedias;
    }

    /**
     * Get the {@code nbplansimpl} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbplansimpl() {
        return mNbplansimpl;
    }

    /**
     * Set the {@code nbplansimpl} value.
     * Can be {@code null}.
     */
    public void setNbplansimpl(@Nullable Integer nbplansimpl) {
        mNbplansimpl = nbplansimpl;
    }

    /**
     * Get the {@code dtdebnouveau} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Date getDtdebnouveau() {
        return mDtdebnouveau;
    }

    /**
     * Set the {@code dtdebnouveau} value.
     * Can be {@code null}.
     */
    public void setDtdebnouveau(@Nullable Date dtdebnouveau) {
        mDtdebnouveau = dtdebnouveau;
    }

    /**
     * Get the {@code dtdebremise} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Date getDtdebremise() {
        return mDtdebremise;
    }

    /**
     * Set the {@code dtdebremise} value.
     * Can be {@code null}.
     */
    public void setDtdebremise(@Nullable Date dtdebremise) {
        mDtdebremise = dtdebremise;
    }

    /**
     * Get the {@code dtfinnouveau} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Date getDtfinnouveau() {
        return mDtfinnouveau;
    }

    /**
     * Set the {@code dtfinnouveau} value.
     * Can be {@code null}.
     */
    public void setDtfinnouveau(@Nullable Date dtfinnouveau) {
        mDtfinnouveau = dtfinnouveau;
    }

    /**
     * Get the {@code dtfinporteouverte} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Date getDtfinporteouverte() {
        return mDtfinporteouverte;
    }

    /**
     * Set the {@code dtfinporteouverte} value.
     * Can be {@code null}.
     */
    public void setDtfinporteouverte(@Nullable Date dtfinporteouverte) {
        mDtfinporteouverte = dtfinporteouverte;
    }

    /**
     * Get the {@code dtfinremise} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Date getDtfinremise() {
        return mDtfinremise;
    }

    /**
     * Set the {@code dtfinremise} value.
     * Can be {@code null}.
     */
    public void setDtfinremise(@Nullable Date dtfinremise) {
        mDtfinremise = dtfinremise;
    }

    /**
     * Get the {@code infoporteouverte} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getInfoporteouverte() {
        return mInfoporteouverte;
    }

    /**
     * Set the {@code infoporteouverte} value.
     * Can be {@code null}.
     */
    public void setInfoporteouverte(@Nullable String infoporteouverte) {
        mInfoporteouverte = infoporteouverte;
    }

    /**
     * Get the {@code libelleremise} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLibelleremise() {
        return mLibelleremise;
    }

    /**
     * Set the {@code libelleremise} value.
     * Can be {@code null}.
     */
    public void setLibelleremise(@Nullable String libelleremise) {
        mLibelleremise = libelleremise;
    }

    /**
     * Get the {@code nbtriplex} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbtriplex() {
        return mNbtriplex;
    }

    /**
     * Set the {@code nbtriplex} value.
     * Can be {@code null}.
     */
    public void setNbtriplex(@Nullable Integer nbtriplex) {
        mNbtriplex = nbtriplex;
    }

    /**
     * Get the {@code nbquadriplex} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbquadriplex() {
        return mNbquadriplex;
    }

    /**
     * Set the {@code nbquadriplex} value.
     * Can be {@code null}.
     */
    public void setNbquadriplex(@Nullable Integer nbquadriplex) {
        mNbquadriplex = nbquadriplex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnsembleBean bean = (EnsembleBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new EnsembleBean with specified values.
     */
    @NonNull
    public static EnsembleBean newInstance(long id, @Nullable String socicode, @Nullable String cptepl, @Nullable String divicode, @Nullable String ensecode, @Nullable String adresse, @Nullable String postloc, @Nullable String postcode, @Nullable String ensedesc, @Nullable String libcommercialfr, @Nullable String libcommercialen, @Nullable Double latitude, @Nullable Double longitude, @Nullable String descriptiondistancefr, @Nullable String descriptiondistanceen, @Nullable Integer totunit, @Nullable String terrainmin, @Nullable String terrainmax, @Nullable Integer terrainspp, @Nullable Integer terrainspc, @Nullable Integer terrainsec, @Nullable Integer maisonsec, @Nullable Integer maisonsc, @Nullable String surfmin, @Nullable String surfmax, @Nullable Integer nbstudios, @Nullable Integer nbapparts, @Nullable Integer nbpenthouses, @Nullable Integer nbduplex, @Nullable Integer nbcommerces, @Nullable Integer nbbureaux, @Nullable Integer nbterrainsdispo, @Nullable Boolean maison, @Nullable Boolean appart, @Nullable Boolean terrain, @Nullable String province, @Nullable Integer idpointcontact, @Nullable Integer nbmedias, @Nullable Integer nbplansimpl, @Nullable Date dtdebnouveau, @Nullable Date dtdebremise, @Nullable Date dtfinnouveau, @Nullable Date dtfinporteouverte, @Nullable Date dtfinremise, @Nullable String infoporteouverte, @Nullable String libelleremise, @Nullable Integer nbtriplex, @Nullable Integer nbquadriplex) {
        EnsembleBean res = new EnsembleBean();
        res.mId = id;
        res.mSocicode = socicode;
        res.mCptepl = cptepl;
        res.mDivicode = divicode;
        res.mEnsecode = ensecode;
        res.mAdresse = adresse;
        res.mPostloc = postloc;
        res.mPostcode = postcode;
        res.mEnsedesc = ensedesc;
        res.mLibcommercialfr = libcommercialfr;
        res.mLibcommercialen = libcommercialen;
        res.mLatitude = latitude;
        res.mLongitude = longitude;
        res.mDescriptiondistancefr = descriptiondistancefr;
        res.mDescriptiondistanceen = descriptiondistanceen;
        res.mTotunit = totunit;
        res.mTerrainmin = terrainmin;
        res.mTerrainmax = terrainmax;
        res.mTerrainspp = terrainspp;
        res.mTerrainspc = terrainspc;
        res.mTerrainsec = terrainsec;
        res.mMaisonsec = maisonsec;
        res.mMaisonsc = maisonsc;
        res.mSurfmin = surfmin;
        res.mSurfmax = surfmax;
        res.mNbstudios = nbstudios;
        res.mNbapparts = nbapparts;
        res.mNbpenthouses = nbpenthouses;
        res.mNbduplex = nbduplex;
        res.mNbcommerces = nbcommerces;
        res.mNbbureaux = nbbureaux;
        res.mNbterrainsdispo = nbterrainsdispo;
        res.mMaison = maison;
        res.mAppart = appart;
        res.mTerrain = terrain;
        res.mProvince = province;
        res.mIdpointcontact = idpointcontact;
        res.mNbmedias = nbmedias;
        res.mNbplansimpl = nbplansimpl;
        res.mDtdebnouveau = dtdebnouveau;
        res.mDtdebremise = dtdebremise;
        res.mDtfinnouveau = dtfinnouveau;
        res.mDtfinporteouverte = dtfinporteouverte;
        res.mDtfinremise = dtfinremise;
        res.mInfoporteouverte = infoporteouverte;
        res.mLibelleremise = libelleremise;
        res.mNbtriplex = nbtriplex;
        res.mNbquadriplex = nbquadriplex;
        return res;
    }

    /**
     * Instantiate a new EnsembleBean with all the values copied from the given model.
     */
    @NonNull
    public static EnsembleBean copy(@NonNull EnsembleModel from) {
        EnsembleBean res = new EnsembleBean();
        res.mId = from.getId();
        res.mSocicode = from.getSocicode();
        res.mCptepl = from.getCptepl();
        res.mDivicode = from.getDivicode();
        res.mEnsecode = from.getEnsecode();
        res.mAdresse = from.getAdresse();
        res.mPostloc = from.getPostloc();
        res.mPostcode = from.getPostcode();
        res.mEnsedesc = from.getEnsedesc();
        res.mLibcommercialfr = from.getLibcommercialfr();
        res.mLibcommercialen = from.getLibcommercialen();
        res.mLatitude = from.getLatitude();
        res.mLongitude = from.getLongitude();
        res.mDescriptiondistancefr = from.getDescriptiondistancefr();
        res.mDescriptiondistanceen = from.getDescriptiondistanceen();
        res.mTotunit = from.getTotunit();
        res.mTerrainmin = from.getTerrainmin();
        res.mTerrainmax = from.getTerrainmax();
        res.mTerrainspp = from.getTerrainspp();
        res.mTerrainspc = from.getTerrainspc();
        res.mTerrainsec = from.getTerrainsec();
        res.mMaisonsec = from.getMaisonsec();
        res.mMaisonsc = from.getMaisonsc();
        res.mSurfmin = from.getSurfmin();
        res.mSurfmax = from.getSurfmax();
        res.mNbstudios = from.getNbstudios();
        res.mNbapparts = from.getNbapparts();
        res.mNbpenthouses = from.getNbpenthouses();
        res.mNbduplex = from.getNbduplex();
        res.mNbcommerces = from.getNbcommerces();
        res.mNbbureaux = from.getNbbureaux();
        res.mNbterrainsdispo = from.getNbterrainsdispo();
        res.mMaison = from.getMaison();
        res.mAppart = from.getAppart();
        res.mTerrain = from.getTerrain();
        res.mProvince = from.getProvince();
        res.mIdpointcontact = from.getIdpointcontact();
        res.mNbmedias = from.getNbmedias();
        res.mNbplansimpl = from.getNbplansimpl();
        res.mDtdebnouveau = from.getDtdebnouveau();
        res.mDtdebremise = from.getDtdebremise();
        res.mDtfinnouveau = from.getDtfinnouveau();
        res.mDtfinporteouverte = from.getDtfinporteouverte();
        res.mDtfinremise = from.getDtfinremise();
        res.mInfoporteouverte = from.getInfoporteouverte();
        res.mLibelleremise = from.getLibelleremise();
        res.mNbtriplex = from.getNbtriplex();
        res.mNbquadriplex = from.getNbquadriplex();
        return res;
    }

    public static class Builder {
        private EnsembleBean mRes = new EnsembleBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Set the {@code socicode} value.
         * Can be {@code null}.
         */
        public Builder socicode(@Nullable String socicode) {
            mRes.mSocicode = socicode;
            return this;
        }

        /**
         * Set the {@code cptepl} value.
         * Can be {@code null}.
         */
        public Builder cptepl(@Nullable String cptepl) {
            mRes.mCptepl = cptepl;
            return this;
        }

        /**
         * Set the {@code divicode} value.
         * Can be {@code null}.
         */
        public Builder divicode(@Nullable String divicode) {
            mRes.mDivicode = divicode;
            return this;
        }

        /**
         * Set the {@code ensecode} value.
         * Can be {@code null}.
         */
        public Builder ensecode(@Nullable String ensecode) {
            mRes.mEnsecode = ensecode;
            return this;
        }

        /**
         * Set the {@code adresse} value.
         * Can be {@code null}.
         */
        public Builder adresse(@Nullable String adresse) {
            mRes.mAdresse = adresse;
            return this;
        }

        /**
         * Set the {@code postloc} value.
         * Can be {@code null}.
         */
        public Builder postloc(@Nullable String postloc) {
            mRes.mPostloc = postloc;
            return this;
        }

        /**
         * Set the {@code postcode} value.
         * Can be {@code null}.
         */
        public Builder postcode(@Nullable String postcode) {
            mRes.mPostcode = postcode;
            return this;
        }

        /**
         * Set the {@code ensedesc} value.
         * Can be {@code null}.
         */
        public Builder ensedesc(@Nullable String ensedesc) {
            mRes.mEnsedesc = ensedesc;
            return this;
        }

        /**
         * Set the {@code libcommercialfr} value.
         * Can be {@code null}.
         */
        public Builder libcommercialfr(@Nullable String libcommercialfr) {
            mRes.mLibcommercialfr = libcommercialfr;
            return this;
        }

        /**
         * Set the {@code libcommercialen} value.
         * Can be {@code null}.
         */
        public Builder libcommercialen(@Nullable String libcommercialen) {
            mRes.mLibcommercialen = libcommercialen;
            return this;
        }

        /**
         * Set the {@code latitude} value.
         * Can be {@code null}.
         */
        public Builder latitude(@Nullable Double latitude) {
            mRes.mLatitude = latitude;
            return this;
        }

        /**
         * Set the {@code longitude} value.
         * Can be {@code null}.
         */
        public Builder longitude(@Nullable Double longitude) {
            mRes.mLongitude = longitude;
            return this;
        }

        /**
         * Set the {@code descriptiondistancefr} value.
         * Can be {@code null}.
         */
        public Builder descriptiondistancefr(@Nullable String descriptiondistancefr) {
            mRes.mDescriptiondistancefr = descriptiondistancefr;
            return this;
        }

        /**
         * Set the {@code descriptiondistanceen} value.
         * Can be {@code null}.
         */
        public Builder descriptiondistanceen(@Nullable String descriptiondistanceen) {
            mRes.mDescriptiondistanceen = descriptiondistanceen;
            return this;
        }

        /**
         * Set the {@code totunit} value.
         * Can be {@code null}.
         */
        public Builder totunit(@Nullable Integer totunit) {
            mRes.mTotunit = totunit;
            return this;
        }

        /**
         * Set the {@code terrainmin} value.
         * Can be {@code null}.
         */
        public Builder terrainmin(@Nullable String terrainmin) {
            mRes.mTerrainmin = terrainmin;
            return this;
        }

        /**
         * Set the {@code terrainmax} value.
         * Can be {@code null}.
         */
        public Builder terrainmax(@Nullable String terrainmax) {
            mRes.mTerrainmax = terrainmax;
            return this;
        }

        /**
         * Set the {@code terrainspp} value.
         * Can be {@code null}.
         */
        public Builder terrainspp(@Nullable Integer terrainspp) {
            mRes.mTerrainspp = terrainspp;
            return this;
        }

        /**
         * Set the {@code terrainspc} value.
         * Can be {@code null}.
         */
        public Builder terrainspc(@Nullable Integer terrainspc) {
            mRes.mTerrainspc = terrainspc;
            return this;
        }

        /**
         * Set the {@code terrainsec} value.
         * Can be {@code null}.
         */
        public Builder terrainsec(@Nullable Integer terrainsec) {
            mRes.mTerrainsec = terrainsec;
            return this;
        }

        /**
         * Set the {@code maisonsec} value.
         * Can be {@code null}.
         */
        public Builder maisonsec(@Nullable Integer maisonsec) {
            mRes.mMaisonsec = maisonsec;
            return this;
        }

        /**
         * Set the {@code maisonsc} value.
         * Can be {@code null}.
         */
        public Builder maisonsc(@Nullable Integer maisonsc) {
            mRes.mMaisonsc = maisonsc;
            return this;
        }

        /**
         * Set the {@code surfmin} value.
         * Can be {@code null}.
         */
        public Builder surfmin(@Nullable String surfmin) {
            mRes.mSurfmin = surfmin;
            return this;
        }

        /**
         * Set the {@code surfmax} value.
         * Can be {@code null}.
         */
        public Builder surfmax(@Nullable String surfmax) {
            mRes.mSurfmax = surfmax;
            return this;
        }

        /**
         * Set the {@code nbstudios} value.
         * Can be {@code null}.
         */
        public Builder nbstudios(@Nullable Integer nbstudios) {
            mRes.mNbstudios = nbstudios;
            return this;
        }

        /**
         * Set the {@code nbapparts} value.
         * Can be {@code null}.
         */
        public Builder nbapparts(@Nullable Integer nbapparts) {
            mRes.mNbapparts = nbapparts;
            return this;
        }

        /**
         * Set the {@code nbpenthouses} value.
         * Can be {@code null}.
         */
        public Builder nbpenthouses(@Nullable Integer nbpenthouses) {
            mRes.mNbpenthouses = nbpenthouses;
            return this;
        }

        /**
         * Set the {@code nbduplex} value.
         * Can be {@code null}.
         */
        public Builder nbduplex(@Nullable Integer nbduplex) {
            mRes.mNbduplex = nbduplex;
            return this;
        }

        /**
         * Set the {@code nbcommerces} value.
         * Can be {@code null}.
         */
        public Builder nbcommerces(@Nullable Integer nbcommerces) {
            mRes.mNbcommerces = nbcommerces;
            return this;
        }

        /**
         * Set the {@code nbbureaux} value.
         * Can be {@code null}.
         */
        public Builder nbbureaux(@Nullable Integer nbbureaux) {
            mRes.mNbbureaux = nbbureaux;
            return this;
        }

        /**
         * Set the {@code nbterrainsdispo} value.
         * Can be {@code null}.
         */
        public Builder nbterrainsdispo(@Nullable Integer nbterrainsdispo) {
            mRes.mNbterrainsdispo = nbterrainsdispo;
            return this;
        }

        /**
         * Set the {@code maison} value.
         * Can be {@code null}.
         */
        public Builder maison(@Nullable Boolean maison) {
            mRes.mMaison = maison;
            return this;
        }

        /**
         * Set the {@code appart} value.
         * Can be {@code null}.
         */
        public Builder appart(@Nullable Boolean appart) {
            mRes.mAppart = appart;
            return this;
        }

        /**
         * Set the {@code terrain} value.
         * Can be {@code null}.
         */
        public Builder terrain(@Nullable Boolean terrain) {
            mRes.mTerrain = terrain;
            return this;
        }

        /**
         * Set the {@code province} value.
         * Can be {@code null}.
         */
        public Builder province(@Nullable String province) {
            mRes.mProvince = province;
            return this;
        }

        /**
         * Set the {@code idpointcontact} value.
         * Can be {@code null}.
         */
        public Builder idpointcontact(@Nullable Integer idpointcontact) {
            mRes.mIdpointcontact = idpointcontact;
            return this;
        }

        /**
         * Set the {@code nbmedias} value.
         * Can be {@code null}.
         */
        public Builder nbmedias(@Nullable Integer nbmedias) {
            mRes.mNbmedias = nbmedias;
            return this;
        }

        /**
         * Set the {@code nbplansimpl} value.
         * Can be {@code null}.
         */
        public Builder nbplansimpl(@Nullable Integer nbplansimpl) {
            mRes.mNbplansimpl = nbplansimpl;
            return this;
        }

        /**
         * Set the {@code dtdebnouveau} value.
         * Can be {@code null}.
         */
        public Builder dtdebnouveau(@Nullable Date dtdebnouveau) {
            mRes.mDtdebnouveau = dtdebnouveau;
            return this;
        }

        /**
         * Set the {@code dtdebremise} value.
         * Can be {@code null}.
         */
        public Builder dtdebremise(@Nullable Date dtdebremise) {
            mRes.mDtdebremise = dtdebremise;
            return this;
        }

        /**
         * Set the {@code dtfinnouveau} value.
         * Can be {@code null}.
         */
        public Builder dtfinnouveau(@Nullable Date dtfinnouveau) {
            mRes.mDtfinnouveau = dtfinnouveau;
            return this;
        }

        /**
         * Set the {@code dtfinporteouverte} value.
         * Can be {@code null}.
         */
        public Builder dtfinporteouverte(@Nullable Date dtfinporteouverte) {
            mRes.mDtfinporteouverte = dtfinporteouverte;
            return this;
        }

        /**
         * Set the {@code dtfinremise} value.
         * Can be {@code null}.
         */
        public Builder dtfinremise(@Nullable Date dtfinremise) {
            mRes.mDtfinremise = dtfinremise;
            return this;
        }

        /**
         * Set the {@code infoporteouverte} value.
         * Can be {@code null}.
         */
        public Builder infoporteouverte(@Nullable String infoporteouverte) {
            mRes.mInfoporteouverte = infoporteouverte;
            return this;
        }

        /**
         * Set the {@code libelleremise} value.
         * Can be {@code null}.
         */
        public Builder libelleremise(@Nullable String libelleremise) {
            mRes.mLibelleremise = libelleremise;
            return this;
        }

        /**
         * Set the {@code nbtriplex} value.
         * Can be {@code null}.
         */
        public Builder nbtriplex(@Nullable Integer nbtriplex) {
            mRes.mNbtriplex = nbtriplex;
            return this;
        }

        /**
         * Set the {@code nbquadriplex} value.
         * Can be {@code null}.
         */
        public Builder nbquadriplex(@Nullable Integer nbquadriplex) {
            mRes.mNbquadriplex = nbquadriplex;
            return this;
        }

        /**
         * Get a new EnsembleBean built with the given values.
         */
        public EnsembleBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
