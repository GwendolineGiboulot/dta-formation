package fr.pizzeria.ihm;

import java.util.ResourceBundle;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.IhmRuntimeException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

/**
 * @author Quelqun
 *
 */
@OptionMenu
public class ActionExporterVersBase extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		ResourceBundle bundle = ResourceBundle.getBundle("conf/application");
		String daoImpl = bundle.getString("dao.source");

		try {
			IDao<Pizza, String> dao = (IDao<Pizza, String>) Class.forName(daoImpl).newInstance();
			System.out.println("Import des fichiers dans la BDD");

			ihmTools.getPizzaDao().importer(dao);

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new IhmRuntimeException(e);
		}

	}

	@Override
	String getLibelle() {

		return "Importer les fichiers vers la base de donnée";
	}

}
