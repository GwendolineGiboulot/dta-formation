package fr.pizzeria.exception;

public class DaoRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -5333919020370360569L;

	public DaoRuntimeException() {
		super();

	}

	public DaoRuntimeException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public DaoRuntimeException(String message) {
		super(message);
	}

	public DaoRuntimeException(Throwable cause) {
		super(cause);

	}

}
