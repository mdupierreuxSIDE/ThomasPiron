package eu.side.thomaspiron.android.provider.lots;

// @formatter:off
import eu.side.thomaspiron.android.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * lot
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class LotsBean implements LotsModel {
    private long mId;
    private String mLotdesc;
    private String mCptepl;
    private String mJardin;
    private String mBalcon;
    private String mChambres;
    private String mFacadesnbr;
    private String mOrientation;
    private String mStatutlot;
    private String mSurfter;
    private String mSurfhab;
    private String mCodeetage;
    private String mLibellefr;
    private String mEnsecode;
    private String mSocicode;
    private String mPebclasseenergetique;
    private Integer mNbmedias;
    private Integer mNbplansimpl;

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
     * Get the {@code lotdesc} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLotdesc() {
        return mLotdesc;
    }

    /**
     * Set the {@code lotdesc} value.
     * Can be {@code null}.
     */
    public void setLotdesc(@Nullable String lotdesc) {
        mLotdesc = lotdesc;
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
     * Get the {@code jardin} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getJardin() {
        return mJardin;
    }

    /**
     * Set the {@code jardin} value.
     * Can be {@code null}.
     */
    public void setJardin(@Nullable String jardin) {
        mJardin = jardin;
    }

    /**
     * Get the {@code balcon} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getBalcon() {
        return mBalcon;
    }

    /**
     * Set the {@code balcon} value.
     * Can be {@code null}.
     */
    public void setBalcon(@Nullable String balcon) {
        mBalcon = balcon;
    }

    /**
     * Get the {@code chambres} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getChambres() {
        return mChambres;
    }

    /**
     * Set the {@code chambres} value.
     * Can be {@code null}.
     */
    public void setChambres(@Nullable String chambres) {
        mChambres = chambres;
    }

    /**
     * Get the {@code facadesnbr} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFacadesnbr() {
        return mFacadesnbr;
    }

    /**
     * Set the {@code facadesnbr} value.
     * Can be {@code null}.
     */
    public void setFacadesnbr(@Nullable String facadesnbr) {
        mFacadesnbr = facadesnbr;
    }

    /**
     * Get the {@code orientation} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getOrientation() {
        return mOrientation;
    }

    /**
     * Set the {@code orientation} value.
     * Can be {@code null}.
     */
    public void setOrientation(@Nullable String orientation) {
        mOrientation = orientation;
    }

    /**
     * Get the {@code statutlot} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getStatutlot() {
        return mStatutlot;
    }

    /**
     * Set the {@code statutlot} value.
     * Can be {@code null}.
     */
    public void setStatutlot(@Nullable String statutlot) {
        mStatutlot = statutlot;
    }

    /**
     * Get the {@code surfter} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSurfter() {
        return mSurfter;
    }

    /**
     * Set the {@code surfter} value.
     * Can be {@code null}.
     */
    public void setSurfter(@Nullable String surfter) {
        mSurfter = surfter;
    }

    /**
     * Get the {@code surfhab} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSurfhab() {
        return mSurfhab;
    }

    /**
     * Set the {@code surfhab} value.
     * Can be {@code null}.
     */
    public void setSurfhab(@Nullable String surfhab) {
        mSurfhab = surfhab;
    }

    /**
     * Get the {@code codeetage} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCodeetage() {
        return mCodeetage;
    }

    /**
     * Set the {@code codeetage} value.
     * Can be {@code null}.
     */
    public void setCodeetage(@Nullable String codeetage) {
        mCodeetage = codeetage;
    }

    /**
     * Get the {@code libellefr} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLibellefr() {
        return mLibellefr;
    }

    /**
     * Set the {@code libellefr} value.
     * Can be {@code null}.
     */
    public void setLibellefr(@Nullable String libellefr) {
        mLibellefr = libellefr;
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
     * Get the {@code pebclasseenergetique} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPebclasseenergetique() {
        return mPebclasseenergetique;
    }

    /**
     * Set the {@code pebclasseenergetique} value.
     * Can be {@code null}.
     */
    public void setPebclasseenergetique(@Nullable String pebclasseenergetique) {
        mPebclasseenergetique = pebclasseenergetique;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotsBean bean = (LotsBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new LotsBean with specified values.
     */
    @NonNull
    public static LotsBean newInstance(long id, @Nullable String lotdesc, @Nullable String cptepl, @Nullable String jardin, @Nullable String balcon, @Nullable String chambres, @Nullable String facadesnbr, @Nullable String orientation, @Nullable String statutlot, @Nullable String surfter, @Nullable String surfhab, @Nullable String codeetage, @Nullable String libellefr, @Nullable String ensecode, @Nullable String socicode, @Nullable String pebclasseenergetique, @Nullable Integer nbmedias, @Nullable Integer nbplansimpl) {
        LotsBean res = new LotsBean();
        res.mId = id;
        res.mLotdesc = lotdesc;
        res.mCptepl = cptepl;
        res.mJardin = jardin;
        res.mBalcon = balcon;
        res.mChambres = chambres;
        res.mFacadesnbr = facadesnbr;
        res.mOrientation = orientation;
        res.mStatutlot = statutlot;
        res.mSurfter = surfter;
        res.mSurfhab = surfhab;
        res.mCodeetage = codeetage;
        res.mLibellefr = libellefr;
        res.mEnsecode = ensecode;
        res.mSocicode = socicode;
        res.mPebclasseenergetique = pebclasseenergetique;
        res.mNbmedias = nbmedias;
        res.mNbplansimpl = nbplansimpl;
        return res;
    }

    /**
     * Instantiate a new LotsBean with all the values copied from the given model.
     */
    @NonNull
    public static LotsBean copy(@NonNull LotsModel from) {
        LotsBean res = new LotsBean();
        res.mId = from.getId();
        res.mLotdesc = from.getLotdesc();
        res.mCptepl = from.getCptepl();
        res.mJardin = from.getJardin();
        res.mBalcon = from.getBalcon();
        res.mChambres = from.getChambres();
        res.mFacadesnbr = from.getFacadesnbr();
        res.mOrientation = from.getOrientation();
        res.mStatutlot = from.getStatutlot();
        res.mSurfter = from.getSurfter();
        res.mSurfhab = from.getSurfhab();
        res.mCodeetage = from.getCodeetage();
        res.mLibellefr = from.getLibellefr();
        res.mEnsecode = from.getEnsecode();
        res.mSocicode = from.getSocicode();
        res.mPebclasseenergetique = from.getPebclasseenergetique();
        res.mNbmedias = from.getNbmedias();
        res.mNbplansimpl = from.getNbplansimpl();
        return res;
    }

    public static class Builder {
        private LotsBean mRes = new LotsBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Set the {@code lotdesc} value.
         * Can be {@code null}.
         */
        public Builder lotdesc(@Nullable String lotdesc) {
            mRes.mLotdesc = lotdesc;
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
         * Set the {@code jardin} value.
         * Can be {@code null}.
         */
        public Builder jardin(@Nullable String jardin) {
            mRes.mJardin = jardin;
            return this;
        }

        /**
         * Set the {@code balcon} value.
         * Can be {@code null}.
         */
        public Builder balcon(@Nullable String balcon) {
            mRes.mBalcon = balcon;
            return this;
        }

        /**
         * Set the {@code chambres} value.
         * Can be {@code null}.
         */
        public Builder chambres(@Nullable String chambres) {
            mRes.mChambres = chambres;
            return this;
        }

        /**
         * Set the {@code facadesnbr} value.
         * Can be {@code null}.
         */
        public Builder facadesnbr(@Nullable String facadesnbr) {
            mRes.mFacadesnbr = facadesnbr;
            return this;
        }

        /**
         * Set the {@code orientation} value.
         * Can be {@code null}.
         */
        public Builder orientation(@Nullable String orientation) {
            mRes.mOrientation = orientation;
            return this;
        }

        /**
         * Set the {@code statutlot} value.
         * Can be {@code null}.
         */
        public Builder statutlot(@Nullable String statutlot) {
            mRes.mStatutlot = statutlot;
            return this;
        }

        /**
         * Set the {@code surfter} value.
         * Can be {@code null}.
         */
        public Builder surfter(@Nullable String surfter) {
            mRes.mSurfter = surfter;
            return this;
        }

        /**
         * Set the {@code surfhab} value.
         * Can be {@code null}.
         */
        public Builder surfhab(@Nullable String surfhab) {
            mRes.mSurfhab = surfhab;
            return this;
        }

        /**
         * Set the {@code codeetage} value.
         * Can be {@code null}.
         */
        public Builder codeetage(@Nullable String codeetage) {
            mRes.mCodeetage = codeetage;
            return this;
        }

        /**
         * Set the {@code libellefr} value.
         * Can be {@code null}.
         */
        public Builder libellefr(@Nullable String libellefr) {
            mRes.mLibellefr = libellefr;
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
         * Set the {@code socicode} value.
         * Can be {@code null}.
         */
        public Builder socicode(@Nullable String socicode) {
            mRes.mSocicode = socicode;
            return this;
        }

        /**
         * Set the {@code pebclasseenergetique} value.
         * Can be {@code null}.
         */
        public Builder pebclasseenergetique(@Nullable String pebclasseenergetique) {
            mRes.mPebclasseenergetique = pebclasseenergetique;
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
         * Get a new LotsBean built with the given values.
         */
        public LotsBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
