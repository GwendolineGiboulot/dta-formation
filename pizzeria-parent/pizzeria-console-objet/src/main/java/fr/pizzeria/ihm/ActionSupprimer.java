package fr.pizzeria.ihm;

import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.IhmRuntimeException;
import fr.pizzeria.tools.IhmTools;

@OptionMenu
public class ActionSupprimer extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		System.out.println("Veuillez saisir le code de la pizza à supprimer");
		String codePizza = ihmTools.getReader().next();

		try {
			ihmTools.getPizzaDao().deletePizza(codePizza);
		} catch (DeleteDaoException e) {
			throw new IhmRuntimeException(e);
		}

	}

	@Override
	String getLibelle() {
		return "Supprimer une Pizza";
	}

}