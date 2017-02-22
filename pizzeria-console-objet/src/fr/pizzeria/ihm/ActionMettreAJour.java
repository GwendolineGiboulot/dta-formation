package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImplTableau;
import fr.pizzeria.model.Pizza;

public class ActionMettreAJour extends Action {

	@Override
	void faireAction() {

		PizzaDaoImplTableau pizz = new PizzaDaoImplTableau();

		Scanner reader = new Scanner(System.in); // Reading from System.in

		System.out.println("Veuillez saisir le code de la pizza à mettre à jour");
		String codeARemplacer = reader.next();

		System.out.println("Veuillez saisir le nouveau code");
		String code = reader.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = reader.next();
		System.out.println("Veuillez saisir le prix");
		double prix = reader.nextDouble();

		Pizza pizza = new Pizza(36, code, nom, prix);

		pizz.updatePizza(codeARemplacer, pizza);

	}

	@Override
	String getLibelle() {
		return "Mettre a jour une Pizza";
	}

}