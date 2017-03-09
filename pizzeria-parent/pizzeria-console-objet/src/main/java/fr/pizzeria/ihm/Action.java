package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

public abstract class Action {

	abstract void faireAction(IhmTools ihmTools);

	abstract String getLibelle();

	public Pizza SaisirPizza(Scanner c) {

		System.out.println("Veuillez saisir le code");

		String code = c.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = c.nextLine();
		System.out.println("Veuillez saisir le prix");
		double prix = c.nextDouble();
		c.nextLine();
		System.out.println("Veuillez saisir la cat�gorie");
		String categorie = c.nextLine();

		return new Pizza(36, code, nom, prix, CategoriePizza.getEnum(categorie));

	}

}
