package pizzeria;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.dao.PizzaDaoImplTableau;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTableauTest {

	@Test
	public void testFindAll() {

		PizzaDaoImplTableau dao = new PizzaDaoImplTableau();

		List<Pizza> piz = new ArrayList<Pizza>();

		piz = dao.findAllPizzas();

		Assert.assertEquals(piz.size(), 8);
	}

}
