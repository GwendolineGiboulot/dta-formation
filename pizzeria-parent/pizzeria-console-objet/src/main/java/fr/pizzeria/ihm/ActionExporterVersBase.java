package fr.pizzeria.ihm;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.IhmRuntimeException;
import fr.pizzeria.model.Pizza;

/**
 * @author Quelqun
 *
 */
@OptionMenu
@Controller
public class ActionExporterVersBase extends Action {

	IDao<Pizza, String> dao;

	@Autowired
	public ActionExporterVersBase(IDao<Pizza, String> dao) {
		this.dao = dao;
	}

	@Override
	void faireAction() {

		ResourceBundle bundle = ResourceBundle.getBundle("conf/application");
		String daoImpl = bundle.getString("dao.source");

		try {
			IDao<Pizza, String> dao = (IDao<Pizza, String>) Class.forName(daoImpl).newInstance();
			System.out.println("Import des fichiers dans la BDD");

			dao.importer(dao);

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new IhmRuntimeException(e);
		}

	}

	@Override
	String getLibelle() {

		return "Importer les fichiers vers la base de donnée";
	}

}
