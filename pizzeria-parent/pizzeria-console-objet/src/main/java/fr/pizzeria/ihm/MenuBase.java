package fr.pizzeria.ihm;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Quelqun
 *
 */
@Component
public class MenuBase extends Menu {

	/**
	 * 
	 * ce constructeur permet de faire un menu mais il faut rajouter les items a
	 * la main
	 * 
	 */
	public MenuBase() {

	}

	@Autowired
	private ApplicationContext context;

	@PostConstruct
	public void init() {

		menuAction = new HashMap<Integer, Action>();

		menuAction.put(1, context.getBean(ActionLister.class));
		menuAction.put(2, context.getBean(ActionAfficherPrixMax.class));
		menuAction.put(3, context.getBean(ActionAjouter.class));
		menuAction.put(4, context.getBean(ActionListerCategorie.class));
		menuAction.put(5, context.getBean(ActionMettreAJour.class));
		menuAction.put(6, context.getBean(ActionSupprimer.class));

	}
}
