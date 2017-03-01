package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Composite interface.
 * 
 */
public abstract class ViewComposite {

	private List<ViewComposite> children = new ArrayList<>();

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
}
