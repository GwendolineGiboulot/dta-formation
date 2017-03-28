package fr.pizzeria.tools;

import java.util.Scanner;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Quelqun
 *
 */
public class IhmTools {

	Scanner c;

	public IhmTools(Scanner scan) {
		c = scan;
	}

	public Pizza saisirPizza() {

		System.out.println("Veuillez saisir le code");

		String code = c.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = c.nextLine();
		System.out.println("Veuillez saisir le prix");
		double prix = c.nextDouble();
		c.nextLine();
		System.out.println("Veuillez saisir la catégorie");
		String categorie = c.nextLine();

		return new Pizza(code, nom, prix, CategoriePizza.getEnum(categorie));

	}

}
