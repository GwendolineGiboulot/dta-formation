package fr.pizzeria.exception;

/**
 * @author Quelqun
 *
 */
public class DaoRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -5333919020370360569L;

	/**
	 * @param arg0
	 * @param arg1
	 */
	public DaoRuntimeException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	/**
	 * @param message
	 */
	public DaoRuntimeException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DaoRuntimeException(Throwable cause) {
		super(cause);

	}

}
