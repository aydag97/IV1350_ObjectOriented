package se.kth.iv1350.integration;
import java.util.ArrayList;
import se.kth.iv1350.dto.*;


/**
 * The SalesLog class is responsible for logging completed sales.
 */
public class SalesLog {
    private ArrayList<ArrayList<ItemsInBagDTO>> finalSale;

    /**
     * Constructs a SalesLog object with an empty list of final sales.
     */
    public SalesLog(){
        this.finalSale = new ArrayList<ArrayList<ItemsInBagDTO>>();
    }

    /**
     * Records a completed sale by adding it to the sales log.
     * 
     * @param finalSale The list of items sold in the completed sale.
     */
    public void recordSale(ArrayList<ItemsInBagDTO> finalSale){
        this.finalSale.add(finalSale);
    }
}
