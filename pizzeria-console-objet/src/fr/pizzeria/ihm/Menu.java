package fr.pizzeria.ihm;

import java.util.Scanner;

public class Menu {

	public static void menuPrincipal() {

		Action menuAction[] = { new ActionLister(), new ActionAjouter(), new ActionMettreAJour(),
				new ActionSupprimer() };
		String libelle[] = { new ActionLister().getLibelle(), new ActionAjouter().getLibelle(),
				new ActionMettreAJour().getLibelle(), new ActionSupprimer().getLibelle() };

		int choix = 0;
		Scanner reader = new Scanner(System.in);

		while (choix != 98) {

			for (int i = 0; i < libelle.length; ++i) {
				System.out.println(i + 1 + " : " + libelle[i]);
			}

			System.out.println("99 : Sortir");

			choix = reader.nextInt() - 1;

			if (choix == 98) {
				break;
			} else {
				if (choix > -1 && choix < menuAction.length)
					menuAction[choix].faireAction();

			}

		}

		reader.close();
	}

}
