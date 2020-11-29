package com.example.demo.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Evenement")

public class Evenement {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id_event;
    private String titre;
    private String description;
    private String photo;
    private String prix;
    private Date date;
    private long nbrejour  ;
    private String speakers;
    private String planning;
    @ManyToOne
    private Ville villes;

    public Ville getVilles() {
        return villes;
    }

    public void setVilles(Ville villes) {
        this.villes = villes;
    }

    @ManyToMany(mappedBy = "EvenementList")
    private List<Activite> activiteList;
    public List<Activite> getActiviteList() {
        return activiteList;
    }

    public void setActiviteList(List<Activite> activiteList) {
        this.activiteList = activiteList;
    }
    @OneToMany(mappedBy = "evenement")
    private List<Reservation> reservationList;

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @ManyToOne
private AssociationJSC associationJSC;

    public AssociationJSC getAssociationJSC() {
        return associationJSC;
    }

    public void setAssociationJSC(AssociationJSC associationJSC) {
        this.associationJSC = associationJSC;
    }

    public Evenement(String titre, String description, String photo, String prix, Date date, long nbrejour, String speakers, String planning, Ville villes, List<Activite> activiteList, List<Reservation> reservationList, AssociationJSC associationJSC) {
        this.titre = titre;
        this.description = description;
        this.photo = photo;
        this.prix = prix;
        this.date = date;
        this.nbrejour = nbrejour;
        this.speakers = speakers;
        this.planning = planning;
        this.villes = villes;
        this.activiteList = activiteList;
        this.reservationList = reservationList;
        this.associationJSC = associationJSC;
    }

    public Evenement(){}

    public long getId_event() {
        return id_event;
    }

    public void setId_event(long id_event) {
        this.id_event = id_event;
    }

    public String getTitre() {
        return titre;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getNbrejour() {
        return nbrejour;
    }

    public void setNbrejour(long nbrejour) {
        this.nbrejour = nbrejour;
    }

    public String getSpeakers() {
        return speakers;
    }

    public void setSpeakers(String speakers) {
        this.speakers = speakers;
    }

    public String getPlanning() {
        return planning;
    }

    public void setPlanning(String planning) {
        this.planning = planning;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
}
