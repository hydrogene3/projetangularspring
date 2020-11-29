package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Reservation {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)


private  Long id_res;
private  float prix;
private  int codePayement;
private  boolean accepete;
    @ManyToOne
    @JsonIgnore
    private Evenement evenement;
    @ManyToOne
    private Visiteur visiteur;
    public Reservation(long id_res, float prix, int codePayement, boolean accepete) {
        this.id_res = id_res;
        this.prix = prix;
        this.codePayement = codePayement;
        this.accepete = accepete;
    }


    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public Reservation() {
    }


    public Long getId_res() {
        return id_res;
    }

    public void setId_res(Long id_res) {
        this.id_res = id_res;
    }



    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getCodePayement() {
        return codePayement;
    }

    public void setCodePayement(int codePayement) {
        this.codePayement = codePayement;
    }

    public boolean isAccepete() {
        return accepete;
    }

    public void setAccepete(boolean accepete) {
        this.accepete = accepete;
    }





}
