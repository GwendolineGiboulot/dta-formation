package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTableau implements IPizzaDao {

	private static Pizza tableauPizza[] = new Pizza[100];

	private static int tailleTableau = 0;

	static {
		tableauPizza[0] = new Pizza(0, "PEP", "Pépéroni", 12.50);
		tableauPizza[1] = new Pizza(1, "MAR", "Margherita", 14.00);
		tableauPizza[2] = new Pizza(2, "REI", "La Reine", 11.50);
		tableauPizza[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00);
		tableauPizza[4] = new Pizza(4, "CAN", "La cannibale", 12.50);
		tableauPizza[5] = new Pizza(5, "SAV", "La savoyarde", 13.00);
		tableauPizza[6] = new Pizza(6, "ORI", "L’orientale", 13.50);
		tableauPizza[7] = new Pizza(7, "IND", "L’indienne", 14.00);

		tailleTableau = 8;
	}

	@Override
	public Pizza[] findAllPizzas() {
		Pizza tableauARenvoyer[] = new Pizza[tailleTableau];

		for (int i = 0; i < tailleTableau; ++i) {
			tableauARenvoyer[i] = tableauPizza[i];

		}

		return tableauARenvoyer;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) {
		if (tailleTableau < 100) {

			pizza.id = tailleTableau;
			tableauPizza[tailleTableau] = pizza;
			tailleTableau++;
			return true;
		} else {

			return false;
		}

	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {

		boolean trouve = false;
		int num_pizza = -1;
		for (int i = 0; i < Pizza.nbPizzas; ++i) {

			if (tableauPizza[i].code.equals(codePizza)) {

				trouve = true;
				num_pizza = i;
				break;
			}
		}

		if (trouve == true) {

			tableauPizza[num_pizza] = pizza;

		}
		return trouve;
	}

	@Override
	public boolean deletePizza(String codePizza) {
		boolean trouve = false;
		int num_pizza = -1;
		for (int i = 0; i < Pizza.nbPizzas; ++i) {

			if (tableauPizza[i].code.equals(codePizza)) {

				trouve = true;
				num_pizza = i;
				break;
			}
		}

		if (trouve == true) {

			for (int i = num_pizza; i < Pizza.nbPizzas - 1; ++i) {

				tableauPizza[i].id = tableauPizza[i + 1].id;
				tableauPizza[i].code = tableauPizza[i + 1].code;
				tableauPizza[i].nom = tableauPizza[i + 1].nom;
				tableauPizza[i].prix = tableauPizza[i + 1].prix;

			}
			tailleTableau--;
		}
		return trouve;
	}

}
