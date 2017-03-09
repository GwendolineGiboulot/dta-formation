package fr.pizzeria.exception;

/**
 * @author Quelqun
 *
 */
public class UpdateDaoException extends Exception {

	private static final long serialVersionUID = 8702769028656955569L;

	/**
	 * @param string
	 */
	public UpdateDaoException(String string) {
		super(string);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UpdateDaoException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * @param cause
	 */
	public UpdateDaoException(Throwable cause) {
		super(cause);

	}

}
