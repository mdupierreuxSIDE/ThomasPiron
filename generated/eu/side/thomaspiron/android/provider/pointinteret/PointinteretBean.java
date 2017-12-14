package eu.side.thomaspiron.android.provider.pointinteret;

// @formatter:off
import eu.side.thomaspiron.android.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * point interet
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class PointinteretBean implements PointinteretModel {
    private long mId;
    private Integer mIdinteret;
    private String mLibellefr;
    private String mLibelleen;
    private Integer mIdpays;
    private String mEmail;

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
     * Get the {@code idinteret} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getIdinteret() {
        return mIdinteret;
    }

    /**
     * Set the {@code idinteret} value.
     * Can be {@code null}.
     */
    public void setIdinteret(@Nullable Integer idinteret) {
        mIdinteret = idinteret;
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
     * Get the {@code libelleen} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLibelleen() {
        return mLibelleen;
    }

    /**
     * Set the {@code libelleen} value.
     * Can be {@code null}.
     */
    public void setLibelleen(@Nullable String libelleen) {
        mLibelleen = libelleen;
    }

    /**
     * Get the {@code idpays} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getIdpays() {
        return mIdpays;
    }

    /**
     * Set the {@code idpays} value.
     * Can be {@code null}.
     */
    public void setIdpays(@Nullable Integer idpays) {
        mIdpays = idpays;
    }

    /**
     * Get the {@code email} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getEmail() {
        return mEmail;
    }

    /**
     * Set the {@code email} value.
     * Can be {@code null}.
     */
    public void setEmail(@Nullable String email) {
        mEmail = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointinteretBean bean = (PointinteretBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new PointinteretBean with specified values.
     */
    @NonNull
    public static PointinteretBean newInstance(long id, @Nullable Integer idinteret, @Nullable String libellefr, @Nullable String libelleen, @Nullable Integer idpays, @Nullable String email) {
        PointinteretBean res = new PointinteretBean();
        res.mId = id;
        res.mIdinteret = idinteret;
        res.mLibellefr = libellefr;
        res.mLibelleen = libelleen;
        res.mIdpays = idpays;
        res.mEmail = email;
        return res;
    }

    /**
     * Instantiate a new PointinteretBean with all the values copied from the given model.
     */
    @NonNull
    public static PointinteretBean copy(@NonNull PointinteretModel from) {
        PointinteretBean res = new PointinteretBean();
        res.mId = from.getId();
        res.mIdinteret = from.getIdinteret();
        res.mLibellefr = from.getLibellefr();
        res.mLibelleen = from.getLibelleen();
        res.mIdpays = from.getIdpays();
        res.mEmail = from.getEmail();
        return res;
    }

    public static class Builder {
        private PointinteretBean mRes = new PointinteretBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Set the {@code idinteret} value.
         * Can be {@code null}.
         */
        public Builder idinteret(@Nullable Integer idinteret) {
            mRes.mIdinteret = idinteret;
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
         * Set the {@code libelleen} value.
         * Can be {@code null}.
         */
        public Builder libelleen(@Nullable String libelleen) {
            mRes.mLibelleen = libelleen;
            return this;
        }

        /**
         * Set the {@code idpays} value.
         * Can be {@code null}.
         */
        public Builder idpays(@Nullable Integer idpays) {
            mRes.mIdpays = idpays;
            return this;
        }

        /**
         * Set the {@code email} value.
         * Can be {@code null}.
         */
        public Builder email(@Nullable String email) {
            mRes.mEmail = email;
            return this;
        }

        /**
         * Get a new PointinteretBean built with the given values.
         */
        public PointinteretBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
