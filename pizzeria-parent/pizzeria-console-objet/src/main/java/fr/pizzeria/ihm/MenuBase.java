package fr.pizzeria.ihm;

public class MenuBase extends Menu {

	public MenuBase() {

		menuAction.put(1, new ActionLister());
		menuAction.put(2, new ActionAjouter());
		menuAction.put(3, new ActionMettreAJour());
		menuAction.put(4, new ActionSupprimer());
		menuAction.put(5, new ActionListerCategorie());
		menuAction.put(6, new ActionAfficherPrixMax());
	}

}
