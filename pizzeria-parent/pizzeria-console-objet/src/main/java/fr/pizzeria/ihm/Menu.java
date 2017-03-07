package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.exception.IhmRuntimeException;
import fr.pizzeria.tools.IhmTools;

public abstract class Menu {

	protected Map<Integer, Action> menuAction = new HashMap<>();

	public Menu() {

	}

	public void demarrer() {

		try {

			int choix = 0;

			IhmTools ihmTools;

			ihmTools = new IhmTools();

			while (choix != 98) {

				menuAction.forEach((k, v) -> System.out.println(k + " : " + v.getLibelle()));

				System.out.println("99 : Sortir");

				choix = ihmTools.getReader().nextInt();
				ihmTools.getReader().nextLine();

				if (choix == 99) {
					break;
				} else {
					if (choix > 0 && choix < menuAction.size() + 1)
						menuAction.get(choix).faireAction(ihmTools);

				}

			}

			ihmTools.getReader().close();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new IhmRuntimeException(e);
		}
	}

}
