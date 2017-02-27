package fr.pizzeria.ihm;

import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.tools.IhmTools;

public class Menu {

	public static void menuPrincipal() {

		Map<Integer, Action> menuAction = new HashMap<>();
		menuAction.put(1, new ActionLister());
		menuAction.put(2, new ActionAjouter());
		menuAction.put(3, new ActionMettreAJour());
		menuAction.put(4, new ActionSupprimer());
		menuAction.put(5, new ActionListerCategorie());
		menuAction.put(6, new ActionAfficherPrixMax());

		int choix = 0;

		IhmTools ihmTools = new IhmTools();

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
	}

}
