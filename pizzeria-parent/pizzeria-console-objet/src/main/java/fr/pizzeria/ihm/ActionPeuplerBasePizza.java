package fr.pizzeria.ihm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Pizza;

@OptionMenu
@Controller
public class ActionPeuplerBasePizza extends Action {

	IDao<Pizza, String> dao;

	@Autowired
	public ActionPeuplerBasePizza(IDao<Pizza, String> dao) {
		this.dao = dao;
	}

	@Override
	void faireAction() {

		dao.peuplerBasePizza();

	}

	@Override
	String getLibelle() {
		return "Rajouter 8 pizzas par defaut a la base de pizza";
	}

}
