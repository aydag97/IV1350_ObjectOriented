package se.kth.iv1350.integration;
import java.util.ArrayList;

import se.kth.iv1350.dto.DiscountDTO;
import se.kth.iv1350.model.*;

/**
 * The DiscountCatalog class is responsible for fetching discount information
 * based on customer ID and the items in the sale.
 */

public class DiscountCatalog {

    /**
     * Fetches discount information based on the customer ID and the items in the sale.
     * No logic applied to this class for this seminar.
     * 
     * @param customerID The ID of the customer for whom the discount information is fetched.
     * @param saleInfo   The list of items in the sale for which the discount is calculated.
     * @return The discount amount as a double value.
     */
    public DiscountDTO fetchDiscountOnItems(ArrayList<ItemsInBag> saleInfo){
        return new DiscountDTO(30, "Amount", "A bonus of 30 kr added to sale");
    }

    public DiscountDTO fetchDiscountOnSale(double totalSaleAmount){
        return new DiscountDTO(0.1, "Percent", "10% off on the sale");
    }

    public DiscountDTO fetchDiscountOnCustomer(int customerID){
        return new DiscountDTO(0.2, "Percent", "20% off for all members");
    }
}
