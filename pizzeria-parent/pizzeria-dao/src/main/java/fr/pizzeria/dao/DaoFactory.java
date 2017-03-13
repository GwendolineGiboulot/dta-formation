package fr.pizzeria.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Commande;
import fr.pizzeria.model.CommandePizza;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;

public class DaoFactory {

	private EntityManagerFactory emf;

	public DaoFactory() {
		emf = Persistence.createEntityManagerFactory("pizza-pu");
	}

	public CrudJpa<Client, Integer> createClientDao() {
		return new CrudJpa<>(Client.class, emf);
	}

	public CrudJpa<Pizza, Integer> createPizzaDao() {
		return new CrudJpa<>(Pizza.class, emf);
	}

	public CrudJpa<Livreur, Integer> createLivreurDao() {
		return new CrudJpa<>(Livreur.class, emf);
	}

	public CrudJpa<Commande, Integer> createCommandeDao() {
		return new CrudJpa<>(Commande.class, emf);
	}

	public CrudJpa<CommandePizza, Integer> createCommandePizzaDao() {
		return new CrudJpa<>(CommandePizza.class, emf);
	}

}
