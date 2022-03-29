/*
 * Copyright (c) 2022.
 * Writed by Jordan Jouin
 * Student at ESEO (Angers)
 */

package com.blo;

import com.dto.Ville;

import java.util.List;

public interface VilleBLO {
    void addVille(Ville ville);
    List<Ville> findAllVilles();
    void updateVille(String code_commune_insee, String Code_postal, String Latitude,
                     String Longitude, String Nom_commune, String Libelle_acheminement, String Ligne_5);
    void deleteVille(String code_commune_insee);
}
