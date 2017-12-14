package eu.side.thomaspiron.android.provider.lots;

// @formatter:off
import eu.side.thomaspiron.android.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * lot
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public interface LotsModel extends BaseModel {

    /**
     * Primary key.
     */
    long getId();

    /**
     * Get the {@code lotdesc} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLotdesc();

    /**
     * Get the {@code cptepl} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCptepl();

    /**
     * Get the {@code jardin} value.
     * Can be {@code null}.
     */
    @Nullable
    String getJardin();

    /**
     * Get the {@code balcon} value.
     * Can be {@code null}.
     */
    @Nullable
    String getBalcon();

    /**
     * Get the {@code chambres} value.
     * Can be {@code null}.
     */
    @Nullable
    String getChambres();

    /**
     * Get the {@code facadesnbr} value.
     * Can be {@code null}.
     */
    @Nullable
    String getFacadesnbr();

    /**
     * Get the {@code orientation} value.
     * Can be {@code null}.
     */
    @Nullable
    String getOrientation();

    /**
     * Get the {@code statutlot} value.
     * Can be {@code null}.
     */
    @Nullable
    String getStatutlot();

    /**
     * Get the {@code surfter} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSurfter();

    /**
     * Get the {@code surfhab} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSurfhab();

    /**
     * Get the {@code codeetage} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCodeetage();

    /**
     * Get the {@code libellefr} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLibellefr();

    /**
     * Get the {@code ensecode} value.
     * Can be {@code null}.
     */
    @Nullable
    String getEnsecode();

    /**
     * Get the {@code socicode} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSocicode();

    /**
     * Get the {@code pebclasseenergetique} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPebclasseenergetique();

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
}
