package com.capstone.mini.petini.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capstone.mini.petini.model.PetiniRole;

public interface PetiniRoleRepo extends JpaRepository<PetiniRole, Long> {
    @Query(value = "select r from PetiniRole r where r.name = :name")
    Optional<PetiniRole> findRoleByName(@Param("name") String name);
}
