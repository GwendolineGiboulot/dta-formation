package dta.chat.view.console;

import java.util.Scanner;

import inutile.couleur;

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
		System.out.println(couleur.coloriser("~~~~~              Authentification              ~~~~~~"));
		System.out.print("Veuillez saisir votre login : ");
		login = read.nextLine();
		this.authStrategy.authenticate(login);

	}

	@Override
	protected void printThisAfter() {
		// TODO Auto-generated method stub

	}

}
