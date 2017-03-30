package fr.pizzeria.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.config.DaoConfigSpringData;
import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Performance;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.repo.PerformanceRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfigSpringData.class)
public class TestJDBCTemplace {

	@Autowired
	private IDao<Pizza, String> pizzaDao;

	@Autowired
	private PerformanceRepo perfoDao;

	@Test
	public void testInsertionSuppression() throws SaveDaoException, DeleteDaoException {

		pizzaDao.saveNew(new Pizza("", "toto", 45, CategoriePizza.SANS_VIANDE));

		List<Pizza> listZa = pizzaDao.findAll();

		int nombrePizza = listZa.size();

		pizzaDao.delete("TOT");

		listZa = pizzaDao.findAll();

		assertTrue(nombrePizza == listZa.size() + 1);

	}

	@Test
	public void testPerfo() throws SaveDaoException, DeleteDaoException {

		pizzaDao.saveNew(new Pizza("KKJ", "tonotn", 45, CategoriePizza.SANS_VIANDE));

		List<Performance> toto = perfoDao.findAll();

		toto.size();

	}

}
