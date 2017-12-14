package eu.side.thomaspiron.android.model;

import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by mdupierreux1 on 5/08/15.
 */
public class Ensemble {

    @SerializedName("cptEpl")
    public String cptEpl;
    @SerializedName("enseCode")
    public String enseCode;
    @SerializedName("adresse")
    public String adresse;
    @SerializedName("postLoc")
    public String postLoc;
    @SerializedName("postCode")
    public String postCode;
    @SerializedName("enseDesc")
    public String enseDesc;
    @SerializedName("libCommercialFR")
    public String libCommercialFr;
    @SerializedName("libCommercialEN")
    public String libCommercialEn;
    @SerializedName("latitude")
    public double latitude;
    @SerializedName("longitude")
    public double longitude;
    @SerializedName("descriptionDistanceFR")
    public String descriptionDistanceFR;
    @SerializedName("descriptionDistanceEN")
    public String descriptionDistanceEN;
    @SerializedName("toUnit")
    public int totUnit;
    @SerializedName("sociCode")
    public String sociCode;
    @SerializedName("diviCode")
    public String divicode;
    @SerializedName("province")
    public String province;
    @SerializedName("idPointContact")
    public Integer idPointContact;
    @SerializedName("nbMedias")
    private int nbMedias;
    @SerializedName("nbPlansImpl")
    private int nbPlansImpl;

    private Long dtDebNouveau;
    private Long dtDebRemise;
    private Long dtFinNouveau;
    private Long dtFinPorteOuverte;
    private Long dtFinRemise;
    private String infoPorteOuverte;
    @SerializedName("libelleRemise")
    private String libelleRemise;


    public Ensemble(String cptEpl, String enseCode, String adresse, String postLoc, String postCode, String enseDesc, String libCommercialFr, String libCommercialEn, double latitude, double longitude, String descriptionDistanceFR, String descriptionDistanceEN, int totUnit, String sociCode, String divicode, String province, Integer idPointContact, int nbMedias, int nbPlansImpl, Long dtDebNouveau, Long dtDebRemise, Long dtFinNouveau, Long dtFinPorteOuverte, Long dtFinRemise, String infoPorteOuverte, String libelleRemise) {
        this.cptEpl = cptEpl;
        this.enseCode = enseCode;
        this.adresse = adresse;
        this.postLoc = postLoc;
        this.postCode = postCode;
        this.enseDesc = enseDesc;
        this.libCommercialFr = libCommercialFr;
        this.libCommercialEn = libCommercialEn;
        this.latitude = latitude;
        this.longitude = longitude;
        this.descriptionDistanceFR = descriptionDistanceFR;
        this.descriptionDistanceEN = descriptionDistanceEN;
        this.totUnit = totUnit;
        this.sociCode = sociCode;
        this.divicode = divicode;
        this.province = province;
        this.idPointContact = idPointContact;
        this.nbMedias = nbMedias;
        this.nbPlansImpl = nbPlansImpl;
        this.dtDebNouveau = dtDebNouveau;
        this.dtDebRemise = dtDebRemise;
        this.dtFinNouveau = dtFinNouveau;
        this.dtFinPorteOuverte = dtFinPorteOuverte;
        this.dtFinRemise = dtFinRemise;
        this.infoPorteOuverte = infoPorteOuverte;
        this.libelleRemise = libelleRemise;
    }

    public Ensemble(String cptEpl, String enseCode, String adresse, String postLoc, String postCode, String enseDesc, String libCommercialFr, String libCommercialEn, double latitude, double longitude, String descriptionDistanceFR, String descriptionDistanceEN, int totUnit, String sociCode, String divicode, String province) {
        this.cptEpl = cptEpl;
        this.enseCode = enseCode;
        this.adresse = adresse;
        this.postLoc = postLoc;
        this.postCode = postCode;
        this.enseDesc = enseDesc;
        this.libCommercialFr = libCommercialFr;
        this.libCommercialEn = libCommercialEn;
        this.latitude = latitude;
        this.longitude = longitude;
        this.descriptionDistanceFR = descriptionDistanceFR;
        this.descriptionDistanceEN = descriptionDistanceEN;
        this.totUnit = totUnit;
        this.sociCode = sociCode;
        this.divicode = divicode;
        this.province = province;
    }

