package fr.pizzeria.tools;

import java.util.Scanner;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoImplFichier;
import fr.pizzeria.model.Pizza;

public class IhmTools {

	private IDao<Pizza, String> pizzaDao = new PizzaDaoImplFichier();
	private Scanner reader = new Scanner(System.in);

	public IDao<Pizza, String> getPizzaDao() {
		return pizzaDao;
	}

	public void setPizzaDao(IDao<Pizza, String> pizzaDao) {
		this.pizzaDao = pizzaDao;
	}

	public Scanner getReader() {
		return reader;
	}

	public void setReader(Scanner reader) {
		this.reader = reader;
	}

}
