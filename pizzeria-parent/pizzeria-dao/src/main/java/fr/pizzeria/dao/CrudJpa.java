package fr.pizzeria.dao;

import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.model.Pizza;

public class CrudJpa<E, I> implements IDao<E, I> {

	private Class<E> classe;
	private EntityManagerFactory emf;

	public CrudJpa(Class<E> classe, EntityManagerFactory emf) {
		this.emf = emf;
		this.classe = classe;
	}

	@Override
	public List<E> findAll() {

		EntityManager em = emf.createEntityManager();

		TypedQuery<E> query = em.createQuery("select p from " + classe.getName() + " p", classe);

		List<E> l = query.getResultList();

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
	public void saveNew(E pizza) throws SaveDaoException {

		executeUpdate(t -> t.persist(pizza));

	}

	@Override
	public void update(I code, E pizza) throws UpdateDaoException {

		executeUpdate(t -> {

			TypedQuery<Pizza> query = t
					.createQuery("select p from " + classe.getName() + " p where p.id='" + code + "'", Pizza.class);
			Pizza p = (Pizza) query.getResultList().get(0);

			if (p != null) {
				t.remove(p);
				t.persist(pizza);
			}

		});

	}

	@Override
	public void delete(I code) throws DeleteDaoException {

		executeUpdate(t -> {

			TypedQuery<Pizza> query = t
					.createQuery("select p from " + classe.getName() + " p where p.id='" + code + "'", Pizza.class);
			Pizza p = (Pizza) query.getResultList().get(0);

			if (p != null) {
				t.remove(p);
			}

		});

	}
}
