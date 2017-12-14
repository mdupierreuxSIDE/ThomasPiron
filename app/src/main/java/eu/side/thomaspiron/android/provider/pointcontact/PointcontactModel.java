package eu.side.thomaspiron.android.provider.pointcontact;

// @formatter:off
import eu.side.thomaspiron.android.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * point contact
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface PointcontactModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code idpointcontact} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getIdpointcontact();

    /**
     * Get the {@code typepointcontact} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTypepointcontact();

    /**
     * Get the {@code titre} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTitre();

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
     * Get the {@code tel} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTel();

    /**
     * Get the {@code permanencefr} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPermanencefr();

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
     * Get the {@code nbmedias} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getNbmedias();
}
