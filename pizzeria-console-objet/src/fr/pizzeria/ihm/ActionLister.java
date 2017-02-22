package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDaoImplTableau;
import fr.pizzeria.model.Pizza;

public class ActionLister extends Action {

	@Override
	void faireAction() {

		PizzaDaoImplTableau pizz = new PizzaDaoImplTableau();

		Pizza[] tableauPizza = pizz.findAllPizzas();

		for (int i = 0; i < tableauPizza.length; ++i) {
			System.out
					.println(tableauPizza[i].code + " -> " + tableauPizza[i].nom + " (" + tableauPizza[i].prix + " €)");
		}
		System.out.println("-> " + tableauPizza.length + " pizzas créées depuis l'initialisation du programme");

	}

	@Override
	String getLibelle() {

		return "Afficher la liste des pizzas";
	}

}
