package dta.chat.model;

import dta.chat.model.observer.ChatObservable;

public class ChatConversationModel extends ChatObservable<ChatMessage> {

	String login;

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

		notifyObservers(message);
	}
}
