package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.IhmRuntimeException;
import fr.pizzeria.model.Pizza;

/**
 * @author Quelqun
 *
 */
@OptionMenu
public class ActionSupprimer extends Action {

	IDao<Pizza, String> dao;
	Scanner scan;

	public ActionSupprimer(IDao<Pizza, String> dao, Scanner scan) {
		this.dao = dao;
		this.scan = scan;
	}

	@Override
	void faireAction() {

		System.out.println("Veuillez saisir le code de la pizza à supprimer");
		String codePizza = scan.next();

		try {
			dao.delete(codePizza);
		} catch (DeleteDaoException e) {
			throw new IhmRuntimeException(e);
		}

	}

	@Override
	String getLibelle() {
		return "Supprimer une Pizza";
	}

}