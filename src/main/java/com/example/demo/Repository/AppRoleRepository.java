package com.example.demo.Repository;

import com.example.demo.Model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRoleRepository extends JpaRepository <AppRole,Long> {
    AppRole findByRoleName (String roleName);
}
