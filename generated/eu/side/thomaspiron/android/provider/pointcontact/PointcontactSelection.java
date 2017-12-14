package eu.side.thomaspiron.android.provider.pointcontact;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

import eu.side.thomaspiron.android.provider.base.AbstractSelection;

/**
 * Selection for the {@code pointcontact} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class PointcontactSelection extends AbstractSelection<PointcontactSelection> {
    @Override
    protected Uri baseUri() {
        return PointcontactColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PointcontactCursor} object, which is positioned before the first entry, or null.
     */
    public PointcontactCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PointcontactCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public PointcontactCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PointcontactCursor} object, which is positioned before the first entry, or null.
     */
    public PointcontactCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PointcontactCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public PointcontactCursor query(Context context) {
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
                return new PointcontactCursor(super.loadInBackground());
            }
        };
    }


    public PointcontactSelection id(long... value) {
        addEquals("pointcontact." + PointcontactColumns._ID, toObjectArray(value));
        return this;
    }

    public PointcontactSelection idNot(long... value) {
        addNotEquals("pointcontact." + PointcontactColumns._ID, toObjectArray(value));
        return this;
    }

    public PointcontactSelection orderById(boolean desc) {
        orderBy("pointcontact." + PointcontactColumns._ID, desc);
        return this;
    }

    public PointcontactSelection orderById() {
        return orderById(false);
    }

    public PointcontactSelection idpointcontact(Integer... value) {
        addEquals(PointcontactColumns.IDPOINTCONTACT, value);
        return this;
    }

    public PointcontactSelection idpointcontactNot(Integer... value) {
        addNotEquals(PointcontactColumns.IDPOINTCONTACT, value);
        return this;
    }

    public PointcontactSelection idpointcontactGt(int value) {
        addGreaterThan(PointcontactColumns.IDPOINTCONTACT, value);
        return this;
    }

    public PointcontactSelection idpointcontactGtEq(int value) {
        addGreaterThanOrEquals(PointcontactColumns.IDPOINTCONTACT, value);
        return this;
    }

    public PointcontactSelection idpointcontactLt(int value) {
        addLessThan(PointcontactColumns.IDPOINTCONTACT, value);
        return this;
    }

    public PointcontactSelection idpointcontactLtEq(int value) {
        addLessThanOrEquals(PointcontactColumns.IDPOINTCONTACT, value);
        return this;
    }

    public PointcontactSelection orderByIdpointcontact(boolean desc) {
        orderBy(PointcontactColumns.IDPOINTCONTACT, desc);
        return this;
    }

    public PointcontactSelection orderByIdpointcontact() {
        orderBy(PointcontactColumns.IDPOINTCONTACT, false);
        return this;
    }

    public PointcontactSelection typepointcontact(String... value) {
        addEquals(PointcontactColumns.TYPEPOINTCONTACT, value);
        return this;
    }

    public PointcontactSelection typepointcontactNot(String... value) {
        addNotEquals(PointcontactColumns.TYPEPOINTCONTACT, value);
        return this;
    }

    public PointcontactSelection typepointcontactLike(String... value) {
        addLike(PointcontactColumns.TYPEPOINTCONTACT, value);
        return this;
    }

    public PointcontactSelection typepointcontactContains(String... value) {
        addContains(PointcontactColumns.TYPEPOINTCONTACT, value);
        return this;
    }

    public PointcontactSelection typepointcontactStartsWith(String... value) {
        addStartsWith(PointcontactColumns.TYPEPOINTCONTACT, value);
        return this;
    }

    public PointcontactSelection typepointcontactEndsWith(String... value) {
        addEndsWith(PointcontactColumns.TYPEPOINTCONTACT, value);
        return this;
    }

    public PointcontactSelection orderByTypepointcontact(boolean desc) {
        orderBy(PointcontactColumns.TYPEPOINTCONTACT, desc);
        return this;
    }

    public PointcontactSelection orderByTypepointcontact() {
        orderBy(PointcontactColumns.TYPEPOINTCONTACT, false);
        return this;
    }

    public PointcontactSelection titre(String... value) {
        addEquals(PointcontactColumns.TITRE, value);
        return this;
    }

    public PointcontactSelection titreNot(String... value) {
        addNotEquals(PointcontactColumns.TITRE, value);
        return this;
    }

    public PointcontactSelection titreLike(String... value) {
        addLike(PointcontactColumns.TITRE, value);
        return this;
    }

    public PointcontactSelection titreContains(String... value) {
        addContains(PointcontactColumns.TITRE, value);
        return this;
    }

    public PointcontactSelection titreStartsWith(String... value) {
        addStartsWith(PointcontactColumns.TITRE, value);
        return this;
    }

    public PointcontactSelection titreEndsWith(String... value) {
        addEndsWith(PointcontactColumns.TITRE, value);
        return this;
    }

    public PointcontactSelection orderByTitre(boolean desc) {
        orderBy(PointcontactColumns.TITRE, desc);
        return this;
    }

    public PointcontactSelection orderByTitre() {
        orderBy(PointcontactColumns.TITRE, false);
        return this;
    }

    public PointcontactSelection adresse(String... value) {
        addEquals(PointcontactColumns.ADRESSE, value);
        return this;
    }

    public PointcontactSelection adresseNot(String... value) {
        addNotEquals(PointcontactColumns.ADRESSE, value);
        return this;
    }

    public PointcontactSelection adresseLike(String... value) {
        addLike(PointcontactColumns.ADRESSE, value);
        return this;
    }

    public PointcontactSelection adresseContains(String... value) {
        addContains(PointcontactColumns.ADRESSE, value);
        return this;
    }

    public PointcontactSelection adresseStartsWith(String... value) {
        addStartsWith(PointcontactColumns.ADRESSE, value);
        return this;
    }

    public PointcontactSelection adresseEndsWith(String... value) {
        addEndsWith(PointcontactColumns.ADRESSE, value);
        return this;
    }

    public PointcontactSelection orderByAdresse(boolean desc) {
        orderBy(PointcontactColumns.ADRESSE, desc);
        return this;
    }

    public PointcontactSelection orderByAdresse() {
        orderBy(PointcontactColumns.ADRESSE, false);
        return this;
    }

    public PointcontactSelection postloc(String... value) {
        addEquals(PointcontactColumns.POSTLOC, value);
        return this;
    }

    public PointcontactSelection postlocNot(String... value) {
        addNotEquals(PointcontactColumns.POSTLOC, value);
        return this;
    }

    public PointcontactSelection postlocLike(String... value) {
        addLike(PointcontactColumns.POSTLOC, value);
        return this;
    }

    public PointcontactSelection postlocContains(String... value) {
        addContains(PointcontactColumns.POSTLOC, value);
        return this;
    }

    public PointcontactSelection postlocStartsWith(String... value) {
        addStartsWith(PointcontactColumns.POSTLOC, value);
        return this;
    }

    public PointcontactSelection postlocEndsWith(String... value) {
        addEndsWith(PointcontactColumns.POSTLOC, value);
        return this;
    }

    public PointcontactSelection orderByPostloc(boolean desc) {
        orderBy(PointcontactColumns.POSTLOC, desc);
        return this;
    }

    public PointcontactSelection orderByPostloc() {
        orderBy(PointcontactColumns.POSTLOC, false);
        return this;
    }

    public PointcontactSelection postcode(String... value) {
        addEquals(PointcontactColumns.POSTCODE, value);
        return this;
    }

    public PointcontactSelection postcodeNot(String... value) {
        addNotEquals(PointcontactColumns.POSTCODE, value);
        return this;
    }

    public PointcontactSelection postcodeLike(String... value) {
        addLike(PointcontactColumns.POSTCODE, value);
        return this;
    }

    public PointcontactSelection postcodeContains(String... value) {
        addContains(PointcontactColumns.POSTCODE, value);
        return this;
    }

    public PointcontactSelection postcodeStartsWith(String... value) {
        addStartsWith(PointcontactColumns.POSTCODE, value);
        return this;
    }

    public PointcontactSelection postcodeEndsWith(String... value) {
        addEndsWith(PointcontactColumns.POSTCODE, value);
        return this;
    }

    public PointcontactSelection orderByPostcode(boolean desc) {
        orderBy(PointcontactColumns.POSTCODE, desc);
        return this;
    }

    public PointcontactSelection orderByPostcode() {
        orderBy(PointcontactColumns.POSTCODE, false);
        return this;
    }

    public PointcontactSelection tel(String... value) {
        addEquals(PointcontactColumns.TEL, value);
        return this;
    }

    public PointcontactSelection telNot(String... value) {
        addNotEquals(PointcontactColumns.TEL, value);
        return this;
    }

    public PointcontactSelection telLike(String... value) {
        addLike(PointcontactColumns.TEL, value);
        return this;
    }

    public PointcontactSelection telContains(String... value) {
        addContains(PointcontactColumns.TEL, value);
        return this;
    }

    public PointcontactSelection telStartsWith(String... value) {
        addStartsWith(PointcontactColumns.TEL, value);
        return this;
    }

    public PointcontactSelection telEndsWith(String... value) {
        addEndsWith(PointcontactColumns.TEL, value);
        return this;
    }

    public PointcontactSelection orderByTel(boolean desc) {
        orderBy(PointcontactColumns.TEL, desc);
        return this;
    }

    public PointcontactSelection orderByTel() {
        orderBy(PointcontactColumns.TEL, false);
        return this;
    }

    public PointcontactSelection permanencefr(String... value) {
        addEquals(PointcontactColumns.PERMANENCEFR, value);
        return this;
    }

    public PointcontactSelection permanencefrNot(String... value) {
        addNotEquals(PointcontactColumns.PERMANENCEFR, value);
        return this;
    }

    public PointcontactSelection permanencefrLike(String... value) {
        addLike(PointcontactColumns.PERMANENCEFR, value);
        return this;
    }

    public PointcontactSelection permanencefrContains(String... value) {
        addContains(PointcontactColumns.PERMANENCEFR, value);
        return this;
    }

    public PointcontactSelection permanencefrStartsWith(String... value) {
        addStartsWith(PointcontactColumns.PERMANENCEFR, value);
        return this;
    }

    public PointcontactSelection permanencefrEndsWith(String... value) {
        addEndsWith(PointcontactColumns.PERMANENCEFR, value);
        return this;
    }

    public PointcontactSelection orderByPermanencefr(boolean desc) {
        orderBy(PointcontactColumns.PERMANENCEFR, desc);
        return this;
    }

    public PointcontactSelection orderByPermanencefr() {
        orderBy(PointcontactColumns.PERMANENCEFR, false);
        return this;
    }

    public PointcontactSelection latitude(Double... value) {
        addEquals(PointcontactColumns.LATITUDE, value);
        return this;
    }

    public PointcontactSelection latitudeNot(Double... value) {
        addNotEquals(PointcontactColumns.LATITUDE, value);
        return this;
    }

    public PointcontactSelection latitudeGt(double value) {
        addGreaterThan(PointcontactColumns.LATITUDE, value);
        return this;
    }

    public PointcontactSelection latitudeGtEq(double value) {
        addGreaterThanOrEquals(PointcontactColumns.LATITUDE, value);
        return this;
    }

    public PointcontactSelection latitudeLt(double value) {
        addLessThan(PointcontactColumns.LATITUDE, value);
        return this;
    }

    public PointcontactSelection latitudeLtEq(double value) {
        addLessThanOrEquals(PointcontactColumns.LATITUDE, value);
        return this;
    }

    public PointcontactSelection orderByLatitude(boolean desc) {
        orderBy(PointcontactColumns.LATITUDE, desc);
        return this;
    }

    public PointcontactSelection orderByLatitude() {
        orderBy(PointcontactColumns.LATITUDE, false);
        return this;
    }

    public PointcontactSelection longitude(Double... value) {
        addEquals(PointcontactColumns.LONGITUDE, value);
        return this;
    }

    public PointcontactSelection longitudeNot(Double... value) {
        addNotEquals(PointcontactColumns.LONGITUDE, value);
        return this;
    }

    public PointcontactSelection longitudeGt(double value) {
        addGreaterThan(PointcontactColumns.LONGITUDE, value);
        return this;
    }

    public PointcontactSelection longitudeGtEq(double value) {
        addGreaterThanOrEquals(PointcontactColumns.LONGITUDE, value);
        return this;
    }

    public PointcontactSelection longitudeLt(double value) {
        addLessThan(PointcontactColumns.LONGITUDE, value);
        return this;
    }

    public PointcontactSelection longitudeLtEq(double value) {
        addLessThanOrEquals(PointcontactColumns.LONGITUDE, value);
        return this;
    }

    public PointcontactSelection orderByLongitude(boolean desc) {
        orderBy(PointcontactColumns.LONGITUDE, desc);
        return this;
    }

    public PointcontactSelection orderByLongitude() {
        orderBy(PointcontactColumns.LONGITUDE, false);
        return this;
    }

    public PointcontactSelection nbmedias(Integer... value) {
        addEquals(PointcontactColumns.NBMEDIAS, value);
        return this;
    }

    public PointcontactSelection nbmediasNot(Integer... value) {
        addNotEquals(PointcontactColumns.NBMEDIAS, value);
        return this;
    }

    public PointcontactSelection nbmediasGt(int value) {
        addGreaterThan(PointcontactColumns.NBMEDIAS, value);
        return this;
    }

    public PointcontactSelection nbmediasGtEq(int value) {
        addGreaterThanOrEquals(PointcontactColumns.NBMEDIAS, value);
        return this;
    }

    public PointcontactSelection nbmediasLt(int value) {
        addLessThan(PointcontactColumns.NBMEDIAS, value);
        return this;
    }

    public PointcontactSelection nbmediasLtEq(int value) {
        addLessThanOrEquals(PointcontactColumns.NBMEDIAS, value);
        return this;
    }

    public PointcontactSelection orderByNbmedias(boolean desc) {
        orderBy(PointcontactColumns.NBMEDIAS, desc);
        return this;
    }

    public PointcontactSelection orderByNbmedias() {
        orderBy(PointcontactColumns.NBMEDIAS, false);
        return this;
    }
}
