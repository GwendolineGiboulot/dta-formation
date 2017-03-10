package fr.pizzeria.ihm;

import java.util.Set;

import org.reflections.Reflections;

import fr.pizzeria.exception.IhmRuntimeException;

/**
 * @author Quelqun
 *
 */
public class MenuReflection extends Menu {

	/**
	 * 
	 * ce constructeur fabrique un menu automatiquement un menu a partir des
	 * items ayant l'anotation OptionMenu
	 * 
	 */
	public MenuReflection() {
		Reflections reflections = new Reflections("fr.pizzeria.ihm");

		Set<Class<? extends Action>> subTypes = reflections.getSubTypesOf(Action.class);

		int i = 1;
		for (Class<? extends Action> classe : subTypes) {

			OptionMenu annotationTrouve = classe.getAnnotation(OptionMenu.class);

			if (annotationTrouve != null) {

				try {
					menuAction.put(i++, classe.newInstance());
				} catch (InstantiationException | IllegalAccessException e) {
					throw new IhmRuntimeException(e);
				}
			}

		}

	}

}
