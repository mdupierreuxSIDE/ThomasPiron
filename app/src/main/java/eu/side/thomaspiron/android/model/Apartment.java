package eu.side.thomaspiron.android.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mdupierreux1 on 5/08/15.
 */
public class Apartment extends Ensemble{

    @SerializedName("surfMin")
    public String surfMin;
    @SerializedName("surfMax")
    public String surfMax;
    @SerializedName("studios")
    public int nbStudios;
    @SerializedName("appart")
    public int nbApparts;
    @SerializedName("penthouse")
    public int nbPenthouses;
    @SerializedName("duplex")
    public int nbDuplex;
    @SerializedName("triplex")
    public int nbTriplex;
    @SerializedName("quadriplex")
    public int nbQuadriplex;
    @SerializedName("commerces")
    public int nbCommerces;
    @SerializedName("bureaux")
    public int nbBureaux;



    public Apartment() {
    }

    public Apartment(String cptEpl, String enseCode, String adresse, String postLoc, String postCode, String enseDesc, String libCommercialFr, String libCommercialEn, double latitude, double longitude, String descriptionDistanceFR, String descriptionDistanceEN, int totUnit, String sociCode, String divicode, String province, String surfMin, String surfMax, int nbStudios, int nbApparts, int nbPenthouses, int nbDuplex, int nbCommerces, int nbBureaux) {
        super(cptEpl, enseCode, adresse, postLoc, postCode, enseDesc, libCommercialFr, libCommercialEn, latitude, longitude, descriptionDistanceFR, descriptionDistanceEN, totUnit, sociCode, divicode, province);
        this.surfMin = surfMin;
        this.surfMax = surfMax;
        this.nbStudios = nbStudios;
        this.nbApparts = nbApparts;
        this.nbPenthouses = nbPenthouses;
        this.nbDuplex = nbDuplex;
        this.nbCommerces = nbCommerces;
        this.nbBureaux = nbBureaux;
    }

    public Apartment(String cptEpl, String enseCode, String adresse, String postLoc, String postCode, String enseDesc, String libCommercialFr, String libCommercialEn, double latitude, double longitude, String descriptionDistanceFR, String descriptionDistanceEN, int totUnit, String sociCode, String divicode, String surfMin, String surfMax, int nbStudios, int nbApparts, int nbPenthouses, int nbDuplex, int nbCommerces, int nbBureaux) {
        super(cptEpl, enseCode, adresse, postLoc, postCode, enseDesc, libCommercialFr, libCommercialEn, latitude, longitude, descriptionDistanceFR, descriptionDistanceEN, totUnit, sociCode, divicode);
        this.surfMin = surfMin;
        this.surfMax = surfMax;
        this.nbStudios = nbStudios;
        this.nbApparts = nbApparts;
        this.nbPenthouses = nbPenthouses;
        this.nbDuplex = nbDuplex;
        this.nbCommerces = nbCommerces;
        this.nbBureaux = nbBureaux;
    }

    public Apartment(String surfMin, String surfMax, int nbStudios, int nbApparts, int nbPenthouses, int nbDuplex, int nbCommerces, int nbBureaux) {
        this.surfMin = surfMin;
        this.surfMax = surfMax;
        this.nbStudios = nbStudios;
        this.nbApparts = nbApparts;
        this.nbPenthouses = nbPenthouses;
        this.nbDuplex = nbDuplex;
        this.nbCommerces = nbCommerces;
        this.nbBureaux = nbBureaux;
    }

    public Apartment(String cptEpl, String enseCode, String adresse, String postLoc, String postCode, String enseDesc, String libCommercialFr, String libCommercialEn
            , double latitude, double longitude, String descriptionDistanceFR, String descriptionDistanceEN, int totUnit, String surfMin, String surfMax, int nbStudios
            , int nbApparts, int nbPenthouses, int nbDuplex, int nbCommerces, int nbBureaux) {
        super(cptEpl, enseCode, adresse, postLoc, postCode, enseDesc, libCommercialFr, libCommercialEn, latitude, longitude, descriptionDistanceFR, descriptionDistanceEN, totUnit);
        this.surfMin = surfMin;
        this.surfMax = surfMax;
        this.nbStudios = nbStudios;
        this.nbApparts = nbApparts;
        this.nbPenthouses = nbPenthouses;
        this.nbDuplex = nbDuplex;
        this.nbCommerces = nbCommerces;
        this.nbBureaux = nbBureaux;
    }

