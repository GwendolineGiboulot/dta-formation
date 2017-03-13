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
	List<E> findAll();

	/**
	 * @param pizza
	 * @throws SaveDaoException
	 */
	void saveNew(E pizza) throws SaveDaoException;

	/**
	 * @param code
	 * @param pizza
	 * @throws UpdateDaoException
	 */
	void update(I code, E pizza) throws UpdateDaoException;

	/**
	 * @param code
	 * @throws DeleteDaoException
	 */
	void delete(I code) throws DeleteDaoException;

	/**
	 * @param source
	 */
	default void importer(IDao<E, I> source) {
		throw new DaoRuntimeException("IL FAUT UTILISER LE DAO BDD POUR UTILISER L'IMPORT");
	}

	/**
	 * cette fonction peuple la base de pizza
	 */
	default void peuplerBasePizza() {
		throw new DaoRuntimeException("Fonction non implémenté");
	}

}
