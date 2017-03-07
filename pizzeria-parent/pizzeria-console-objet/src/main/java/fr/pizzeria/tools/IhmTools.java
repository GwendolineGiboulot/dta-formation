package fr.pizzeria.tools;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Pizza;

public class IhmTools {

	public IhmTools() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		ResourceBundle bundle = ResourceBundle.getBundle("conf/application");
		String daoImpl = bundle.getString("dao.impl");

		IDao<Pizza, String> dao = (IDao<Pizza, String>) Class.forName(daoImpl).newInstance();

		pizzaDao = dao;

	}

	private IDao<Pizza, String> pizzaDao;
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
