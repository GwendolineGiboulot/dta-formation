package fr.pizzeria.dao;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplJpa implements IDao<Pizza, String> {

	EntityManagerFactory emf;

	public PizzaDaoImplJpa() {

		emf = Persistence.createEntityManagerFactory("pizza-pu");
	}

	@Override
	public List<Pizza> findAll() {

		EntityManager em = emf.createEntityManager();

		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);

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
	public void saveNew(Pizza pizza) throws SaveDaoException {

		executeUpdate(t -> t.persist(pizza));

	}

	@Override
	public void update(String code, Pizza pizza) throws UpdateDaoException {

		executeUpdate(t -> {

			TypedQuery<Pizza> query = t.createQuery("select p from Pizza p where p.code='" + code + "'", Pizza.class);
			Pizza p = (Pizza) query.getResultList().get(0);

			if (p != null) {

				int id = p.getId();

				p = pizza;

				p.setId(id);

				t.merge(p);
			}

		});

	}

	@Override
	public void delete(String code) throws DeleteDaoException {

		executeUpdate(t -> {

			TypedQuery<Pizza> query = t.createQuery("select p from Pizza p where p.code='" + code + "'", Pizza.class);
			Pizza p = (Pizza) query.getResultList().get(0);

			if (p != null) {
				t.remove(p);
			}

		});

	}

	public void peuplerBasePizza() {

		executeUpdate(t -> {

			t.persist(new Pizza("PEP", "Pépéronni", 12.50, CategoriePizza.POISSON));
			t.persist(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.VIANDE));
			t.persist(new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
			t.persist(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
			t.persist(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
			t.persist(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
			t.persist(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
			t.persist(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.SANS_VIANDE));

		});

	}

}
