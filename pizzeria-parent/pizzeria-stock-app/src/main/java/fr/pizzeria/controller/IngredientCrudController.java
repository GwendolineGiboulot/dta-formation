package fr.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.model.Ingredient;
import fr.pizzeria.repo.IngredientRepository;

@Controller
public class IngredientCrudController {

	@Autowired
	private IngredientRepository IngredientRepo;

	@RequestMapping(path = "/ingredients", method = RequestMethod.GET)
	public ModelAndView listerIngredient() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ListerIngredient");
		mav.addObject("lIngr", IngredientRepo.findAll());
		return mav;
	}

	@RequestMapping(path = "/ingredients/{ingreId}", method = RequestMethod.GET)
	public ModelAndView editerIngredient(@PathVariable int ingreId) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("EditerIngredient");
		mav.addObject("ingre", IngredientRepo.findOne(ingreId));

		return mav;
	}

	@RequestMapping(path = "/ingredients/{ingreId}", method = RequestMethod.POST)
	public String methodePost(@PathVariable int ingreId, @ModelAttribute("ingre") Ingredient ingre) {
		ingre.setId(ingreId);
		IngredientRepo.save(ingre);
		return "redirect:" + "/mvc/ingredients";
	}

}
