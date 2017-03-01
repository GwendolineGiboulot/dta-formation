package dta.chat.view.console;

import java.util.Scanner;

public class ChatConsoleLoginView extends ViewComposite {

	private Scanner read;
	private String login;

	public ChatConsoleLoginView(Scanner read) {
		this.read = read;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	protected void printThisBefore() {
		System.out.println("~~~~~              Authentification              ~~~~~~");
		System.out.print("Veuillez saisir votre login : ");
		login = read.nextLine();

	}

	@Override
	protected void printThisAfter() {
		// TODO Auto-generated method stub

	}

}
