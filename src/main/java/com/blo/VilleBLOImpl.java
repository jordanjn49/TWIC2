/*
 * Copyright (c) 2022.
 * Writed by Jordan Jouin
 * Student at ESEO (Angers)
 */

package com.blo;

import com.dto.Ville;
import com.jpa.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VilleBLOImpl implements VilleBLO {

    private final VilleRepository villeRepo;

    @Autowired
    public VilleBLOImpl(VilleRepository villeRepo) {
        this.villeRepo = villeRepo;
    }


    public void addVille(Ville ville) {
//        System.out.println(ville);
        Optional<Ville> villeOptional = villeRepo
                .findVilleByNom_commune(ville.getNom_commune());
        if (villeOptional.isPresent()) {
            throw new IllegalStateException("Ville déjà prise");
        }
        villeRepo.save(ville);
    }

    public List<Ville> findAllVilles() {
//        System.out.println(villeRepo.findAll());
//        return null;
        return villeRepo.findAll();
    }

    @Transactional
    public void updateVille(String code_commune_insee, String Code_postal, String Latitude,
                            String Longitude, String Nom_commune, String Libelle_acheminement, String Ligne_5) {
        Ville ville = villeRepo.findById(code_commune_insee)
                .orElseThrow(() -> new IllegalStateException("La ville avec CodeINSEE=" + code_commune_insee + " n'existe pas."));

        if ((Code_postal != null)
                && (Code_postal.length() > 0)
                && (!Object.equals(ville.getCode_postal(), Code_postal))) {
            ville.setCode_postal(Code_postal);
        }

        if ((Latitude != null)
                && (Latitude.length() > 0)
                && (!Object.equals(ville.getLatitude(), Latitude))) {
            ville.setLatitude(Latitude);
        }

        if ((Longitude != null)
                && (Longitude.length() > 0)
                && (!Object.equals(ville.getLongitude(), Longitude))) {
            ville.setLongitude(Longitude);
        }

        if ((Nom_commune != null)
                && (Nom_commune.length() > 0)
                && (!Object.equals(ville.getNom_commune(), Nom_commune))) {
            ville.setNom_commune(Nom_commune);
        }

        if ((Libelle_acheminement != null)
                && (Libelle_acheminement.length() > 0)
                && (!Object.equals(ville.getLibelle_acheminement(), Libelle_acheminement))) {
            ville.setLibelle_acheminement(Libelle_acheminement);
        }

        if ((Ligne_5 != null)
                && (Ligne_5.length() > 0)
                && (!Object.equals(ville.getLigne_5(), Ligne_5))) {
            ville.setLigne_5(Ligne_5);
        }
    }

    public void deleteVille(String code_commune_insee) {
        boolean exists = villeRepo.existsById(code_commune_insee);
        if (!exists) {
            throw new IllegalStateException("Ville avec CodeINSEE= " + code_commune_insee + "n'existe pas");
        }
        villeRepo.deleteById(code_commune_insee);
    }
}

