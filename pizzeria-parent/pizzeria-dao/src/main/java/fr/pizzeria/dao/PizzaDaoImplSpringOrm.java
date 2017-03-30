package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.model.Pizza;

@Repository
public class PizzaDaoImplSpringOrm implements IDao<Pizza, String> {

	@PersistenceContext
	private EntityManager em;

	public List<Pizza> findAll() {

		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);

		List<Pizza> l = query.getResultList();

		return l;

	}

	@Transactional
	public void saveNew(Pizza pizza) {

		em.persist(pizza);

	}

	@Transactional
	public void update(String code, Pizza pizza) {

		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.code='" + code + "'", Pizza.class);
		Pizza p = (Pizza) query.getResultList().get(0);

		if (p != null) {

			int id = p.getId();

			p = pizza;

			p.setId(id);

			em.merge(p);
		}

	}

	@Transactional
	public void delete(String code) {

		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.code='" + code + "'", Pizza.class);
		Pizza p = (Pizza) query.getResultList().get(0);

		if (p != null) {
			em.remove(p);
		}

	}

}
