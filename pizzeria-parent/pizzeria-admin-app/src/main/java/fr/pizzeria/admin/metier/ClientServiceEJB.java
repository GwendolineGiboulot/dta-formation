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

import fr.pizzeria.model.Client;

@Stateless
@TransactionManagement(value = TransactionManagementType.CONTAINER)
public class ClientServiceEJB {

	@PersistenceContext(unitName = "pizzeria-pu")
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Client> findAll() {

		TypedQuery<Client> query = em.createQuery("select p from Client p", Client.class);

		List<Client> l = query.getResultList();

		return l;

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void saveNew(Client client) {

		em.persist(client);

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void update(String code, Client client) {

		TypedQuery<Client> query = em.createQuery("select p from Client p where p.id='" + code + "'", Client.class);
		Client p = (Client) query.getResultList().get(0);

		if (p != null) {

			int id = p.getId();

			p = client;

			p.setId(id);

			em.merge(p);
		}

	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(String code) {

		TypedQuery<Client> query = em.createQuery("select p from Client p where p.id='" + code + "'", Client.class);
		Client p = (Client) query.getResultList().get(0);

		if (p != null) {
			em.remove(p);
		}

	}

}
