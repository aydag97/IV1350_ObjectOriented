package se.kth.iv1350.view;
import se.kth.iv1350.controller.*;
import se.kth.iv1350.exceptions.*;
import se.kth.iv1350.logapi.*;

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
        contr.addNewSaleObserver(new TotalRevenueView());
        contr.addNewSaleObserver(new TotalRevenueFileOutput());
    }

    /**
     * Simulates a fake sale story for testing purposes.
     */
    public void simulateFakeSaleStory(){
        FileLogger fileLogger = new FileLogger();
        
        out.println("\n---------- Welcome to our store! ----------\n");

        contr.startSale();
        out.println("Starting a new sale: \n");

        try{
            contr.registerItem(1, 1);
            out.println("1x Item 1 added.");
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            out.println(exception.getMessage());
            fileLogger.log(exception);
        }
          
        try{
            contr.registerItem(2, 3);
            out.println("3x Item 2 added.");
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            out.println(exception.getMessage());
            fileLogger.log(exception);
        }

        try{
            contr.registerItem(4, 1);
            out.println("1x Item 4 added.");
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            fileLogger.log(exception);
            out.println(exception.getMessage());
        }

        try{
            contr.registerItem(6, 1);
            out.println("1x Item 6 added.");
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            out.println(exception.getMessage());
            fileLogger.log(exception);
        }
    
        contr.endSale();
        out.println("Sale has been ended\n");

        contr.requestDiscount(1);

        out.println("Calculating the change to be returned to customer...\n");

        double change = contr.pay(500);

        out.println("Cash back to customer: " + change + " SEK");

        out.println("\n---------- Sale has been paid and ended ----------\n");
    }

    public void simulateAnotherFakeSaleStory(){
        FileLogger fileLogger = new FileLogger();
        
        out.println("\n---------- Welcome to our store! ----------\n");

        contr.startSale();
        out.println("Starting a new sale: \n");

        try{
            contr.registerItem(3, 10);
            out.println("10x Item 3 added.");
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            out.println(exception.getMessage());
            fileLogger.log(exception);
        }
          
        try{
            contr.registerItem(2, 2);
            out.println("2x Item 2 added.");
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            out.println(exception.getMessage());
            fileLogger.log(exception);
        }
    
        contr.endSale();
        out.println("Sale has been ended\n");

        contr.requestDiscount(1);

        out.println("Calculating the change to be returned to customer...\n");

        double change = contr.pay(400);

        out.printf("Cash back to customer: %.2f SEK\n" , change);

        out.println("\n---------- Sale has been paid and ended ----------\n");
    }
}
