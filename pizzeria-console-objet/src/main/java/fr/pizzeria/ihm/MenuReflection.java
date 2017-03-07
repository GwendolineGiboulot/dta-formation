package fr.pizzeria.ihm;

import java.util.Set;

import org.reflections.Reflections;

public class MenuReflection extends Menu {

	public MenuReflection() {
		Reflections reflections = new Reflections("fr.pizzeria.ihm");

		Set<Class<? extends Action>> subTypes = reflections.getSubTypesOf(Action.class);

		int i = 1;
		for (Class<? extends Action> classe : subTypes) {

			OptionMenu annotationTrouve = classe.getAnnotation((OptionMenu.class));

			if (annotationTrouve != null) {

				try {
					menuAction.put(i++, classe.newInstance());
				} catch (InstantiationException | IllegalAccessException e) {
					throw new RuntimeException(e);
				}
			}

		}

	}

}
