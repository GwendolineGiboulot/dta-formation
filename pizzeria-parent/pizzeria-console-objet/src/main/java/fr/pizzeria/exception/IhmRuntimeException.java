package fr.pizzeria.exception;

public class IhmRuntimeException extends RuntimeException {

	private static final long serialVersionUID = -5333919020370360569L;

	public IhmRuntimeException() {
		super();

	}

	public IhmRuntimeException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public IhmRuntimeException(String message) {
		super(message);
	}

	public IhmRuntimeException(Throwable cause) {
		super(cause);

	}

}
