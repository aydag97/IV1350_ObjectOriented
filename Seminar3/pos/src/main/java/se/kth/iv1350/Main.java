package se.kth.iv1350;

import se.kth.iv1350.startup.Startup;
import se.kth.iv1350.view.*;

public class Main {
  public static void main(String[] args) {
    Startup startup = new Startup();

    View view = startup.getView();
    view.simulateFakeSaleStory();

    
  }
}