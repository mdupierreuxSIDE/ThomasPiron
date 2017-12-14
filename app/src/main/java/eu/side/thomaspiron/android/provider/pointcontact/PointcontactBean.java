package eu.side.thomaspiron.android.provider.pointcontact;

// @formatter:off
import eu.side.thomaspiron.android.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * point contact
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class PointcontactBean implements PointcontactModel {
    private long mId;
    private Integer mIdpointcontact;
    private String mTypepointcontact;
    private String mTitre;
    private String mAdresse;
    private String mPostloc;
    private String mPostcode;
    private String mTel;
    private String mPermanencefr;
    private Double mLatitude;
    private Double mLongitude;
    private Integer mNbmedias;

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
     * Get the {@code typepointcontact} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTypepointcontact() {
        return mTypepointcontact;
    }

    /**
     * Set the {@code typepointcontact} value.
     * Can be {@code null}.
     */
    public void setTypepointcontact(@Nullable String typepointcontact) {
        mTypepointcontact = typepointcontact;
    }

    /**
     * Get the {@code titre} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTitre() {
        return mTitre;
    }

    /**
     * Set the {@code titre} value.
     * Can be {@code null}.
     */
    public void setTitre(@Nullable String titre) {
        mTitre = titre;
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
     * Get the {@code tel} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTel() {
        return mTel;
    }

    /**
     * Set the {@code tel} value.
     * Can be {@code null}.
     */
    public void setTel(@Nullable String tel) {
        mTel = tel;
    }

    /**
     * Get the {@code permanencefr} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPermanencefr() {
        return mPermanencefr;
    }

    /**
     * Set the {@code permanencefr} value.
     * Can be {@code null}.
     */
    public void setPermanencefr(@Nullable String permanencefr) {
        mPermanencefr = permanencefr;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointcontactBean bean = (PointcontactBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new PointcontactBean with specified values.
     */
    @NonNull
    public static PointcontactBean newInstance(long id, @Nullable Integer idpointcontact, @Nullable String typepointcontact, @Nullable String titre, @Nullable String adresse, @Nullable String postloc, @Nullable String postcode, @Nullable String tel, @Nullable String permanencefr, @Nullable Double latitude, @Nullable Double longitude, @Nullable Integer nbmedias) {
        PointcontactBean res = new PointcontactBean();
        res.mId = id;
        res.mIdpointcontact = idpointcontact;
        res.mTypepointcontact = typepointcontact;
        res.mTitre = titre;
        res.mAdresse = adresse;
        res.mPostloc = postloc;
        res.mPostcode = postcode;
        res.mTel = tel;
        res.mPermanencefr = permanencefr;
        res.mLatitude = latitude;
        res.mLongitude = longitude;
        res.mNbmedias = nbmedias;
        return res;
    }

    /**
     * Instantiate a new PointcontactBean with all the values copied from the given model.
     */
    @NonNull
    public static PointcontactBean copy(@NonNull PointcontactModel from) {
        PointcontactBean res = new PointcontactBean();
        res.mId = from.getId();
        res.mIdpointcontact = from.getIdpointcontact();
        res.mTypepointcontact = from.getTypepointcontact();
        res.mTitre = from.getTitre();
        res.mAdresse = from.getAdresse();
        res.mPostloc = from.getPostloc();
        res.mPostcode = from.getPostcode();
        res.mTel = from.getTel();
        res.mPermanencefr = from.getPermanencefr();
        res.mLatitude = from.getLatitude();
        res.mLongitude = from.getLongitude();
        res.mNbmedias = from.getNbmedias();
        return res;
    }

    public static class Builder {
        private PointcontactBean mRes = new PointcontactBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
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
         * Set the {@code typepointcontact} value.
         * Can be {@code null}.
         */
        public Builder typepointcontact(@Nullable String typepointcontact) {
            mRes.mTypepointcontact = typepointcontact;
            return this;
        }

        /**
         * Set the {@code titre} value.
         * Can be {@code null}.
         */
        public Builder titre(@Nullable String titre) {
            mRes.mTitre = titre;
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
         * Set the {@code tel} value.
         * Can be {@code null}.
         */
        public Builder tel(@Nullable String tel) {
            mRes.mTel = tel;
            return this;
        }

        /**
         * Set the {@code permanencefr} value.
         * Can be {@code null}.
         */
        public Builder permanencefr(@Nullable String permanencefr) {
            mRes.mPermanencefr = permanencefr;
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
         * Set the {@code nbmedias} value.
         * Can be {@code null}.
         */
        public Builder nbmedias(@Nullable Integer nbmedias) {
            mRes.mNbmedias = nbmedias;
            return this;
        }

        /**
         * Get a new PointcontactBean built with the given values.
         */
        public PointcontactBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
