package fr.pizzeria.ihm;

import fr.pizzeria.exception.IhmRuntimeException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

/**
 * @author Quelqun
 *
 */
@OptionMenu
public class ActionAjouter extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		Pizza pizza = ihmTools.saisirPizza(ihmTools.getReader());

		try {
			ihmTools.getPizzaDao().saveNew(pizza);
		} catch (SaveDaoException e) {
			throw new IhmRuntimeException(e);
		}

	}

	@Override
	String getLibelle() {
		return "Ajouter une pizza";
	}

}
