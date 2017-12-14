package eu.side.thomaspiron.android.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mdupierreux1 on 5/08/15.
 */
public class Maison extends Ensemble{
    @SerializedName("terrainMini")
    public String terrainMin;
    @SerializedName("terrainMaxi")
    public String terrainMax;
    @SerializedName("terrainPP")
    public int terrainsPP;
    @SerializedName("terrainPC")
    public int terrainsPC;
    @SerializedName("maisonEC")
    public int maisonsEC;
    @SerializedName("maisonC")
    public int maisonsC;

    public Maison() {
    }

    public Maison(String cptEpl, String enseCode, String adresse, String postLoc, String postCode, String enseDesc, String libCommercialFr, String libCommercialEn, double latitude
            , double longitude, String descriptionDistanceFR, String descriptionDistanceEN, int totUnit, String terrainMin, String terrainMax, int terrainsPP, int terrainsPC, int maisonsEC, int maisonsC) {
        super(cptEpl, enseCode, adresse, postLoc, postCode, enseDesc, libCommercialFr, libCommercialEn, latitude, longitude, descriptionDistanceFR, descriptionDistanceEN, totUnit);
        this.terrainMin = terrainMin;
        this.terrainMax = terrainMax;
        this.terrainsPP = terrainsPP;
        this.terrainsPC = terrainsPC;
        this.maisonsEC = maisonsEC;
        this.maisonsC = maisonsC;
    }

    public Maison(String cptEpl, String enseCode, String adresse, String postLoc, String postCode, String enseDesc, String libCommercialFr, String libCommercialEn, double latitude, double longitude, String descriptionDistanceFR, String descriptionDistanceEN, int totUnit, String sociCode, String divicode, String province, String terrainMin, String terrainMax, int terrainsPP, int terrainsPC, int maisonsEC, int maisonsC) {
        super(cptEpl, enseCode, adresse, postLoc, postCode, enseDesc, libCommercialFr, libCommercialEn, latitude, longitude, descriptionDistanceFR, descriptionDistanceEN, totUnit, sociCode, divicode, province);
        this.terrainMin = terrainMin;
        this.terrainMax = terrainMax;
        this.terrainsPP = terrainsPP;
        this.terrainsPC = terrainsPC;
        this.maisonsEC = maisonsEC;
        this.maisonsC = maisonsC;
    }

    public Maison(String cptEpl, String enseCode, String adresse, String postLoc, String postCode, String enseDesc, String libCommercialFr, String libCommercialEn, double latitude, double longitude, String descriptionDistanceFR, String descriptionDistanceEN, int totUnit, String sociCode, String divicode, String terrainMin, String terrainMax, int terrainsPP, int terrainsPC, int maisonsEC, int maisonsC) {
        super(cptEpl, enseCode, adresse, postLoc, postCode, enseDesc, libCommercialFr, libCommercialEn, latitude, longitude, descriptionDistanceFR, descriptionDistanceEN, totUnit, sociCode, divicode);
        this.terrainMin = terrainMin;
        this.terrainMax = terrainMax;
        this.terrainsPP = terrainsPP;
        this.terrainsPC = terrainsPC;
        this.maisonsEC = maisonsEC;
        this.maisonsC = maisonsC;
    }

    public Maison(String terrainMin, String terrainMax, int terrainsPP, int terrainsPC, int maisonsEC, int maisonsC) {
        this.terrainMin = terrainMin;
        this.terrainMax = terrainMax;
        this.terrainsPP = terrainsPP;
        this.terrainsPC = terrainsPC;
        this.maisonsEC = maisonsEC;
        this.maisonsC = maisonsC;
    }

    public String getTerrainMin() {
        return terrainMin;
    }

    public void setTerrainMin(String terrainMin) {
        this.terrainMin = terrainMin;
    }

    public String getTerrainMax() {
        return terrainMax;
    }

    public void setTerrainMax(String terrainMax) {
        this.terrainMax = terrainMax;
    }

    public int getTerrainsPP() {
        return terrainsPP;
    }

    public void setTerrainsPP(int terrainsPP) {
        this.terrainsPP = terrainsPP;
    }

    public int getTerrainsPC() {
        return terrainsPC;
    }

    public void setTerrainsPC(int terrainsPC) {
        this.terrainsPC = terrainsPC;
    }

    public int getMaisonsEC() {
        return maisonsEC;
    }

    public void setMaisonsEC(int maisonsEC) {
        this.maisonsEC = maisonsEC;
    }

    public int getMaisonsC() {
        return maisonsC;
    }

    public void setMaisonsC(int maisonsC) {
        this.maisonsC = maisonsC;
    }
}
