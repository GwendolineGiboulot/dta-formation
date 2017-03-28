package fr.pizzeria.admin.web;

import java.util.ArrayList;
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

import fr.pizzeria.admin.metier.ClientServiceEJB;
import fr.pizzeria.model.Client;

@Path("/clients")
public class ClientRessource {

	@EJB
	private ClientServiceEJB ClientEJB;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client> list() {

		List<Integer> toto = new ArrayList<>();

		return ClientEJB.findAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void save(Client pizza) {

		ClientEJB.saveNew(pizza);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public void update(@PathParam("code") String code, Client pizza) {

		ClientEJB.update(code, pizza);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("code") String code) {

		ClientEJB.delete(code);
	}

}
