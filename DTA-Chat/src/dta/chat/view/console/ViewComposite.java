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

  public void add(ViewComposite letter) {
    children.add(letter);
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
    for (ViewComposite letter : children) {
      letter.print();
    }
    printThisAfter();
  }
}
