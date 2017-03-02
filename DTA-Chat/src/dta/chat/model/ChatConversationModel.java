package dta.chat.model;

import chat.model.socket.ChatSocketImpl;
import dta.chat.model.observer.ChatObservable;

public class ChatConversationModel extends ChatObservable<ChatMessage> {

	String login;
	ChatSocketImpl connection;

	public ChatConversationModel(ChatSocketImpl connection) {

		this.connection = connection;
	}

	public void setLogin(String login) {
		this.login = login;

		ChatMessage message = new ChatMessage();

		message.setLogin("Je vous prie d'agréer l'expression de mes plus sincères salutations distinguées");
		message.setText(login);

		notifyObservers(message);
	}

	public void sendMessage(String msg) {

		ChatMessage message = new ChatMessage();
		message.setLogin(login);
		message.setText(msg);

		connection.sendMessage(message);

		notifyObservers(message);
	}

	public void readMessage() {

		new Thread(() -> {

			while (true) {
				ChatMessage message = connection.readMessage();
				notifyObservers(message);
			}

		}).start();

	}

}
