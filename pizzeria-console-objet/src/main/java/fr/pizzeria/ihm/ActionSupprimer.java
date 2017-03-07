package fr.pizzeria.ihm;

import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.tools.IhmTools;

@OptionMenu
public class ActionSupprimer extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		System.out.println("Veuillez saisir le code de la pizza � supprimer");
		String codePizza = ihmTools.getReader().next();

		try {
			ihmTools.getPizzaDao().deletePizza(codePizza);
		} catch (DeleteDaoException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	String getLibelle() {
		return "Supprimer une Pizza";
	}

}