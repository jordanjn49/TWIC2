package com.blo;

import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VilleBLOImpl implements VilleBLO {

/*    @Autowired
    private VilleDAO villeDAO;*/

    public ArrayList<Ville> getInfoVilles(String codePostal) {
        ArrayList<Ville> listVille = new ArrayList<Ville>();

/*        try {
            villeDAO.findAllVilles();
        } catch (DaoException e) {
            e.printStackTrace();
        }*/
        return listVille;
    }

}

