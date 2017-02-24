package fr.pizzeria.ihm;

import fr.pizzeria.tools.IhmTools;

public abstract class Action {

	abstract void faireAction(IhmTools ihmTools);

	abstract String getLibelle();

}
