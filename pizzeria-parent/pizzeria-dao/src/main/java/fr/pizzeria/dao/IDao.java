package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.DaoRuntimeException;
import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.UpdateDaoException;

/**
 * @author Quelqun
 *
 * @param <E>
 * @param <I>
 */
public interface IDao<E, I> {

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
	void updatePizza(I code, E pizza) throws UpdateDaoException;

	/**
	 * @param code
	 * @throws DeleteDaoException
	 */
	void deletePizza(I code) throws DeleteDaoException;

	/**
	 * 
	 */
	default void importer() {
		throw new DaoRuntimeException("IL FAUT UTILISER LE DAO BDD POUR UTILISER L'IMPORT");
	}

}
