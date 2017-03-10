package fr.pizzeria.tools;

import java.util.ResourceBundle;
import java.util.Scanner;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Quelqun
 *
 */
public class IhmTools {

	private IDao<Pizza, String> pizzaDao;
	private Scanner reader = new Scanner(System.in);

	/**
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public IhmTools() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		ResourceBundle bundle = ResourceBundle.getBundle("conf/application");
		String daoImpl = bundle.getString("dao.impl");

		IDao<Pizza, String> dao = (IDao<Pizza, String>) Class.forName(daoImpl).newInstance();
		pizzaDao = dao;

	}

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

	/**
	 * @param c
	 * @return
	 * 
	 * 		permet de faire remplir un objet pizza par l'utilisateur
	 */

	public Pizza saisirPizza(Scanner c) {

		System.out.println("Veuillez saisir le code");

		String code = c.nextLine();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = c.nextLine();
		System.out.println("Veuillez saisir le prix");
		double prix = c.nextDouble();
		c.nextLine();
		System.out.println("Veuillez saisir la cat�gorie");
		String categorie = c.nextLine();

		return new Pizza(code, nom, prix, CategoriePizza.getEnum(categorie));

	}

}