    public Apartment(String cptEpl, String enseCode, String adresse, String postLoc, String postCode, String enseDesc, String libCommercialFr, String libCommercialEn, double latitude, double longitude, String descriptionDistanceFR, String descriptionDistanceEN, int totUnit, String sociCode, String divicode, String province, Integer idPointContact, int nbMedias, int nbPlansImpl, Long dtDebNouveau, Long dtDebRemise, Long dtFinNouveau, Long dtFinPorteOuverte, Long dtFinRemise, String infoPorteOuverte, String libelleRemise, String surfMin, String surfMax, int nbStudios, int nbApparts, int nbPenthouses, int nbDuplex, int nbTriplex, int nbQuadriplex, int nbCommerces, int nbBureaux) {
        super(cptEpl, enseCode, adresse, postLoc, postCode, enseDesc, libCommercialFr, libCommercialEn, latitude, longitude, descriptionDistanceFR, descriptionDistanceEN, totUnit, sociCode, divicode, province, idPointContact, nbMedias, nbPlansImpl, dtDebNouveau, dtDebRemise, dtFinNouveau, dtFinPorteOuverte, dtFinRemise, infoPorteOuverte, libelleRemise);
        this.surfMin = surfMin;
        this.surfMax = surfMax;
        this.nbStudios = nbStudios;
        this.nbApparts = nbApparts;
        this.nbPenthouses = nbPenthouses;
        this.nbDuplex = nbDuplex;
        this.nbTriplex = nbTriplex;
        this.nbQuadriplex = nbQuadriplex;
        this.nbCommerces = nbCommerces;
        this.nbBureaux = nbBureaux;
    }

    public Apartment(String cptEpl, String enseCode, String adresse, String postLoc, String postCode, String enseDesc, String libCommercialFr, String libCommercialEn, double latitude, double longitude, String descriptionDistanceFR, String descriptionDistanceEN, int totUnit, String sociCode, String divicode, String province, String surfMin, String surfMax, int nbStudios, int nbApparts, int nbPenthouses, int nbDuplex, int nbTriplex, int nbQuadriplex, int nbCommerces, int nbBureaux) {
        super(cptEpl, enseCode, adresse, postLoc, postCode, enseDesc, libCommercialFr, libCommercialEn, latitude, longitude, descriptionDistanceFR, descriptionDistanceEN, totUnit, sociCode, divicode, province);
        this.surfMin = surfMin;
        this.surfMax = surfMax;
        this.nbStudios = nbStudios;
        this.nbApparts = nbApparts;
        this.nbPenthouses = nbPenthouses;
        this.nbDuplex = nbDuplex;
        this.nbTriplex = nbTriplex;
        this.nbQuadriplex = nbQuadriplex;
        this.nbCommerces = nbCommerces;
        this.nbBureaux = nbBureaux;
    }

    public Apartment(String cptEpl, String enseCode, String adresse, String postLoc, String postCode, String enseDesc, String libCommercialFr, String libCommercialEn, double latitude, double longitude, String descriptionDistanceFR, String descriptionDistanceEN, int totUnit, String sociCode, String divicode, String surfMin, String surfMax, int nbStudios, int nbApparts, int nbPenthouses, int nbDuplex, int nbTriplex, int nbQuadriplex, int nbCommerces, int nbBureaux) {
        super(cptEpl, enseCode, adresse, postLoc, postCode, enseDesc, libCommercialFr, libCommercialEn, latitude, longitude, descriptionDistanceFR, descriptionDistanceEN, totUnit, sociCode, divicode);
        this.surfMin = surfMin;
        this.surfMax = surfMax;
        this.nbStudios = nbStudios;
        this.nbApparts = nbApparts;
        this.nbPenthouses = nbPenthouses;
        this.nbDuplex = nbDuplex;
        this.nbTriplex = nbTriplex;
        this.nbQuadriplex = nbQuadriplex;
        this.nbCommerces = nbCommerces;
        this.nbBureaux = nbBureaux;
    }

