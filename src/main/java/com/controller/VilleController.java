/*
 * Copyright (c) 2022.
 * Writed by Jordan Jouin
 * Student at ESEO (Angers)
 */

package com.controller;

import com.blo.VilleBLO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/villes")
public class VilleController {

	private final VilleBLO villeService;

	@Autowired
	public VilleController(VilleBLO villeService) {
		this.villeService = villeService;
	}

	@Autowired

	@GetMapping
	public List<Ville> getAllVilles() {
		return villeService.findAllVilles();
	}

	@PostMapping
	public void addNewVille(@RequestBody Ville ville) {
		villeService.addVille(ville);
	}

	@PutMapping(path = "{code_commune_insee}")
	public void updateVille(
			@PathVariable("code_commune_insee") String code_commune_insee,
			@RequestParam(required = false) String Code_postal,
			@RequestParam(required = false) String Latitude,
			@RequestParam(required = false) String Longitude,
			@RequestParam(required = false) String Nom_commune,
			@RequestParam(required = false) String Libelle_acheminement,
			@RequestParam(required = false) String Ligne_5)
			{
				villeService.updateVille(code_commune_insee, Code_postal, Latitude, Longitude, Nom_commune, Libelle_acheminement, Ligne_5);

	}

	@DeleteMapping(path = "{code_commune_insee}")
	public void deleteVille(@PathVariable("code_commune_insee") String code_commune_insee) {
		villeService.deleteVille(code_commune_insee);
	}

}