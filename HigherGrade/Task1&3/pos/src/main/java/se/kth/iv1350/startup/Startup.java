package se.kth.iv1350.startup;
import se.kth.iv1350.controller.*;
import se.kth.iv1350.view.*;
import se.kth.iv1350.integration.*;

/**
 * The Startup class initializes the application components and starts the system.
 */
public class Startup {
  
  private Printer printr;
  private View view;
  private Controller contr;
  private SalesLog salesL;

  /**
   * Constructs a Startup object and initializes the application components.
   */
  public Startup(){
    printr = new Printer();
    salesL = new SalesLog();
    contr = new Controller(printr, salesL);
    view = new View(contr);
  }

  /**
   * Retrieves the view component of the system.
   * 
   * @return The View object associated with this Startup instance.
   */
  public View getView(){
    return this.view;
  }

  public static void main(String[] args) {
    Startup startup = new Startup();
    View view = startup.getView();
    view.simulateFakeSaleStory();
    view.simulateAnotherFakeSaleStory();
  }
}
