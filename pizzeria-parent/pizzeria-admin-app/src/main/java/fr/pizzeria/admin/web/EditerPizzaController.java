package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.tool.PizzaTool;
import fr.pizzeria.exception.PizzaServletRuntimeException;
import fr.pizzeria.exception.UpdateDaoException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class EditerPizzaController
 */
public class EditerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditerPizzaController() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Pizza> lPiz = PizzaTool.dao.findAll();

		String code = request.getParameter("code");

		for (Pizza pizza : lPiz) {

			if (pizza.getCode().equals(code)) {

				request.setAttribute("pizza", pizza);

				RequestDispatcher dispatcher = this.getServletContext()
						.getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp");
				dispatcher.forward(request, response);

			}
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

		String oldCode = request.getParameter("oldCode");

		Pizza piz = new Pizza(code, nom, Double.parseDouble(prix), CategoriePizza.getEnum(categorie));

		try {
			PizzaTool.dao.update(oldCode, piz);
		} catch (UpdateDaoException e) {
			throw new PizzaServletRuntimeException(e);
		}

		response.sendRedirect("/pizzeria-admin-app/pizzas/list");
	}

}
