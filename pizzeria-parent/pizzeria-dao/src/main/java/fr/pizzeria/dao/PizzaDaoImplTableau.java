package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTableau implements IDao<Pizza, String> {

	private Pizza tableauPizza[] = new Pizza[100];

	private int tailleTableau = 0;

	public PizzaDaoImplTableau() {

		tableauPizza[0] = new Pizza(0, "PEP", "Pépéronni", 12.50, CategoriePizza.POISSON);
		tableauPizza[1] = new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.VIANDE);
		tableauPizza[2] = new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.VIANDE);
		tableauPizza[3] = new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE);
		tableauPizza[4] = new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE);
		tableauPizza[5] = new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE);
		tableauPizza[6] = new Pizza(6, "ORI", "L'orientale", 13.50, CategoriePizza.VIANDE);
		tableauPizza[7] = new Pizza(7, "IND", "L'indienne", 14.00, CategoriePizza.SANS_VIANDE);

		tailleTableau = 8;

	}

	@Override
	public List<Pizza> findAllPizzas() {
		Pizza tableauARenvoyer[] = new Pizza[tailleTableau];

		for (int i = 0; i < tailleTableau; ++i) {
			tableauARenvoyer[i] = tableauPizza[i];

		}

		return new ArrayList<>(Arrays.asList(tableauARenvoyer));

	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SaveDaoException {

		if (pizza.code.length() != 3) {
			throw new SaveDaoException("Un code doit faire 3 caractère");
		}

		String pizzaMaj = pizza.code.toUpperCase();

		if (!pizzaMaj.equals(pizza.code)) { // ie si le code
											// n'est pas
			throw new SaveDaoException("Un code pizza doit être en majuscule"); // tout
																				// en
																				// majuscule

		}

		if (tailleTableau < 100) {

			pizza.id = tailleTableau;
			tableauPizza[tailleTableau] = pizza;
			tailleTableau++;
		} else {
			throw new SaveDaoException("Trop de pizza, impossible d'en ajouter");
		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdateDaoException {

		boolean trouve = false;
		int numPizza = -1;
		for (int i = 0; i < tailleTableau; ++i) {

			if (tableauPizza[i].code.equals(codePizza)) {

				trouve = true;
				numPizza = i;
				break;
			}
		}

		if (trouve) {

			tableauPizza[numPizza] = pizza;

		} else {
			throw new UpdateDaoException("Code pizza introuvable");
		}
	}

	@Override
	public void deletePizza(String codePizza) throws DeleteDaoException {
		boolean trouve = false;
		int numPizza = -1;
		for (int i = 0; i < tailleTableau; ++i) {

			if (tableauPizza[i].code.equals(codePizza)) {

				trouve = true;
				numPizza = i;
				break;
			}
		}

		if (trouve) {

			for (int i = numPizza; i < tailleTableau - 1; ++i) {

				tableauPizza[i].id = tableauPizza[i + 1].id;
				tableauPizza[i].code = tableauPizza[i + 1].code;
				tableauPizza[i].nom = tableauPizza[i + 1].nom;
				tableauPizza[i].prix = tableauPizza[i + 1].prix;

			}
			tailleTableau--;
		} else {
			throw new DeleteDaoException("Code pizza introuvable");
		}
	}

}
