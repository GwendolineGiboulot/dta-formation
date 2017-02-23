package fr.pizzeria.dao;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
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
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {

		if (pizza.code.length() != 3) {
			throw new SavePizzaException("Un code doit faire 3 caractère");
		}

		if (pizza.code.toUpperCase() != pizza.code) { // ie si le code n'est pas
			throw new SavePizzaException("Un code pizza doit être en majuscule"); // tout
																					// en
																					// majuscule

		}

		if (tailleTableau < 100) {

			pizza.id = tailleTableau;
			tableauPizza[tailleTableau] = pizza;
			tailleTableau++;
		} else {
			throw new SavePizzaException("Trop de pizza, impossible d'en ajouter");
		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {

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

		} else {
			throw new UpdatePizzaException("Code pizza introuvable");
		}
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
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

			for (int i = num_pizza; i < tailleTableau - 1; ++i) {

				tableauPizza[i].id = tableauPizza[i + 1].id;
				tableauPizza[i].code = tableauPizza[i + 1].code;
				tableauPizza[i].nom = tableauPizza[i + 1].nom;
				tableauPizza[i].prix = tableauPizza[i + 1].prix;

			}
			tailleTableau--;
		} else {
			throw new DeletePizzaException("Code pizza introuvable");
		}
	}

}
