package dta.chat.controller;

import dta.chat.model.ChatConversationModel;
import inutile.couleur;

public class ChatLoginStrategy implements ChatAuthController {

	private ChatConversationModel model;

	public ChatLoginStrategy(ChatConversationModel model) {
		this.model = model;
	}

	@Override
	public void authenticate(String login) {
		model.setLogin(couleur.coloriser(login));

	}

}
