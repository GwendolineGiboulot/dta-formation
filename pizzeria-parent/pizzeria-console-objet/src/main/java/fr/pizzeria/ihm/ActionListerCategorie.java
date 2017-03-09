package fr.pizzeria.ihm;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.tools.IhmTools;

/**
 * @author Quelqun
 *
 */
@OptionMenu
public class ActionListerCategorie extends Action {

	@Override
	void faireAction(IhmTools ihmTools) {

		List<Pizza> tableauPizza = ihmTools.getPizzaDao().findAllPizzas();

		Map<CategoriePizza, List<Pizza>> map = tableauPizza.stream()
				.collect(Collectors.groupingBy(Pizza::getCategorie));

		System.out.println(map);

	}

	@Override
	String getLibelle() {
		return "Afficher une liste de pizza par catégorie";
	}

}
