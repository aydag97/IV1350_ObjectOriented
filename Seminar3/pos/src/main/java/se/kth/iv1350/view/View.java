package se.kth.iv1350.view;

import se.kth.iv1350.controller.*;
import se.kth.iv1350.model.*;
import java.util.ArrayList;
import static java.lang.System.*;

public class View {

    private Controller contr;

    //Constructor
    public View(Controller contr){
        this.contr = contr;
    }

    public void simulateFakeSaleStory(){
        
        out.println("\n---------- Welcome to our store! ----------\n");

        contr.startSale();
        out.println("Starting a new sale: \n");

        contr.registerItem(1, 1);
        out.println("1x Item 1 added.");
        contr.registerItem(2, 3);
        out.println("3x Item 2 added.");

        ArrayList<ItemsInBag> saleInfo = contr.endSale();
        out.println("Sale has been ended\n");

        contr.requestDiscount(1, saleInfo);

        out.println("Calculating the change to be returned to customer...\n");

        double change = contr.pay(500);

        out.println("Cash back to customer: " + change + " SEK");


        out.println("\n---------- Sale has been paid and ended ----------\n");

    }
    

}
