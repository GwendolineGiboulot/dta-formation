package fr.pizzeria.ihm;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class App {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {

		Pizza p1 = new Pizza(12, "RTE", "la meilleure pizza", 78.25, CategoriePizza.VIANDE);

		Pizza p2 = new Pizza(12, "RTE", "la meilleure pizza", 78.25, CategoriePizza.VIANDE);

		System.out.println(p1.equals(p2));

		new MenuReflection().demarrer();

	}
}
