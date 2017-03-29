package fr.pizzeria.ihm;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppAnotation {

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

		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml")) {

			MenuBase menu = context.getBean(MenuBase.class);

			menu.demarrer();

		}

	}
}
