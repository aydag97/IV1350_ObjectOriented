package se.kth.iv1350.integration;
import java.util.ArrayList;
import se.kth.iv1350.model.*;


/**
 * The SalesLog class is responsible for logging completed sales.
 */
public class SalesLog {
    private ArrayList<ArrayList<ItemsInBag>> finalSale;

    /**
     * Constructs a SalesLog object with an empty list of final sales.
     */
    public SalesLog(){
        this.finalSale = new ArrayList<ArrayList<ItemsInBag>>();
    }

    /**
     * Records a completed sale by adding it to the sales log.
     * 
     * @param finalSale The list of items sold in the completed sale.
     */
    public void recordSale(ArrayList<ItemsInBag> finalSale){
        this.finalSale.add(finalSale);
    }
}
