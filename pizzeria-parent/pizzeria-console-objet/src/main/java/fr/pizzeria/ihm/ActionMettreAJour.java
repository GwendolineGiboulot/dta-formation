package fr.pizzeria.ihm;

import fr.pizzeria.exception.IhmRuntimeException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

/**
 * @author Quelqun
 *
 */
@OptionMenu
public class ActionMettreAJour extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		System.out.println("Veuillez saisir le code de la pizza à mettre à jour");
		String codeARemplacer = ihmTools.getReader().nextLine();

		Pizza pizza = ihmTools.saisirPizza(ihmTools.getReader());

		try {
			ihmTools.getPizzaDao().update(codeARemplacer, pizza);
		} catch (UpdateDaoException e) {
			throw new IhmRuntimeException(e);
		}

	}

	@Override
	String getLibelle() {
		return "Mettre a jour une Pizza";
	}

}