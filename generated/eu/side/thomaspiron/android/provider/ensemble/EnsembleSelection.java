package eu.side.thomaspiron.android.provider.ensemble;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

import eu.side.thomaspiron.android.provider.base.AbstractSelection;

/**
 * Selection for the {@code ensemble} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class EnsembleSelection extends AbstractSelection<EnsembleSelection> {
    @Override
    protected Uri baseUri() {
        return EnsembleColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code EnsembleCursor} object, which is positioned before the first entry, or null.
     */
    public EnsembleCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new EnsembleCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public EnsembleCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code EnsembleCursor} object, which is positioned before the first entry, or null.
     */
    public EnsembleCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new EnsembleCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public EnsembleCursor query(Context context) {
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
                return new EnsembleCursor(super.loadInBackground());
            }
        };
    }


    public EnsembleSelection id(long... value) {
        addEquals("ensemble." + EnsembleColumns._ID, toObjectArray(value));
        return this;
    }

    public EnsembleSelection idNot(long... value) {
        addNotEquals("ensemble." + EnsembleColumns._ID, toObjectArray(value));
        return this;
    }

    public EnsembleSelection orderById(boolean desc) {
        orderBy("ensemble." + EnsembleColumns._ID, desc);
        return this;
    }

    public EnsembleSelection orderById() {
        return orderById(false);
    }

    public EnsembleSelection socicode(String... value) {
        addEquals(EnsembleColumns.SOCICODE, value);
        return this;
    }

    public EnsembleSelection socicodeNot(String... value) {
        addNotEquals(EnsembleColumns.SOCICODE, value);
        return this;
    }

    public EnsembleSelection socicodeLike(String... value) {
        addLike(EnsembleColumns.SOCICODE, value);
        return this;
    }

    public EnsembleSelection socicodeContains(String... value) {
        addContains(EnsembleColumns.SOCICODE, value);
        return this;
    }

    public EnsembleSelection socicodeStartsWith(String... value) {
        addStartsWith(EnsembleColumns.SOCICODE, value);
        return this;
    }

    public EnsembleSelection socicodeEndsWith(String... value) {
        addEndsWith(EnsembleColumns.SOCICODE, value);
        return this;
    }

    public EnsembleSelection orderBySocicode(boolean desc) {
        orderBy(EnsembleColumns.SOCICODE, desc);
        return this;
    }

    public EnsembleSelection orderBySocicode() {
        orderBy(EnsembleColumns.SOCICODE, false);
        return this;
    }

    public EnsembleSelection cptepl(String... value) {
        addEquals(EnsembleColumns.CPTEPL, value);
        return this;
    }

    public EnsembleSelection cpteplNot(String... value) {
        addNotEquals(EnsembleColumns.CPTEPL, value);
        return this;
    }

    public EnsembleSelection cpteplLike(String... value) {
        addLike(EnsembleColumns.CPTEPL, value);
        return this;
    }

    public EnsembleSelection cpteplContains(String... value) {
        addContains(EnsembleColumns.CPTEPL, value);
        return this;
    }

    public EnsembleSelection cpteplStartsWith(String... value) {
        addStartsWith(EnsembleColumns.CPTEPL, value);
        return this;
    }

    public EnsembleSelection cpteplEndsWith(String... value) {
        addEndsWith(EnsembleColumns.CPTEPL, value);
        return this;
    }

    public EnsembleSelection orderByCptepl(boolean desc) {
        orderBy(EnsembleColumns.CPTEPL, desc);
        return this;
    }

    public EnsembleSelection orderByCptepl() {
        orderBy(EnsembleColumns.CPTEPL, false);
        return this;
    }

    public EnsembleSelection divicode(String... value) {
        addEquals(EnsembleColumns.DIVICODE, value);
        return this;
    }

    public EnsembleSelection divicodeNot(String... value) {
        addNotEquals(EnsembleColumns.DIVICODE, value);
        return this;
    }

    public EnsembleSelection divicodeLike(String... value) {
        addLike(EnsembleColumns.DIVICODE, value);
        return this;
    }

    public EnsembleSelection divicodeContains(String... value) {
        addContains(EnsembleColumns.DIVICODE, value);
        return this;
    }

    public EnsembleSelection divicodeStartsWith(String... value) {
        addStartsWith(EnsembleColumns.DIVICODE, value);
        return this;
    }

    public EnsembleSelection divicodeEndsWith(String... value) {
        addEndsWith(EnsembleColumns.DIVICODE, value);
        return this;
    }

    public EnsembleSelection orderByDivicode(boolean desc) {
        orderBy(EnsembleColumns.DIVICODE, desc);
        return this;
    }

    public EnsembleSelection orderByDivicode() {
        orderBy(EnsembleColumns.DIVICODE, false);
        return this;
    }

    public EnsembleSelection ensecode(String... value) {
        addEquals(EnsembleColumns.ENSECODE, value);
        return this;
    }

    public EnsembleSelection ensecodeNot(String... value) {
        addNotEquals(EnsembleColumns.ENSECODE, value);
        return this;
    }

    public EnsembleSelection ensecodeLike(String... value) {
        addLike(EnsembleColumns.ENSECODE, value);
        return this;
    }

    public EnsembleSelection ensecodeContains(String... value) {
        addContains(EnsembleColumns.ENSECODE, value);
        return this;
    }

    public EnsembleSelection ensecodeStartsWith(String... value) {
        addStartsWith(EnsembleColumns.ENSECODE, value);
        return this;
    }

    public EnsembleSelection ensecodeEndsWith(String... value) {
        addEndsWith(EnsembleColumns.ENSECODE, value);
        return this;
    }

    public EnsembleSelection orderByEnsecode(boolean desc) {
        orderBy(EnsembleColumns.ENSECODE, desc);
        return this;
    }

    public EnsembleSelection orderByEnsecode() {
        orderBy(EnsembleColumns.ENSECODE, false);
        return this;
    }

    public EnsembleSelection adresse(String... value) {
        addEquals(EnsembleColumns.ADRESSE, value);
        return this;
    }

    public EnsembleSelection adresseNot(String... value) {
        addNotEquals(EnsembleColumns.ADRESSE, value);
        return this;
    }

    public EnsembleSelection adresseLike(String... value) {
        addLike(EnsembleColumns.ADRESSE, value);
        return this;
    }

    public EnsembleSelection adresseContains(String... value) {
        addContains(EnsembleColumns.ADRESSE, value);
        return this;
    }

    public EnsembleSelection adresseStartsWith(String... value) {
        addStartsWith(EnsembleColumns.ADRESSE, value);
        return this;
    }

    public EnsembleSelection adresseEndsWith(String... value) {
        addEndsWith(EnsembleColumns.ADRESSE, value);
        return this;
    }

    public EnsembleSelection orderByAdresse(boolean desc) {
        orderBy(EnsembleColumns.ADRESSE, desc);
        return this;
    }

    public EnsembleSelection orderByAdresse() {
        orderBy(EnsembleColumns.ADRESSE, false);
        return this;
    }

    public EnsembleSelection postloc(String... value) {
        addEquals(EnsembleColumns.POSTLOC, value);
        return this;
    }

    public EnsembleSelection postlocNot(String... value) {
        addNotEquals(EnsembleColumns.POSTLOC, value);
        return this;
    }

    public EnsembleSelection postlocLike(String... value) {
        addLike(EnsembleColumns.POSTLOC, value);
        return this;
    }

    public EnsembleSelection postlocContains(String... value) {
        addContains(EnsembleColumns.POSTLOC, value);
        return this;
    }

    public EnsembleSelection postlocStartsWith(String... value) {
        addStartsWith(EnsembleColumns.POSTLOC, value);
        return this;
    }

    public EnsembleSelection postlocEndsWith(String... value) {
        addEndsWith(EnsembleColumns.POSTLOC, value);
        return this;
    }

    public EnsembleSelection orderByPostloc(boolean desc) {
        orderBy(EnsembleColumns.POSTLOC, desc);
        return this;
    }

    public EnsembleSelection orderByPostloc() {
        orderBy(EnsembleColumns.POSTLOC, false);
        return this;
    }

    public EnsembleSelection postcode(String... value) {
        addEquals(EnsembleColumns.POSTCODE, value);
        return this;
    }

    public EnsembleSelection postcodeNot(String... value) {
        addNotEquals(EnsembleColumns.POSTCODE, value);
        return this;
    }

    public EnsembleSelection postcodeLike(String... value) {
        addLike(EnsembleColumns.POSTCODE, value);
        return this;
    }

    public EnsembleSelection postcodeContains(String... value) {
        addContains(EnsembleColumns.POSTCODE, value);
        return this;
    }

    public EnsembleSelection postcodeStartsWith(String... value) {
        addStartsWith(EnsembleColumns.POSTCODE, value);
        return this;
    }

    public EnsembleSelection postcodeEndsWith(String... value) {
        addEndsWith(EnsembleColumns.POSTCODE, value);
        return this;
    }

    public EnsembleSelection orderByPostcode(boolean desc) {
        orderBy(EnsembleColumns.POSTCODE, desc);
        return this;
    }

    public EnsembleSelection orderByPostcode() {
        orderBy(EnsembleColumns.POSTCODE, false);
        return this;
    }

    public EnsembleSelection ensedesc(String... value) {
        addEquals(EnsembleColumns.ENSEDESC, value);
        return this;
    }

    public EnsembleSelection ensedescNot(String... value) {
        addNotEquals(EnsembleColumns.ENSEDESC, value);
        return this;
    }

    public EnsembleSelection ensedescLike(String... value) {
        addLike(EnsembleColumns.ENSEDESC, value);
        return this;
    }

    public EnsembleSelection ensedescContains(String... value) {
        addContains(EnsembleColumns.ENSEDESC, value);
        return this;
    }

    public EnsembleSelection ensedescStartsWith(String... value) {
        addStartsWith(EnsembleColumns.ENSEDESC, value);
        return this;
    }

    public EnsembleSelection ensedescEndsWith(String... value) {
        addEndsWith(EnsembleColumns.ENSEDESC, value);
        return this;
    }

    public EnsembleSelection orderByEnsedesc(boolean desc) {
        orderBy(EnsembleColumns.ENSEDESC, desc);
        return this;
    }

    public EnsembleSelection orderByEnsedesc() {
        orderBy(EnsembleColumns.ENSEDESC, false);
        return this;
    }

    public EnsembleSelection libcommercialfr(String... value) {
        addEquals(EnsembleColumns.LIBCOMMERCIALFR, value);
        return this;
    }

    public EnsembleSelection libcommercialfrNot(String... value) {
        addNotEquals(EnsembleColumns.LIBCOMMERCIALFR, value);
        return this;
    }

    public EnsembleSelection libcommercialfrLike(String... value) {
        addLike(EnsembleColumns.LIBCOMMERCIALFR, value);
        return this;
    }

    public EnsembleSelection libcommercialfrContains(String... value) {
        addContains(EnsembleColumns.LIBCOMMERCIALFR, value);
        return this;
    }

    public EnsembleSelection libcommercialfrStartsWith(String... value) {
        addStartsWith(EnsembleColumns.LIBCOMMERCIALFR, value);
        return this;
    }

    public EnsembleSelection libcommercialfrEndsWith(String... value) {
        addEndsWith(EnsembleColumns.LIBCOMMERCIALFR, value);
        return this;
    }

    public EnsembleSelection orderByLibcommercialfr(boolean desc) {
        orderBy(EnsembleColumns.LIBCOMMERCIALFR, desc);
        return this;
    }

    public EnsembleSelection orderByLibcommercialfr() {
        orderBy(EnsembleColumns.LIBCOMMERCIALFR, false);
        return this;
    }

    public EnsembleSelection libcommercialen(String... value) {
        addEquals(EnsembleColumns.LIBCOMMERCIALEN, value);
        return this;
    }

    public EnsembleSelection libcommercialenNot(String... value) {
        addNotEquals(EnsembleColumns.LIBCOMMERCIALEN, value);
        return this;
    }

    public EnsembleSelection libcommercialenLike(String... value) {
        addLike(EnsembleColumns.LIBCOMMERCIALEN, value);
        return this;
    }

    public EnsembleSelection libcommercialenContains(String... value) {
        addContains(EnsembleColumns.LIBCOMMERCIALEN, value);
        return this;
    }

    public EnsembleSelection libcommercialenStartsWith(String... value) {
        addStartsWith(EnsembleColumns.LIBCOMMERCIALEN, value);
        return this;
    }

    public EnsembleSelection libcommercialenEndsWith(String... value) {
        addEndsWith(EnsembleColumns.LIBCOMMERCIALEN, value);
        return this;
    }

    public EnsembleSelection orderByLibcommercialen(boolean desc) {
        orderBy(EnsembleColumns.LIBCOMMERCIALEN, desc);
        return this;
    }

    public EnsembleSelection orderByLibcommercialen() {
        orderBy(EnsembleColumns.LIBCOMMERCIALEN, false);
        return this;
    }

    public EnsembleSelection latitude(Double... value) {
        addEquals(EnsembleColumns.LATITUDE, value);
        return this;
    }

    public EnsembleSelection latitudeNot(Double... value) {
        addNotEquals(EnsembleColumns.LATITUDE, value);
        return this;
    }

    public EnsembleSelection latitudeGt(double value) {
        addGreaterThan(EnsembleColumns.LATITUDE, value);
        return this;
    }

    public EnsembleSelection latitudeGtEq(double value) {
        addGreaterThanOrEquals(EnsembleColumns.LATITUDE, value);
        return this;
    }

    public EnsembleSelection latitudeLt(double value) {
        addLessThan(EnsembleColumns.LATITUDE, value);
        return this;
    }

    public EnsembleSelection latitudeLtEq(double value) {
        addLessThanOrEquals(EnsembleColumns.LATITUDE, value);
        return this;
    }

    public EnsembleSelection orderByLatitude(boolean desc) {
        orderBy(EnsembleColumns.LATITUDE, desc);
        return this;
    }

    public EnsembleSelection orderByLatitude() {
        orderBy(EnsembleColumns.LATITUDE, false);
        return this;
    }

    public EnsembleSelection longitude(Double... value) {
        addEquals(EnsembleColumns.LONGITUDE, value);
        return this;
    }

    public EnsembleSelection longitudeNot(Double... value) {
        addNotEquals(EnsembleColumns.LONGITUDE, value);
        return this;
    }

    public EnsembleSelection longitudeGt(double value) {
        addGreaterThan(EnsembleColumns.LONGITUDE, value);
        return this;
    }

    public EnsembleSelection longitudeGtEq(double value) {
        addGreaterThanOrEquals(EnsembleColumns.LONGITUDE, value);
        return this;
    }

    public EnsembleSelection longitudeLt(double value) {
        addLessThan(EnsembleColumns.LONGITUDE, value);
        return this;
    }

    public EnsembleSelection longitudeLtEq(double value) {
        addLessThanOrEquals(EnsembleColumns.LONGITUDE, value);
        return this;
    }

    public EnsembleSelection orderByLongitude(boolean desc) {
        orderBy(EnsembleColumns.LONGITUDE, desc);
        return this;
    }

    public EnsembleSelection orderByLongitude() {
        orderBy(EnsembleColumns.LONGITUDE, false);
        return this;
    }

    public EnsembleSelection descriptiondistancefr(String... value) {
        addEquals(EnsembleColumns.DESCRIPTIONDISTANCEFR, value);
        return this;
    }

    public EnsembleSelection descriptiondistancefrNot(String... value) {
        addNotEquals(EnsembleColumns.DESCRIPTIONDISTANCEFR, value);
        return this;
    }

    public EnsembleSelection descriptiondistancefrLike(String... value) {
        addLike(EnsembleColumns.DESCRIPTIONDISTANCEFR, value);
        return this;
    }

    public EnsembleSelection descriptiondistancefrContains(String... value) {
        addContains(EnsembleColumns.DESCRIPTIONDISTANCEFR, value);
        return this;
    }

    public EnsembleSelection descriptiondistancefrStartsWith(String... value) {
        addStartsWith(EnsembleColumns.DESCRIPTIONDISTANCEFR, value);
        return this;
    }

    public EnsembleSelection descriptiondistancefrEndsWith(String... value) {
        addEndsWith(EnsembleColumns.DESCRIPTIONDISTANCEFR, value);
        return this;
    }

    public EnsembleSelection orderByDescriptiondistancefr(boolean desc) {
        orderBy(EnsembleColumns.DESCRIPTIONDISTANCEFR, desc);
        return this;
    }

    public EnsembleSelection orderByDescriptiondistancefr() {
        orderBy(EnsembleColumns.DESCRIPTIONDISTANCEFR, false);
        return this;
    }

    public EnsembleSelection descriptiondistanceen(String... value) {
        addEquals(EnsembleColumns.DESCRIPTIONDISTANCEEN, value);
        return this;
    }

    public EnsembleSelection descriptiondistanceenNot(String... value) {
        addNotEquals(EnsembleColumns.DESCRIPTIONDISTANCEEN, value);
        return this;
    }

    public EnsembleSelection descriptiondistanceenLike(String... value) {
        addLike(EnsembleColumns.DESCRIPTIONDISTANCEEN, value);
        return this;
    }

    public EnsembleSelection descriptiondistanceenContains(String... value) {
        addContains(EnsembleColumns.DESCRIPTIONDISTANCEEN, value);
        return this;
    }

    public EnsembleSelection descriptiondistanceenStartsWith(String... value) {
        addStartsWith(EnsembleColumns.DESCRIPTIONDISTANCEEN, value);
        return this;
    }

    public EnsembleSelection descriptiondistanceenEndsWith(String... value) {
        addEndsWith(EnsembleColumns.DESCRIPTIONDISTANCEEN, value);
        return this;
    }

    public EnsembleSelection orderByDescriptiondistanceen(boolean desc) {
        orderBy(EnsembleColumns.DESCRIPTIONDISTANCEEN, desc);
        return this;
    }

    public EnsembleSelection orderByDescriptiondistanceen() {
        orderBy(EnsembleColumns.DESCRIPTIONDISTANCEEN, false);
        return this;
    }

    public EnsembleSelection totunit(Integer... value) {
        addEquals(EnsembleColumns.TOTUNIT, value);
        return this;
    }

    public EnsembleSelection totunitNot(Integer... value) {
        addNotEquals(EnsembleColumns.TOTUNIT, value);
        return this;
    }

    public EnsembleSelection totunitGt(int value) {
        addGreaterThan(EnsembleColumns.TOTUNIT, value);
        return this;
    }

    public EnsembleSelection totunitGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.TOTUNIT, value);
        return this;
    }

    public EnsembleSelection totunitLt(int value) {
        addLessThan(EnsembleColumns.TOTUNIT, value);
        return this;
    }

    public EnsembleSelection totunitLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.TOTUNIT, value);
        return this;
    }

    public EnsembleSelection orderByTotunit(boolean desc) {
        orderBy(EnsembleColumns.TOTUNIT, desc);
        return this;
    }

    public EnsembleSelection orderByTotunit() {
        orderBy(EnsembleColumns.TOTUNIT, false);
        return this;
    }

    public EnsembleSelection terrainmin(String... value) {
        addEquals(EnsembleColumns.TERRAINMIN, value);
        return this;
    }

    public EnsembleSelection terrainminNot(String... value) {
        addNotEquals(EnsembleColumns.TERRAINMIN, value);
        return this;
    }

    public EnsembleSelection terrainminLike(String... value) {
        addLike(EnsembleColumns.TERRAINMIN, value);
        return this;
    }

    public EnsembleSelection terrainminContains(String... value) {
        addContains(EnsembleColumns.TERRAINMIN, value);
        return this;
    }

    public EnsembleSelection terrainminStartsWith(String... value) {
        addStartsWith(EnsembleColumns.TERRAINMIN, value);
        return this;
    }

    public EnsembleSelection terrainminEndsWith(String... value) {
        addEndsWith(EnsembleColumns.TERRAINMIN, value);
        return this;
    }

    public EnsembleSelection orderByTerrainmin(boolean desc) {
        orderBy(EnsembleColumns.TERRAINMIN, desc);
        return this;
    }

    public EnsembleSelection orderByTerrainmin() {
        orderBy(EnsembleColumns.TERRAINMIN, false);
        return this;
    }

    public EnsembleSelection terrainmax(String... value) {
        addEquals(EnsembleColumns.TERRAINMAX, value);
        return this;
    }

    public EnsembleSelection terrainmaxNot(String... value) {
        addNotEquals(EnsembleColumns.TERRAINMAX, value);
        return this;
    }

    public EnsembleSelection terrainmaxLike(String... value) {
        addLike(EnsembleColumns.TERRAINMAX, value);
        return this;
    }

    public EnsembleSelection terrainmaxContains(String... value) {
        addContains(EnsembleColumns.TERRAINMAX, value);
        return this;
    }

    public EnsembleSelection terrainmaxStartsWith(String... value) {
        addStartsWith(EnsembleColumns.TERRAINMAX, value);
        return this;
    }

    public EnsembleSelection terrainmaxEndsWith(String... value) {
        addEndsWith(EnsembleColumns.TERRAINMAX, value);
        return this;
    }

    public EnsembleSelection orderByTerrainmax(boolean desc) {
        orderBy(EnsembleColumns.TERRAINMAX, desc);
        return this;
    }

    public EnsembleSelection orderByTerrainmax() {
        orderBy(EnsembleColumns.TERRAINMAX, false);
        return this;
    }

    public EnsembleSelection terrainspp(Integer... value) {
        addEquals(EnsembleColumns.TERRAINSPP, value);
        return this;
    }

    public EnsembleSelection terrainsppNot(Integer... value) {
        addNotEquals(EnsembleColumns.TERRAINSPP, value);
        return this;
    }

    public EnsembleSelection terrainsppGt(int value) {
        addGreaterThan(EnsembleColumns.TERRAINSPP, value);
        return this;
    }

    public EnsembleSelection terrainsppGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.TERRAINSPP, value);
        return this;
    }

    public EnsembleSelection terrainsppLt(int value) {
        addLessThan(EnsembleColumns.TERRAINSPP, value);
        return this;
    }

    public EnsembleSelection terrainsppLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.TERRAINSPP, value);
        return this;
    }

    public EnsembleSelection orderByTerrainspp(boolean desc) {
        orderBy(EnsembleColumns.TERRAINSPP, desc);
        return this;
    }

    public EnsembleSelection orderByTerrainspp() {
        orderBy(EnsembleColumns.TERRAINSPP, false);
        return this;
    }

    public EnsembleSelection terrainspc(Integer... value) {
        addEquals(EnsembleColumns.TERRAINSPC, value);
        return this;
    }

    public EnsembleSelection terrainspcNot(Integer... value) {
        addNotEquals(EnsembleColumns.TERRAINSPC, value);
        return this;
    }

    public EnsembleSelection terrainspcGt(int value) {
        addGreaterThan(EnsembleColumns.TERRAINSPC, value);
        return this;
    }

    public EnsembleSelection terrainspcGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.TERRAINSPC, value);
        return this;
    }

    public EnsembleSelection terrainspcLt(int value) {
        addLessThan(EnsembleColumns.TERRAINSPC, value);
        return this;
    }

    public EnsembleSelection terrainspcLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.TERRAINSPC, value);
        return this;
    }

    public EnsembleSelection orderByTerrainspc(boolean desc) {
        orderBy(EnsembleColumns.TERRAINSPC, desc);
        return this;
    }

    public EnsembleSelection orderByTerrainspc() {
        orderBy(EnsembleColumns.TERRAINSPC, false);
        return this;
    }

    public EnsembleSelection terrainsec(Integer... value) {
        addEquals(EnsembleColumns.TERRAINSEC, value);
        return this;
    }

    public EnsembleSelection terrainsecNot(Integer... value) {
        addNotEquals(EnsembleColumns.TERRAINSEC, value);
        return this;
    }

    public EnsembleSelection terrainsecGt(int value) {
        addGreaterThan(EnsembleColumns.TERRAINSEC, value);
        return this;
    }

    public EnsembleSelection terrainsecGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.TERRAINSEC, value);
        return this;
    }

    public EnsembleSelection terrainsecLt(int value) {
        addLessThan(EnsembleColumns.TERRAINSEC, value);
        return this;
    }

    public EnsembleSelection terrainsecLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.TERRAINSEC, value);
        return this;
    }

    public EnsembleSelection orderByTerrainsec(boolean desc) {
        orderBy(EnsembleColumns.TERRAINSEC, desc);
        return this;
    }

    public EnsembleSelection orderByTerrainsec() {
        orderBy(EnsembleColumns.TERRAINSEC, false);
        return this;
    }

    public EnsembleSelection maisonsec(Integer... value) {
        addEquals(EnsembleColumns.MAISONSEC, value);
        return this;
    }

    public EnsembleSelection maisonsecNot(Integer... value) {
        addNotEquals(EnsembleColumns.MAISONSEC, value);
        return this;
    }

    public EnsembleSelection maisonsecGt(int value) {
        addGreaterThan(EnsembleColumns.MAISONSEC, value);
        return this;
    }

    public EnsembleSelection maisonsecGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.MAISONSEC, value);
        return this;
    }

    public EnsembleSelection maisonsecLt(int value) {
        addLessThan(EnsembleColumns.MAISONSEC, value);
        return this;
    }

    public EnsembleSelection maisonsecLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.MAISONSEC, value);
        return this;
    }

    public EnsembleSelection orderByMaisonsec(boolean desc) {
        orderBy(EnsembleColumns.MAISONSEC, desc);
        return this;
    }

    public EnsembleSelection orderByMaisonsec() {
        orderBy(EnsembleColumns.MAISONSEC, false);
        return this;
    }

    public EnsembleSelection maisonsc(Integer... value) {
        addEquals(EnsembleColumns.MAISONSC, value);
        return this;
    }

    public EnsembleSelection maisonscNot(Integer... value) {
        addNotEquals(EnsembleColumns.MAISONSC, value);
        return this;
    }

    public EnsembleSelection maisonscGt(int value) {
        addGreaterThan(EnsembleColumns.MAISONSC, value);
        return this;
    }

    public EnsembleSelection maisonscGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.MAISONSC, value);
        return this;
    }

    public EnsembleSelection maisonscLt(int value) {
        addLessThan(EnsembleColumns.MAISONSC, value);
        return this;
    }

    public EnsembleSelection maisonscLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.MAISONSC, value);
        return this;
    }

    public EnsembleSelection orderByMaisonsc(boolean desc) {
        orderBy(EnsembleColumns.MAISONSC, desc);
        return this;
    }

    public EnsembleSelection orderByMaisonsc() {
        orderBy(EnsembleColumns.MAISONSC, false);
        return this;
    }

    public EnsembleSelection surfmin(String... value) {
        addEquals(EnsembleColumns.SURFMIN, value);
        return this;
    }

    public EnsembleSelection surfminNot(String... value) {
        addNotEquals(EnsembleColumns.SURFMIN, value);
        return this;
    }

    public EnsembleSelection surfminLike(String... value) {
        addLike(EnsembleColumns.SURFMIN, value);
        return this;
    }

    public EnsembleSelection surfminContains(String... value) {
        addContains(EnsembleColumns.SURFMIN, value);
        return this;
    }

    public EnsembleSelection surfminStartsWith(String... value) {
        addStartsWith(EnsembleColumns.SURFMIN, value);
        return this;
    }

    public EnsembleSelection surfminEndsWith(String... value) {
        addEndsWith(EnsembleColumns.SURFMIN, value);
        return this;
    }

    public EnsembleSelection orderBySurfmin(boolean desc) {
        orderBy(EnsembleColumns.SURFMIN, desc);
        return this;
    }

    public EnsembleSelection orderBySurfmin() {
        orderBy(EnsembleColumns.SURFMIN, false);
        return this;
    }

    public EnsembleSelection surfmax(String... value) {
        addEquals(EnsembleColumns.SURFMAX, value);
        return this;
    }

    public EnsembleSelection surfmaxNot(String... value) {
        addNotEquals(EnsembleColumns.SURFMAX, value);
        return this;
    }

    public EnsembleSelection surfmaxLike(String... value) {
        addLike(EnsembleColumns.SURFMAX, value);
        return this;
    }

    public EnsembleSelection surfmaxContains(String... value) {
        addContains(EnsembleColumns.SURFMAX, value);
        return this;
    }

    public EnsembleSelection surfmaxStartsWith(String... value) {
        addStartsWith(EnsembleColumns.SURFMAX, value);
        return this;
    }

    public EnsembleSelection surfmaxEndsWith(String... value) {
        addEndsWith(EnsembleColumns.SURFMAX, value);
        return this;
    }

    public EnsembleSelection orderBySurfmax(boolean desc) {
        orderBy(EnsembleColumns.SURFMAX, desc);
        return this;
    }

    public EnsembleSelection orderBySurfmax() {
        orderBy(EnsembleColumns.SURFMAX, false);
        return this;
    }

    public EnsembleSelection nbstudios(Integer... value) {
        addEquals(EnsembleColumns.NBSTUDIOS, value);
        return this;
    }

    public EnsembleSelection nbstudiosNot(Integer... value) {
        addNotEquals(EnsembleColumns.NBSTUDIOS, value);
        return this;
    }

    public EnsembleSelection nbstudiosGt(int value) {
        addGreaterThan(EnsembleColumns.NBSTUDIOS, value);
        return this;
    }

    public EnsembleSelection nbstudiosGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.NBSTUDIOS, value);
        return this;
    }

    public EnsembleSelection nbstudiosLt(int value) {
        addLessThan(EnsembleColumns.NBSTUDIOS, value);
        return this;
    }

    public EnsembleSelection nbstudiosLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.NBSTUDIOS, value);
        return this;
    }

    public EnsembleSelection orderByNbstudios(boolean desc) {
        orderBy(EnsembleColumns.NBSTUDIOS, desc);
        return this;
    }

    public EnsembleSelection orderByNbstudios() {
        orderBy(EnsembleColumns.NBSTUDIOS, false);
        return this;
    }

    public EnsembleSelection nbapparts(Integer... value) {
        addEquals(EnsembleColumns.NBAPPARTS, value);
        return this;
    }

    public EnsembleSelection nbappartsNot(Integer... value) {
        addNotEquals(EnsembleColumns.NBAPPARTS, value);
        return this;
    }

    public EnsembleSelection nbappartsGt(int value) {
        addGreaterThan(EnsembleColumns.NBAPPARTS, value);
        return this;
    }

    public EnsembleSelection nbappartsGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.NBAPPARTS, value);
        return this;
    }

    public EnsembleSelection nbappartsLt(int value) {
        addLessThan(EnsembleColumns.NBAPPARTS, value);
        return this;
    }

    public EnsembleSelection nbappartsLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.NBAPPARTS, value);
        return this;
    }

    public EnsembleSelection orderByNbapparts(boolean desc) {
        orderBy(EnsembleColumns.NBAPPARTS, desc);
        return this;
    }

    public EnsembleSelection orderByNbapparts() {
        orderBy(EnsembleColumns.NBAPPARTS, false);
        return this;
    }

    public EnsembleSelection nbpenthouses(Integer... value) {
        addEquals(EnsembleColumns.NBPENTHOUSES, value);
        return this;
    }

    public EnsembleSelection nbpenthousesNot(Integer... value) {
        addNotEquals(EnsembleColumns.NBPENTHOUSES, value);
        return this;
    }

    public EnsembleSelection nbpenthousesGt(int value) {
        addGreaterThan(EnsembleColumns.NBPENTHOUSES, value);
        return this;
    }

    public EnsembleSelection nbpenthousesGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.NBPENTHOUSES, value);
        return this;
    }

    public EnsembleSelection nbpenthousesLt(int value) {
        addLessThan(EnsembleColumns.NBPENTHOUSES, value);
        return this;
    }

    public EnsembleSelection nbpenthousesLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.NBPENTHOUSES, value);
        return this;
    }

    public EnsembleSelection orderByNbpenthouses(boolean desc) {
        orderBy(EnsembleColumns.NBPENTHOUSES, desc);
        return this;
    }

    public EnsembleSelection orderByNbpenthouses() {
        orderBy(EnsembleColumns.NBPENTHOUSES, false);
        return this;
    }

    public EnsembleSelection nbduplex(Integer... value) {
        addEquals(EnsembleColumns.NBDUPLEX, value);
        return this;
    }

    public EnsembleSelection nbduplexNot(Integer... value) {
        addNotEquals(EnsembleColumns.NBDUPLEX, value);
        return this;
    }

    public EnsembleSelection nbduplexGt(int value) {
        addGreaterThan(EnsembleColumns.NBDUPLEX, value);
        return this;
    }

    public EnsembleSelection nbduplexGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.NBDUPLEX, value);
        return this;
    }

    public EnsembleSelection nbduplexLt(int value) {
        addLessThan(EnsembleColumns.NBDUPLEX, value);
        return this;
    }

    public EnsembleSelection nbduplexLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.NBDUPLEX, value);
        return this;
    }

    public EnsembleSelection orderByNbduplex(boolean desc) {
        orderBy(EnsembleColumns.NBDUPLEX, desc);
        return this;
    }

    public EnsembleSelection orderByNbduplex() {
        orderBy(EnsembleColumns.NBDUPLEX, false);
        return this;
    }

    public EnsembleSelection nbcommerces(Integer... value) {
        addEquals(EnsembleColumns.NBCOMMERCES, value);
        return this;
    }

    public EnsembleSelection nbcommercesNot(Integer... value) {
        addNotEquals(EnsembleColumns.NBCOMMERCES, value);
        return this;
    }

    public EnsembleSelection nbcommercesGt(int value) {
        addGreaterThan(EnsembleColumns.NBCOMMERCES, value);
        return this;
    }

    public EnsembleSelection nbcommercesGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.NBCOMMERCES, value);
        return this;
    }

    public EnsembleSelection nbcommercesLt(int value) {
        addLessThan(EnsembleColumns.NBCOMMERCES, value);
        return this;
    }

    public EnsembleSelection nbcommercesLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.NBCOMMERCES, value);
        return this;
    }

    public EnsembleSelection orderByNbcommerces(boolean desc) {
        orderBy(EnsembleColumns.NBCOMMERCES, desc);
        return this;
    }

    public EnsembleSelection orderByNbcommerces() {
        orderBy(EnsembleColumns.NBCOMMERCES, false);
        return this;
    }

    public EnsembleSelection nbbureaux(Integer... value) {
        addEquals(EnsembleColumns.NBBUREAUX, value);
        return this;
    }

    public EnsembleSelection nbbureauxNot(Integer... value) {
        addNotEquals(EnsembleColumns.NBBUREAUX, value);
        return this;
    }

    public EnsembleSelection nbbureauxGt(int value) {
        addGreaterThan(EnsembleColumns.NBBUREAUX, value);
        return this;
    }

    public EnsembleSelection nbbureauxGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.NBBUREAUX, value);
        return this;
    }

    public EnsembleSelection nbbureauxLt(int value) {
        addLessThan(EnsembleColumns.NBBUREAUX, value);
        return this;
    }

    public EnsembleSelection nbbureauxLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.NBBUREAUX, value);
        return this;
    }

    public EnsembleSelection orderByNbbureaux(boolean desc) {
        orderBy(EnsembleColumns.NBBUREAUX, desc);
        return this;
    }

    public EnsembleSelection orderByNbbureaux() {
        orderBy(EnsembleColumns.NBBUREAUX, false);
        return this;
    }

    public EnsembleSelection nbterrainsdispo(Integer... value) {
        addEquals(EnsembleColumns.NBTERRAINSDISPO, value);
        return this;
    }

    public EnsembleSelection nbterrainsdispoNot(Integer... value) {
        addNotEquals(EnsembleColumns.NBTERRAINSDISPO, value);
        return this;
    }

    public EnsembleSelection nbterrainsdispoGt(int value) {
        addGreaterThan(EnsembleColumns.NBTERRAINSDISPO, value);
        return this;
    }

    public EnsembleSelection nbterrainsdispoGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.NBTERRAINSDISPO, value);
        return this;
    }

    public EnsembleSelection nbterrainsdispoLt(int value) {
        addLessThan(EnsembleColumns.NBTERRAINSDISPO, value);
        return this;
    }

    public EnsembleSelection nbterrainsdispoLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.NBTERRAINSDISPO, value);
        return this;
    }

    public EnsembleSelection orderByNbterrainsdispo(boolean desc) {
        orderBy(EnsembleColumns.NBTERRAINSDISPO, desc);
        return this;
    }

    public EnsembleSelection orderByNbterrainsdispo() {
        orderBy(EnsembleColumns.NBTERRAINSDISPO, false);
        return this;
    }

    public EnsembleSelection maison(Boolean value) {
        addEquals(EnsembleColumns.MAISON, toObjectArray(value));
        return this;
    }

    public EnsembleSelection orderByMaison(boolean desc) {
        orderBy(EnsembleColumns.MAISON, desc);
        return this;
    }

    public EnsembleSelection orderByMaison() {
        orderBy(EnsembleColumns.MAISON, false);
        return this;
    }

    public EnsembleSelection appart(Boolean value) {
        addEquals(EnsembleColumns.APPART, toObjectArray(value));
        return this;
    }

    public EnsembleSelection orderByAppart(boolean desc) {
        orderBy(EnsembleColumns.APPART, desc);
        return this;
    }

    public EnsembleSelection orderByAppart() {
        orderBy(EnsembleColumns.APPART, false);
        return this;
    }

    public EnsembleSelection terrain(Boolean value) {
        addEquals(EnsembleColumns.TERRAIN, toObjectArray(value));
        return this;
    }

    public EnsembleSelection orderByTerrain(boolean desc) {
        orderBy(EnsembleColumns.TERRAIN, desc);
        return this;
    }

    public EnsembleSelection orderByTerrain() {
        orderBy(EnsembleColumns.TERRAIN, false);
        return this;
    }

    public EnsembleSelection province(String... value) {
        addEquals(EnsembleColumns.PROVINCE, value);
        return this;
    }

    public EnsembleSelection provinceNot(String... value) {
        addNotEquals(EnsembleColumns.PROVINCE, value);
        return this;
    }

    public EnsembleSelection provinceLike(String... value) {
        addLike(EnsembleColumns.PROVINCE, value);
        return this;
    }

    public EnsembleSelection provinceContains(String... value) {
        addContains(EnsembleColumns.PROVINCE, value);
        return this;
    }

    public EnsembleSelection provinceStartsWith(String... value) {
        addStartsWith(EnsembleColumns.PROVINCE, value);
        return this;
    }

    public EnsembleSelection provinceEndsWith(String... value) {
        addEndsWith(EnsembleColumns.PROVINCE, value);
        return this;
    }

    public EnsembleSelection orderByProvince(boolean desc) {
        orderBy(EnsembleColumns.PROVINCE, desc);
        return this;
    }

    public EnsembleSelection orderByProvince() {
        orderBy(EnsembleColumns.PROVINCE, false);
        return this;
    }

    public EnsembleSelection idpointcontact(Integer... value) {
        addEquals(EnsembleColumns.IDPOINTCONTACT, value);
        return this;
    }

    public EnsembleSelection idpointcontactNot(Integer... value) {
        addNotEquals(EnsembleColumns.IDPOINTCONTACT, value);
        return this;
    }

    public EnsembleSelection idpointcontactGt(int value) {
        addGreaterThan(EnsembleColumns.IDPOINTCONTACT, value);
        return this;
    }

    public EnsembleSelection idpointcontactGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.IDPOINTCONTACT, value);
        return this;
    }

    public EnsembleSelection idpointcontactLt(int value) {
        addLessThan(EnsembleColumns.IDPOINTCONTACT, value);
        return this;
    }

    public EnsembleSelection idpointcontactLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.IDPOINTCONTACT, value);
        return this;
    }

    public EnsembleSelection orderByIdpointcontact(boolean desc) {
        orderBy(EnsembleColumns.IDPOINTCONTACT, desc);
        return this;
    }

    public EnsembleSelection orderByIdpointcontact() {
        orderBy(EnsembleColumns.IDPOINTCONTACT, false);
        return this;
    }

    public EnsembleSelection nbmedias(Integer... value) {
        addEquals(EnsembleColumns.NBMEDIAS, value);
        return this;
    }

    public EnsembleSelection nbmediasNot(Integer... value) {
        addNotEquals(EnsembleColumns.NBMEDIAS, value);
        return this;
    }

    public EnsembleSelection nbmediasGt(int value) {
        addGreaterThan(EnsembleColumns.NBMEDIAS, value);
        return this;
    }

    public EnsembleSelection nbmediasGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.NBMEDIAS, value);
        return this;
    }

    public EnsembleSelection nbmediasLt(int value) {
        addLessThan(EnsembleColumns.NBMEDIAS, value);
        return this;
    }

    public EnsembleSelection nbmediasLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.NBMEDIAS, value);
        return this;
    }

    public EnsembleSelection orderByNbmedias(boolean desc) {
        orderBy(EnsembleColumns.NBMEDIAS, desc);
        return this;
    }

    public EnsembleSelection orderByNbmedias() {
        orderBy(EnsembleColumns.NBMEDIAS, false);
        return this;
    }

    public EnsembleSelection nbplansimpl(Integer... value) {
        addEquals(EnsembleColumns.NBPLANSIMPL, value);
        return this;
    }

    public EnsembleSelection nbplansimplNot(Integer... value) {
        addNotEquals(EnsembleColumns.NBPLANSIMPL, value);
        return this;
    }

    public EnsembleSelection nbplansimplGt(int value) {
        addGreaterThan(EnsembleColumns.NBPLANSIMPL, value);
        return this;
    }

    public EnsembleSelection nbplansimplGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.NBPLANSIMPL, value);
        return this;
    }

    public EnsembleSelection nbplansimplLt(int value) {
        addLessThan(EnsembleColumns.NBPLANSIMPL, value);
        return this;
    }

    public EnsembleSelection nbplansimplLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.NBPLANSIMPL, value);
        return this;
    }

    public EnsembleSelection orderByNbplansimpl(boolean desc) {
        orderBy(EnsembleColumns.NBPLANSIMPL, desc);
        return this;
    }

    public EnsembleSelection orderByNbplansimpl() {
        orderBy(EnsembleColumns.NBPLANSIMPL, false);
        return this;
    }

    public EnsembleSelection dtdebnouveau(Date... value) {
        addEquals(EnsembleColumns.DTDEBNOUVEAU, value);
        return this;
    }

    public EnsembleSelection dtdebnouveauNot(Date... value) {
        addNotEquals(EnsembleColumns.DTDEBNOUVEAU, value);
        return this;
    }

    public EnsembleSelection dtdebnouveau(Long... value) {
        addEquals(EnsembleColumns.DTDEBNOUVEAU, value);
        return this;
    }

    public EnsembleSelection dtdebnouveauAfter(Date value) {
        addGreaterThan(EnsembleColumns.DTDEBNOUVEAU, value);
        return this;
    }

    public EnsembleSelection dtdebnouveauAfterEq(Date value) {
        addGreaterThanOrEquals(EnsembleColumns.DTDEBNOUVEAU, value);
        return this;
    }

    public EnsembleSelection dtdebnouveauBefore(Date value) {
        addLessThan(EnsembleColumns.DTDEBNOUVEAU, value);
        return this;
    }

    public EnsembleSelection dtdebnouveauBeforeEq(Date value) {
        addLessThanOrEquals(EnsembleColumns.DTDEBNOUVEAU, value);
        return this;
    }

    public EnsembleSelection orderByDtdebnouveau(boolean desc) {
        orderBy(EnsembleColumns.DTDEBNOUVEAU, desc);
        return this;
    }

    public EnsembleSelection orderByDtdebnouveau() {
        orderBy(EnsembleColumns.DTDEBNOUVEAU, false);
        return this;
    }

    public EnsembleSelection dtdebremise(Date... value) {
        addEquals(EnsembleColumns.DTDEBREMISE, value);
        return this;
    }

    public EnsembleSelection dtdebremiseNot(Date... value) {
        addNotEquals(EnsembleColumns.DTDEBREMISE, value);
        return this;
    }

    public EnsembleSelection dtdebremise(Long... value) {
        addEquals(EnsembleColumns.DTDEBREMISE, value);
        return this;
    }

    public EnsembleSelection dtdebremiseAfter(Date value) {
        addGreaterThan(EnsembleColumns.DTDEBREMISE, value);
        return this;
    }

    public EnsembleSelection dtdebremiseAfterEq(Date value) {
        addGreaterThanOrEquals(EnsembleColumns.DTDEBREMISE, value);
        return this;
    }

    public EnsembleSelection dtdebremiseBefore(Date value) {
        addLessThan(EnsembleColumns.DTDEBREMISE, value);
        return this;
    }

    public EnsembleSelection dtdebremiseBeforeEq(Date value) {
        addLessThanOrEquals(EnsembleColumns.DTDEBREMISE, value);
        return this;
    }

    public EnsembleSelection orderByDtdebremise(boolean desc) {
        orderBy(EnsembleColumns.DTDEBREMISE, desc);
        return this;
    }

    public EnsembleSelection orderByDtdebremise() {
        orderBy(EnsembleColumns.DTDEBREMISE, false);
        return this;
    }

    public EnsembleSelection dtfinnouveau(Date... value) {
        addEquals(EnsembleColumns.DTFINNOUVEAU, value);
        return this;
    }

    public EnsembleSelection dtfinnouveauNot(Date... value) {
        addNotEquals(EnsembleColumns.DTFINNOUVEAU, value);
        return this;
    }

    public EnsembleSelection dtfinnouveau(Long... value) {
        addEquals(EnsembleColumns.DTFINNOUVEAU, value);
        return this;
    }

    public EnsembleSelection dtfinnouveauAfter(Date value) {
        addGreaterThan(EnsembleColumns.DTFINNOUVEAU, value);
        return this;
    }

    public EnsembleSelection dtfinnouveauAfterEq(Date value) {
        addGreaterThanOrEquals(EnsembleColumns.DTFINNOUVEAU, value);
        return this;
    }

    public EnsembleSelection dtfinnouveauBefore(Date value) {
        addLessThan(EnsembleColumns.DTFINNOUVEAU, value);
        return this;
    }

    public EnsembleSelection dtfinnouveauBeforeEq(Date value) {
        addLessThanOrEquals(EnsembleColumns.DTFINNOUVEAU, value);
        return this;
    }

    public EnsembleSelection orderByDtfinnouveau(boolean desc) {
        orderBy(EnsembleColumns.DTFINNOUVEAU, desc);
        return this;
    }

    public EnsembleSelection orderByDtfinnouveau() {
        orderBy(EnsembleColumns.DTFINNOUVEAU, false);
        return this;
    }

    public EnsembleSelection dtfinporteouverte(Date... value) {
        addEquals(EnsembleColumns.DTFINPORTEOUVERTE, value);
        return this;
    }

    public EnsembleSelection dtfinporteouverteNot(Date... value) {
        addNotEquals(EnsembleColumns.DTFINPORTEOUVERTE, value);
        return this;
    }

    public EnsembleSelection dtfinporteouverte(Long... value) {
        addEquals(EnsembleColumns.DTFINPORTEOUVERTE, value);
        return this;
    }

    public EnsembleSelection dtfinporteouverteAfter(Date value) {
        addGreaterThan(EnsembleColumns.DTFINPORTEOUVERTE, value);
        return this;
    }

    public EnsembleSelection dtfinporteouverteAfterEq(Date value) {
        addGreaterThanOrEquals(EnsembleColumns.DTFINPORTEOUVERTE, value);
        return this;
    }

    public EnsembleSelection dtfinporteouverteBefore(Date value) {
        addLessThan(EnsembleColumns.DTFINPORTEOUVERTE, value);
        return this;
    }

    public EnsembleSelection dtfinporteouverteBeforeEq(Date value) {
        addLessThanOrEquals(EnsembleColumns.DTFINPORTEOUVERTE, value);
        return this;
    }

    public EnsembleSelection orderByDtfinporteouverte(boolean desc) {
        orderBy(EnsembleColumns.DTFINPORTEOUVERTE, desc);
        return this;
    }

    public EnsembleSelection orderByDtfinporteouverte() {
        orderBy(EnsembleColumns.DTFINPORTEOUVERTE, false);
        return this;
    }

    public EnsembleSelection dtfinremise(Date... value) {
        addEquals(EnsembleColumns.DTFINREMISE, value);
        return this;
    }

    public EnsembleSelection dtfinremiseNot(Date... value) {
        addNotEquals(EnsembleColumns.DTFINREMISE, value);
        return this;
    }

    public EnsembleSelection dtfinremise(Long... value) {
        addEquals(EnsembleColumns.DTFINREMISE, value);
        return this;
    }

    public EnsembleSelection dtfinremiseAfter(Date value) {
        addGreaterThan(EnsembleColumns.DTFINREMISE, value);
        return this;
    }

    public EnsembleSelection dtfinremiseAfterEq(Date value) {
        addGreaterThanOrEquals(EnsembleColumns.DTFINREMISE, value);
        return this;
    }

    public EnsembleSelection dtfinremiseBefore(Date value) {
        addLessThan(EnsembleColumns.DTFINREMISE, value);
        return this;
    }

    public EnsembleSelection dtfinremiseBeforeEq(Date value) {
        addLessThanOrEquals(EnsembleColumns.DTFINREMISE, value);
        return this;
    }

    public EnsembleSelection orderByDtfinremise(boolean desc) {
        orderBy(EnsembleColumns.DTFINREMISE, desc);
        return this;
    }

    public EnsembleSelection orderByDtfinremise() {
        orderBy(EnsembleColumns.DTFINREMISE, false);
        return this;
    }

    public EnsembleSelection infoporteouverte(String... value) {
        addEquals(EnsembleColumns.INFOPORTEOUVERTE, value);
        return this;
    }

    public EnsembleSelection infoporteouverteNot(String... value) {
        addNotEquals(EnsembleColumns.INFOPORTEOUVERTE, value);
        return this;
    }

    public EnsembleSelection infoporteouverteLike(String... value) {
        addLike(EnsembleColumns.INFOPORTEOUVERTE, value);
        return this;
    }

    public EnsembleSelection infoporteouverteContains(String... value) {
        addContains(EnsembleColumns.INFOPORTEOUVERTE, value);
        return this;
    }

    public EnsembleSelection infoporteouverteStartsWith(String... value) {
        addStartsWith(EnsembleColumns.INFOPORTEOUVERTE, value);
        return this;
    }

    public EnsembleSelection infoporteouverteEndsWith(String... value) {
        addEndsWith(EnsembleColumns.INFOPORTEOUVERTE, value);
        return this;
    }

    public EnsembleSelection orderByInfoporteouverte(boolean desc) {
        orderBy(EnsembleColumns.INFOPORTEOUVERTE, desc);
        return this;
    }

    public EnsembleSelection orderByInfoporteouverte() {
        orderBy(EnsembleColumns.INFOPORTEOUVERTE, false);
        return this;
    }

    public EnsembleSelection libelleremise(String... value) {
        addEquals(EnsembleColumns.LIBELLEREMISE, value);
        return this;
    }

    public EnsembleSelection libelleremiseNot(String... value) {
        addNotEquals(EnsembleColumns.LIBELLEREMISE, value);
        return this;
    }

    public EnsembleSelection libelleremiseLike(String... value) {
        addLike(EnsembleColumns.LIBELLEREMISE, value);
        return this;
    }

    public EnsembleSelection libelleremiseContains(String... value) {
        addContains(EnsembleColumns.LIBELLEREMISE, value);
        return this;
    }

    public EnsembleSelection libelleremiseStartsWith(String... value) {
        addStartsWith(EnsembleColumns.LIBELLEREMISE, value);
        return this;
    }

    public EnsembleSelection libelleremiseEndsWith(String... value) {
        addEndsWith(EnsembleColumns.LIBELLEREMISE, value);
        return this;
    }

    public EnsembleSelection orderByLibelleremise(boolean desc) {
        orderBy(EnsembleColumns.LIBELLEREMISE, desc);
        return this;
    }

    public EnsembleSelection orderByLibelleremise() {
        orderBy(EnsembleColumns.LIBELLEREMISE, false);
        return this;
    }

    public EnsembleSelection nbtriplex(Integer... value) {
        addEquals(EnsembleColumns.NBTRIPLEX, value);
        return this;
    }

    public EnsembleSelection nbtriplexNot(Integer... value) {
        addNotEquals(EnsembleColumns.NBTRIPLEX, value);
        return this;
    }

    public EnsembleSelection nbtriplexGt(int value) {
        addGreaterThan(EnsembleColumns.NBTRIPLEX, value);
        return this;
    }

    public EnsembleSelection nbtriplexGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.NBTRIPLEX, value);
        return this;
    }

    public EnsembleSelection nbtriplexLt(int value) {
        addLessThan(EnsembleColumns.NBTRIPLEX, value);
        return this;
    }

    public EnsembleSelection nbtriplexLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.NBTRIPLEX, value);
        return this;
    }

    public EnsembleSelection orderByNbtriplex(boolean desc) {
        orderBy(EnsembleColumns.NBTRIPLEX, desc);
        return this;
    }

    public EnsembleSelection orderByNbtriplex() {
        orderBy(EnsembleColumns.NBTRIPLEX, false);
        return this;
    }

    public EnsembleSelection nbquadriplex(Integer... value) {
        addEquals(EnsembleColumns.NBQUADRIPLEX, value);
        return this;
    }

    public EnsembleSelection nbquadriplexNot(Integer... value) {
        addNotEquals(EnsembleColumns.NBQUADRIPLEX, value);
        return this;
    }

    public EnsembleSelection nbquadriplexGt(int value) {
        addGreaterThan(EnsembleColumns.NBQUADRIPLEX, value);
        return this;
    }

    public EnsembleSelection nbquadriplexGtEq(int value) {
        addGreaterThanOrEquals(EnsembleColumns.NBQUADRIPLEX, value);
        return this;
    }

    public EnsembleSelection nbquadriplexLt(int value) {
        addLessThan(EnsembleColumns.NBQUADRIPLEX, value);
        return this;
    }

    public EnsembleSelection nbquadriplexLtEq(int value) {
        addLessThanOrEquals(EnsembleColumns.NBQUADRIPLEX, value);
        return this;
    }

    public EnsembleSelection orderByNbquadriplex(boolean desc) {
        orderBy(EnsembleColumns.NBQUADRIPLEX, desc);
        return this;
    }

    public EnsembleSelection orderByNbquadriplex() {
        orderBy(EnsembleColumns.NBQUADRIPLEX, false);
        return this;
    }
}
