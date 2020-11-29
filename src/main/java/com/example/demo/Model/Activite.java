package com.example.demo.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Activite")
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_act;
    private String name;
    private String duree;
    private  String description;

    @ManyToMany
    private List<Evenement> EvenementList;

    public List<Evenement> getEvenementList() {
        return EvenementList;
    }

    public void setEvenementList(List<Evenement> evenementList) {
        EvenementList = evenementList;
    }

    public Activite(long id_act, String name, String duree, String description) {
        this.id_act = id_act;
        this.name = name;
        this.duree = duree;
        this.description = description;
    }
    public Activite(){}

    public long getId_act() {
        return id_act;
    }

    public void setId_act(long id_act) {
        this.id_act = id_act;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
