package com.example.demo.Service;

import com.example.demo.Model.*;

public interface AccountService {

    Administrateur saveAdmin(Administrateur admin);
    Visiteur saveVisiteur(Visiteur visiteur);
    AssociationJSC saveAssociationJSC(AssociationJSC associationJSC);

    AppRole save(AppRole role);
    Utilisateur loadUserByUsername(String username);
    void addRoleToUser(String username, String roleName);

}

