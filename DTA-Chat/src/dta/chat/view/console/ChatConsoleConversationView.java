package dta.chat.view.console;

public class ChatConsoleConversationView extends ViewComposite {

	@Override
	protected void printThisBefore() {
		System.out.println(">>>>>              Conversations              <<<<<");

		System.out.println("Salut " + user);

	}

	@Override
	protected void printThisAfter() {
		// TODO Auto-generated method stub

	}

}
