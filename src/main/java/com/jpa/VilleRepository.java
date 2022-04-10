/*
 * Copyright (c) 2022.
 * Writed by Jordan Jouin
 * Student at ESEO (Angers)
 */
package com.jpa;

import com.dto.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VilleRepository extends JpaRepository<Ville,String> {
    Optional<Ville> findVilleByNomCommune(String nomCommune);
    Optional<Ville> findVilleById(String id);
}
