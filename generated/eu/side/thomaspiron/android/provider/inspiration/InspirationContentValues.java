package eu.side.thomaspiron.android.provider.inspiration;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import eu.side.thomaspiron.android.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code inspiration} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class InspirationContentValues extends AbstractContentValues<InspirationContentValues> {
    @Override
    protected Uri baseUri() {
        return InspirationColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable InspirationSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable InspirationSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public InspirationContentValues putDate(@Nullable String value) {
        mContentValues.put(InspirationColumns.DATE, value);
        return this;
    }

    public InspirationContentValues putDateNull() {
        mContentValues.putNull(InspirationColumns.DATE);
        return this;
    }

    public InspirationContentValues putNumero(@Nullable String value) {
        mContentValues.put(InspirationColumns.NUMERO, value);
        return this;
    }

    public InspirationContentValues putNumeroNull() {
        mContentValues.putNull(InspirationColumns.NUMERO);
        return this;
    }

    public InspirationContentValues putNumerosimplifie(@Nullable String value) {
        mContentValues.put(InspirationColumns.NUMEROSIMPLIFIE, value);
        return this;
    }

    public InspirationContentValues putNumerosimplifieNull() {
        mContentValues.putNull(InspirationColumns.NUMEROSIMPLIFIE);
        return this;
    }

    public InspirationContentValues putClient(@Nullable String value) {
        mContentValues.put(InspirationColumns.CLIENT, value);
        return this;
    }

    public InspirationContentValues putClientNull() {
        mContentValues.putNull(InspirationColumns.CLIENT);
        return this;
    }

    public InspirationContentValues putPrix(@Nullable Double value) {
        mContentValues.put(InspirationColumns.PRIX, value);
        return this;
    }

    public InspirationContentValues putPrixNull() {
        mContentValues.putNull(InspirationColumns.PRIX);
        return this;
    }

    public InspirationContentValues putTopographie(@Nullable String value) {
        mContentValues.put(InspirationColumns.TOPOGRAPHIE, value);
        return this;
    }

    public InspirationContentValues putTopographieNull() {
        mContentValues.putNull(InspirationColumns.TOPOGRAPHIE);
        return this;
    }

    public InspirationContentValues putGarage(@Nullable String value) {
        mContentValues.put(InspirationColumns.GARAGE, value);
        return this;
    }

    public InspirationContentValues putGarageNull() {
        mContentValues.putNull(InspirationColumns.GARAGE);
        return this;
    }

    public InspirationContentValues putCarport(@Nullable String value) {
        mContentValues.put(InspirationColumns.CARPORT, value);
        return this;
    }

    public InspirationContentValues putCarportNull() {
        mContentValues.putNull(InspirationColumns.CARPORT);
        return this;
    }

    public InspirationContentValues putCave(@Nullable String value) {
        mContentValues.put(InspirationColumns.CAVE, value);
        return this;
    }

    public InspirationContentValues putCaveNull() {
        mContentValues.putNull(InspirationColumns.CAVE);
        return this;
    }

    public InspirationContentValues putPro(@Nullable String value) {
        mContentValues.put(InspirationColumns.PRO, value);
        return this;
    }

    public InspirationContentValues putProNull() {
        mContentValues.putNull(InspirationColumns.PRO);
        return this;
    }

    public InspirationContentValues putParement(@Nullable String value) {
        mContentValues.put(InspirationColumns.PAREMENT, value);
        return this;
    }

    public InspirationContentValues putParementNull() {
        mContentValues.putNull(InspirationColumns.PAREMENT);
        return this;
    }

    public InspirationContentValues putToiture1(@Nullable String value) {
        mContentValues.put(InspirationColumns.TOITURE1, value);
        return this;
    }

    public InspirationContentValues putToiture1Null() {
        mContentValues.putNull(InspirationColumns.TOITURE1);
        return this;
    }

    public InspirationContentValues putToiture2(@Nullable String value) {
        mContentValues.put(InspirationColumns.TOITURE2, value);
        return this;
    }

    public InspirationContentValues putToiture2Null() {
        mContentValues.putNull(InspirationColumns.TOITURE2);
        return this;
    }

    public InspirationContentValues putChassis(@Nullable String value) {
        mContentValues.put(InspirationColumns.CHASSIS, value);
        return this;
    }

    public InspirationContentValues putChassisNull() {
        mContentValues.putNull(InspirationColumns.CHASSIS);
        return this;
    }

    public InspirationContentValues putInvest(@Nullable Integer value) {
        mContentValues.put(InspirationColumns.INVEST, value);
        return this;
    }

    public InspirationContentValues putInvestNull() {
        mContentValues.putNull(InspirationColumns.INVEST);
        return this;
    }

    public InspirationContentValues putChambrerez(@Nullable String value) {
        mContentValues.put(InspirationColumns.CHAMBREREZ, value);
        return this;
    }

    public InspirationContentValues putChambrerezNull() {
        mContentValues.putNull(InspirationColumns.CHAMBREREZ);
        return this;
    }

    public InspirationContentValues putIdapmodele(@Nullable Integer value) {
        mContentValues.put(InspirationColumns.IDAPMODELE, value);
        return this;
    }

    public InspirationContentValues putIdapmodeleNull() {
        mContentValues.putNull(InspirationColumns.IDAPMODELE);
        return this;
    }
}
