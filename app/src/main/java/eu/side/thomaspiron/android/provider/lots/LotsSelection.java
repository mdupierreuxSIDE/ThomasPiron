package eu.side.thomaspiron.android.provider.lots;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

import eu.side.thomaspiron.android.provider.base.AbstractSelection;

/**
 * Selection for the {@code lots} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class LotsSelection extends AbstractSelection<LotsSelection> {
    @Override
    protected Uri baseUri() {
        return LotsColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code LotsCursor} object, which is positioned before the first entry, or null.
     */
    public LotsCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new LotsCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public LotsCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code LotsCursor} object, which is positioned before the first entry, or null.
     */
    public LotsCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new LotsCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public LotsCursor query(Context context) {
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
                return new LotsCursor(super.loadInBackground());
            }
        };
    }


    public LotsSelection id(long... value) {
        addEquals("lots." + LotsColumns._ID, toObjectArray(value));
        return this;
    }

    public LotsSelection idNot(long... value) {
        addNotEquals("lots." + LotsColumns._ID, toObjectArray(value));
        return this;
    }

    public LotsSelection orderById(boolean desc) {
        orderBy("lots." + LotsColumns._ID, desc);
        return this;
    }

    public LotsSelection orderById() {
        return orderById(false);
    }

    public LotsSelection lotdesc(String... value) {
        addEquals(LotsColumns.LOTDESC, value);
        return this;
    }

    public LotsSelection lotdescNot(String... value) {
        addNotEquals(LotsColumns.LOTDESC, value);
        return this;
    }

    public LotsSelection lotdescLike(String... value) {
        addLike(LotsColumns.LOTDESC, value);
        return this;
    }

    public LotsSelection lotdescContains(String... value) {
        addContains(LotsColumns.LOTDESC, value);
        return this;
    }

    public LotsSelection lotdescStartsWith(String... value) {
        addStartsWith(LotsColumns.LOTDESC, value);
        return this;
    }

    public LotsSelection lotdescEndsWith(String... value) {
        addEndsWith(LotsColumns.LOTDESC, value);
        return this;
    }

    public LotsSelection orderByLotdesc(boolean desc) {
        orderBy(LotsColumns.LOTDESC, desc);
        return this;
    }

    public LotsSelection orderByLotdesc() {
        orderBy(LotsColumns.LOTDESC, false);
        return this;
    }

    public LotsSelection cptepl(String... value) {
        addEquals(LotsColumns.CPTEPL, value);
        return this;
    }

    public LotsSelection cpteplNot(String... value) {
        addNotEquals(LotsColumns.CPTEPL, value);
        return this;
    }

    public LotsSelection cpteplLike(String... value) {
        addLike(LotsColumns.CPTEPL, value);
        return this;
    }

    public LotsSelection cpteplContains(String... value) {
        addContains(LotsColumns.CPTEPL, value);
        return this;
    }

    public LotsSelection cpteplStartsWith(String... value) {
        addStartsWith(LotsColumns.CPTEPL, value);
        return this;
    }

    public LotsSelection cpteplEndsWith(String... value) {
        addEndsWith(LotsColumns.CPTEPL, value);
        return this;
    }

    public LotsSelection orderByCptepl(boolean desc) {
        orderBy(LotsColumns.CPTEPL, desc);
        return this;
    }

    public LotsSelection orderByCptepl() {
        orderBy(LotsColumns.CPTEPL, false);
        return this;
    }

    public LotsSelection jardin(String... value) {
        addEquals(LotsColumns.JARDIN, value);
        return this;
    }

    public LotsSelection jardinNot(String... value) {
        addNotEquals(LotsColumns.JARDIN, value);
        return this;
    }

    public LotsSelection jardinLike(String... value) {
        addLike(LotsColumns.JARDIN, value);
        return this;
    }

    public LotsSelection jardinContains(String... value) {
        addContains(LotsColumns.JARDIN, value);
        return this;
    }

    public LotsSelection jardinStartsWith(String... value) {
        addStartsWith(LotsColumns.JARDIN, value);
        return this;
    }

    public LotsSelection jardinEndsWith(String... value) {
        addEndsWith(LotsColumns.JARDIN, value);
        return this;
    }

    public LotsSelection orderByJardin(boolean desc) {
        orderBy(LotsColumns.JARDIN, desc);
        return this;
    }

    public LotsSelection orderByJardin() {
        orderBy(LotsColumns.JARDIN, false);
        return this;
    }

    public LotsSelection balcon(String... value) {
        addEquals(LotsColumns.BALCON, value);
        return this;
    }

    public LotsSelection balconNot(String... value) {
        addNotEquals(LotsColumns.BALCON, value);
        return this;
    }

    public LotsSelection balconLike(String... value) {
        addLike(LotsColumns.BALCON, value);
        return this;
    }

    public LotsSelection balconContains(String... value) {
        addContains(LotsColumns.BALCON, value);
        return this;
    }

    public LotsSelection balconStartsWith(String... value) {
        addStartsWith(LotsColumns.BALCON, value);
        return this;
    }

    public LotsSelection balconEndsWith(String... value) {
        addEndsWith(LotsColumns.BALCON, value);
        return this;
    }

    public LotsSelection orderByBalcon(boolean desc) {
        orderBy(LotsColumns.BALCON, desc);
        return this;
    }

    public LotsSelection orderByBalcon() {
        orderBy(LotsColumns.BALCON, false);
        return this;
    }

    public LotsSelection chambres(String... value) {
        addEquals(LotsColumns.CHAMBRES, value);
        return this;
    }

    public LotsSelection chambresNot(String... value) {
        addNotEquals(LotsColumns.CHAMBRES, value);
        return this;
    }

    public LotsSelection chambresLike(String... value) {
        addLike(LotsColumns.CHAMBRES, value);
        return this;
    }

    public LotsSelection chambresContains(String... value) {
        addContains(LotsColumns.CHAMBRES, value);
        return this;
    }

    public LotsSelection chambresStartsWith(String... value) {
        addStartsWith(LotsColumns.CHAMBRES, value);
        return this;
    }

    public LotsSelection chambresEndsWith(String... value) {
        addEndsWith(LotsColumns.CHAMBRES, value);
        return this;
    }

    public LotsSelection orderByChambres(boolean desc) {
        orderBy(LotsColumns.CHAMBRES, desc);
        return this;
    }

    public LotsSelection orderByChambres() {
        orderBy(LotsColumns.CHAMBRES, false);
        return this;
    }

    public LotsSelection facadesnbr(String... value) {
        addEquals(LotsColumns.FACADESNBR, value);
        return this;
    }

    public LotsSelection facadesnbrNot(String... value) {
        addNotEquals(LotsColumns.FACADESNBR, value);
        return this;
    }

    public LotsSelection facadesnbrLike(String... value) {
        addLike(LotsColumns.FACADESNBR, value);
        return this;
    }

    public LotsSelection facadesnbrContains(String... value) {
        addContains(LotsColumns.FACADESNBR, value);
        return this;
    }

    public LotsSelection facadesnbrStartsWith(String... value) {
        addStartsWith(LotsColumns.FACADESNBR, value);
        return this;
    }

    public LotsSelection facadesnbrEndsWith(String... value) {
        addEndsWith(LotsColumns.FACADESNBR, value);
        return this;
    }

    public LotsSelection orderByFacadesnbr(boolean desc) {
        orderBy(LotsColumns.FACADESNBR, desc);
        return this;
    }

    public LotsSelection orderByFacadesnbr() {
        orderBy(LotsColumns.FACADESNBR, false);
        return this;
    }

    public LotsSelection orientation(String... value) {
        addEquals(LotsColumns.ORIENTATION, value);
        return this;
    }

    public LotsSelection orientationNot(String... value) {
        addNotEquals(LotsColumns.ORIENTATION, value);
        return this;
    }

    public LotsSelection orientationLike(String... value) {
        addLike(LotsColumns.ORIENTATION, value);
        return this;
    }

    public LotsSelection orientationContains(String... value) {
        addContains(LotsColumns.ORIENTATION, value);
        return this;
    }

    public LotsSelection orientationStartsWith(String... value) {
        addStartsWith(LotsColumns.ORIENTATION, value);
        return this;
    }

    public LotsSelection orientationEndsWith(String... value) {
        addEndsWith(LotsColumns.ORIENTATION, value);
        return this;
    }

    public LotsSelection orderByOrientation(boolean desc) {
        orderBy(LotsColumns.ORIENTATION, desc);
        return this;
    }

    public LotsSelection orderByOrientation() {
        orderBy(LotsColumns.ORIENTATION, false);
        return this;
    }

    public LotsSelection statutlot(String... value) {
        addEquals(LotsColumns.STATUTLOT, value);
        return this;
    }

    public LotsSelection statutlotNot(String... value) {
        addNotEquals(LotsColumns.STATUTLOT, value);
        return this;
    }

    public LotsSelection statutlotLike(String... value) {
        addLike(LotsColumns.STATUTLOT, value);
        return this;
    }

    public LotsSelection statutlotContains(String... value) {
        addContains(LotsColumns.STATUTLOT, value);
        return this;
    }

    public LotsSelection statutlotStartsWith(String... value) {
        addStartsWith(LotsColumns.STATUTLOT, value);
        return this;
    }

    public LotsSelection statutlotEndsWith(String... value) {
        addEndsWith(LotsColumns.STATUTLOT, value);
        return this;
    }

    public LotsSelection orderByStatutlot(boolean desc) {
        orderBy(LotsColumns.STATUTLOT, desc);
        return this;
    }

    public LotsSelection orderByStatutlot() {
        orderBy(LotsColumns.STATUTLOT, false);
        return this;
    }

    public LotsSelection surfter(String... value) {
        addEquals(LotsColumns.SURFTER, value);
        return this;
    }

    public LotsSelection surfterNot(String... value) {
        addNotEquals(LotsColumns.SURFTER, value);
        return this;
    }

    public LotsSelection surfterLike(String... value) {
        addLike(LotsColumns.SURFTER, value);
        return this;
    }

    public LotsSelection surfterContains(String... value) {
        addContains(LotsColumns.SURFTER, value);
        return this;
    }

    public LotsSelection surfterStartsWith(String... value) {
        addStartsWith(LotsColumns.SURFTER, value);
        return this;
    }

    public LotsSelection surfterEndsWith(String... value) {
        addEndsWith(LotsColumns.SURFTER, value);
        return this;
    }

    public LotsSelection orderBySurfter(boolean desc) {
        orderBy(LotsColumns.SURFTER, desc);
        return this;
    }

    public LotsSelection orderBySurfter() {
        orderBy(LotsColumns.SURFTER, false);
        return this;
    }

    public LotsSelection surfhab(String... value) {
        addEquals(LotsColumns.SURFHAB, value);
        return this;
    }

    public LotsSelection surfhabNot(String... value) {
        addNotEquals(LotsColumns.SURFHAB, value);
        return this;
    }

    public LotsSelection surfhabLike(String... value) {
        addLike(LotsColumns.SURFHAB, value);
        return this;
    }

    public LotsSelection surfhabContains(String... value) {
        addContains(LotsColumns.SURFHAB, value);
        return this;
    }

    public LotsSelection surfhabStartsWith(String... value) {
        addStartsWith(LotsColumns.SURFHAB, value);
        return this;
    }

    public LotsSelection surfhabEndsWith(String... value) {
        addEndsWith(LotsColumns.SURFHAB, value);
        return this;
    }

    public LotsSelection orderBySurfhab(boolean desc) {
        orderBy(LotsColumns.SURFHAB, desc);
        return this;
    }

    public LotsSelection orderBySurfhab() {
        orderBy(LotsColumns.SURFHAB, false);
        return this;
    }

    public LotsSelection codeetage(String... value) {
        addEquals(LotsColumns.CODEETAGE, value);
        return this;
    }

    public LotsSelection codeetageNot(String... value) {
        addNotEquals(LotsColumns.CODEETAGE, value);
        return this;
    }

    public LotsSelection codeetageLike(String... value) {
        addLike(LotsColumns.CODEETAGE, value);
        return this;
    }

    public LotsSelection codeetageContains(String... value) {
        addContains(LotsColumns.CODEETAGE, value);
        return this;
    }

    public LotsSelection codeetageStartsWith(String... value) {
        addStartsWith(LotsColumns.CODEETAGE, value);
        return this;
    }

    public LotsSelection codeetageEndsWith(String... value) {
        addEndsWith(LotsColumns.CODEETAGE, value);
        return this;
    }

    public LotsSelection orderByCodeetage(boolean desc) {
        orderBy(LotsColumns.CODEETAGE, desc);
        return this;
    }

    public LotsSelection orderByCodeetage() {
        orderBy(LotsColumns.CODEETAGE, false);
        return this;
    }

    public LotsSelection libellefr(String... value) {
        addEquals(LotsColumns.LIBELLEFR, value);
        return this;
    }

    public LotsSelection libellefrNot(String... value) {
        addNotEquals(LotsColumns.LIBELLEFR, value);
        return this;
    }

    public LotsSelection libellefrLike(String... value) {
        addLike(LotsColumns.LIBELLEFR, value);
        return this;
    }

    public LotsSelection libellefrContains(String... value) {
        addContains(LotsColumns.LIBELLEFR, value);
        return this;
    }

    public LotsSelection libellefrStartsWith(String... value) {
        addStartsWith(LotsColumns.LIBELLEFR, value);
        return this;
    }

    public LotsSelection libellefrEndsWith(String... value) {
        addEndsWith(LotsColumns.LIBELLEFR, value);
        return this;
    }

    public LotsSelection orderByLibellefr(boolean desc) {
        orderBy(LotsColumns.LIBELLEFR, desc);
        return this;
    }

    public LotsSelection orderByLibellefr() {
        orderBy(LotsColumns.LIBELLEFR, false);
        return this;
    }

    public LotsSelection ensecode(String... value) {
        addEquals(LotsColumns.ENSECODE, value);
        return this;
    }

    public LotsSelection ensecodeNot(String... value) {
        addNotEquals(LotsColumns.ENSECODE, value);
        return this;
    }

    public LotsSelection ensecodeLike(String... value) {
        addLike(LotsColumns.ENSECODE, value);
        return this;
    }

    public LotsSelection ensecodeContains(String... value) {
        addContains(LotsColumns.ENSECODE, value);
        return this;
    }

    public LotsSelection ensecodeStartsWith(String... value) {
        addStartsWith(LotsColumns.ENSECODE, value);
        return this;
    }

    public LotsSelection ensecodeEndsWith(String... value) {
        addEndsWith(LotsColumns.ENSECODE, value);
        return this;
    }

    public LotsSelection orderByEnsecode(boolean desc) {
        orderBy(LotsColumns.ENSECODE, desc);
        return this;
    }

    public LotsSelection orderByEnsecode() {
        orderBy(LotsColumns.ENSECODE, false);
        return this;
    }

    public LotsSelection socicode(String... value) {
        addEquals(LotsColumns.SOCICODE, value);
        return this;
    }

    public LotsSelection socicodeNot(String... value) {
        addNotEquals(LotsColumns.SOCICODE, value);
        return this;
    }

    public LotsSelection socicodeLike(String... value) {
        addLike(LotsColumns.SOCICODE, value);
        return this;
    }

    public LotsSelection socicodeContains(String... value) {
        addContains(LotsColumns.SOCICODE, value);
        return this;
    }

    public LotsSelection socicodeStartsWith(String... value) {
        addStartsWith(LotsColumns.SOCICODE, value);
        return this;
    }

    public LotsSelection socicodeEndsWith(String... value) {
        addEndsWith(LotsColumns.SOCICODE, value);
        return this;
    }

    public LotsSelection orderBySocicode(boolean desc) {
        orderBy(LotsColumns.SOCICODE, desc);
        return this;
    }

    public LotsSelection orderBySocicode() {
        orderBy(LotsColumns.SOCICODE, false);
        return this;
    }

    public LotsSelection pebclasseenergetique(String... value) {
        addEquals(LotsColumns.PEBCLASSEENERGETIQUE, value);
        return this;
    }

    public LotsSelection pebclasseenergetiqueNot(String... value) {
        addNotEquals(LotsColumns.PEBCLASSEENERGETIQUE, value);
        return this;
    }

    public LotsSelection pebclasseenergetiqueLike(String... value) {
        addLike(LotsColumns.PEBCLASSEENERGETIQUE, value);
        return this;
    }

    public LotsSelection pebclasseenergetiqueContains(String... value) {
        addContains(LotsColumns.PEBCLASSEENERGETIQUE, value);
        return this;
    }

    public LotsSelection pebclasseenergetiqueStartsWith(String... value) {
        addStartsWith(LotsColumns.PEBCLASSEENERGETIQUE, value);
        return this;
    }

    public LotsSelection pebclasseenergetiqueEndsWith(String... value) {
        addEndsWith(LotsColumns.PEBCLASSEENERGETIQUE, value);
        return this;
    }

    public LotsSelection orderByPebclasseenergetique(boolean desc) {
        orderBy(LotsColumns.PEBCLASSEENERGETIQUE, desc);
        return this;
    }

    public LotsSelection orderByPebclasseenergetique() {
        orderBy(LotsColumns.PEBCLASSEENERGETIQUE, false);
        return this;
    }

    public LotsSelection nbmedias(Integer... value) {
        addEquals(LotsColumns.NBMEDIAS, value);
        return this;
    }

    public LotsSelection nbmediasNot(Integer... value) {
        addNotEquals(LotsColumns.NBMEDIAS, value);
        return this;
    }

    public LotsSelection nbmediasGt(int value) {
        addGreaterThan(LotsColumns.NBMEDIAS, value);
        return this;
    }

    public LotsSelection nbmediasGtEq(int value) {
        addGreaterThanOrEquals(LotsColumns.NBMEDIAS, value);
        return this;
    }

    public LotsSelection nbmediasLt(int value) {
        addLessThan(LotsColumns.NBMEDIAS, value);
        return this;
    }

    public LotsSelection nbmediasLtEq(int value) {
        addLessThanOrEquals(LotsColumns.NBMEDIAS, value);
        return this;
    }

    public LotsSelection orderByNbmedias(boolean desc) {
        orderBy(LotsColumns.NBMEDIAS, desc);
        return this;
    }

    public LotsSelection orderByNbmedias() {
        orderBy(LotsColumns.NBMEDIAS, false);
        return this;
    }

    public LotsSelection nbplansimpl(Integer... value) {
        addEquals(LotsColumns.NBPLANSIMPL, value);
        return this;
    }

    public LotsSelection nbplansimplNot(Integer... value) {
        addNotEquals(LotsColumns.NBPLANSIMPL, value);
        return this;
    }

    public LotsSelection nbplansimplGt(int value) {
        addGreaterThan(LotsColumns.NBPLANSIMPL, value);
        return this;
    }

    public LotsSelection nbplansimplGtEq(int value) {
        addGreaterThanOrEquals(LotsColumns.NBPLANSIMPL, value);
        return this;
    }

    public LotsSelection nbplansimplLt(int value) {
        addLessThan(LotsColumns.NBPLANSIMPL, value);
        return this;
    }

    public LotsSelection nbplansimplLtEq(int value) {
        addLessThanOrEquals(LotsColumns.NBPLANSIMPL, value);
        return this;
    }

    public LotsSelection orderByNbplansimpl(boolean desc) {
        orderBy(LotsColumns.NBPLANSIMPL, desc);
        return this;
    }

    public LotsSelection orderByNbplansimpl() {
        orderBy(LotsColumns.NBPLANSIMPL, false);
        return this;
    }
}
