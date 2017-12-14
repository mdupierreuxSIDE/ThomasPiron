package eu.side.thomaspiron.android.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mdupierreux1 on 5/08/15.
 */
public class Land extends Ensemble {
    @SerializedName("NbTerrainsDispo")
    private int nbTerrainsDispo;

    public Land() {
    }

    public Land(String cptEpl, String enseCode, String adresse, String postLoc, String postCode, String enseDesc, String libCommercialFr, String libCommercialEn
            , double latitude, double longitude, String descriptionDistanceFR, String descriptionDistanceEN, int totUnit, int nbTerrainsDispo) {
        super(cptEpl, enseCode, adresse, postLoc, postCode, enseDesc, libCommercialFr, libCommercialEn, latitude, longitude, descriptionDistanceFR, descriptionDistanceEN, totUnit);
        this.nbTerrainsDispo = nbTerrainsDispo;
    }

    public int getNbTerrainsDispo() {
        return nbTerrainsDispo;
    }

    public void setNbTerrainsDispo(int nbTerrainsDispo) {
        this.nbTerrainsDispo = nbTerrainsDispo;
    }
}
