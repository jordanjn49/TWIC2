package com.dao;

import com.dto.Ville;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DaoFactory {
    private String url;
    private String username;
    private String password;

    DaoFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static DaoFactory getInstance() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        DaoFactory instance = new DaoFactory("jdbc:mysql://localhost:3306/ville_france", "javaee", "pass1234");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        Connection connexion = DriverManager.getConnection(url, username, password);
        connexion.setAutoCommit(false);
        return connexion;
    }

    // Récupération des tables (DAO)

    public VilleDAO getVilleDao() {
        return new VilleDAOImpl(this);
    }
}
