package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import fr.pizzeria.admin.tool.RequeteLog;

@WebFilter(urlPatterns = "/*")
public class TimerFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		long before = System.currentTimeMillis();
		chain.doFilter(req, resp);
		long after = System.currentTimeMillis();

		HttpServletRequest request = (HttpServletRequest) req;

		List<RequeteLog> logReq = (List<RequeteLog>) request.getSession().getServletContext().getAttribute("logReq");

		if (logReq == null) {
			logReq = new ArrayList<RequeteLog>();
		}

		logReq.add(new RequeteLog(request.getRequestURI(), (after - before)));

		request.getSession().getServletContext().setAttribute("logReq", logReq);

	}

	@Override
	public void destroy() {
	}
}