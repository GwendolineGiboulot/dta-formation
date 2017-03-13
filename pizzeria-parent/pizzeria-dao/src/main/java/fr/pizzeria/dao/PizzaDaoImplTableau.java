package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Quelqun
 * 
 *         cette classe implémente IDao avec des fichiers .txt sur le disque
 *
 */
public class PizzaDaoImplTableau implements IDao<Pizza, String> {

	private Pizza[] tableauPizza = new Pizza[100];

	private int tailleTableau = 0;

	/**
	 * 
	 * Ce constructeur initialize le tableau avec 8 pizzas
	 * 
	 */
	public PizzaDaoImplTableau() {

		tableauPizza[0] = new Pizza("PEP", "Pépéronni", 12.50, CategoriePizza.POISSON);
		tableauPizza[1] = new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VIANDE);
		tableauPizza[2] = new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE);
		tableauPizza[3] = new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE);
		tableauPizza[4] = new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE);
		tableauPizza[5] = new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE);
		tableauPizza[6] = new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE);
		tableauPizza[7] = new Pizza("IND", "L'indienne", 14.00, CategoriePizza.SANS_VIANDE);

		tailleTableau = 8;

	}

	@Override
	public List<Pizza> findAll() {
		Pizza[] tableauARenvoyer = new Pizza[tailleTableau];

		for (int i = 0; i < tailleTableau; ++i) {
			tableauARenvoyer[i] = tableauPizza[i];

		}

		return new ArrayList<>(Arrays.asList(tableauARenvoyer));

	}

	@Override
	public void saveNew(Pizza pizza) throws SaveDaoException {

		if (pizza.getCode().length() != 3) {
			throw new SaveDaoException("Un code doit faire 3 caractère");
		}

		String pizzaMaj = pizza.getCode().toUpperCase();

		if (!pizzaMaj.equals(pizza.getCode())) { // ie si le code
			// n'est pas
			throw new SaveDaoException("Un code pizza doit être en majuscule"); // tout
																				// en
																				// majuscule

		}

		if (tailleTableau < 100) {

			pizza.setId(tailleTableau);
			tableauPizza[tailleTableau] = pizza;
			tailleTableau++;
		} else {
			throw new SaveDaoException("Trop de pizza, impossible d'en ajouter");
		}

	}

	@Override
	public void update(String codePizza, Pizza pizza) throws UpdateDaoException {

		boolean trouve = false;
		int numPizza = -1;
		for (int i = 0; i < tailleTableau; ++i) {

			if (tableauPizza[i].getCode().equals(codePizza)) {

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
	public void delete(String codePizza) throws DeleteDaoException {
		boolean trouve = false;
		int numPizza = -1;
		for (int i = 0; i < tailleTableau; ++i) {

			if (tableauPizza[i].getCode().equals(codePizza)) {

				trouve = true;
				numPizza = i;
				break;
			}
		}

		if (trouve) {

			for (int i = numPizza; i < tailleTableau - 1; ++i) {

				tableauPizza[i].setId(tableauPizza[i + 1].getId());
				tableauPizza[i].setCode(tableauPizza[i + 1].getCode());
				tableauPizza[i].setNom(tableauPizza[i + 1].getNom());
				tableauPizza[i].setPrix(tableauPizza[i + 1].getPrix());

			}
			tailleTableau--;
		} else {
			throw new DeleteDaoException("Code pizza introuvable");
		}
	}

}
