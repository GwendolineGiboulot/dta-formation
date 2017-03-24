package fr.pizzeria.admin.metier;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.admin.event.PizzaEvent;
import fr.pizzeria.admin.event.TypeEvent;
import fr.pizzeria.model.Pizza;

@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class PizzaServiceEJB {

	@Inject
	private Event<PizzaEvent> pizzEvent;

	@PersistenceContext(unitName = "pizzeria-pu")
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Pizza> findAll() {

		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);

		List<Pizza> l = query.getResultList();

		return l;

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveNew(Pizza pizza) {

		em.persist(pizza);

		pizzEvent.fire(new PizzaEvent(pizza.getCode(), LocalDateTime.now(), TypeEvent.CREATION));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(String code, Pizza pizza) {

		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.code='" + code + "'", Pizza.class);
		Pizza p = (Pizza) query.getResultList().get(0);

		if (p != null) {

			int id = p.getId();

			p = pizza;

			p.setId(id);

			em.merge(p);
		}

		pizzEvent.fire(new PizzaEvent(code, LocalDateTime.now(), TypeEvent.UPDATATION));

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String code) {

		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where p.code='" + code + "'", Pizza.class);
		Pizza p = (Pizza) query.getResultList().get(0);

		if (p != null) {
			em.remove(p);
		}

		pizzEvent.fire(new PizzaEvent(code, LocalDateTime.now(), TypeEvent.DELETATION));

	}

}
