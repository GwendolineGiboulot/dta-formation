package dta.chat.view.console;

import java.util.Scanner;

import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.observer.ChatObserver;

public class ChatConsoleView extends ViewComposite implements ChatObserver<ChatMessage> {

	private Scanner read;

	public ChatConsoleView(Scanner read) {

		this.read = read;

		this.add(new ChatConsoleTitleView());
		this.add(new ChatConsoleLoginView(read));
		this.add(new ChatConsoleConversationView());
	}

	@Override
	protected void printThisBefore() {

	}

	@Override
	protected void printThisAfter() {

	}

	@Override
	public void update(ChatObservable<ChatMessage> observable, ChatMessage message) {

		System.out.println(message.getLogin() + " : " + message.getText());

	}

}
