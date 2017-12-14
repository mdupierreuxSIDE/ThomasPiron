package eu.side.thomaspiron.android.model;

/**
 * Created by mdupierreux1 on 28/08/15.
 */
public class PointContact {
    private Integer idPointContact;
    private String typePointContact;
    private String titre;
    private String adresse;
    private String postLoc;
    private String postCode;
    private String tel;
    private String permanenceFr;
    private Double latitude;
    private Double longitude;
    private Integer idTypePointContact;
    private Integer nbMedias;



    public PointContact() {
    }

    public Integer getIdPointContact() {
        return idPointContact;
    }

    public void setIdPointContact(Integer idPointContact) {
        this.idPointContact = idPointContact;
    }

    public String getTypePointContact() {
        return typePointContact;
    }

    public void setTypePointContact(String typePointContact) {
        this.typePointContact = typePointContact;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPermanenceFr() {
        return permanenceFr;
    }

    public void setPermanenceFr(String permanenceFr) {
        this.permanenceFr = permanenceFr;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getIdTypePointContact() {
        return idTypePointContact;
    }

    public void setIdTypePointContact(Integer idTypePointContact) {
        this.idTypePointContact = idTypePointContact;
    }

    public Integer getNbMedias() {
        return nbMedias;
    }

    public void setNbMedias(Integer nbMedias) {
        this.nbMedias = nbMedias;
    }
}
