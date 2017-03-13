package fr.pizzeria.exception;

/**
 * @author Quelqun
 *
 */
public class IhmRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -5333919020370360569L;

	/**
	 * @param arg0
	 * @param arg1
	 */
	public IhmRuntimeException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	/**
	 * @param message
	 */
	public IhmRuntimeException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public IhmRuntimeException(Throwable cause) {
		super(cause);

	}

}
