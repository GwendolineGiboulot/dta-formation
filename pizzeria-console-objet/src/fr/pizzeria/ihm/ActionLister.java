package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

public class ActionLister extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		List<Pizza> tableauPizza = ihmTools.getPizzaDao().findAllPizzas();

		for (Pizza pizza : tableauPizza) {
			// System.out.println(tableauPizza.get(i).code + " -> " +
			// tableauPizza.get(i).nom + " ("
			// + tableauPizza.get(i).prix + " €) " +
			// tableauPizza.get(i).categorie.getLibelle());

			System.out.println(pizza.toString());
		}
		System.out.println("-> " + tableauPizza.size() + " pizzas créées depuis l'initialisation du programme");

	}

	@Override
	String getLibelle() {

		return "Afficher la liste des pizzas";
	}

}
