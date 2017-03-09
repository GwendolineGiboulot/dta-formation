package fr.pizzeria.ihm;

import fr.pizzeria.tools.IhmTools;

/**
 * @author Quelqun
 *
 */
@OptionMenu
public class ActionExporterVersBase extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		System.out.println("Import des fichiers dans la BDD");

		ihmTools.getPizzaDao().importer();

	}

	@Override
	String getLibelle() {

		return "Importer les fichiers vers la base de donnée";
	}

}
