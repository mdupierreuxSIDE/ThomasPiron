package eu.side.thomaspiron.android.provider.pointinteret;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import eu.side.thomaspiron.android.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code pointinteret} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class PointinteretCursor extends AbstractCursor implements PointinteretModel {
    public PointinteretCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(PointinteretColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code idinteret} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getIdinteret() {
        Integer res = getIntegerOrNull(PointinteretColumns.IDINTERET);
        return res;
    }

    /**
     * Get the {@code libellefr} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLibellefr() {
        String res = getStringOrNull(PointinteretColumns.LIBELLEFR);
        return res;
    }

    /**
     * Get the {@code libelleen} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLibelleen() {
        String res = getStringOrNull(PointinteretColumns.LIBELLEEN);
        return res;
    }

    /**
     * Get the {@code idpays} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getIdpays() {
        Integer res = getIntegerOrNull(PointinteretColumns.IDPAYS);
        return res;
    }

    /**
     * Get the {@code email} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getEmail() {
        String res = getStringOrNull(PointinteretColumns.EMAIL);
        return res;
    }
}
