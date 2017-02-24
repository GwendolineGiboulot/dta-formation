package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

public class ActionLister extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		List<Pizza> tableauPizza = ihmTools.getPizzaDao().findAllPizzas();

		for (int i = 0; i < tableauPizza.size(); ++i) {
			System.out.println(tableauPizza.get(i).toString());
		}
		System.out.println("-> " + tableauPizza.size() + " pizzas cr��es depuis l'initialisation du programme");

	}

	@Override
	String getLibelle() {

		return "Afficher la liste des pizzas";
	}

}
