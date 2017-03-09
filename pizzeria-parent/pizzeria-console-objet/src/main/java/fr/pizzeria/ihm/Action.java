package fr.pizzeria.ihm;

import fr.pizzeria.tools.IhmTools;

/**
 * @author Quelqun
 *
 */
public abstract class Action {

	abstract void faireAction(IhmTools ihmTools);

	abstract String getLibelle();

}
