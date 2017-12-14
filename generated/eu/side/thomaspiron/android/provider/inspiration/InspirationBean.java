package eu.side.thomaspiron.android.provider.inspiration;

// @formatter:off
import eu.side.thomaspiron.android.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * inspiration
 */
@SuppressWarnings({"WeakerAccess", "unused", "ConstantConditions"})
public class InspirationBean implements InspirationModel {
    private long mId;
    private String mDate;
    private String mNumero;
    private String mNumerosimplifie;
    private String mClient;
    private Double mPrix;
    private String mTopographie;
    private String mGarage;
    private String mCarport;
    private String mCave;
    private String mPro;
    private String mParement;
    private String mToiture1;
    private String mToiture2;
    private String mChassis;
    private Integer mInvest;
    private String mChambrerez;
    private Integer mIdapmodele;

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
     * Get the {@code date} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDate() {
        return mDate;
    }

    /**
     * Set the {@code date} value.
     * Can be {@code null}.
     */
    public void setDate(@Nullable String date) {
        mDate = date;
    }

    /**
     * Get the {@code numero} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getNumero() {
        return mNumero;
    }

    /**
     * Set the {@code numero} value.
     * Can be {@code null}.
     */
    public void setNumero(@Nullable String numero) {
        mNumero = numero;
    }

    /**
     * Get the {@code numerosimplifie} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getNumerosimplifie() {
        return mNumerosimplifie;
    }

    /**
     * Set the {@code numerosimplifie} value.
     * Can be {@code null}.
     */
    public void setNumerosimplifie(@Nullable String numerosimplifie) {
        mNumerosimplifie = numerosimplifie;
    }

    /**
     * Get the {@code client} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getClient() {
        return mClient;
    }

    /**
     * Set the {@code client} value.
     * Can be {@code null}.
     */
    public void setClient(@Nullable String client) {
        mClient = client;
    }

    /**
     * Get the {@code prix} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Double getPrix() {
        return mPrix;
    }

    /**
     * Set the {@code prix} value.
     * Can be {@code null}.
     */
    public void setPrix(@Nullable Double prix) {
        mPrix = prix;
    }

    /**
     * Get the {@code topographie} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTopographie() {
        return mTopographie;
    }

    /**
     * Set the {@code topographie} value.
     * Can be {@code null}.
     */
    public void setTopographie(@Nullable String topographie) {
        mTopographie = topographie;
    }

    /**
     * Get the {@code garage} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getGarage() {
        return mGarage;
    }

    /**
     * Set the {@code garage} value.
     * Can be {@code null}.
     */
    public void setGarage(@Nullable String garage) {
        mGarage = garage;
    }

    /**
     * Get the {@code carport} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCarport() {
        return mCarport;
    }

    /**
     * Set the {@code carport} value.
     * Can be {@code null}.
     */
    public void setCarport(@Nullable String carport) {
        mCarport = carport;
    }

    /**
     * Get the {@code cave} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCave() {
        return mCave;
    }

    /**
     * Set the {@code cave} value.
     * Can be {@code null}.
     */
    public void setCave(@Nullable String cave) {
        mCave = cave;
    }

    /**
     * Get the {@code pro} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPro() {
        return mPro;
    }

    /**
     * Set the {@code pro} value.
     * Can be {@code null}.
     */
    public void setPro(@Nullable String pro) {
        mPro = pro;
    }

    /**
     * Get the {@code parement} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getParement() {
        return mParement;
    }

    /**
     * Set the {@code parement} value.
     * Can be {@code null}.
     */
    public void setParement(@Nullable String parement) {
        mParement = parement;
    }

    /**
     * Get the {@code toiture1} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getToiture1() {
        return mToiture1;
    }

    /**
     * Set the {@code toiture1} value.
     * Can be {@code null}.
     */
    public void setToiture1(@Nullable String toiture1) {
        mToiture1 = toiture1;
    }

    /**
     * Get the {@code toiture2} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getToiture2() {
        return mToiture2;
    }

    /**
     * Set the {@code toiture2} value.
     * Can be {@code null}.
     */
    public void setToiture2(@Nullable String toiture2) {
        mToiture2 = toiture2;
    }

    /**
     * Get the {@code chassis} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getChassis() {
        return mChassis;
    }

    /**
     * Set the {@code chassis} value.
     * Can be {@code null}.
     */
    public void setChassis(@Nullable String chassis) {
        mChassis = chassis;
    }

    /**
     * Get the {@code invest} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getInvest() {
        return mInvest;
    }

    /**
     * Set the {@code invest} value.
     * Can be {@code null}.
     */
    public void setInvest(@Nullable Integer invest) {
        mInvest = invest;
    }

    /**
     * Get the {@code chambrerez} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getChambrerez() {
        return mChambrerez;
    }

    /**
     * Set the {@code chambrerez} value.
     * Can be {@code null}.
     */
    public void setChambrerez(@Nullable String chambrerez) {
        mChambrerez = chambrerez;
    }

    /**
     * Get the {@code idapmodele} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getIdapmodele() {
        return mIdapmodele;
    }

    /**
     * Set the {@code idapmodele} value.
     * Can be {@code null}.
     */
    public void setIdapmodele(@Nullable Integer idapmodele) {
        mIdapmodele = idapmodele;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InspirationBean bean = (InspirationBean) o;
        return mId == bean.mId;
    }

    @Override
    public int hashCode() {
        return (int) (mId ^ (mId >>> 32));
    }

