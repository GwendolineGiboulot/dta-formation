package dta.chat.model;

import dta.chat.model.observer.ChatObservable;
import inutile.couleur;
import proxy.Proxy;

public class ChatConversationModel extends ChatObservable<ChatMessage> {

	String login;
	Proxy proxy;

	public ChatConversationModel(Proxy connection) {

		this.proxy = connection;
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
		message.setText(couleur.coloriser(msg));

		proxy.sendMessage(message);

		notifyObservers(message);
	}

	public void readMessage() {

		new Thread(() -> {

			while (true) {
				ChatMessage message = proxy.readMessage();
				notifyObservers(message);
			}

		}).start();

	}

}
