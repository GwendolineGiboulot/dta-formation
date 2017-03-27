package fr.pizzeria.admin.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/commande/list")
public class ListCommandeController extends HttpServlet {
	private static final long serialVersionUID = 36L;

	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	//
	// List<Commande> lPiz = commandeEJB.findAll();
	//
	// request.setAttribute("lCommande", lPiz);
	//
	// RequestDispatcher dispatcher = this.getServletContext()
	// .getRequestDispatcher("/WEB-INF/views/pizzas/listerCommande.jsp");
	// dispatcher.forward(request, response);
	//
	// }

}