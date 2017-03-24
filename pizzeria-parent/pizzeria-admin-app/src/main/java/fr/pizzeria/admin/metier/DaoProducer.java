package fr.pizzeria.admin.metier;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoImplTableau;
import fr.pizzeria.model.Pizza;

public class DaoProducer {

	@Produces
	@ApplicationScoped
	public IDao<Pizza, String> buildDao() {
		return new PizzaDaoImplTableau();
	}

}
