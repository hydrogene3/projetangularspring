package com.example.demo.Service;

import com.example.demo.Model.*;
import com.example.demo.Repository.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepository appUserRepository;
    private AdministrateurRepository administrateurRepository;
    private VisiteurRepository visiteurRepository;
    private AssociationRepository associationRepository;
    private AppRoleRepository appRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, AdministrateurRepository administrateurRepository, VisiteurRepository visiteurRepository, AssociationRepository associationRepository, AppRoleRepository appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.appUserRepository = appUserRepository;
        this.administrateurRepository = administrateurRepository;
        this.visiteurRepository = visiteurRepository;
        this.associationRepository = associationRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Administrateur saveAdmin(Administrateur admin) {
        Utilisateur  user=appUserRepository.findByUsername(admin.getUsername());
        if(user!=null) throw new RuntimeException("User already exists");
        Administrateur appUser=new Administrateur();
        appUser.setUsername(admin.getUsername());
        appUser.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
        appUser.setNom(admin.getNom());
        appUser.setPrenom(admin.getPrenom());
        appUser.setPhoto(admin.getPhoto());

        AppRole role=appRoleRepository.findByRoleName("ADMIN");
        if(role != null){
            appUser.getRoles().add(role);
            appUserRepository.save(appUser);
        }
        return appUser;
    }

    @Override
    public Visiteur saveVisiteur(Visiteur visiteur) {
        Utilisateur  user=appUserRepository.findByUsername(visiteur.getUsername());
        if(user!=null) throw new RuntimeException("User already exists");
        Visiteur appUser=new Visiteur();
        appUser.setUsername(visiteur.getUsername());
        appUser.setPassword(bCryptPasswordEncoder.encode(visiteur.getPassword()));
        appUser.setNom(visiteur.getNom());
        appUser.setPrenom(visiteur.getPrenom());
        appUser.setPhoto(visiteur.getPhoto());



        appUserRepository.save(appUser);
        addRoleToUser(visiteur.getUsername(),"Visiteur");
        return appUser;
    }


    @Override
    public AssociationJSC saveAssociationJSC(AssociationJSC associationJSC) {
        Utilisateur  user=appUserRepository.findByUsername(associationJSC.getUsername());
        if(user!=null) throw new RuntimeException("User already exists");
        AssociationJSC appUser=new AssociationJSC();
        appUser.setUsername(associationJSC.getUsername());
        appUser.setPassword(bCryptPasswordEncoder.encode(associationJSC.getPassword()));
        appUser.setNom(associationJSC.getNom());
        appUser.setPrenom(associationJSC.getPrenom());
        appUser.setPhoto(associationJSC.getPhoto());

        appUserRepository.save(appUser);
        addRoleToUser(associationJSC.getUsername(),"Association");
        return appUser;    }

    @Override
    public AppRole save(AppRole role) {
        return appRoleRepository.save(role);    }

    @Override
    public Utilisateur loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Utilisateur appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findByRoleName(roleName);
        appUser.getRoles().add(appRole);
    }
}
