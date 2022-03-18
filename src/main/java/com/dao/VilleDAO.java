package com.dao;

import com.dto.Ville;

import java.util.List;

public interface VilleDAO {

    List<Ville> findAllVilles() throws DaoException;
}
