package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTableau implements IPizzaDao {

	private static Pizza tableauPizza[] = new Pizza[100];

	private static int tailleTableau = 0;

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
