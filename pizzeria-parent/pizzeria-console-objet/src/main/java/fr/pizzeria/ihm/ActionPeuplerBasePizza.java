package fr.pizzeria.ihm;

import fr.pizzeria.tools.IhmTools;

@OptionMenu
public class ActionPeuplerBasePizza extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		ihmTools.getPizzaDao().peuplerBasePizza();

	}

	@Override
	String getLibelle() {
		return "Rajouter 8 pizzas par defaut a la base de pizza";
	}

}
