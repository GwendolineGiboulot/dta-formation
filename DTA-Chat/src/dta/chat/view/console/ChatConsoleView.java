package dta.chat.view.console;

import java.util.Scanner;

public class ChatConsoleView extends ViewComposite {

	private Scanner read;

	public ChatConsoleView(Scanner read) {

		this.read = read;

		this.add(new ChatConsoleTitleView());
		this.add(new ChatConsoleLoginView(read));
		this.add(new ChatConsoleConversationView());
	}

	@Override
	protected void printThisBefore() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void printThisAfter() {
		// TODO Auto-generated method stub

	}

}
