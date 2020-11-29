package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="AssociationJSC")
public class AssociationJSC extends  Utilisateur {
@OneToMany(mappedBy = "associationJSC")
@JsonIgnore
private List<Evenement>evenementList;




    public List<Evenement> getEvenementList() {
        return evenementList;
    }

    public void setEvenementList(List<Evenement> evenementList) {
        this.evenementList = evenementList;
    }

    public AssociationJSC(String nom, String prenom, String username, String password, String photo, Collection<AppRole> roles, List<Evenement> evenementList) {
        super(nom, prenom, username, password, photo, roles);
        this.evenementList = evenementList;
    }

    public AssociationJSC(List<Evenement> evenementList) {
        this.evenementList = evenementList;
    }

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }
    public AssociationJSC(){}


}
