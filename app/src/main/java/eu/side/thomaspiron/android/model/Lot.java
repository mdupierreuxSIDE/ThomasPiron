package eu.side.thomaspiron.android.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mdupierreux1 on 6/08/15.
 */
public class Lot {
    @SerializedName("lotDesc")
    private String lotDesc;
    @SerializedName("surfHab")
    private String surfHab;
    @SerializedName("jardin")
    private String jardin;
    @SerializedName("balcon")
    private String balcon;
    @SerializedName("chambreNbr")
    private String chambres;
    @SerializedName("facadeNbr")
    private String facades;
    @SerializedName("orientation")
    private String orientation;
    @SerializedName("statutLot")
    private String statut;
    @SerializedName("surfTer")
    private String surfTerrain;
    @SerializedName("cptepl")
    private String cptepl;
    @SerializedName("codeEtage")
    private String codeEtage;
    @SerializedName("libelleFR")
    private String libEtage;
    @SerializedName("pebclasseEnergetique")
    private String pebClasseEnergetique;
    @SerializedName("nbMedias")
    private int nbMedias;
    @SerializedName("nbPlansLot")
    private int nbPlansImpl;


    private String ensecode;



    public Lot(String lotDesc, String surfHab, String jardin, String balcon, String chambres, String facades, String orientation, String statut, String surfTerrain, String cptepl, String codeEtage, String libEtage, String pebClasseEnergetique) {
        this.lotDesc = lotDesc;
        this.surfHab = surfHab;
        this.jardin = jardin;
        this.balcon = balcon;
        this.chambres = chambres;
        this.facades = facades;
        this.orientation = orientation;
        this.statut = statut;
        this.surfTerrain = surfTerrain;
        this.cptepl = cptepl;
        this.codeEtage = codeEtage;
        this.libEtage = libEtage;
        this.pebClasseEnergetique = pebClasseEnergetique;
    }

    public Lot(String lotDesc, String surfHab, String jardin, String balcon, String chambres, String facades, String orientation, String statut, String surfTerrain, String cptepl) {
        this.lotDesc = lotDesc;
        this.surfHab = surfHab;
        this.jardin = jardin;
        this.balcon = balcon;
        this.chambres = chambres;
        this.facades = facades;
        this.orientation = orientation;
        this.statut = statut;
        this.surfTerrain = surfTerrain;
        this.cptepl = cptepl;
    }

    public Lot() {
    }

    public Lot(String lotDesc, String surfHab, String jardin, String balcon, String chambres, String facades, String orientation, String statut, String surfTerrain) {
        this.lotDesc = lotDesc;
        this.surfHab = surfHab;
        this.jardin = jardin;
        this.balcon = balcon;
        this.chambres = chambres;
        this.facades = facades;
        this.orientation = orientation;
        this.statut = statut;
        this.surfTerrain = surfTerrain;
    }

    public Lot(String lotDesc, String surfHab, String jardin, String balcon, String chambres, String facades, String orientation, String statut) {
        this.lotDesc = lotDesc;
        this.surfHab = surfHab;
        this.jardin = jardin;
        this.balcon = balcon;
        this.chambres = chambres;
        this.facades = facades;
        this.orientation = orientation;
        this.statut = statut;
    }

    public String getLotDesc() {
        return lotDesc;
    }

    public void setLotDesc(String lotDesc) {
        this.lotDesc = lotDesc;
    }

    public String getSurfHab() {
        return surfHab;
    }

    public void setSurfHab(String surfHab) {
        this.surfHab = surfHab;
    }

    public String getJardin() {
        return jardin;
    }

    public void setJardin(String jardin) {
        this.jardin = jardin;
    }

    public String getBalcon() {
        return balcon;
    }

    public void setBalcon(String balcon) {
        this.balcon = balcon;
    }

    public String getChambres() {
        return chambres;
    }

    public void setChambres(String chambres) {
        this.chambres = chambres;
    }

    public String getFacades() {
        return facades;
    }

    public void setFacades(String facades) {
        this.facades = facades;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getSurfTerrain() {
        return surfTerrain;
    }

    public void setSurfTerrain(String surfTerrain) {
        this.surfTerrain = surfTerrain;
    }

    public String getCptepl() {
        return cptepl;
    }

    public void setCptepl(String cptepl) {
        this.cptepl = cptepl;
    }


    public String getCodeEtage() {
        return codeEtage;
    }

    public void setCodeEtage(String codeEtage) {
        this.codeEtage = codeEtage;
    }

    public String getLibEtage() {
        return libEtage;
    }

    public void setLibEtage(String libEtage) {
        this.libEtage = libEtage;
    }


    public String getPebClasseEnergetique() {
        return pebClasseEnergetique;
    }

    public void setPebClasseEnergetique(String pebClasseEnergetique) {
        this.pebClasseEnergetique = pebClasseEnergetique;
    }

    public String getEnsecode() {
        return ensecode;
    }

    public void setEnsecode(String ensecode) {
        this.ensecode = ensecode;
    }

    public int getNbMedias() {
        return nbMedias;
    }

    public void setNbMedias(int nbMedias) {
        this.nbMedias = nbMedias;
    }

    public int getNbPlansImpl() {
        return nbPlansImpl;
    }

    public void setNbPlansImpl(int nbPlansImpl) {
        this.nbPlansImpl = nbPlansImpl;
    }
}
