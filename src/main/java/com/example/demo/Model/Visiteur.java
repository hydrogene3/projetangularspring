package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="Visiteur")
public class Visiteur extends Utilisateur {

    @OneToMany(mappedBy = "visiteur")
    @JsonIgnore
    private List<Reservation> reservationList;

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }


    public Visiteur(String nom, String prenom, String username, String password, String photo, Collection<AppRole> roles, List<Reservation> reservationList) {
        super(nom, prenom, username, password, photo, roles);
        this.reservationList = reservationList;
    }

    public Visiteur(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }

    public Visiteur(){}


}
