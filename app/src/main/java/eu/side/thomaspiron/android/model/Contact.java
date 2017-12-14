package eu.side.thomaspiron.android.model;

import java.util.List;

/**
 * Created by mdupierreux1 on 27/08/15.
 */
public class Contact {

    private String sujet;
    private String nom;
    private String prenom;
    private String gsm;
    private String email;
    private String langue;
    private String remarque;

    //for mail
    private List<String> recipientToList;

    //for interet contact
    private String cptEpl;

    public Contact() {
    }


    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public List<String> getRecipientToList() {
        return recipientToList;
    }

    public void setRecipientToList(List<String> recipientToList) {
        this.recipientToList = recipientToList;
    }

    public String getCptEpl() {
        return cptEpl;
    }

    public void setCptEpl(String cptEpl) {
        this.cptEpl = cptEpl;
    }
}
