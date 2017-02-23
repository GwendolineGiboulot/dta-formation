package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImplTableau;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class ActionAjouter extends Action {

	@Override
	void faireAction() {

		PizzaDaoImplTableau pizz = new PizzaDaoImplTableau();

		Scanner reader = new Scanner(System.in); // Reading from System.in

		System.out.println("Veuillez saisir le code");

		String code = reader.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = reader.next();
		System.out.println("Veuillez saisir le prix");
		double prix = reader.nextDouble();

		Pizza pizza = new Pizza(36, code, nom, prix);

		try {
			pizz.saveNewPizza(pizza);
		} catch (SavePizzaException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	String getLibelle() {
		return "Ajouter une pizza";
	}

}
