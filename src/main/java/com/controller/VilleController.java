/*
 * Copyright (c) 2022.
 * Writed by Jordan Jouin
 * Student at ESEO (Angers)
 */

package com.controller;

import com.blo.VilleService;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleController {

	private final VilleService villeService;

	@Autowired
	public VilleController(VilleService villeService) {
		this.villeService = villeService;
	}

	@GetMapping(path = "all")
	public ResponseEntity<List<Ville>> getAllVilles() {
		List<Ville> villes = villeService.findAllVille();
		return new ResponseEntity<>(villes, HttpStatus.OK);
	}

	@GetMapping(path = "/find/{id}")
	public ResponseEntity<Ville> getVilleById(@PathVariable("id") String id) {
		Ville ville = villeService.findVilleById(id);
		return new ResponseEntity<>(ville, HttpStatus.OK);
	}

	@GetMapping(path = "/find/{nomCommune}")
	public ResponseEntity<Ville> getVilleByNomCommune(@PathVariable("nomCommune") String nomCommune) {
		Ville ville = villeService.findVilleByNomCommune(nomCommune);
		return new ResponseEntity<>(ville, HttpStatus.OK);
	}

	@PostMapping(path = "/add")
	public ResponseEntity<Ville> addVille(@RequestBody Ville ville) {
		Ville newVille = villeService.addVille(ville);
		return new ResponseEntity<>(newVille,HttpStatus.CREATED);
	}

	@PutMapping(path = "/update/{id}")
	public void updateVille(
			@PathVariable("id") String code_commune_insee,
			@RequestParam(required = false) String Code_postal,
			@RequestParam(required = false) String Latitude,
			@RequestParam(required = false) String Longitude,
			@RequestParam(required = false) String Nom_commune,
			@RequestParam(required = false) String Libelle_acheminement,
			@RequestParam(required = false) String Ligne_5)
			{
			villeService.updateVille(code_commune_insee, Code_postal, Latitude, Longitude, Nom_commune, Libelle_acheminement, Ligne_5);
	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<?> deleteVille(@PathVariable("id") String id) {
		villeService.deleteVille(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}