package eu.side.thomaspiron.android.provider.ensemble;

// @formatter:off
import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import eu.side.thomaspiron.android.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code ensemble} table.
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class EnsembleContentValues extends AbstractContentValues<EnsembleContentValues> {
    @Override
    protected Uri baseUri() {
        return EnsembleColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable EnsembleSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param context The context to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable EnsembleSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public EnsembleContentValues putSocicode(@Nullable String value) {
        mContentValues.put(EnsembleColumns.SOCICODE, value);
        return this;
    }

    public EnsembleContentValues putSocicodeNull() {
        mContentValues.putNull(EnsembleColumns.SOCICODE);
        return this;
    }

    public EnsembleContentValues putCptepl(@Nullable String value) {
        mContentValues.put(EnsembleColumns.CPTEPL, value);
        return this;
    }

    public EnsembleContentValues putCpteplNull() {
        mContentValues.putNull(EnsembleColumns.CPTEPL);
        return this;
    }

    public EnsembleContentValues putDivicode(@Nullable String value) {
        mContentValues.put(EnsembleColumns.DIVICODE, value);
        return this;
    }

    public EnsembleContentValues putDivicodeNull() {
        mContentValues.putNull(EnsembleColumns.DIVICODE);
        return this;
    }

    public EnsembleContentValues putEnsecode(@Nullable String value) {
        mContentValues.put(EnsembleColumns.ENSECODE, value);
        return this;
    }

    public EnsembleContentValues putEnsecodeNull() {
        mContentValues.putNull(EnsembleColumns.ENSECODE);
        return this;
    }

    public EnsembleContentValues putAdresse(@Nullable String value) {
        mContentValues.put(EnsembleColumns.ADRESSE, value);
        return this;
    }

    public EnsembleContentValues putAdresseNull() {
        mContentValues.putNull(EnsembleColumns.ADRESSE);
        return this;
    }

    public EnsembleContentValues putPostloc(@Nullable String value) {
        mContentValues.put(EnsembleColumns.POSTLOC, value);
        return this;
    }

    public EnsembleContentValues putPostlocNull() {
        mContentValues.putNull(EnsembleColumns.POSTLOC);
        return this;
    }

    public EnsembleContentValues putPostcode(@Nullable String value) {
        mContentValues.put(EnsembleColumns.POSTCODE, value);
        return this;
    }

    public EnsembleContentValues putPostcodeNull() {
        mContentValues.putNull(EnsembleColumns.POSTCODE);
        return this;
    }

    public EnsembleContentValues putEnsedesc(@Nullable String value) {
        mContentValues.put(EnsembleColumns.ENSEDESC, value);
        return this;
    }

    public EnsembleContentValues putEnsedescNull() {
        mContentValues.putNull(EnsembleColumns.ENSEDESC);
        return this;
    }

    public EnsembleContentValues putLibcommercialfr(@Nullable String value) {
        mContentValues.put(EnsembleColumns.LIBCOMMERCIALFR, value);
        return this;
    }

    public EnsembleContentValues putLibcommercialfrNull() {
        mContentValues.putNull(EnsembleColumns.LIBCOMMERCIALFR);
        return this;
    }

    public EnsembleContentValues putLibcommercialen(@Nullable String value) {
        mContentValues.put(EnsembleColumns.LIBCOMMERCIALEN, value);
        return this;
    }

    public EnsembleContentValues putLibcommercialenNull() {
        mContentValues.putNull(EnsembleColumns.LIBCOMMERCIALEN);
        return this;
    }

    public EnsembleContentValues putLatitude(@Nullable Double value) {
        mContentValues.put(EnsembleColumns.LATITUDE, value);
        return this;
    }

    public EnsembleContentValues putLatitudeNull() {
        mContentValues.putNull(EnsembleColumns.LATITUDE);
        return this;
    }

    public EnsembleContentValues putLongitude(@Nullable Double value) {
        mContentValues.put(EnsembleColumns.LONGITUDE, value);
        return this;
    }

    public EnsembleContentValues putLongitudeNull() {
        mContentValues.putNull(EnsembleColumns.LONGITUDE);
        return this;
    }

    public EnsembleContentValues putDescriptiondistancefr(@Nullable String value) {
        mContentValues.put(EnsembleColumns.DESCRIPTIONDISTANCEFR, value);
        return this;
    }

    public EnsembleContentValues putDescriptiondistancefrNull() {
        mContentValues.putNull(EnsembleColumns.DESCRIPTIONDISTANCEFR);
        return this;
    }

    public EnsembleContentValues putDescriptiondistanceen(@Nullable String value) {
        mContentValues.put(EnsembleColumns.DESCRIPTIONDISTANCEEN, value);
        return this;
    }

    public EnsembleContentValues putDescriptiondistanceenNull() {
        mContentValues.putNull(EnsembleColumns.DESCRIPTIONDISTANCEEN);
        return this;
    }

    public EnsembleContentValues putTotunit(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.TOTUNIT, value);
        return this;
    }

    public EnsembleContentValues putTotunitNull() {
        mContentValues.putNull(EnsembleColumns.TOTUNIT);
        return this;
    }

    public EnsembleContentValues putTerrainmin(@Nullable String value) {
        mContentValues.put(EnsembleColumns.TERRAINMIN, value);
        return this;
    }

    public EnsembleContentValues putTerrainminNull() {
        mContentValues.putNull(EnsembleColumns.TERRAINMIN);
        return this;
    }

    public EnsembleContentValues putTerrainmax(@Nullable String value) {
        mContentValues.put(EnsembleColumns.TERRAINMAX, value);
        return this;
    }

    public EnsembleContentValues putTerrainmaxNull() {
        mContentValues.putNull(EnsembleColumns.TERRAINMAX);
        return this;
    }

    public EnsembleContentValues putTerrainspp(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.TERRAINSPP, value);
        return this;
    }

    public EnsembleContentValues putTerrainsppNull() {
        mContentValues.putNull(EnsembleColumns.TERRAINSPP);
        return this;
    }

    public EnsembleContentValues putTerrainspc(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.TERRAINSPC, value);
        return this;
    }

    public EnsembleContentValues putTerrainspcNull() {
        mContentValues.putNull(EnsembleColumns.TERRAINSPC);
        return this;
    }

    public EnsembleContentValues putTerrainsec(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.TERRAINSEC, value);
        return this;
    }

    public EnsembleContentValues putTerrainsecNull() {
        mContentValues.putNull(EnsembleColumns.TERRAINSEC);
        return this;
    }

    public EnsembleContentValues putMaisonsec(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.MAISONSEC, value);
        return this;
    }

    public EnsembleContentValues putMaisonsecNull() {
        mContentValues.putNull(EnsembleColumns.MAISONSEC);
        return this;
    }

    public EnsembleContentValues putMaisonsc(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.MAISONSC, value);
        return this;
    }

    public EnsembleContentValues putMaisonscNull() {
        mContentValues.putNull(EnsembleColumns.MAISONSC);
        return this;
    }

    public EnsembleContentValues putSurfmin(@Nullable String value) {
        mContentValues.put(EnsembleColumns.SURFMIN, value);
        return this;
    }

    public EnsembleContentValues putSurfminNull() {
        mContentValues.putNull(EnsembleColumns.SURFMIN);
        return this;
    }

    public EnsembleContentValues putSurfmax(@Nullable String value) {
        mContentValues.put(EnsembleColumns.SURFMAX, value);
        return this;
    }

    public EnsembleContentValues putSurfmaxNull() {
        mContentValues.putNull(EnsembleColumns.SURFMAX);
        return this;
    }

    public EnsembleContentValues putNbstudios(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.NBSTUDIOS, value);
        return this;
    }

    public EnsembleContentValues putNbstudiosNull() {
        mContentValues.putNull(EnsembleColumns.NBSTUDIOS);
        return this;
    }

    public EnsembleContentValues putNbapparts(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.NBAPPARTS, value);
        return this;
    }

    public EnsembleContentValues putNbappartsNull() {
        mContentValues.putNull(EnsembleColumns.NBAPPARTS);
        return this;
    }

    public EnsembleContentValues putNbpenthouses(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.NBPENTHOUSES, value);
        return this;
    }

    public EnsembleContentValues putNbpenthousesNull() {
        mContentValues.putNull(EnsembleColumns.NBPENTHOUSES);
        return this;
    }

    public EnsembleContentValues putNbduplex(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.NBDUPLEX, value);
        return this;
    }

    public EnsembleContentValues putNbduplexNull() {
        mContentValues.putNull(EnsembleColumns.NBDUPLEX);
        return this;
    }

    public EnsembleContentValues putNbcommerces(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.NBCOMMERCES, value);
        return this;
    }

    public EnsembleContentValues putNbcommercesNull() {
        mContentValues.putNull(EnsembleColumns.NBCOMMERCES);
        return this;
    }

    public EnsembleContentValues putNbbureaux(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.NBBUREAUX, value);
        return this;
    }

    public EnsembleContentValues putNbbureauxNull() {
        mContentValues.putNull(EnsembleColumns.NBBUREAUX);
        return this;
    }

    public EnsembleContentValues putNbterrainsdispo(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.NBTERRAINSDISPO, value);
        return this;
    }

    public EnsembleContentValues putNbterrainsdispoNull() {
        mContentValues.putNull(EnsembleColumns.NBTERRAINSDISPO);
        return this;
    }

    public EnsembleContentValues putMaison(@Nullable Boolean value) {
        mContentValues.put(EnsembleColumns.MAISON, value);
        return this;
    }

    public EnsembleContentValues putMaisonNull() {
        mContentValues.putNull(EnsembleColumns.MAISON);
        return this;
    }

    public EnsembleContentValues putAppart(@Nullable Boolean value) {
        mContentValues.put(EnsembleColumns.APPART, value);
        return this;
    }

    public EnsembleContentValues putAppartNull() {
        mContentValues.putNull(EnsembleColumns.APPART);
        return this;
    }

    public EnsembleContentValues putTerrain(@Nullable Boolean value) {
        mContentValues.put(EnsembleColumns.TERRAIN, value);
        return this;
    }

    public EnsembleContentValues putTerrainNull() {
        mContentValues.putNull(EnsembleColumns.TERRAIN);
        return this;
    }

    public EnsembleContentValues putProvince(@Nullable String value) {
        mContentValues.put(EnsembleColumns.PROVINCE, value);
        return this;
    }

    public EnsembleContentValues putProvinceNull() {
        mContentValues.putNull(EnsembleColumns.PROVINCE);
        return this;
    }

    public EnsembleContentValues putIdpointcontact(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.IDPOINTCONTACT, value);
        return this;
    }

    public EnsembleContentValues putIdpointcontactNull() {
        mContentValues.putNull(EnsembleColumns.IDPOINTCONTACT);
        return this;
    }

    public EnsembleContentValues putNbmedias(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.NBMEDIAS, value);
        return this;
    }

    public EnsembleContentValues putNbmediasNull() {
        mContentValues.putNull(EnsembleColumns.NBMEDIAS);
        return this;
    }

    public EnsembleContentValues putNbplansimpl(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.NBPLANSIMPL, value);
        return this;
    }

    public EnsembleContentValues putNbplansimplNull() {
        mContentValues.putNull(EnsembleColumns.NBPLANSIMPL);
        return this;
    }

    public EnsembleContentValues putDtdebnouveau(@Nullable Date value) {
        mContentValues.put(EnsembleColumns.DTDEBNOUVEAU, value == null ? null : value.getTime());
        return this;
    }

    public EnsembleContentValues putDtdebnouveauNull() {
        mContentValues.putNull(EnsembleColumns.DTDEBNOUVEAU);
        return this;
    }

    public EnsembleContentValues putDtdebnouveau(@Nullable Long value) {
        mContentValues.put(EnsembleColumns.DTDEBNOUVEAU, value);
        return this;
    }

    public EnsembleContentValues putDtdebremise(@Nullable Date value) {
        mContentValues.put(EnsembleColumns.DTDEBREMISE, value == null ? null : value.getTime());
        return this;
    }

    public EnsembleContentValues putDtdebremiseNull() {
        mContentValues.putNull(EnsembleColumns.DTDEBREMISE);
        return this;
    }

    public EnsembleContentValues putDtdebremise(@Nullable Long value) {
        mContentValues.put(EnsembleColumns.DTDEBREMISE, value);
        return this;
    }

    public EnsembleContentValues putDtfinnouveau(@Nullable Date value) {
        mContentValues.put(EnsembleColumns.DTFINNOUVEAU, value == null ? null : value.getTime());
        return this;
    }

    public EnsembleContentValues putDtfinnouveauNull() {
        mContentValues.putNull(EnsembleColumns.DTFINNOUVEAU);
        return this;
    }

    public EnsembleContentValues putDtfinnouveau(@Nullable Long value) {
        mContentValues.put(EnsembleColumns.DTFINNOUVEAU, value);
        return this;
    }

    public EnsembleContentValues putDtfinporteouverte(@Nullable Date value) {
        mContentValues.put(EnsembleColumns.DTFINPORTEOUVERTE, value == null ? null : value.getTime());
        return this;
    }

    public EnsembleContentValues putDtfinporteouverteNull() {
        mContentValues.putNull(EnsembleColumns.DTFINPORTEOUVERTE);
        return this;
    }

    public EnsembleContentValues putDtfinporteouverte(@Nullable Long value) {
        mContentValues.put(EnsembleColumns.DTFINPORTEOUVERTE, value);
        return this;
    }

    public EnsembleContentValues putDtfinremise(@Nullable Date value) {
        mContentValues.put(EnsembleColumns.DTFINREMISE, value == null ? null : value.getTime());
        return this;
    }

    public EnsembleContentValues putDtfinremiseNull() {
        mContentValues.putNull(EnsembleColumns.DTFINREMISE);
        return this;
    }

    public EnsembleContentValues putDtfinremise(@Nullable Long value) {
        mContentValues.put(EnsembleColumns.DTFINREMISE, value);
        return this;
    }

    public EnsembleContentValues putInfoporteouverte(@Nullable String value) {
        mContentValues.put(EnsembleColumns.INFOPORTEOUVERTE, value);
        return this;
    }

    public EnsembleContentValues putInfoporteouverteNull() {
        mContentValues.putNull(EnsembleColumns.INFOPORTEOUVERTE);
        return this;
    }

    public EnsembleContentValues putLibelleremise(@Nullable String value) {
        mContentValues.put(EnsembleColumns.LIBELLEREMISE, value);
        return this;
    }

    public EnsembleContentValues putLibelleremiseNull() {
        mContentValues.putNull(EnsembleColumns.LIBELLEREMISE);
        return this;
    }

    public EnsembleContentValues putNbtriplex(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.NBTRIPLEX, value);
        return this;
    }

    public EnsembleContentValues putNbtriplexNull() {
        mContentValues.putNull(EnsembleColumns.NBTRIPLEX);
        return this;
    }

    public EnsembleContentValues putNbquadriplex(@Nullable Integer value) {
        mContentValues.put(EnsembleColumns.NBQUADRIPLEX, value);
        return this;
    }

    public EnsembleContentValues putNbquadriplexNull() {
        mContentValues.putNull(EnsembleColumns.NBQUADRIPLEX);
        return this;
    }
}
