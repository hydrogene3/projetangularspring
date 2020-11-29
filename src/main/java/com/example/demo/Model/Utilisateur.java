package com.example.demo.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    private  String username;
    private String password;
    private String photo;


    public Utilisateur(String nom, String prenom, String username, String password, String photo, Collection<AppRole> roles) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.photo = photo;
        this.roles = roles;
    }

    public Utilisateur(){};


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    public Collection<AppRole> roles = new ArrayList<>();



    public Collection<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }
}
