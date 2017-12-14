package eu.side.thomaspiron.android.provider.pointcontact;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import eu.side.thomaspiron.android.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code pointcontact} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class PointcontactCursor extends AbstractCursor implements PointcontactModel {
    public PointcontactCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(PointcontactColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code idpointcontact} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getIdpointcontact() {
        Integer res = getIntegerOrNull(PointcontactColumns.IDPOINTCONTACT);
        return res;
    }

    /**
     * Get the {@code typepointcontact} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTypepointcontact() {
        String res = getStringOrNull(PointcontactColumns.TYPEPOINTCONTACT);
        return res;
    }

    /**
     * Get the {@code titre} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTitre() {
        String res = getStringOrNull(PointcontactColumns.TITRE);
        return res;
    }

    /**
     * Get the {@code adresse} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getAdresse() {
        String res = getStringOrNull(PointcontactColumns.ADRESSE);
        return res;
    }

    /**
     * Get the {@code postloc} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPostloc() {
        String res = getStringOrNull(PointcontactColumns.POSTLOC);
        return res;
    }

    /**
     * Get the {@code postcode} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPostcode() {
        String res = getStringOrNull(PointcontactColumns.POSTCODE);
        return res;
    }

    /**
     * Get the {@code tel} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTel() {
        String res = getStringOrNull(PointcontactColumns.TEL);
        return res;
    }

    /**
     * Get the {@code permanencefr} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPermanencefr() {
        String res = getStringOrNull(PointcontactColumns.PERMANENCEFR);
        return res;
    }

    /**
     * Get the {@code latitude} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Double getLatitude() {
        Double res = getDoubleOrNull(PointcontactColumns.LATITUDE);
        return res;
    }

    /**
     * Get the {@code longitude} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Double getLongitude() {
        Double res = getDoubleOrNull(PointcontactColumns.LONGITUDE);
        return res;
    }

    /**
     * Get the {@code nbmedias} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbmedias() {
        Integer res = getIntegerOrNull(PointcontactColumns.NBMEDIAS);
        return res;
    }
}
