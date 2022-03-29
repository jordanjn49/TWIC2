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






















//	// fonction pour récupérer le contenu de la BDD
//	@RequestMapping(value="/ville", method=RequestMethod.GET)
//	@ResponseBody
//	public ArrayList<Ville> get(@RequestParam(required  = false, value="codePostal") String codePostal) {
//		System.out.println("get");
//		ArrayList<Ville> listeVille = villeBLODService.getInfoVilles(codePostal);
//		return listeVille;
//	}
//
//	// fonction pour récupérer le contenu de la BDD
//	@RequestMapping(value="/ville", method=RequestMethod.POST)
//	@ResponseBody
//	public String insert(@RequestBody Ville ville, Model model) {
//		//public String insert(@RequestBody String num) {
//		//System.out.println(num);
//		System.out.println(ville);
//		return null;
//	}

}