package chat.model.socket;

public class ChatClientException extends RuntimeException {

	private static final long serialVersionUID = -5644690678865699514L;

	public ChatClientException() {
		super();

	}

	public ChatClientException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public ChatClientException(Throwable arg0) {
		super(arg0);

	}

	public ChatClientException(String string) {
		super(string);
	}

}
