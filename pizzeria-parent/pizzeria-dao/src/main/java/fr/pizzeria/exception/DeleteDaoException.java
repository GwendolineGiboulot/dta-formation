package fr.pizzeria.exception;

/**
 * @author Quelqun
 *
 */
public class DeleteDaoException extends Exception {

	private static final long serialVersionUID = -205480846048285884L;

	/**
	 * @param string
	 */
	public DeleteDaoException(String string) {
		super(string);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public DeleteDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	/**
	 * @param arg0
	 */
	public DeleteDaoException(Throwable arg0) {
		super(arg0);

	}

}
