package fr.pizzeria.admin.tool;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoImplTableau;
import fr.pizzeria.model.Pizza;

public interface PizzaTool {

	IDao<Pizza, String> DAO = new PizzaDaoImplTableau();

}
