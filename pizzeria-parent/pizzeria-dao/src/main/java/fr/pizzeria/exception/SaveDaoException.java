package fr.pizzeria.exception;

/**
 * @author Quelqun
 *
 */
public class SaveDaoException extends Exception {

	private static final long serialVersionUID = -2346475209618282430L;

	/**
	 * @param string
	 */
	public SaveDaoException(String string) {
		super(string);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SaveDaoException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * @param cause
	 */
	public SaveDaoException(Throwable cause) {
		super(cause);

	}

}
