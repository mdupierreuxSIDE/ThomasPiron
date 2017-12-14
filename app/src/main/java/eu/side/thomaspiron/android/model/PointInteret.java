package eu.side.thomaspiron.android.model;

/**
 * Created by mdupierreux1 on 28/08/15.
 */
public class PointInteret {
    private Integer idInteret;
    private String libelleFr;
    private String libelleEn;
    private Integer idPays;
    private String email;

    public PointInteret() {

    }

    public Integer getIdInteret() {
        return idInteret;
    }

    public void setIdInteret(Integer idInteret) {
        this.idInteret = idInteret;
    }

    public String getLibelleFr() {
        return libelleFr;
    }

    public void setLibelleFr(String libelleFr) {
        this.libelleFr = libelleFr;
    }

    public String getLibelleEn() {
        return libelleEn;
    }

    public void setLibelleEn(String libelleEn) {
        this.libelleEn = libelleEn;
    }

    public Integer getIdPays() {
        return idPays;
    }

    public void setIdPays(Integer idPays) {
        this.idPays = idPays;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