    public Ensemble(String cptEpl, String enseCode, String adresse, String postLoc, String postCode, String enseDesc, String libCommercialFr, String libCommercialEn, double latitude, double longitude, String descriptionDistanceFR, String descriptionDistanceEN, int totUnit, String sociCode, String divicode) {
        this.cptEpl = cptEpl;
        this.enseCode = enseCode;
        this.adresse = adresse;
        this.postLoc = postLoc;
        this.postCode = postCode;
        this.enseDesc = enseDesc;
        this.libCommercialFr = libCommercialFr;
        this.libCommercialEn = libCommercialEn;
        this.latitude = latitude;
        this.longitude = longitude;
        this.descriptionDistanceFR = descriptionDistanceFR;
        this.descriptionDistanceEN = descriptionDistanceEN;
        this.totUnit = totUnit;
        this.sociCode = sociCode;
        this.divicode = divicode;
    }



    public Ensemble() {
    }

    public Ensemble(String cptEpl, String enseCode, String adresse, String postLoc, String postCode, String enseDesc, String libCommercialFr, String libCommercialEn, double latitude, double longitude, String descriptionDistanceFR, String descriptionDistanceEN, int totUnit) {
        this.cptEpl = cptEpl;
        this.enseCode = enseCode;
        this.adresse = adresse;
        this.postLoc = postLoc;
        this.postCode = postCode;
        this.enseDesc = enseDesc;
        this.libCommercialFr = libCommercialFr;
        this.libCommercialEn = libCommercialEn;
        this.latitude = latitude;
        this.longitude = longitude;
        this.descriptionDistanceFR = descriptionDistanceFR;
        this.descriptionDistanceEN = descriptionDistanceEN;
        this.totUnit = totUnit;
    }

    public String getCptEpl() {
        return cptEpl;
    }

    public void setCptEpl(String cptEpl) {
        this.cptEpl = cptEpl;
    }

    public String getEnseCode() {
        return enseCode;
    }

    public void setEnseCode(String enseCode) {
        this.enseCode = enseCode;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPostLoc() {
        return postLoc;
    }

    public void setPostLoc(String postLoc) {
        this.postLoc = postLoc;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEnseDesc() {
        return enseDesc;
    }

    public void setEnseDesc(String enseDesc) {
        this.enseDesc = enseDesc;
    }

    public String getLibCommercialFr() {
        return libCommercialFr;
    }

    public void setLibCommercialFr(String libCommercialFr) {
        this.libCommercialFr = libCommercialFr;
    }

    public String getLibCommercialEn() {
        return libCommercialEn;
    }

    public void setLibCommercialEn(String libCommercialEn) {
        this.libCommercialEn = libCommercialEn;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDescriptionDistanceFR() {
        return descriptionDistanceFR;
    }

    public void setDescriptionDistanceFR(String descriptionDistanceFR) {
        this.descriptionDistanceFR = descriptionDistanceFR;
    }

    public String getDescriptionDistanceEN() {
        return descriptionDistanceEN;
    }

    public void setDescriptionDistanceEN(String descriptionDistanceEN) {
        this.descriptionDistanceEN = descriptionDistanceEN;
    }

    public int getTotUnit() {
        return totUnit;
    }

    public void setTotUnit(int totUnit) {
        this.totUnit = totUnit;
    }

    public String getSociCode() {
        return sociCode;
    }

    public void setSociCode(String sociCode) {
        this.sociCode = sociCode;
    }

    public String getDivicode() {
        return divicode;
    }

    public void setDivicode(String divicode) {
        this.divicode = divicode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getIdPointContact() {
        return idPointContact;
    }

    public void setIdPointContact(Integer idPointContact) {
        this.idPointContact = idPointContact;
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

    public Long getDtDebNouveau() {
        return dtDebNouveau;
    }

    public void setDtDebNouveau(Long dtDebNouveau) {
        this.dtDebNouveau = dtDebNouveau;
    }

    public Long getDtDebRemise() {
        return dtDebRemise;
    }

    public void setDtDebRemise(Long dtDebRemise) {
        this.dtDebRemise = dtDebRemise;
    }

    public Long getDtFinNouveau() {
        return dtFinNouveau;
    }

    public void setDtFinNouveau(Long dtFinNouveau) {
        this.dtFinNouveau = dtFinNouveau;
    }

    public Long getDtFinPorteOuverte() {
        return dtFinPorteOuverte;
    }

    public void setDtFinPorteOuverte(Long dtFinPorteOuverte) {
        this.dtFinPorteOuverte = dtFinPorteOuverte;
    }

    public Long getDtFinRemise() {
        return dtFinRemise;
    }

    public void setDtFinRemise(Long dtFinRemise) {
        this.dtFinRemise = dtFinRemise;
    }

    public String getInfoPorteOuverte() {
        return infoPorteOuverte;
    }

    public void setInfoPorteOuverte(String infoPorteOuverte) {
        this.infoPorteOuverte = infoPorteOuverte;
    }

    public String getLibelleRemise() {
        return libelleRemise;
    }

    public void setLibelleRemise(String libelleRemise) {
        this.libelleRemise = libelleRemise;
    }
}
