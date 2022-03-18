package com.dao;

import com.dto.Ville;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class VilleDAOImpl implements VilleDAO {

    private DaoFactory daoFactory;

    public VilleDAOImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public ArrayList<Ville> findAllVilles() {
        ArrayList<Ville> listVille = new ArrayList<Ville>();

        Ville ville = new Ville();
        ville.setCode_postal("44000");
        ville.setNom_commune("Test");
        listVille.add(ville);
        return listVille;
    }
}
