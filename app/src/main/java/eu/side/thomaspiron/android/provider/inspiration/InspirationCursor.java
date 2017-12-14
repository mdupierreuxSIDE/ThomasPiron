package eu.side.thomaspiron.android.provider.inspiration;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import eu.side.thomaspiron.android.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code inspiration} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class InspirationCursor extends AbstractCursor implements InspirationModel {
    public InspirationCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(InspirationColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code date} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getDate() {
        String res = getStringOrNull(InspirationColumns.DATE);
        return res;
    }

    /**
     * Get the {@code numero} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getNumero() {
        String res = getStringOrNull(InspirationColumns.NUMERO);
        return res;
    }

    /**
     * Get the {@code numerosimplifie} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getNumerosimplifie() {
        String res = getStringOrNull(InspirationColumns.NUMEROSIMPLIFIE);
        return res;
    }

    /**
     * Get the {@code client} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getClient() {
        String res = getStringOrNull(InspirationColumns.CLIENT);
        return res;
    }

    /**
     * Get the {@code prix} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Double getPrix() {
        Double res = getDoubleOrNull(InspirationColumns.PRIX);
        return res;
    }

    /**
     * Get the {@code topographie} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getTopographie() {
        String res = getStringOrNull(InspirationColumns.TOPOGRAPHIE);
        return res;
    }

    /**
     * Get the {@code garage} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getGarage() {
        String res = getStringOrNull(InspirationColumns.GARAGE);
        return res;
    }

    /**
     * Get the {@code carport} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCarport() {
        String res = getStringOrNull(InspirationColumns.CARPORT);
        return res;
    }

    /**
     * Get the {@code cave} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCave() {
        String res = getStringOrNull(InspirationColumns.CAVE);
        return res;
    }

    /**
     * Get the {@code pro} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPro() {
        String res = getStringOrNull(InspirationColumns.PRO);
        return res;
    }

    /**
     * Get the {@code parement} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getParement() {
        String res = getStringOrNull(InspirationColumns.PAREMENT);
        return res;
    }

    /**
     * Get the {@code toiture1} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getToiture1() {
        String res = getStringOrNull(InspirationColumns.TOITURE1);
        return res;
    }

    /**
     * Get the {@code toiture2} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getToiture2() {
        String res = getStringOrNull(InspirationColumns.TOITURE2);
        return res;
    }

    /**
     * Get the {@code chassis} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getChassis() {
        String res = getStringOrNull(InspirationColumns.CHASSIS);
        return res;
    }

    /**
     * Get the {@code invest} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getInvest() {
        Integer res = getIntegerOrNull(InspirationColumns.INVEST);
        return res;
    }

    /**
     * Get the {@code chambrerez} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getChambrerez() {
        String res = getStringOrNull(InspirationColumns.CHAMBREREZ);
        return res;
    }

    /**
     * Get the {@code idapmodele} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getIdapmodele() {
        Integer res = getIntegerOrNull(InspirationColumns.IDAPMODELE);
        return res;
    }
}
