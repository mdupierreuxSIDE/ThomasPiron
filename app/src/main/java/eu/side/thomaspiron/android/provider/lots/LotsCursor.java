package eu.side.thomaspiron.android.provider.lots;

// @formatter:off
import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import eu.side.thomaspiron.android.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code lots} table.
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnnecessaryLocalVariable"})
public class LotsCursor extends AbstractCursor implements LotsModel {
    public LotsCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    @Override
    public long getId() {
        Long res = getLongOrNull(LotsColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code lotdesc} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLotdesc() {
        String res = getStringOrNull(LotsColumns.LOTDESC);
        return res;
    }

    /**
     * Get the {@code cptepl} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCptepl() {
        String res = getStringOrNull(LotsColumns.CPTEPL);
        return res;
    }

    /**
     * Get the {@code jardin} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getJardin() {
        String res = getStringOrNull(LotsColumns.JARDIN);
        return res;
    }

    /**
     * Get the {@code balcon} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getBalcon() {
        String res = getStringOrNull(LotsColumns.BALCON);
        return res;
    }

    /**
     * Get the {@code chambres} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getChambres() {
        String res = getStringOrNull(LotsColumns.CHAMBRES);
        return res;
    }

    /**
     * Get the {@code facadesnbr} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getFacadesnbr() {
        String res = getStringOrNull(LotsColumns.FACADESNBR);
        return res;
    }

    /**
     * Get the {@code orientation} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getOrientation() {
        String res = getStringOrNull(LotsColumns.ORIENTATION);
        return res;
    }

    /**
     * Get the {@code statutlot} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getStatutlot() {
        String res = getStringOrNull(LotsColumns.STATUTLOT);
        return res;
    }

    /**
     * Get the {@code surfter} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSurfter() {
        String res = getStringOrNull(LotsColumns.SURFTER);
        return res;
    }

    /**
     * Get the {@code surfhab} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSurfhab() {
        String res = getStringOrNull(LotsColumns.SURFHAB);
        return res;
    }

    /**
     * Get the {@code codeetage} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getCodeetage() {
        String res = getStringOrNull(LotsColumns.CODEETAGE);
        return res;
    }

    /**
     * Get the {@code libellefr} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getLibellefr() {
        String res = getStringOrNull(LotsColumns.LIBELLEFR);
        return res;
    }

    /**
     * Get the {@code ensecode} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getEnsecode() {
        String res = getStringOrNull(LotsColumns.ENSECODE);
        return res;
    }

    /**
     * Get the {@code socicode} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getSocicode() {
        String res = getStringOrNull(LotsColumns.SOCICODE);
        return res;
    }

    /**
     * Get the {@code pebclasseenergetique} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public String getPebclasseenergetique() {
        String res = getStringOrNull(LotsColumns.PEBCLASSEENERGETIQUE);
        return res;
    }

    /**
     * Get the {@code nbmedias} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbmedias() {
        Integer res = getIntegerOrNull(LotsColumns.NBMEDIAS);
        return res;
    }

    /**
     * Get the {@code nbplansimpl} value.
     * Can be {@code null}.
     */
    @Nullable
    @Override
    public Integer getNbplansimpl() {
        Integer res = getIntegerOrNull(LotsColumns.NBPLANSIMPL);
        return res;
    }
}
