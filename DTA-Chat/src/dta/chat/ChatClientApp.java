package dta.chat;

import java.util.Scanner;

import chat.model.socket.ChatSocketImpl;
import dta.chat.controller.ChatLoginStrategy;
import dta.chat.model.ChatConversationModel;
import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static void main(String[] args) {

		try (Scanner read = new Scanner(System.in)) {

			ChatSocketImpl connection = new ChatSocketImpl("192.168.99.31", 1800);
			ChatConversationModel model = new ChatConversationModel(connection);
			final ChatConsoleView view = new ChatConsoleView(read);

			view.setAuthController(new ChatLoginStrategy(view, model));

			model.addObserver(view);

			view.print();

			model.readMessage();

			while (true) {
				String s = read.nextLine();
				model.sendMessage(s);
			}

			// model.sendMessage("je dit un autre truc");

		}

	}

}
