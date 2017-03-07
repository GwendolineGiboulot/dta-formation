package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

@OptionMenu
public class ActionLister extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		List<Pizza> tableauPizza = ihmTools.getPizzaDao().findAllPizzas();

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
