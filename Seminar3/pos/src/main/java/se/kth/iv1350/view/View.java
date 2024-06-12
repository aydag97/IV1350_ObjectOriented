package se.kth.iv1350.view;
import se.kth.iv1350.controller.*;

import static java.lang.System.*;


/**
 * The View class is responsible for interacting with the user interface.
 */
public class View {

    private Controller contr;

    /**
     * Constructs a View object with the specified controller.
     * 
     * @param controller The Controller object associated with this View instance.
     */
    public View(Controller contr){
        this.contr = contr;
    }

    /**
     * Simulates a fake sale story for testing purposes.
     */
    public void simulateFakeSaleStory(){
        
        out.println("\n---------- Welcome to our store! ----------\n");

        contr.startSale();
        out.println("Starting a new sale: \n");

        contr.registerItem(1, 1);
        out.println("1x Item 1 added.");
        contr.registerItem(2, 3);
        out.println("3x Item 2 added.");

        double totalPrice = contr.endSale();
        out.println("Sale has been ended. Total Price of sale is: "+ totalPrice + " SEK.\n");

        contr.requestDiscount(1);

        out.println("Calculating the change to be returned to customer...\n");

        double change = contr.pay(500);

        out.println("Cash back to customer: " + change + " SEK");


        out.println("\n---------- Sale has been paid and ended ----------\n");
    }
}
