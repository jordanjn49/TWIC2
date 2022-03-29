package com.blo;

import com.dto.Ville;

import java.util.List;

public interface VilleBLO {
    public void addVille(Ville ville);
//    public Ville findVilleById(String Code_commune_INSEE);
    public List<Ville> findAllVilles();
    public Ville updateVille(Ville ville);
}
