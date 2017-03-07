package fr.pizzeria.exception;

public class SaveDaoException extends Exception {

	private static final long serialVersionUID = -2346475209618282430L;

	public SaveDaoException(String string) {
		super(string);
	}

	public SaveDaoException() {
		super();

	}

	public SaveDaoException(String message, Throwable cause) {
		super(message, cause);

	}

	public SaveDaoException(Throwable cause) {
		super(cause);

	}

}
