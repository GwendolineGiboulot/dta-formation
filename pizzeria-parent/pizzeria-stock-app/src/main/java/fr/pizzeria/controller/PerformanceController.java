package fr.pizzeria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.pizzeria.repo.PerformanceRepo;

@Controller
public class PerformanceController {

	@Autowired
	private PerformanceRepo perfRepo;

	@RequestMapping(path = "/performances", method = RequestMethod.GET)
	public ModelAndView editerIngredient() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("AfficherPerformance");
		mav.addObject("lPerfo", perfRepo.findAll());

		return mav;
	}

}