    /**
     * Instantiate a new InspirationBean with specified values.
     */
    @NonNull
    public static InspirationBean newInstance(long id, @Nullable String date, @Nullable String numero, @Nullable String numerosimplifie, @Nullable String client, @Nullable Double prix, @Nullable String topographie, @Nullable String garage, @Nullable String carport, @Nullable String cave, @Nullable String pro, @Nullable String parement, @Nullable String toiture1, @Nullable String toiture2, @Nullable String chassis, @Nullable Integer invest, @Nullable String chambrerez, @Nullable Integer idapmodele) {
        InspirationBean res = new InspirationBean();
        res.mId = id;
        res.mDate = date;
        res.mNumero = numero;
        res.mNumerosimplifie = numerosimplifie;
        res.mClient = client;
        res.mPrix = prix;
        res.mTopographie = topographie;
        res.mGarage = garage;
        res.mCarport = carport;
        res.mCave = cave;
        res.mPro = pro;
        res.mParement = parement;
        res.mToiture1 = toiture1;
        res.mToiture2 = toiture2;
        res.mChassis = chassis;
        res.mInvest = invest;
        res.mChambrerez = chambrerez;
        res.mIdapmodele = idapmodele;
        return res;
    }

    /**
     * Instantiate a new InspirationBean with all the values copied from the given model.
     */
    @NonNull
    public static InspirationBean copy(@NonNull InspirationModel from) {
        InspirationBean res = new InspirationBean();
        res.mId = from.getId();
        res.mDate = from.getDate();
        res.mNumero = from.getNumero();
        res.mNumerosimplifie = from.getNumerosimplifie();
        res.mClient = from.getClient();
        res.mPrix = from.getPrix();
        res.mTopographie = from.getTopographie();
        res.mGarage = from.getGarage();
        res.mCarport = from.getCarport();
        res.mCave = from.getCave();
        res.mPro = from.getPro();
        res.mParement = from.getParement();
        res.mToiture1 = from.getToiture1();
        res.mToiture2 = from.getToiture2();
        res.mChassis = from.getChassis();
        res.mInvest = from.getInvest();
        res.mChambrerez = from.getChambrerez();
        res.mIdapmodele = from.getIdapmodele();
        return res;
    }

    public static class Builder {
        private InspirationBean mRes = new InspirationBean();

        /**
         * Primary key.
         */
        public Builder id(long id) {
            mRes.mId = id;
            return this;
        }

        /**
         * Set the {@code date} value.
         * Can be {@code null}.
         */
        public Builder date(@Nullable String date) {
            mRes.mDate = date;
            return this;
        }

        /**
         * Set the {@code numero} value.
         * Can be {@code null}.
         */
        public Builder numero(@Nullable String numero) {
            mRes.mNumero = numero;
            return this;
        }

        /**
         * Set the {@code numerosimplifie} value.
         * Can be {@code null}.
         */
        public Builder numerosimplifie(@Nullable String numerosimplifie) {
            mRes.mNumerosimplifie = numerosimplifie;
            return this;
        }

        /**
         * Set the {@code client} value.
         * Can be {@code null}.
         */
        public Builder client(@Nullable String client) {
            mRes.mClient = client;
            return this;
        }

        /**
         * Set the {@code prix} value.
         * Can be {@code null}.
         */
        public Builder prix(@Nullable Double prix) {
            mRes.mPrix = prix;
            return this;
        }

        /**
         * Set the {@code topographie} value.
         * Can be {@code null}.
         */
        public Builder topographie(@Nullable String topographie) {
            mRes.mTopographie = topographie;
            return this;
        }

        /**
         * Set the {@code garage} value.
         * Can be {@code null}.
         */
        public Builder garage(@Nullable String garage) {
            mRes.mGarage = garage;
            return this;
        }

        /**
         * Set the {@code carport} value.
         * Can be {@code null}.
         */
        public Builder carport(@Nullable String carport) {
            mRes.mCarport = carport;
            return this;
        }

        /**
         * Set the {@code cave} value.
         * Can be {@code null}.
         */
        public Builder cave(@Nullable String cave) {
            mRes.mCave = cave;
            return this;
        }

        /**
         * Set the {@code pro} value.
         * Can be {@code null}.
         */
        public Builder pro(@Nullable String pro) {
            mRes.mPro = pro;
            return this;
        }

        /**
         * Set the {@code parement} value.
         * Can be {@code null}.
         */
        public Builder parement(@Nullable String parement) {
            mRes.mParement = parement;
            return this;
        }

        /**
         * Set the {@code toiture1} value.
         * Can be {@code null}.
         */
        public Builder toiture1(@Nullable String toiture1) {
            mRes.mToiture1 = toiture1;
            return this;
        }

        /**
         * Set the {@code toiture2} value.
         * Can be {@code null}.
         */
        public Builder toiture2(@Nullable String toiture2) {
            mRes.mToiture2 = toiture2;
            return this;
        }

        /**
         * Set the {@code chassis} value.
         * Can be {@code null}.
         */
        public Builder chassis(@Nullable String chassis) {
            mRes.mChassis = chassis;
            return this;
        }

        /**
         * Set the {@code invest} value.
         * Can be {@code null}.
         */
        public Builder invest(@Nullable Integer invest) {
            mRes.mInvest = invest;
            return this;
        }

        /**
         * Set the {@code chambrerez} value.
         * Can be {@code null}.
         */
        public Builder chambrerez(@Nullable String chambrerez) {
            mRes.mChambrerez = chambrerez;
            return this;
        }

        /**
         * Set the {@code idapmodele} value.
         * Can be {@code null}.
         */
        public Builder idapmodele(@Nullable Integer idapmodele) {
            mRes.mIdapmodele = idapmodele;
            return this;
        }

        /**
         * Get a new InspirationBean built with the given values.
         */
        public InspirationBean build() {
            return mRes;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }
}
