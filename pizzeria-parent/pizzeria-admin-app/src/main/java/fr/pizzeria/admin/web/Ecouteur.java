package fr.pizzeria.admin.web;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Ecouteur
 *
 */
@WebListener
public class Ecouteur implements HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public Ecouteur() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		Integer nbSession = (Integer) se.getSession().getServletContext().getAttribute("nbSession");

		if (nbSession == null) {
			se.getSession().getServletContext().setAttribute("nbSession", 1);
		} else {
			se.getSession().getServletContext().setAttribute("nbSession", nbSession + 1);
		}
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		Integer nbSession = (Integer) se.getSession().getServletContext().getAttribute("nbSession");

		se.getSession().getServletContext().setAttribute("nbSession", nbSession - 1);
	}

}
