package fr.pizzeria.exception;

/**
 * @author Quelqun
 *
 */
public class PizzaServletRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -533319020370360569L;

	/**
	 * @param arg0
	 * @param arg1
	 */
	public PizzaServletRuntimeException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	/**
	 * @param message
	 */
	public PizzaServletRuntimeException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public PizzaServletRuntimeException(Throwable cause) {
		super(cause);

	}

}
