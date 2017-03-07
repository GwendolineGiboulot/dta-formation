package fr.pizzeria.exception;

public class DeleteDaoException extends Exception {

	private static final long serialVersionUID = -205480846048285884L;

	public DeleteDaoException(String string) {
		super(string);
	}

	public DeleteDaoException() {
		super();

	}

	public DeleteDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public DeleteDaoException(Throwable arg0) {
		super(arg0);

	}

}
