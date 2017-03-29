import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.pizzeria.config.DaoConfigTest;
import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfigTest.class)
public class TestJDBCTemplace {

	@Autowired
	private IDao<Pizza, String> pizzaDao;

	@Test
	public void testInsertionSuppression() throws SaveDaoException, DeleteDaoException {

		List<Pizza> listZa = pizzaDao.findAll();

		int nombrePizza = listZa.size();

		pizzaDao.saveNew(new Pizza("HNQ", "toto", 45, CategoriePizza.SANS_VIANDE));

		listZa = pizzaDao.findAll();

		assertTrue(nombrePizza + 1 == listZa.size());

		pizzaDao.delete("HNQ");

		listZa = pizzaDao.findAll();

		assertTrue(nombrePizza == listZa.size());

	}

}
