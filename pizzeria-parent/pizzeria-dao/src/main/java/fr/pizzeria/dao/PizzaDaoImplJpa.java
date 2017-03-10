package fr.pizzeria.dao;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplJpa implements IDao<Pizza, String> {

	EntityManagerFactory emf;

	public PizzaDaoImplJpa() {

		emf = Persistence.createEntityManagerFactory("pizza-pu");
	}

	@Override
	public List findAllPizzas() {

		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("select p from Pizza p");

		List<Pizza> l = query.getResultList();

		em.close();

		return l;

	}

	private void executeUpdate(Consumer<EntityManager> ex) {

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		et.begin();

		ex.accept(em);

		et.commit();

		em.close();

	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SaveDaoException {

		executeUpdate(t -> t.persist(pizza));

	}

	@Override
	public void updatePizza(String code, Pizza pizza) throws UpdateDaoException {

		executeUpdate(t -> {

			Query query = t.createQuery("select p from Pizza p where p.code='" + code + "'");
			Pizza p = (Pizza) query.getResultList().get(0);

			if (p != null) {

				p.setCode(pizza.getCode());
				p.setCategorie(pizza.getCategorie());
				p.setNom(pizza.getNom());
				p.setPrix(pizza.getPrix());

				t.merge(p);
			}

		});

	}

	@Override
	public void deletePizza(String code) throws DeleteDaoException {

		executeUpdate(t -> {

			Query query = t.createQuery("select p from Pizza p where p.code='" + code + "'");
			Pizza p = (Pizza) query.getResultList().get(0);

			if (p != null) {
				t.remove(p);
			}

		});

	}

}
