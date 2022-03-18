package com.controller;

import com.blo.VilleBLO;
import com.dto.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class VilleController {

	VilleBLO villeBLODService;

	// fonction pour récupérer le contenu de la BDD
	@RequestMapping(value="/ville", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> get(@RequestParam(required  = false, value="codePostal") String codePostal) {
		System.out.println("get");
		ArrayList<Ville> listeVille = villeBLODService.getInfoVilles(codePostal);
		return listeVille;
	}

	// fonction pour récupérer le contenu de la BDD
	@RequestMapping(value="/ville", method=RequestMethod.POST)
	@ResponseBody
	public String insert(@RequestBody Ville ville, Model model) {
		//public String insert(@RequestBody String num) {
		//System.out.println(num);
		System.out.println(ville);
		return null;
	}

}