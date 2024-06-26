package se.kth.iv1350.integration;
import java.util.ArrayList;

import se.kth.iv1350.dto.*;

/**
 * The DiscountCatalog class is responsible for fetching discount information
 * based on customer ID and the items in the sale.
 */

public class DiscountCatalog {

    /**
     * Fetches discount information based on the items in the sale.
     * 
     * @param saleInfo The list of items in the sale for which the discount is calculated.
     * @return The DiscountDTO object containing the discount details.
     */
    public DiscountDTO fetchDiscountOnItems(ArrayList<ItemsInBagDTO> saleInfo){
        return new DiscountDTO(30, "Amount", "A bonus of 30 kr added to sale");
    }

    /**
     * Fetches discount information based on the total sale amount.
     * 
     * @param totalSaleAmount The total amount of the sale.
     * @return The DiscountDTO object containing the discount details.
     */
    public DiscountDTO fetchDiscountOnSale(double totalSaleAmount){
        return new DiscountDTO(0.1, "Percent", "10% off on the sale");
    }

    /**
     * Fetches discount information based on the customer ID.
     * 
     * @param customerID The ID of the customer for whom the discount information is fetched.
     * @return The DiscountDTO object containing the discount details.
     */
    public DiscountDTO fetchDiscountOnCustomer(int customerID){
        return new DiscountDTO(0.2, "Percent", "20% off for all members");
    }
}
