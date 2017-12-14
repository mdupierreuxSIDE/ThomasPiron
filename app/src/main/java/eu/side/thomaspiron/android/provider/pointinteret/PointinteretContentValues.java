package eu.side.thomaspiron.android.provider.pointinteret;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import eu.side.thomaspiron.android.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code pointinteret} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class PointinteretContentValues extends AbstractContentValues<PointinteretContentValues> {
    @Override
    protected Uri baseUri() {
        return PointinteretColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PointinteretSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PointinteretSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public PointinteretContentValues putIdinteret(@Nullable Integer value) {
        mContentValues.put(PointinteretColumns.IDINTERET, value);
        return this;
    }

    public PointinteretContentValues putIdinteretNull() {
        mContentValues.putNull(PointinteretColumns.IDINTERET);
        return this;
    }

    public PointinteretContentValues putLibellefr(@Nullable String value) {
        mContentValues.put(PointinteretColumns.LIBELLEFR, value);
        return this;
    }

    public PointinteretContentValues putLibellefrNull() {
        mContentValues.putNull(PointinteretColumns.LIBELLEFR);
        return this;
    }

    public PointinteretContentValues putLibelleen(@Nullable String value) {
        mContentValues.put(PointinteretColumns.LIBELLEEN, value);
        return this;
    }

    public PointinteretContentValues putLibelleenNull() {
        mContentValues.putNull(PointinteretColumns.LIBELLEEN);
        return this;
    }

    public PointinteretContentValues putIdpays(@Nullable Integer value) {
        mContentValues.put(PointinteretColumns.IDPAYS, value);
        return this;
    }

    public PointinteretContentValues putIdpaysNull() {
        mContentValues.putNull(PointinteretColumns.IDPAYS);
        return this;
    }

    public PointinteretContentValues putEmail(@Nullable String value) {
        mContentValues.put(PointinteretColumns.EMAIL, value);
        return this;
    }

    public PointinteretContentValues putEmailNull() {
        mContentValues.putNull(PointinteretColumns.EMAIL);
        return this;
    }
}
