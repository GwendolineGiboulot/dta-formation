package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.PizzaDaoImplTableau;
import fr.pizzeria.exception.PizzaServletRuntimeException;
import fr.pizzeria.exception.SaveDaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class PizzaServletWeb
 */
public class PizzaServletWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PizzaDaoImplTableau dao;

	/**
	 * Default constructor.
	 */
	public PizzaServletWeb() {
		dao = new PizzaDaoImplTableau();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Pizza> lPiz = dao.findAll();

		response.getWriter().println("<!DOCTYPE html>");
		response.getWriter().println("<html>");
		response.getWriter().println("<head>");

		response.getWriter().println(
				"    <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'> ");
		response.getWriter().println(
				"   <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js'></script> ");
		response.getWriter().println(
				"  <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js'></script> ");

		response.getWriter().println("</head>");
		response.getWriter().println("<body>");

		response.getWriter().println(" <div class='jumbotron'> ");
		response.getWriter().println(" <div class='container'> ");

		response.getWriter().println("<table class='table'>");

		for (Pizza pizza : lPiz) {

			response.getWriter().println("<tr><td>");

			response.getWriter().println(pizza.toString());

			response.getWriter().println("</td></tr>");
		}

		response.getWriter().println("</table>");

		response.getWriter().println(" </div> ");
		response.getWriter().println(" </div> ");

		response.getWriter().println("</body>");
		response.getWriter().println("</html>");

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

		doGet(request, response);
	}

}
