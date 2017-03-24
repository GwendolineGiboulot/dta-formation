package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaStatistiquesService;

@WebServlet("/technique")
public class TechniqueController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private PizzaStatistiquesService stats;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer nbSession = (Integer) request.getSession().getServletContext().getAttribute("nbSession");

		List<Long> tempsReq = (List<Long>) request.getSession().getServletContext().getAttribute("tempsReq");
		List<String> cheminReq = (List<String>) request.getSession().getServletContext().getAttribute("cheminReq");

		request.setAttribute("nbSession", nbSession);

		request.setAttribute("tempsReq", tempsReq);
		request.setAttribute("cheminReq", cheminReq);

		request.setAttribute("ListePizzaEvent", stats.getListEvent());

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/pizzas/technique.jsp");
		dispatcher.forward(request, response);
	}

}
