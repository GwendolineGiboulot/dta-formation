package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoImplTableau;
import fr.pizzeria.exception.DeletePizzaException;

public class ActionSupprimer extends Action {

	@Override
	void faireAction() {

		PizzaDaoImplTableau pizz = new PizzaDaoImplTableau();

		Scanner reader = new Scanner(System.in); // Reading from System.in

		System.out.println("Veuillez saisir le code de la pizza à supprimer");
		String codePizza = reader.next();

		try {
			pizz.deletePizza(codePizza);
		} catch (DeletePizzaException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	String getLibelle() {
		return "Supprimer une Pizza";
	}

}