package fr.pizzeria.exception;

public class ModelRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 863509342242097398L;

	public ModelRuntimeException() {
		super();
	}

	public ModelRuntimeException(String message, Throwable cause) {
		super(message, cause);

	}

	public ModelRuntimeException(String message) {
		super(message);

	}

	public ModelRuntimeException(Throwable cause) {
		super(cause);

	}

}
