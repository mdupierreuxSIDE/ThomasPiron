package eu.side.thomaspiron.android.provider.pointcontact;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import eu.side.thomaspiron.android.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code pointcontact} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class PointcontactContentValues extends AbstractContentValues<PointcontactContentValues> {
    @Override
    protected Uri baseUri() {
        return PointcontactColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PointcontactSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PointcontactSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public PointcontactContentValues putIdpointcontact(@Nullable Integer value) {
        mContentValues.put(PointcontactColumns.IDPOINTCONTACT, value);
        return this;
    }

    public PointcontactContentValues putIdpointcontactNull() {
        mContentValues.putNull(PointcontactColumns.IDPOINTCONTACT);
        return this;
    }

    public PointcontactContentValues putTypepointcontact(@Nullable String value) {
        mContentValues.put(PointcontactColumns.TYPEPOINTCONTACT, value);
        return this;
    }

    public PointcontactContentValues putTypepointcontactNull() {
        mContentValues.putNull(PointcontactColumns.TYPEPOINTCONTACT);
        return this;
    }

    public PointcontactContentValues putTitre(@Nullable String value) {
        mContentValues.put(PointcontactColumns.TITRE, value);
        return this;
    }

    public PointcontactContentValues putTitreNull() {
        mContentValues.putNull(PointcontactColumns.TITRE);
        return this;
    }

    public PointcontactContentValues putAdresse(@Nullable String value) {
        mContentValues.put(PointcontactColumns.ADRESSE, value);
        return this;
    }

    public PointcontactContentValues putAdresseNull() {
        mContentValues.putNull(PointcontactColumns.ADRESSE);
        return this;
    }

    public PointcontactContentValues putPostloc(@Nullable String value) {
        mContentValues.put(PointcontactColumns.POSTLOC, value);
        return this;
    }

    public PointcontactContentValues putPostlocNull() {
        mContentValues.putNull(PointcontactColumns.POSTLOC);
        return this;
    }

    public PointcontactContentValues putPostcode(@Nullable String value) {
        mContentValues.put(PointcontactColumns.POSTCODE, value);
        return this;
    }

    public PointcontactContentValues putPostcodeNull() {
        mContentValues.putNull(PointcontactColumns.POSTCODE);
        return this;
    }

    public PointcontactContentValues putTel(@Nullable String value) {
        mContentValues.put(PointcontactColumns.TEL, value);
        return this;
    }

    public PointcontactContentValues putTelNull() {
        mContentValues.putNull(PointcontactColumns.TEL);
        return this;
    }

    public PointcontactContentValues putPermanencefr(@Nullable String value) {
        mContentValues.put(PointcontactColumns.PERMANENCEFR, value);
        return this;
    }

    public PointcontactContentValues putPermanencefrNull() {
        mContentValues.putNull(PointcontactColumns.PERMANENCEFR);
        return this;
    }

    public PointcontactContentValues putLatitude(@Nullable Double value) {
        mContentValues.put(PointcontactColumns.LATITUDE, value);
        return this;
    }

    public PointcontactContentValues putLatitudeNull() {
        mContentValues.putNull(PointcontactColumns.LATITUDE);
        return this;
    }

    public PointcontactContentValues putLongitude(@Nullable Double value) {
        mContentValues.put(PointcontactColumns.LONGITUDE, value);
        return this;
    }

    public PointcontactContentValues putLongitudeNull() {
        mContentValues.putNull(PointcontactColumns.LONGITUDE);
        return this;
    }

    public PointcontactContentValues putNbmedias(@Nullable Integer value) {
        mContentValues.put(PointcontactColumns.NBMEDIAS, value);
        return this;
    }

    public PointcontactContentValues putNbmediasNull() {
        mContentValues.putNull(PointcontactColumns.NBMEDIAS);
        return this;
    }
}
