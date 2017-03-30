package fr.pizzeria.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.repo.PizzaRepository;

@Repository
public class PizzaDaoImplSpringData implements IDao<Pizza, String> {

	@Autowired
	private PizzaRepository piz;

	@Override
	public List<Pizza> findAll() {

		return piz.findAll();
	}

	@Override
	public void saveNew(Pizza pizza) throws SaveDaoException {
		piz.save(pizza);

	}

	@Override
	public void update(String code, Pizza pizza) throws UpdateDaoException {
		List<Pizza> pizL = piz.findByCode(code);

		if (pizL.size() == 1) {
			pizza.setId((pizL.get(0).getId()));
			piz.save(pizza);
		} else {
			throw new UpdateDaoException("Fatal erreur critique dans l'updatation");
		}

	}

	@Override
	public void delete(String code) throws DeleteDaoException {
		List<Pizza> pizL = piz.findByCode(code);

		if (pizL.size() == 1) {
			piz.delete(pizL.get(0).getId());
		} else {
			throw new DeleteDaoException("ca a échoué balèse");
		}

	}

}
