package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Ville")
public class Ville {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long id_ville;
    private String name;
    @OneToMany(mappedBy = "villes")
@JsonIgnore()
    private List<Evenement> evenement;

    public List<Evenement> getEvenement() {
        return evenement;
    }

    public void setEvenement(List<Evenement> evenement) {
        this.evenement = evenement;
    }

    public Ville(long id_ville, String name) {
        this.id_ville = id_ville;
        this.name = name;
    }
    public Ville() {}
    public long getId_ville() {
        return id_ville;
    }

    public void setId_ville(long id_ville) {
        this.id_ville = id_ville;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
