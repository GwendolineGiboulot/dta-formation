package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplFichier implements IDao<Pizza, String> {

	@Override
	public List<Pizza> findAllPizzas() {

		List<Pizza> listPizza = new ArrayList<Pizza>();

		try {

			List<String> lines = Files.readAllLines(
					Paths.get("C:\\Users\\Quelqun\\Documents\\workspace-sts-3.8.3.RELEASE\\apps\\data\\pizza.txt"));

			for (String s : lines) {
				String[] items = s.split(";");

				Pizza p = new Pizza(Integer.parseInt(items[0]), items[1], items[2], Double.parseDouble(items[3]),
						CategoriePizza.getEnum(items[4]));

				listPizza.add(p);

			}

		} catch (IOException e) {
			System.out.println("ERREUR LORS DE LA LECTURE");
		}

		// TODO Auto-generated method stub
		return listPizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {

		List<String> lines = Arrays.asList(pizza.toCSV());

		try {
			Files.write(Paths.get("C:\\Users\\Quelqun\\Documents\\workspace-sts-3.8.3.RELEASE\\apps\\data\\pizza.txt"),
					lines, StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("ERREUR LORS DE L'ECRITURE");
		}

	}

	@Override
	public void updatePizza(String code, Pizza pizza) throws UpdateDaoException {
		List<Pizza> listPizza = findAllPizzas();

		boolean trouve = false;
		int num_pizza = -1;
		for (int i = 0; i < Pizza.nbPizzas; ++i) {

			if (listPizza.get(i).code.equals(code)) {

				trouve = true;
				num_pizza = i;
				break;
			}
		}

		if (trouve == true) {

			listPizza.set(num_pizza, pizza);

		} else {
			throw new UpdateDaoException("Code pizza introuvable");
		}

		List<String> lines = new ArrayList<String>(); // Arrays.asList(pizza.toCSV());

		for (Pizza p : listPizza) {
			lines.add(p.toCSV());
		}

		try {
			Files.write(Paths.get("C:\\Users\\Quelqun\\Documents\\workspace-sts-3.8.3.RELEASE\\apps\\data\\pizza.txt"),
					lines);
		} catch (IOException e) {
			System.out.println("ERREUR LORS DE L'ECRITURE");
		}

	}

	@Override
	public void deletePizza(String code) throws DeleteDaoException {

		List<Pizza> listPizza = findAllPizzas();

		boolean trouve = false;
		int num_pizza = -1;
		for (int i = 0; i < Pizza.nbPizzas; ++i) {

			if (listPizza.get(i).code.equals(code)) {

				trouve = true;
				num_pizza = i;
				break;
			}
		}

		if (trouve == true) {

			listPizza.remove(num_pizza);

		} else {
			throw new DeleteDaoException("Code pizza introuvable");
		}

		List<String> lines = new ArrayList<String>(); // Arrays.asList(pizza.toCSV());

		for (Pizza p : listPizza) {
			lines.add(p.toCSV());
		}

		try {
			Files.write(Paths.get("C:\\Users\\Quelqun\\Documents\\workspace-sts-3.8.3.RELEASE\\apps\\data\\pizza.txt"),
					lines);
		} catch (IOException e) {
			System.out.println("ERREUR LORS DE L'ECRITURE");
		}

	}

}
