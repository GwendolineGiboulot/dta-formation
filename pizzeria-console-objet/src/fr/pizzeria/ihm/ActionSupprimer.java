package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImplTableau;

public class ActionSupprimer extends Action {

	@Override
	void faireAction() {

		PizzaDaoImplTableau pizz = new PizzaDaoImplTableau();

		Scanner reader = new Scanner(System.in); // Reading from System.in

		System.out.println("Veuillez saisir le code de la pizza à supprimer");
		String codePizza = reader.next();

		pizz.deletePizza(codePizza);

	}

	@Override
	String getLibelle() {
		return "Supprimer une Pizza";
	}

}