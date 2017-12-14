package eu.side.thomaspiron.android.provider.pointinteret;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

import eu.side.thomaspiron.android.provider.base.AbstractSelection;

/**
 * Selection for the {@code pointinteret} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class PointinteretSelection extends AbstractSelection<PointinteretSelection> {
    @Override
    protected Uri baseUri() {
        return PointinteretColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PointinteretCursor} object, which is positioned before the first entry, or null.
     */
    public PointinteretCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PointinteretCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public PointinteretCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PointinteretCursor} object, which is positioned before the first entry, or null.
     */
    public PointinteretCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PointinteretCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public PointinteretCursor query(Context context) {
        return query(context, null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public CursorLoader getCursorLoader(Context context, String[] projection) {
        return new CursorLoader(context, uri(), projection, sel(), args(), order()) {
            @Override
            public Cursor loadInBackground() {
                return new PointinteretCursor(super.loadInBackground());
            }
        };
    }


    public PointinteretSelection id(long... value) {
        addEquals("pointinteret." + PointinteretColumns._ID, toObjectArray(value));
        return this;
    }

    public PointinteretSelection idNot(long... value) {
        addNotEquals("pointinteret." + PointinteretColumns._ID, toObjectArray(value));
        return this;
    }

    public PointinteretSelection orderById(boolean desc) {
        orderBy("pointinteret." + PointinteretColumns._ID, desc);
        return this;
    }

    public PointinteretSelection orderById() {
        return orderById(false);
    }

    public PointinteretSelection idinteret(Integer... value) {
        addEquals(PointinteretColumns.IDINTERET, value);
        return this;
    }

    public PointinteretSelection idinteretNot(Integer... value) {
        addNotEquals(PointinteretColumns.IDINTERET, value);
        return this;
    }

    public PointinteretSelection idinteretGt(int value) {
        addGreaterThan(PointinteretColumns.IDINTERET, value);
        return this;
    }

    public PointinteretSelection idinteretGtEq(int value) {
        addGreaterThanOrEquals(PointinteretColumns.IDINTERET, value);
        return this;
    }

    public PointinteretSelection idinteretLt(int value) {
        addLessThan(PointinteretColumns.IDINTERET, value);
        return this;
    }

    public PointinteretSelection idinteretLtEq(int value) {
        addLessThanOrEquals(PointinteretColumns.IDINTERET, value);
        return this;
    }

    public PointinteretSelection orderByIdinteret(boolean desc) {
        orderBy(PointinteretColumns.IDINTERET, desc);
        return this;
    }

    public PointinteretSelection orderByIdinteret() {
        orderBy(PointinteretColumns.IDINTERET, false);
        return this;
    }

    public PointinteretSelection libellefr(String... value) {
        addEquals(PointinteretColumns.LIBELLEFR, value);
        return this;
    }

    public PointinteretSelection libellefrNot(String... value) {
        addNotEquals(PointinteretColumns.LIBELLEFR, value);
        return this;
    }

    public PointinteretSelection libellefrLike(String... value) {
        addLike(PointinteretColumns.LIBELLEFR, value);
        return this;
    }

    public PointinteretSelection libellefrContains(String... value) {
        addContains(PointinteretColumns.LIBELLEFR, value);
        return this;
    }

    public PointinteretSelection libellefrStartsWith(String... value) {
        addStartsWith(PointinteretColumns.LIBELLEFR, value);
        return this;
    }

    public PointinteretSelection libellefrEndsWith(String... value) {
        addEndsWith(PointinteretColumns.LIBELLEFR, value);
        return this;
    }

    public PointinteretSelection orderByLibellefr(boolean desc) {
        orderBy(PointinteretColumns.LIBELLEFR, desc);
        return this;
    }

    public PointinteretSelection orderByLibellefr() {
        orderBy(PointinteretColumns.LIBELLEFR, false);
        return this;
    }

    public PointinteretSelection libelleen(String... value) {
        addEquals(PointinteretColumns.LIBELLEEN, value);
        return this;
    }

    public PointinteretSelection libelleenNot(String... value) {
        addNotEquals(PointinteretColumns.LIBELLEEN, value);
        return this;
    }

    public PointinteretSelection libelleenLike(String... value) {
        addLike(PointinteretColumns.LIBELLEEN, value);
        return this;
    }

    public PointinteretSelection libelleenContains(String... value) {
        addContains(PointinteretColumns.LIBELLEEN, value);
        return this;
    }

    public PointinteretSelection libelleenStartsWith(String... value) {
        addStartsWith(PointinteretColumns.LIBELLEEN, value);
        return this;
    }

    public PointinteretSelection libelleenEndsWith(String... value) {
        addEndsWith(PointinteretColumns.LIBELLEEN, value);
        return this;
    }

    public PointinteretSelection orderByLibelleen(boolean desc) {
        orderBy(PointinteretColumns.LIBELLEEN, desc);
        return this;
    }

    public PointinteretSelection orderByLibelleen() {
        orderBy(PointinteretColumns.LIBELLEEN, false);
        return this;
    }

    public PointinteretSelection idpays(Integer... value) {
        addEquals(PointinteretColumns.IDPAYS, value);
        return this;
    }

    public PointinteretSelection idpaysNot(Integer... value) {
        addNotEquals(PointinteretColumns.IDPAYS, value);
        return this;
    }

    public PointinteretSelection idpaysGt(int value) {
        addGreaterThan(PointinteretColumns.IDPAYS, value);
        return this;
    }

    public PointinteretSelection idpaysGtEq(int value) {
        addGreaterThanOrEquals(PointinteretColumns.IDPAYS, value);
        return this;
    }

    public PointinteretSelection idpaysLt(int value) {
        addLessThan(PointinteretColumns.IDPAYS, value);
        return this;
    }

    public PointinteretSelection idpaysLtEq(int value) {
        addLessThanOrEquals(PointinteretColumns.IDPAYS, value);
        return this;
    }

    public PointinteretSelection orderByIdpays(boolean desc) {
        orderBy(PointinteretColumns.IDPAYS, desc);
        return this;
    }

    public PointinteretSelection orderByIdpays() {
        orderBy(PointinteretColumns.IDPAYS, false);
        return this;
    }

    public PointinteretSelection email(String... value) {
        addEquals(PointinteretColumns.EMAIL, value);
        return this;
    }

    public PointinteretSelection emailNot(String... value) {
        addNotEquals(PointinteretColumns.EMAIL, value);
        return this;
    }

    public PointinteretSelection emailLike(String... value) {
        addLike(PointinteretColumns.EMAIL, value);
        return this;
    }

    public PointinteretSelection emailContains(String... value) {
        addContains(PointinteretColumns.EMAIL, value);
        return this;
    }

    public PointinteretSelection emailStartsWith(String... value) {
        addStartsWith(PointinteretColumns.EMAIL, value);
        return this;
    }

    public PointinteretSelection emailEndsWith(String... value) {
        addEndsWith(PointinteretColumns.EMAIL, value);
        return this;
    }

    public PointinteretSelection orderByEmail(boolean desc) {
        orderBy(PointinteretColumns.EMAIL, desc);
        return this;
    }

    public PointinteretSelection orderByEmail() {
        orderBy(PointinteretColumns.EMAIL, false);
        return this;
    }
}
