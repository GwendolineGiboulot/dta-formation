package dta.chat.view.console;

import inutile.couleur;

public class ChatConsoleConversationView extends ViewComposite {

	@Override
	protected void printThisBefore() {
		System.out.println(couleur.coloriser(">>>>>              Conversations              <<<<<"));

	}

	@Override
	protected void printThisAfter() {

	}

}
