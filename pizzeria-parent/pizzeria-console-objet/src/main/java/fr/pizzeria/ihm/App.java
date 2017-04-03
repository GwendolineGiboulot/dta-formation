package fr.pizzeria.ihm;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.console.PizzeriaAppSpringConfig;

/**
 * @author Quelqun
 *
 */
public class App {

	private App() {

	}

	/**
	 * @param args
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * 
	 *             Point d'entrée principal du programme
	 * 
	 */

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {

		Logger.getLogger("org").setLevel(Level.SEVERE);

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				PizzeriaAppSpringConfig.class)) {

			MenuBase menu = context.getBean(MenuBase.class);

			menu.demarrer();

		}

	}
}
