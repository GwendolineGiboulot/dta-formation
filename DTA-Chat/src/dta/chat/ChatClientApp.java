package dta.chat;

import java.util.Scanner;

import dta.chat.controller.ChatLoginStrategy;
import dta.chat.model.ChatConversationModel;
import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static void main(String[] args) {

		try (Scanner read = new Scanner(System.in)) {

			ChatConversationModel model = new ChatConversationModel();
			final ChatConsoleView view = new ChatConsoleView(read);

			view.setAuthController(new ChatLoginStrategy(view, model));

			model.addObserver(view);

			view.print();

			model.sendMessage("je dit un truc");
			model.sendMessage("je dit un autre truc");
		}

	}

}
