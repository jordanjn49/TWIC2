/*
 * Copyright (c) 2022.
 * Writed by Jordan Jouin
 * Student at ESEO (Angers)
 */

package com.blo;

import com.dto.Ville;
import com.exception.VilleNotFoundException;
import com.jpa.VilleRepository;
import lombok.Data;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class VilleService {

    @Autowired
    private VilleRepository villeRepo;

    public List<Ville> findAllVille() {
        return villeRepo.findAll();
    }

    public Ville findVilleById(String id) {
        return villeRepo.findVilleById(id).orElseThrow(() -> new VilleNotFoundException("Ville by id" + id + "not found"));
    }

    public Ville addVille(Ville ville) {
        return villeRepo.save(ville);
    }

    @Transactional
    public void updateVille(String code_commune_insee,
                            String Code_postal,
                            String Latitude,
                            String Longitude,
                            String Nom_commune,
                            String Libelle_acheminement,
                            String Ligne_5) {
        Ville ville = villeRepo.findById(code_commune_insee)
                .orElseThrow(() -> new IllegalStateException("La ville avec CodeINSEE=" + code_commune_insee + " n'existe pas."));

        if ((Code_postal != null)
                && (Code_postal.length() > 0)) {
            ville.setCodeP(Code_postal);
        }

        if ((Latitude != null)
                && (Latitude.length() > 0)) {
            ville.setLatitude(Latitude);
        }

        if ((Longitude != null)
                && (Longitude.length() > 0)) {
            ville.setLongitude(Longitude);
        }

        if ((Nom_commune != null)
                && (Nom_commune.length() > 0)) {
            ville.setNomCommune(Nom_commune);
        }

        if ((Libelle_acheminement != null)
                && (Libelle_acheminement.length() > 0)) {
            ville.setLibelleA(Libelle_acheminement);
        }

        if ((Ligne_5 != null)
                && (Ligne_5.length() > 0)) {
            ville.setLigne5(Ligne_5);
        }
    }

    public void deleteVille(final String id) {
        boolean exists = villeRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Ville avec CodeINSEE= " + id + "n'existe pas");
        }
        villeRepo.deleteById(id);
    }
}

