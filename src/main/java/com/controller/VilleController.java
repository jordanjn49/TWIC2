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
	public List<Ville> get() {
		return List.of(new Ville("01001", "L ABERGEMENT CLEMENCIAT", "01400", "L ABERGEMENT CLEMENCIAT", "", "46.1331001556", "4.99858455549"),
				new Ville("01002", "L ABERGEMENT CLEMENCIAT", "01400", "L ABERGEMENT CLEMENCIAT", "", "46.1331001556", "4.99858455549"));
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