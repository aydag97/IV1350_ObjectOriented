package se.kth.iv1350.model;

/**
 * The SaleObserver interface represents an observer that monitors sales and updates revenue.
 */
public interface SaleObserver {

    /**
     * Updates the revenue based on the total amount of a sale.
     *
     * @param totalAmountOfSale The total amount of the sale.
     */
    void updateRevenue(double totalAmountOfSale);

    
    
}
