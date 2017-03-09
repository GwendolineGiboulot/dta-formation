package fr.pizzeria.exception;

/**
 * @author Quelqun
 *
 */
public class ModelRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 863509342242097398L;

	/**
	 * @param message
	 * @param cause
	 */
	public ModelRuntimeException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * @param message
	 */
	public ModelRuntimeException(String message) {
		super(message);

	}

	/**
	 * @param cause
	 */
	public ModelRuntimeException(Throwable cause) {
		super(cause);

	}

}
