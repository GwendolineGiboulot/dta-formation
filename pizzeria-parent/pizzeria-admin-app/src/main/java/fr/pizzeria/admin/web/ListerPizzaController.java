package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.tool.PizzaTool;
import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.DeleteDaoException;
import fr.pizzeria.exception.PizzaServletRuntimeException;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/list")
public class ListerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 36L;

	private IDao<Pizza, String> dao = PizzaTool.DAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Pizza> lPiz = dao.findAll();

		request.setAttribute("lPizza", lPiz);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp");
		dispatcher.forward(request, response);

	}

	// le doPost fait la suppresion d'une pizza
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");

		try {
			dao.delete(code);
		} catch (DeleteDaoException e) {
			throw new PizzaServletRuntimeException(e);
		}

		response.sendRedirect(request.getContextPath() + "/pizzas/list");
	}

}