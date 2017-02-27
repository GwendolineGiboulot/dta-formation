package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.UpdateDaoException;

public interface IDao<E, Id> {

	List<E> findAllPizzas();

	void saveNewPizza(E pizza) throws SaveDaoException;

	void updatePizza(Id code, E pizza) throws UpdateDaoException;

	void deletePizza(Id code) throws DeleteDaoException;

}
