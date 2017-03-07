package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

import dta.chat.controller.ChatAuthController;

/**
 * 
 * Composite interface.
 * 
 */
public abstract class ViewComposite {

	private List<ViewComposite> children = new ArrayList<>();

	protected ChatAuthController authStrategy;
	protected String user;

	public void add(ViewComposite view) {
		children.add(view);
	}

	public int count() {
		return children.size();
	}

	protected abstract void printThisBefore();

	protected abstract void printThisAfter();

	/**
	 * Print
	 */
	public void print() {
		printThisBefore();
		for (ViewComposite view : children) {
			view.print();
		}
		printThisAfter();
	}

	public void setAuthController(ChatAuthController authStrategy) {
		this.authStrategy = authStrategy;
		this.children.forEach(view -> view.setAuthController(authStrategy));

	}

	public void setLogin(String login) {
		user = login;
		this.children.forEach(view -> view.setLogin(login));
	}

}
