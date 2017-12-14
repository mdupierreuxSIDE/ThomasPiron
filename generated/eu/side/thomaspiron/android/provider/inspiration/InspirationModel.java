package eu.side.thomaspiron.android.provider.inspiration;

// @formatter:off
import eu.side.thomaspiron.android.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * inspiration
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface InspirationModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code date} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDate();

    /**
     * Get the {@code numero} value.
     * Can be {@code null}.
     */
    @Nullable
    String getNumero();

    /**
     * Get the {@code numerosimplifie} value.
     * Can be {@code null}.
     */
    @Nullable
    String getNumerosimplifie();

    /**
     * Get the {@code client} value.
     * Can be {@code null}.
     */
    @Nullable
    String getClient();

    /**
     * Get the {@code prix} value.
     * Can be {@code null}.
     */
    @Nullable
    Double getPrix();

    /**
     * Get the {@code topographie} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTopographie();

    /**
     * Get the {@code garage} value.
     * Can be {@code null}.
     */
    @Nullable
    String getGarage();

    /**
     * Get the {@code carport} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCarport();

    /**
     * Get the {@code cave} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCave();

    /**
     * Get the {@code pro} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPro();

    /**
     * Get the {@code parement} value.
     * Can be {@code null}.
     */
    @Nullable
    String getParement();

    /**
     * Get the {@code toiture1} value.
     * Can be {@code null}.
     */
    @Nullable
    String getToiture1();

    /**
     * Get the {@code toiture2} value.
     * Can be {@code null}.
     */
    @Nullable
    String getToiture2();

    /**
     * Get the {@code chassis} value.
     * Can be {@code null}.
     */
    @Nullable
    String getChassis();

    /**
     * Get the {@code invest} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getInvest();

    /**
     * Get the {@code chambrerez} value.
     * Can be {@code null}.
     */
    @Nullable
    String getChambrerez();

    /**
     * Get the {@code idapmodele} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getIdapmodele();
}
