package fr.pizzeria.ihm;

import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

public class ActionMettreAJour extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		System.out.println("Veuillez saisir le code de la pizza à mettre à jour");
		String codeARemplacer = ihmTools.getReader().next();

		System.out.println("Veuillez saisir le nouveau code");
		String code = ihmTools.getReader().next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = ihmTools.getReader().next();
		System.out.println("Veuillez saisir le prix");
		double prix = ihmTools.getReader().nextDouble();

		Pizza pizza = new Pizza(36, code, nom, prix);

		try {
			ihmTools.getPizzaDao().updatePizza(codeARemplacer, pizza);
		} catch (UpdateDaoException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	String getLibelle() {
		return "Mettre a jour une Pizza";
	}

}