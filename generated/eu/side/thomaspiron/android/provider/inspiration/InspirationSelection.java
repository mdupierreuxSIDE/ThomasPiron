package eu.side.thomaspiron.android.provider.inspiration;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.CursorLoader;

import eu.side.thomaspiron.android.provider.base.AbstractSelection;

/**
 * Selection for the {@code inspiration} table.
 */
@SuppressWarnings({"unused", "WeakerAccess", "Recycle"})
public class InspirationSelection extends AbstractSelection<InspirationSelection> {
    @Override
    protected Uri baseUri() {
        return InspirationColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code InspirationCursor} object, which is positioned before the first entry, or null.
     */
    public InspirationCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new InspirationCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public InspirationCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code InspirationCursor} object, which is positioned before the first entry, or null.
     */
    public InspirationCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new InspirationCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public InspirationCursor query(Context context) {
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
                return new InspirationCursor(super.loadInBackground());
            }
        };
    }


    public InspirationSelection id(long... value) {
        addEquals("inspiration." + InspirationColumns._ID, toObjectArray(value));
        return this;
    }

    public InspirationSelection idNot(long... value) {
        addNotEquals("inspiration." + InspirationColumns._ID, toObjectArray(value));
        return this;
    }

    public InspirationSelection orderById(boolean desc) {
        orderBy("inspiration." + InspirationColumns._ID, desc);
        return this;
    }

    public InspirationSelection orderById() {
        return orderById(false);
    }

    public InspirationSelection date(String... value) {
        addEquals(InspirationColumns.DATE, value);
        return this;
    }

    public InspirationSelection dateNot(String... value) {
        addNotEquals(InspirationColumns.DATE, value);
        return this;
    }

    public InspirationSelection dateLike(String... value) {
        addLike(InspirationColumns.DATE, value);
        return this;
    }

    public InspirationSelection dateContains(String... value) {
        addContains(InspirationColumns.DATE, value);
        return this;
    }

    public InspirationSelection dateStartsWith(String... value) {
        addStartsWith(InspirationColumns.DATE, value);
        return this;
    }

    public InspirationSelection dateEndsWith(String... value) {
        addEndsWith(InspirationColumns.DATE, value);
        return this;
    }

    public InspirationSelection orderByDate(boolean desc) {
        orderBy(InspirationColumns.DATE, desc);
        return this;
    }

    public InspirationSelection orderByDate() {
        orderBy(InspirationColumns.DATE, false);
        return this;
    }

    public InspirationSelection numero(String... value) {
        addEquals(InspirationColumns.NUMERO, value);
        return this;
    }

    public InspirationSelection numeroNot(String... value) {
        addNotEquals(InspirationColumns.NUMERO, value);
        return this;
    }

    public InspirationSelection numeroLike(String... value) {
        addLike(InspirationColumns.NUMERO, value);
        return this;
    }

    public InspirationSelection numeroContains(String... value) {
        addContains(InspirationColumns.NUMERO, value);
        return this;
    }

    public InspirationSelection numeroStartsWith(String... value) {
        addStartsWith(InspirationColumns.NUMERO, value);
        return this;
    }

    public InspirationSelection numeroEndsWith(String... value) {
        addEndsWith(InspirationColumns.NUMERO, value);
        return this;
    }

    public InspirationSelection orderByNumero(boolean desc) {
        orderBy(InspirationColumns.NUMERO, desc);
        return this;
    }

    public InspirationSelection orderByNumero() {
        orderBy(InspirationColumns.NUMERO, false);
        return this;
    }

    public InspirationSelection numerosimplifie(String... value) {
        addEquals(InspirationColumns.NUMEROSIMPLIFIE, value);
        return this;
    }

    public InspirationSelection numerosimplifieNot(String... value) {
        addNotEquals(InspirationColumns.NUMEROSIMPLIFIE, value);
        return this;
    }

    public InspirationSelection numerosimplifieLike(String... value) {
        addLike(InspirationColumns.NUMEROSIMPLIFIE, value);
        return this;
    }

    public InspirationSelection numerosimplifieContains(String... value) {
        addContains(InspirationColumns.NUMEROSIMPLIFIE, value);
        return this;
    }

    public InspirationSelection numerosimplifieStartsWith(String... value) {
        addStartsWith(InspirationColumns.NUMEROSIMPLIFIE, value);
        return this;
    }

    public InspirationSelection numerosimplifieEndsWith(String... value) {
        addEndsWith(InspirationColumns.NUMEROSIMPLIFIE, value);
        return this;
    }

    public InspirationSelection orderByNumerosimplifie(boolean desc) {
        orderBy(InspirationColumns.NUMEROSIMPLIFIE, desc);
        return this;
    }

    public InspirationSelection orderByNumerosimplifie() {
        orderBy(InspirationColumns.NUMEROSIMPLIFIE, false);
        return this;
    }

    public InspirationSelection client(String... value) {
        addEquals(InspirationColumns.CLIENT, value);
        return this;
    }

    public InspirationSelection clientNot(String... value) {
        addNotEquals(InspirationColumns.CLIENT, value);
        return this;
    }

    public InspirationSelection clientLike(String... value) {
        addLike(InspirationColumns.CLIENT, value);
        return this;
    }

    public InspirationSelection clientContains(String... value) {
        addContains(InspirationColumns.CLIENT, value);
        return this;
    }

    public InspirationSelection clientStartsWith(String... value) {
        addStartsWith(InspirationColumns.CLIENT, value);
        return this;
    }

    public InspirationSelection clientEndsWith(String... value) {
        addEndsWith(InspirationColumns.CLIENT, value);
        return this;
    }

    public InspirationSelection orderByClient(boolean desc) {
        orderBy(InspirationColumns.CLIENT, desc);
        return this;
    }

    public InspirationSelection orderByClient() {
        orderBy(InspirationColumns.CLIENT, false);
        return this;
    }

    public InspirationSelection prix(Double... value) {
        addEquals(InspirationColumns.PRIX, value);
        return this;
    }

    public InspirationSelection prixNot(Double... value) {
        addNotEquals(InspirationColumns.PRIX, value);
        return this;
    }

    public InspirationSelection prixGt(double value) {
        addGreaterThan(InspirationColumns.PRIX, value);
        return this;
    }

    public InspirationSelection prixGtEq(double value) {
        addGreaterThanOrEquals(InspirationColumns.PRIX, value);
        return this;
    }

    public InspirationSelection prixLt(double value) {
        addLessThan(InspirationColumns.PRIX, value);
        return this;
    }

    public InspirationSelection prixLtEq(double value) {
        addLessThanOrEquals(InspirationColumns.PRIX, value);
        return this;
    }

    public InspirationSelection orderByPrix(boolean desc) {
        orderBy(InspirationColumns.PRIX, desc);
        return this;
    }

    public InspirationSelection orderByPrix() {
        orderBy(InspirationColumns.PRIX, false);
        return this;
    }

    public InspirationSelection topographie(String... value) {
        addEquals(InspirationColumns.TOPOGRAPHIE, value);
        return this;
    }

    public InspirationSelection topographieNot(String... value) {
        addNotEquals(InspirationColumns.TOPOGRAPHIE, value);
        return this;
    }

    public InspirationSelection topographieLike(String... value) {
        addLike(InspirationColumns.TOPOGRAPHIE, value);
        return this;
    }

    public InspirationSelection topographieContains(String... value) {
        addContains(InspirationColumns.TOPOGRAPHIE, value);
        return this;
    }

    public InspirationSelection topographieStartsWith(String... value) {
        addStartsWith(InspirationColumns.TOPOGRAPHIE, value);
        return this;
    }

    public InspirationSelection topographieEndsWith(String... value) {
        addEndsWith(InspirationColumns.TOPOGRAPHIE, value);
        return this;
    }

    public InspirationSelection orderByTopographie(boolean desc) {
        orderBy(InspirationColumns.TOPOGRAPHIE, desc);
        return this;
    }

    public InspirationSelection orderByTopographie() {
        orderBy(InspirationColumns.TOPOGRAPHIE, false);
        return this;
    }

    public InspirationSelection garage(String... value) {
        addEquals(InspirationColumns.GARAGE, value);
        return this;
    }

    public InspirationSelection garageNot(String... value) {
        addNotEquals(InspirationColumns.GARAGE, value);
        return this;
    }

    public InspirationSelection garageLike(String... value) {
        addLike(InspirationColumns.GARAGE, value);
        return this;
    }

    public InspirationSelection garageContains(String... value) {
        addContains(InspirationColumns.GARAGE, value);
        return this;
    }

    public InspirationSelection garageStartsWith(String... value) {
        addStartsWith(InspirationColumns.GARAGE, value);
        return this;
    }

    public InspirationSelection garageEndsWith(String... value) {
        addEndsWith(InspirationColumns.GARAGE, value);
        return this;
    }

    public InspirationSelection orderByGarage(boolean desc) {
        orderBy(InspirationColumns.GARAGE, desc);
        return this;
    }

    public InspirationSelection orderByGarage() {
        orderBy(InspirationColumns.GARAGE, false);
        return this;
    }

    public InspirationSelection carport(String... value) {
        addEquals(InspirationColumns.CARPORT, value);
        return this;
    }

    public InspirationSelection carportNot(String... value) {
        addNotEquals(InspirationColumns.CARPORT, value);
        return this;
    }

    public InspirationSelection carportLike(String... value) {
        addLike(InspirationColumns.CARPORT, value);
        return this;
    }

    public InspirationSelection carportContains(String... value) {
        addContains(InspirationColumns.CARPORT, value);
        return this;
    }

    public InspirationSelection carportStartsWith(String... value) {
        addStartsWith(InspirationColumns.CARPORT, value);
        return this;
    }

    public InspirationSelection carportEndsWith(String... value) {
        addEndsWith(InspirationColumns.CARPORT, value);
        return this;
    }

    public InspirationSelection orderByCarport(boolean desc) {
        orderBy(InspirationColumns.CARPORT, desc);
        return this;
    }

    public InspirationSelection orderByCarport() {
        orderBy(InspirationColumns.CARPORT, false);
        return this;
    }

    public InspirationSelection cave(String... value) {
        addEquals(InspirationColumns.CAVE, value);
        return this;
    }

    public InspirationSelection caveNot(String... value) {
        addNotEquals(InspirationColumns.CAVE, value);
        return this;
    }

    public InspirationSelection caveLike(String... value) {
        addLike(InspirationColumns.CAVE, value);
        return this;
    }

    public InspirationSelection caveContains(String... value) {
        addContains(InspirationColumns.CAVE, value);
        return this;
    }

    public InspirationSelection caveStartsWith(String... value) {
        addStartsWith(InspirationColumns.CAVE, value);
        return this;
    }

    public InspirationSelection caveEndsWith(String... value) {
        addEndsWith(InspirationColumns.CAVE, value);
        return this;
    }

    public InspirationSelection orderByCave(boolean desc) {
        orderBy(InspirationColumns.CAVE, desc);
        return this;
    }

    public InspirationSelection orderByCave() {
        orderBy(InspirationColumns.CAVE, false);
        return this;
    }

    public InspirationSelection pro(String... value) {
        addEquals(InspirationColumns.PRO, value);
        return this;
    }

    public InspirationSelection proNot(String... value) {
        addNotEquals(InspirationColumns.PRO, value);
        return this;
    }

    public InspirationSelection proLike(String... value) {
        addLike(InspirationColumns.PRO, value);
        return this;
    }

    public InspirationSelection proContains(String... value) {
        addContains(InspirationColumns.PRO, value);
        return this;
    }

    public InspirationSelection proStartsWith(String... value) {
        addStartsWith(InspirationColumns.PRO, value);
        return this;
    }

    public InspirationSelection proEndsWith(String... value) {
        addEndsWith(InspirationColumns.PRO, value);
        return this;
    }

    public InspirationSelection orderByPro(boolean desc) {
        orderBy(InspirationColumns.PRO, desc);
        return this;
    }

    public InspirationSelection orderByPro() {
        orderBy(InspirationColumns.PRO, false);
        return this;
    }

    public InspirationSelection parement(String... value) {
        addEquals(InspirationColumns.PAREMENT, value);
        return this;
    }

    public InspirationSelection parementNot(String... value) {
        addNotEquals(InspirationColumns.PAREMENT, value);
        return this;
    }

    public InspirationSelection parementLike(String... value) {
        addLike(InspirationColumns.PAREMENT, value);
        return this;
    }

    public InspirationSelection parementContains(String... value) {
        addContains(InspirationColumns.PAREMENT, value);
        return this;
    }

    public InspirationSelection parementStartsWith(String... value) {
        addStartsWith(InspirationColumns.PAREMENT, value);
        return this;
    }

    public InspirationSelection parementEndsWith(String... value) {
        addEndsWith(InspirationColumns.PAREMENT, value);
        return this;
    }

    public InspirationSelection orderByParement(boolean desc) {
        orderBy(InspirationColumns.PAREMENT, desc);
        return this;
    }

    public InspirationSelection orderByParement() {
        orderBy(InspirationColumns.PAREMENT, false);
        return this;
    }

    public InspirationSelection toiture1(String... value) {
        addEquals(InspirationColumns.TOITURE1, value);
        return this;
    }

    public InspirationSelection toiture1Not(String... value) {
        addNotEquals(InspirationColumns.TOITURE1, value);
        return this;
    }

    public InspirationSelection toiture1Like(String... value) {
        addLike(InspirationColumns.TOITURE1, value);
        return this;
    }

    public InspirationSelection toiture1Contains(String... value) {
        addContains(InspirationColumns.TOITURE1, value);
        return this;
    }

    public InspirationSelection toiture1StartsWith(String... value) {
        addStartsWith(InspirationColumns.TOITURE1, value);
        return this;
    }

    public InspirationSelection toiture1EndsWith(String... value) {
        addEndsWith(InspirationColumns.TOITURE1, value);
        return this;
    }

    public InspirationSelection orderByToiture1(boolean desc) {
        orderBy(InspirationColumns.TOITURE1, desc);
        return this;
    }

    public InspirationSelection orderByToiture1() {
        orderBy(InspirationColumns.TOITURE1, false);
        return this;
    }

    public InspirationSelection toiture2(String... value) {
        addEquals(InspirationColumns.TOITURE2, value);
        return this;
    }

    public InspirationSelection toiture2Not(String... value) {
        addNotEquals(InspirationColumns.TOITURE2, value);
        return this;
    }

    public InspirationSelection toiture2Like(String... value) {
        addLike(InspirationColumns.TOITURE2, value);
        return this;
    }

    public InspirationSelection toiture2Contains(String... value) {
        addContains(InspirationColumns.TOITURE2, value);
        return this;
    }

    public InspirationSelection toiture2StartsWith(String... value) {
        addStartsWith(InspirationColumns.TOITURE2, value);
        return this;
    }

    public InspirationSelection toiture2EndsWith(String... value) {
        addEndsWith(InspirationColumns.TOITURE2, value);
        return this;
    }

    public InspirationSelection orderByToiture2(boolean desc) {
        orderBy(InspirationColumns.TOITURE2, desc);
        return this;
    }

    public InspirationSelection orderByToiture2() {
        orderBy(InspirationColumns.TOITURE2, false);
        return this;
    }

    public InspirationSelection chassis(String... value) {
        addEquals(InspirationColumns.CHASSIS, value);
        return this;
    }

    public InspirationSelection chassisNot(String... value) {
        addNotEquals(InspirationColumns.CHASSIS, value);
        return this;
    }

    public InspirationSelection chassisLike(String... value) {
        addLike(InspirationColumns.CHASSIS, value);
        return this;
    }

    public InspirationSelection chassisContains(String... value) {
        addContains(InspirationColumns.CHASSIS, value);
        return this;
    }

    public InspirationSelection chassisStartsWith(String... value) {
        addStartsWith(InspirationColumns.CHASSIS, value);
        return this;
    }

    public InspirationSelection chassisEndsWith(String... value) {
        addEndsWith(InspirationColumns.CHASSIS, value);
        return this;
    }

    public InspirationSelection orderByChassis(boolean desc) {
        orderBy(InspirationColumns.CHASSIS, desc);
        return this;
    }

    public InspirationSelection orderByChassis() {
        orderBy(InspirationColumns.CHASSIS, false);
        return this;
    }

    public InspirationSelection invest(Integer... value) {
        addEquals(InspirationColumns.INVEST, value);
        return this;
    }

    public InspirationSelection investNot(Integer... value) {
        addNotEquals(InspirationColumns.INVEST, value);
        return this;
    }

    public InspirationSelection investGt(int value) {
        addGreaterThan(InspirationColumns.INVEST, value);
        return this;
    }

    public InspirationSelection investGtEq(int value) {
        addGreaterThanOrEquals(InspirationColumns.INVEST, value);
        return this;
    }

    public InspirationSelection investLt(int value) {
        addLessThan(InspirationColumns.INVEST, value);
        return this;
    }

    public InspirationSelection investLtEq(int value) {
        addLessThanOrEquals(InspirationColumns.INVEST, value);
        return this;
    }

    public InspirationSelection orderByInvest(boolean desc) {
        orderBy(InspirationColumns.INVEST, desc);
        return this;
    }

    public InspirationSelection orderByInvest() {
        orderBy(InspirationColumns.INVEST, false);
        return this;
    }

    public InspirationSelection chambrerez(String... value) {
        addEquals(InspirationColumns.CHAMBREREZ, value);
        return this;
    }

    public InspirationSelection chambrerezNot(String... value) {
        addNotEquals(InspirationColumns.CHAMBREREZ, value);
        return this;
    }

    public InspirationSelection chambrerezLike(String... value) {
        addLike(InspirationColumns.CHAMBREREZ, value);
        return this;
    }

    public InspirationSelection chambrerezContains(String... value) {
        addContains(InspirationColumns.CHAMBREREZ, value);
        return this;
    }

    public InspirationSelection chambrerezStartsWith(String... value) {
        addStartsWith(InspirationColumns.CHAMBREREZ, value);
        return this;
    }

    public InspirationSelection chambrerezEndsWith(String... value) {
        addEndsWith(InspirationColumns.CHAMBREREZ, value);
        return this;
    }

    public InspirationSelection orderByChambrerez(boolean desc) {
        orderBy(InspirationColumns.CHAMBREREZ, desc);
        return this;
    }

    public InspirationSelection orderByChambrerez() {
        orderBy(InspirationColumns.CHAMBREREZ, false);
        return this;
    }

    public InspirationSelection idapmodele(Integer... value) {
        addEquals(InspirationColumns.IDAPMODELE, value);
        return this;
    }

    public InspirationSelection idapmodeleNot(Integer... value) {
        addNotEquals(InspirationColumns.IDAPMODELE, value);
        return this;
    }

    public InspirationSelection idapmodeleGt(int value) {
        addGreaterThan(InspirationColumns.IDAPMODELE, value);
        return this;
    }

    public InspirationSelection idapmodeleGtEq(int value) {
        addGreaterThanOrEquals(InspirationColumns.IDAPMODELE, value);
        return this;
    }

    public InspirationSelection idapmodeleLt(int value) {
        addLessThan(InspirationColumns.IDAPMODELE, value);
        return this;
    }

    public InspirationSelection idapmodeleLtEq(int value) {
        addLessThanOrEquals(InspirationColumns.IDAPMODELE, value);
        return this;
    }

    public InspirationSelection orderByIdapmodele(boolean desc) {
        orderBy(InspirationColumns.IDAPMODELE, desc);
        return this;
    }

    public InspirationSelection orderByIdapmodele() {
        orderBy(InspirationColumns.IDAPMODELE, false);
        return this;
    }
}
