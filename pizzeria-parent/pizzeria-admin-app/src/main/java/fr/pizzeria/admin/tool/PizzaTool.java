package fr.pizzeria.admin.tool;

import fr.pizzeria.dao.PizzaDaoImplTableau;

public class PizzaTool {

	public static PizzaDaoImplTableau dao;

	static {

		dao = new PizzaDaoImplTableau();
	}

	public PizzaTool() {
		super();

	}

}
