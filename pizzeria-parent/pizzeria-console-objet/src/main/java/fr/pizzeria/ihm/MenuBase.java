package fr.pizzeria.ihm;

/**
 * @author Quelqun
 *
 */
public class MenuBase extends Menu {

	/**
	 * 
	 * ce constructeur permet de faire un menu mais il faut rajouter les items a
	 * la main
	 * 
	 */
	public MenuBase() {

		menuAction.put(1, new ActionLister());
		menuAction.put(2, new ActionAjouter());
		menuAction.put(3, new ActionMettreAJour());
		menuAction.put(4, new ActionSupprimer());
		menuAction.put(5, new ActionListerCategorie());
		menuAction.put(6, new ActionAfficherPrixMax());
	}

}
