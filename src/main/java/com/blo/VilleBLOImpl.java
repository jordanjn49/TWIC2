package com.blo;

import com.dto.Ville;
import com.jpa.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleBLOImpl implements VilleBLO {

    private final VilleRepository villeRepo;

    @Autowired
    public VilleBLOImpl(VilleRepository villeRepo) {
        this.villeRepo = villeRepo;
    }

    public void addVille(Ville ville) {
//        System.out.println(ville);
        villeRepo.save(ville);
    }

//    public Ville findVilleById(String Code_commune_INSEE) {
//        return villeRepo.findVilleById(Code_commune_INSEE)
//                .orElseThrow(() -> new UserPrincipalNotFoundException("City by ID " + Code_commune_INSEE + " was not found"));
//    }

    public List<Ville> findAllVilles() {
//        System.out.println(villeRepo.findAll());
//        return null;
        return villeRepo.findAll();
    }

    public Ville updateVille(Ville ville) {
        return villeRepo.save(ville);
    }

}

