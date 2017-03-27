package fr.pizzeria.admin.metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.model.Pizza;

@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class CrudServiceEJB<E, I> {

	@PersistenceContext(unitName = "pizzeria-pu")
	private EntityManager em;

	private Class<E> classe;

	public CrudServiceEJB() {

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<E> findAll() {

		TypedQuery<E> query = em.createQuery("select p from " + classe.getName() + " p", classe);

		List<E> l = query.getResultList();

		return l;

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveNew(E pizza) throws SaveDaoException {

		em.persist(pizza);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(I code, E pizza) throws UpdateDaoException {

		TypedQuery<Pizza> query = em.createQuery("select p from " + classe.getName() + " p where p.id='" + code + "'",
				Pizza.class);
		Pizza p = (Pizza) query.getResultList().get(0);

		if (p != null) {
			em.remove(p);
			em.persist(pizza);
		}

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(I code) throws DeleteDaoException {

		TypedQuery<Pizza> query = em.createQuery("select p from " + classe.getName() + " p where p.id='" + code + "'",
				Pizza.class);
		Pizza p = (Pizza) query.getResultList().get(0);

		if (p != null) {
			em.remove(p);
		}

	}

}
