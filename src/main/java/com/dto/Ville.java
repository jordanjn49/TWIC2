/*
 * Copyright (c) 2022.
 * Writed by Jordan Jouin
 * Student at ESEO (Angers)
 */

package com.dto;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "ville_france")
@Data
public class Ville {

    @Id

    @Column(name="code_commune_insee")
    private String id;

    @Column(name="nom_commune")
    private String nomCommune;

    @Column(name="code_postal")
    private String codeP;

    @Column(name="libelle_acheminement")
    private String libelleA;

    @Column(name="ligne_5")
    private String ligne5;

    @Column(name="latitude")
    private String latitude;

    @Column(name="longitude")
    private String longitude;

}
