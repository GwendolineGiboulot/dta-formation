package fr.pizzeria.ihm;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Pizza;

/**
 * @author Quelqun
 *
 */
@OptionMenu
@Controller
public class ActionAfficherPrixMax extends Action {

	IDao<Pizza, String> dao;

	@Autowired
	public ActionAfficherPrixMax(IDao<Pizza, String> dao) {
		this.dao = dao;
	}

	@Override
	void faireAction() {

		List<Pizza> tableauPizza = dao.findAll();

		double prixMax = tableauPizza.stream().max((p1, p2) -> Double.compare(p1.getPrix(), p2.getPrix())).get()
				.getPrix();

		List<Pizza> result = tableauPizza.stream().filter(p -> p.getPrix().equals(prixMax))
				.collect(Collectors.toList());

		result.forEach(System.out::println);

	}

	@Override
	String getLibelle() {
		return "Afficher les PIZZAs les plus chères";
	}

}
