package dta.chat;

import java.util.Scanner;

import dta.chat.controller.ChatLoginStrategy;
import dta.chat.view.console.ChatConsoleView;
import dta.chat.view.console.ViewComposite;

public class ChatClientApp {

	public static void main(String[] args) {

		try (Scanner read = new Scanner(System.in)) {

			ViewComposite view = new ChatConsoleView(read);

			view.setAuthController(new ChatLoginStrategy(view));

			view.print();
		}

	}

}
