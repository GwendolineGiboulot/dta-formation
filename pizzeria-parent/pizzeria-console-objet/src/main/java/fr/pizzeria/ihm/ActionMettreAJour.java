package fr.pizzeria.ihm;

import fr.pizzeria.exception.IhmRuntimeException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

@OptionMenu
public class ActionMettreAJour extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		System.out.println("Veuillez saisir le code de la pizza à mettre à jour");
		String codeARemplacer = ihmTools.getReader().nextLine();

		System.out.println("Veuillez saisir le nouveau code");
		String code = ihmTools.getReader().nextLine();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = ihmTools.getReader().nextLine();
		System.out.println("Veuillez saisir le prix");
		double prix = ihmTools.getReader().nextDouble();
		ihmTools.getReader().nextLine();
		System.out.println("Veuillez saisir la catégorie");
		String categorie = ihmTools.getReader().nextLine();

		Pizza pizza = new Pizza(36, code, nom, prix, CategoriePizza.getEnum(categorie));

		try {
			ihmTools.getPizzaDao().updatePizza(codeARemplacer, pizza);
		} catch (UpdateDaoException e) {
			throw new IhmRuntimeException(e);
		}

	}

	@Override
	String getLibelle() {
		return "Mettre a jour une Pizza";
	}

}