package fr.pizzeria.ihm;

import fr.pizzeria.exception.IhmRuntimeException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

@OptionMenu
public class ActionAjouter extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		System.out.println("Veuillez saisir le code");

		String code = ihmTools.getReader().nextLine();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = ihmTools.getReader().nextLine();
		System.out.println("Veuillez saisir le prix");
		double prix = ihmTools.getReader().nextDouble();
		ihmTools.getReader().nextLine();
		System.out.println("Veuillez saisir la cat�gorie");
		String categorie = ihmTools.getReader().nextLine();

		Pizza pizza = new Pizza(36, code, nom, prix, CategoriePizza.getEnum(categorie));

		try {
			ihmTools.getPizzaDao().saveNewPizza(pizza);
		} catch (SaveDaoException e) {
			throw new IhmRuntimeException(e);
		}

	}

	@Override
	String getLibelle() {
		return "Ajouter une pizza";
	}

}
