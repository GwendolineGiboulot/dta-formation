package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.PizzaDaoImplTableau;
import fr.pizzeria.exception.PizzaServletRuntimeException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class PizzaServletWebApi
 */
@WebServlet("/api/servlet/pizzas")
public class PizzaServletWebApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PizzaDaoImplTableau dao;

	public PizzaServletWebApi() {
		dao = new PizzaDaoImplTableau();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Pizza> lPiz = dao.findAll();

		for (Pizza pizza : lPiz) {
			response.getWriter().append(pizza.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		String prix = request.getParameter("prix");
		String categorie = request.getParameter("categorie");
		String url = request.getParameter("url");

		Pizza piz = new Pizza(code, nom, Double.parseDouble(prix), CategoriePizza.getEnum(categorie), url);

		try {
			dao.saveNew(piz);
		} catch (SaveDaoException e) {
			throw new PizzaServletRuntimeException(e);
		}

		response.setStatus(201);
	}

}
