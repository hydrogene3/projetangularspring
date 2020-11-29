package com.example.demo.Repository;

import com.example.demo.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<Utilisateur,Long> {
    public Utilisateur findByUsername(String username);
}
