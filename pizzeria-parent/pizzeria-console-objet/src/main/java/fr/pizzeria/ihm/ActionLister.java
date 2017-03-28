package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Pizza;

/**
 * @author Quelqun
 *
 */
@OptionMenu
public class ActionLister extends Action {

	IDao<Pizza, String> dao;

	public ActionLister(IDao<Pizza, String> dao) {
		this.dao = dao;
	}

	@Override
	void faireAction() {

		List<Pizza> tableauPizza = dao.findAll();

		for (Pizza pizza : tableauPizza) {

			System.out.println(pizza.toString());
		}
		System.out.println("-> " + tableauPizza.size() + " pizzas créées depuis l'initialisation du programme");

	}

	@Override
	String getLibelle() {

		return "Afficher la liste des pizzas";
	}

}
