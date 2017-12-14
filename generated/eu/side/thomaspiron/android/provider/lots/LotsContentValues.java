package eu.side.thomaspiron.android.provider.lots;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import eu.side.thomaspiron.android.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code lots} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class LotsContentValues extends AbstractContentValues<LotsContentValues> {
    @Override
    protected Uri baseUri() {
        return LotsColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable LotsSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable LotsSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public LotsContentValues putLotdesc(@Nullable String value) {
        mContentValues.put(LotsColumns.LOTDESC, value);
        return this;
    }

    public LotsContentValues putLotdescNull() {
        mContentValues.putNull(LotsColumns.LOTDESC);
        return this;
    }

    public LotsContentValues putCptepl(@Nullable String value) {
        mContentValues.put(LotsColumns.CPTEPL, value);
        return this;
    }

    public LotsContentValues putCpteplNull() {
        mContentValues.putNull(LotsColumns.CPTEPL);
        return this;
    }

    public LotsContentValues putJardin(@Nullable String value) {
        mContentValues.put(LotsColumns.JARDIN, value);
        return this;
    }

    public LotsContentValues putJardinNull() {
        mContentValues.putNull(LotsColumns.JARDIN);
        return this;
    }

    public LotsContentValues putBalcon(@Nullable String value) {
        mContentValues.put(LotsColumns.BALCON, value);
        return this;
    }

    public LotsContentValues putBalconNull() {
        mContentValues.putNull(LotsColumns.BALCON);
        return this;
    }

    public LotsContentValues putChambres(@Nullable String value) {
        mContentValues.put(LotsColumns.CHAMBRES, value);
        return this;
    }

    public LotsContentValues putChambresNull() {
        mContentValues.putNull(LotsColumns.CHAMBRES);
        return this;
    }

    public LotsContentValues putFacadesnbr(@Nullable String value) {
        mContentValues.put(LotsColumns.FACADESNBR, value);
        return this;
    }

    public LotsContentValues putFacadesnbrNull() {
        mContentValues.putNull(LotsColumns.FACADESNBR);
        return this;
    }

    public LotsContentValues putOrientation(@Nullable String value) {
        mContentValues.put(LotsColumns.ORIENTATION, value);
        return this;
    }

    public LotsContentValues putOrientationNull() {
        mContentValues.putNull(LotsColumns.ORIENTATION);
        return this;
    }

    public LotsContentValues putStatutlot(@Nullable String value) {
        mContentValues.put(LotsColumns.STATUTLOT, value);
        return this;
    }

    public LotsContentValues putStatutlotNull() {
        mContentValues.putNull(LotsColumns.STATUTLOT);
        return this;
    }

    public LotsContentValues putSurfter(@Nullable String value) {
        mContentValues.put(LotsColumns.SURFTER, value);
        return this;
    }

    public LotsContentValues putSurfterNull() {
        mContentValues.putNull(LotsColumns.SURFTER);
        return this;
    }

    public LotsContentValues putSurfhab(@Nullable String value) {
        mContentValues.put(LotsColumns.SURFHAB, value);
        return this;
    }

    public LotsContentValues putSurfhabNull() {
        mContentValues.putNull(LotsColumns.SURFHAB);
        return this;
    }

    public LotsContentValues putCodeetage(@Nullable String value) {
        mContentValues.put(LotsColumns.CODEETAGE, value);
        return this;
    }

    public LotsContentValues putCodeetageNull() {
        mContentValues.putNull(LotsColumns.CODEETAGE);
        return this;
    }

    public LotsContentValues putLibellefr(@Nullable String value) {
        mContentValues.put(LotsColumns.LIBELLEFR, value);
        return this;
    }

    public LotsContentValues putLibellefrNull() {
        mContentValues.putNull(LotsColumns.LIBELLEFR);
        return this;
    }

    public LotsContentValues putEnsecode(@Nullable String value) {
        mContentValues.put(LotsColumns.ENSECODE, value);
        return this;
    }

    public LotsContentValues putEnsecodeNull() {
        mContentValues.putNull(LotsColumns.ENSECODE);
        return this;
    }

    public LotsContentValues putSocicode(@Nullable String value) {
        mContentValues.put(LotsColumns.SOCICODE, value);
        return this;
    }

    public LotsContentValues putSocicodeNull() {
        mContentValues.putNull(LotsColumns.SOCICODE);
        return this;
    }

    public LotsContentValues putPebclasseenergetique(@Nullable String value) {
        mContentValues.put(LotsColumns.PEBCLASSEENERGETIQUE, value);
        return this;
    }

    public LotsContentValues putPebclasseenergetiqueNull() {
        mContentValues.putNull(LotsColumns.PEBCLASSEENERGETIQUE);
        return this;
    }

    public LotsContentValues putNbmedias(@Nullable Integer value) {
        mContentValues.put(LotsColumns.NBMEDIAS, value);
        return this;
    }

    public LotsContentValues putNbmediasNull() {
        mContentValues.putNull(LotsColumns.NBMEDIAS);
        return this;
    }

    public LotsContentValues putNbplansimpl(@Nullable Integer value) {
        mContentValues.put(LotsColumns.NBPLANSIMPL, value);
        return this;
    }

    public LotsContentValues putNbplansimplNull() {
        mContentValues.putNull(LotsColumns.NBPLANSIMPL);
        return this;
    }
}
