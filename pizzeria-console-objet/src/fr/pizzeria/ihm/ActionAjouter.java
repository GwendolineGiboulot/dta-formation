package fr.pizzeria.ihm;

import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

public class ActionAjouter extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		System.out.println("Veuillez saisir le code");

		String code = ihmTools.getReader().next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = ihmTools.getReader().next();
		System.out.println("Veuillez saisir le prix");
		double prix = ihmTools.getReader().nextDouble();

		Pizza pizza = new Pizza(36, code, nom, prix);

		try {
			ihmTools.getPizzaDao().saveNewPizza(pizza);
		} catch (SaveDaoException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	String getLibelle() {
		return "Ajouter une pizza";
	}

}
