package fr.pizzeria.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.IhmRuntimeException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

/**
 * @author Quelqun
 *
 */
@OptionMenu
@Controller
public class ActionAjouter extends Action {

	IDao<Pizza, String> dao;

	Scanner scan;

	@Autowired
	public ActionAjouter(IDao<Pizza, String> dao, Scanner scan) {
		this.dao = dao;
		this.scan = scan;
	}

	// @Override
	void faireAction() {

		IhmTools ihmTools = new IhmTools(scan);

		Pizza pizza = ihmTools.saisirPizza();

		try {
			dao.saveNew(pizza);
		} catch (SaveDaoException e) {
			throw new IhmRuntimeException(e);
		}

	}

	// @Override
	String getLibelle() {
		return "Ajouter une pizza";
	}

}
