package fr.pizzeria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.UpdateDaoException;

public class PizzaDaoImplJpa implements IDao {

	EntityManagerFactory emf;

	public PizzaDaoImplJpa() {

		emf = Persistence.createEntityManagerFactory("pizza-pu");
	}

	@Override
	public List findAllPizzas() {

		EntityManager em = emf.createEntityManager();

		Query query = em.createQuery("select * from pizza ");

		return query.getResultList();
	}

	@Override
	public void saveNewPizza(Object pizza) throws SaveDaoException {

	}

	@Override
	public void updatePizza(Object code, Object pizza) throws UpdateDaoException {

	}

	@Override
	public void deletePizza(Object code) throws DeleteDaoException {

	}

}
