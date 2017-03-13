package fr.pizzeria.tools;

import java.util.Scanner;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.CommandePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Quelqun
 *
 */
public class IhmTools {

	private IDao<Pizza, Integer> pizzaDao;
	private IDao<Client, Integer> clientDao;
	private IDao<Commande, Integer> commandeDao;
	private IDao<CommandePizza, Integer> commandePizzaDao;

	private boolean estConnecte = false;
	private Client client;

	private Scanner reader = new Scanner(System.in);

	/**
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public IhmTools() throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		DaoFactory df = new DaoFactory();

		pizzaDao = df.createPizzaDao();
		clientDao = df.createClientDao();
		commandeDao = df.createCommandeDao();
		commandePizzaDao = df.createCommandePizzaDao();

	}

	public IDao<Commande, Integer> getCommandeDao() {
		return commandeDao;
	}

	public void setCommandeDao(IDao<Commande, Integer> commandeDao) {
		this.commandeDao = commandeDao;
	}

	public IDao<CommandePizza, Integer> getCommandePizzaDao() {
		return commandePizzaDao;
	}

	public void setCommandePizzaDao(IDao<CommandePizza, Integer> commandePizzaDao) {
		this.commandePizzaDao = commandePizzaDao;
	}

	public IDao<Client, Integer> getClientDao() {
		return clientDao;
	}

	public void setClientDao(IDao<Client, Integer> clientDao) {
		this.clientDao = clientDao;
	}

	public IDao<Pizza, Integer> getPizzaDao() {
		return pizzaDao;
	}

	public void setPizzaDao(IDao<Pizza, Integer> pizzaDao) {
		this.pizzaDao = pizzaDao;
	}

	public Scanner getReader() {
		return reader;
	}

	public void setReader(Scanner reader) {
		this.reader = reader;
	}

	public boolean isEstConnecte() {
		return estConnecte;
	}

	public void setEstConnecte(boolean estConnecte) {
		this.estConnecte = estConnecte;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
