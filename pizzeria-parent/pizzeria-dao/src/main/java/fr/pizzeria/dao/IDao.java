package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.UpdateDaoException;

/**
 * @author Quelqun
 *
 * @param <E>
 * @param <Id>
 */
public interface IDao<E, Id> {

	/**
	 * @return
	 */
	List<E> findAllPizzas();

	/**
	 * @param pizza
	 * @throws SaveDaoException
	 */
	void saveNewPizza(E pizza) throws SaveDaoException;

	/**
	 * @param code
	 * @param pizza
	 * @throws UpdateDaoException
	 */
	void updatePizza(Id code, E pizza) throws UpdateDaoException;

	/**
	 * @param code
	 * @throws DeleteDaoException
	 */
	void deletePizza(Id code) throws DeleteDaoException;

}
