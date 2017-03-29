package fr.pizzeria.ihm;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.IhmRuntimeException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

/**
 * @author Quelqun
 *
 */
@OptionMenu
@Controller
public class ActionMettreAJour extends Action {

	IDao<Pizza, String> dao;

	Scanner scan;

	@Autowired
	public ActionMettreAJour(IDao<Pizza, String> dao, Scanner scan) {
		this.dao = dao;
		this.scan = scan;
	}

	@Override
	void faireAction() {

		System.out.println("Veuillez saisir le code de la pizza à mettre à jour");
		String codeARemplacer = scan.nextLine();

		IhmTools ihmTools = new IhmTools(scan);

		Pizza pizza = ihmTools.saisirPizza();

		try {
			dao.update(codeARemplacer, pizza);
		} catch (UpdateDaoException e) {
			throw new IhmRuntimeException(e);
		}

	}

	@Override
	String getLibelle() {
		return "Mettre a jour une Pizza";
	}

}