    public Apartment(String surfMin, String surfMax, int nbStudios, int nbApparts, int nbPenthouses, int nbDuplex, int nbTriplex, int nbQuadriplex, int nbCommerces, int nbBureaux) {
        this.surfMin = surfMin;
        this.surfMax = surfMax;
        this.nbStudios = nbStudios;
        this.nbApparts = nbApparts;
        this.nbPenthouses = nbPenthouses;
        this.nbDuplex = nbDuplex;
        this.nbTriplex = nbTriplex;
        this.nbQuadriplex = nbQuadriplex;
        this.nbCommerces = nbCommerces;
        this.nbBureaux = nbBureaux;
    }

    public Apartment(String cptEpl, String enseCode, String adresse, String postLoc, String postCode, String enseDesc, String libCommercialFr, String libCommercialEn, double latitude, double longitude, String descriptionDistanceFR, String descriptionDistanceEN, int totUnit, String surfMin, String surfMax, int nbStudios, int nbApparts, int nbPenthouses, int nbDuplex, int nbTriplex, int nbQuadriplex, int nbCommerces, int nbBureaux) {
        super(cptEpl, enseCode, adresse, postLoc, postCode, enseDesc, libCommercialFr, libCommercialEn, latitude, longitude, descriptionDistanceFR, descriptionDistanceEN, totUnit);
        this.surfMin = surfMin;
        this.surfMax = surfMax;
        this.nbStudios = nbStudios;
        this.nbApparts = nbApparts;
        this.nbPenthouses = nbPenthouses;
        this.nbDuplex = nbDuplex;
        this.nbTriplex = nbTriplex;
        this.nbQuadriplex = nbQuadriplex;
        this.nbCommerces = nbCommerces;
        this.nbBureaux = nbBureaux;
    }

    public String getSurfMin() {
        return surfMin;
    }

    public void setSurfMin(String surfMin) {
        this.surfMin = surfMin;
    }

    public String getSurfMax() {
        return surfMax;
    }

    public void setSurfMax(String surfMax) {
        this.surfMax = surfMax;
    }

    public int getNbStudios() {
        return nbStudios;
    }

    public void setNbStudios(int nbStudios) {
        this.nbStudios = nbStudios;
    }

    public int getNbApparts() {
        return nbApparts;
    }

    public void setNbApparts(int nbApparts) {
        this.nbApparts = nbApparts;
    }

    public int getNbPenthouses() {
        return nbPenthouses;
    }

    public void setNbPenthouses(int nbPenthouses) {
        this.nbPenthouses = nbPenthouses;
    }

    public int getNbDuplex() {
        return nbDuplex;
    }

    public void setNbDuplex(int nbDuplex) {
        this.nbDuplex = nbDuplex;
    }

    public int getNbCommerces() {
        return nbCommerces;
    }

    public void setNbCommerces(int nbCommerces) {
        this.nbCommerces = nbCommerces;
    }

    public int getNbBureaux() {
        return nbBureaux;
    }

    public void setNbBureaux(int nbBureaux) {
        this.nbBureaux = nbBureaux;
    }

    public int getNbTriplex() {
        return nbTriplex;
    }

    public void setNbTriplex(int nbTriplex) {
        this.nbTriplex = nbTriplex;
    }

    public int getNbQuadriplex() {
        return nbQuadriplex;
    }

    public void setNbQuadriplex(int nbQuadriplex) {
        this.nbQuadriplex = nbQuadriplex;
    }
}
