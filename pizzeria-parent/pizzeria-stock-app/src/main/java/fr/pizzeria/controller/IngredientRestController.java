package fr.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.pizzeria.model.Ingredient;
import fr.pizzeria.repo.IngredientRepository;

@Controller
@RequestMapping("/rest/ingredients")
public class IngredientRestController {

	@Autowired
	private IngredientRepository IngredientRepo;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Ingredient> methodeGet() {
		return IngredientRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void methodePost(@RequestBody Ingredient ingre) {
		IngredientRepo.save(ingre);
	}

}
