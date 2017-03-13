package fr.pizzeria.ihm;

import java.util.logging.Level;
import java.util.logging.Logger;

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

		Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);

		new MenuReflection().demarrer();

	}
}
