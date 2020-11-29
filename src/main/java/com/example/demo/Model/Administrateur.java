package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name="Administrateur")
public class Administrateur extends Utilisateur {

    public Administrateur(String nom, String prenom, String username, String password, String photo, Collection<AppRole> roles) {
        super(nom, prenom, username, password, photo, roles);
    }

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }

    public Administrateur() {
    }
}
