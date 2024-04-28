package se.kth.iv1350;
import se.kth.iv1350.startup.Startup;
import se.kth.iv1350.view.*;

/**
 * The Main class contains the entry point for the application.
 */
public class Main {

  /**
   * The entry point of the application.
   * 
   * @param args The command line arguments passed to the application (not used in this case).
   */
  public static void main(String[] args) {
    Startup startup = new Startup();
    View view = startup.getView();
    view.simulateFakeSaleStory();
  }
}