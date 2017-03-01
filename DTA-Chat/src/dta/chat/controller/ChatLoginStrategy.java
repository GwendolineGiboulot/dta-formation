package dta.chat.controller;

import dta.chat.view.console.ViewComposite;

public class ChatLoginStrategy implements ChatAuthController {

	private ViewComposite view;

	public ChatLoginStrategy(ViewComposite view) {
		this.view = view;
	}

	@Override
	public void authenticate(String login) {
		view.setLogin(login);
	}

}
