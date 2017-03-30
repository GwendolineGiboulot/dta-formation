package fr.pizzeria.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Performance;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.repo.PerformanceRepo;

@OptionMenu
@Controller
public class ActionAfficherPerfo extends Action {

	IDao<Pizza, String> dao;

	@Autowired
	private PerformanceRepo perfoDao;

	@Override
	void faireAction() {

		List<Performance> listePerfo = perfoDao.findAll();

		for (Performance perfo : listePerfo) {

			System.out.println(perfo.toString());
		}
		System.out.println(listePerfo.size() + " performances mesurées depuis l'initialisation du programme");

	}

	@Override
	String getLibelle() {
		return "Afficher les PERFORMANCES !!!!!";
	}

}
