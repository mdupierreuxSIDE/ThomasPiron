package eu.side.thomaspiron.android.provider.pointinteret;

// @formatter:off
import eu.side.thomaspiron.android.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * point interet
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface PointinteretModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code idinteret} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getIdinteret();

    /**
     * Get the {@code libellefr} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLibellefr();

    /**
     * Get the {@code libelleen} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLibelleen();

    /**
     * Get the {@code idpays} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getIdpays();

    /**
     * Get the {@code email} value.
     * Can be {@code null}.
     */
    @Nullable
    String getEmail();
}
