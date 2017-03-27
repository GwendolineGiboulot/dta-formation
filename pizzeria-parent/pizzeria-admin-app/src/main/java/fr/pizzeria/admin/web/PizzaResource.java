package fr.pizzeria.admin.web;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.PizzaServiceEJB;
import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class PizzaResource {

	@EJB
	private PizzaServiceEJB pizzaEJB;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> list() {

		return pizzaEJB.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(Pizza pizza) {

		pizzaEJB.saveNew(pizza);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{code}")
	public void update(@PathParam("code") String code, Pizza pizza) {

		pizzaEJB.update(code, pizza);
	}

	@DELETE
	@Path("/{code}")
	public void delete(@PathParam("code") String code) {

		pizzaEJB.delete(code);
	}

}
