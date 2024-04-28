package se.kth.iv1350.integration;
import java.util.ArrayList;
import se.kth.iv1350.model.*;

public class SalesLog {
    ArrayList<ArrayList<ItemsInBag>> finalSale;

    public SalesLog(){
        this.finalSale = new ArrayList<ArrayList<ItemsInBag>>();
    }

    public void recordSale(ArrayList<ItemsInBag> finalSale){
        this.finalSale.add(finalSale);
    }
}
