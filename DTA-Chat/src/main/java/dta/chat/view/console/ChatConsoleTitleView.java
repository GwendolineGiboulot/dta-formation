package dta.chat.view.console;

import inutile.couleur;

public class ChatConsoleTitleView extends ViewComposite {

	@Override
	protected void printThisBefore() {
		System.out.println(couleur.coloriser("@@@@@              MON SUPER CHAT              @@@@@"));
	}

	@Override
	protected void printThisAfter() {
		// print things here
	}

}
