package fr.pizzeria.exception;

public class UpdateDaoException extends Exception {

	private static final long serialVersionUID = 8702769028656955569L;

	public UpdateDaoException(String string) {
		super(string);
	}

	public UpdateDaoException() {
		super();

	}

	public UpdateDaoException(String message, Throwable cause) {
		super(message, cause);

	}

	public UpdateDaoException(Throwable cause) {
		super(cause);

	}

}
