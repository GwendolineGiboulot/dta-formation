package fr.pizzeria.ihm;

import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Quelqun
 *
 */

public abstract class Menu {

	@Autowired
	private Scanner scan;

	protected Map<Integer, Action> menuAction;

	public Menu() {

	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	public Map<Integer, Action> getMenuAction() {
		return menuAction;
	}

	public void setMenuAction(Map<Integer, Action> menuAction) {
		this.menuAction = menuAction;
	}

	/**
	 * lance le menu principal
	 */
	public void demarrer() {

		int choix = 0;

		while (choix != 98) {

			menuAction.forEach((k, v) -> {

				System.out.println(k + " : " + v.getLibelle());

			});

			System.out.println("99 : Sortir");

			choix = Integer.valueOf(scan.next());
			scan.nextLine();

			if (choix == 99) {
				break;
			} else {
				if (choix > 0 && choix < menuAction.size() + 1)
					menuAction.get(choix).faireAction();

			}

		}
	}

}
