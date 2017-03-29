package fr.pizzeria.ihm;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author Quelqun
 *
 */
@OptionMenu
@Controller
public class ActionListerCategorie extends Action {

	IDao<Pizza, String> dao;

	@Autowired
	public ActionListerCategorie(IDao<Pizza, String> dao) {
		this.dao = dao;
	}

	@Override
	void faireAction() {

		List<Pizza> tableauPizza = dao.findAll();

		Map<CategoriePizza, List<Pizza>> map = tableauPizza.stream()
				.collect(Collectors.groupingBy(Pizza::getCategorie));

		System.out.println(map);

	}

	@Override
	String getLibelle() {
		return "Afficher une liste de pizza par catégorie";
	}

}
