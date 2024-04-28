package se.kth.iv1350.startup;

import se.kth.iv1350.controller.*;
import se.kth.iv1350.view.*;
import se.kth.iv1350.integration.*;

public class Startup {
  
  private Printer printr;
  private View view;
  private Controller contr;
  private SalesLog salesL;

  public Startup(){
    printr = new Printer();
    salesL = new SalesLog();
    contr = new Controller(printr, salesL);
    view = new View(contr);
  }

  public View getView(){
    return this.view;
  }
  
}
