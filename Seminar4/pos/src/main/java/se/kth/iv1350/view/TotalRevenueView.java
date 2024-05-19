package se.kth.iv1350.view;

import se.kth.iv1350.model.SaleObserver;

/**
 * The TotalRevenueView class represents a view that displays the total revenue.
 */
public class TotalRevenueView implements SaleObserver {

    private double totalRevenue;

    /**
     * Constructs a TotalRevenueView object with initial total revenue set to 0.
     */
    public TotalRevenueView(){
        totalRevenue = 0;
    }

    /**
     * Updates the total revenue and prints the new total revenue.
     *
     * @param totalPrice The total price of the sale.
     */
    @Override
    public void updateRevenue(double totalPrice){
        totalRevenue += totalPrice;
        printTotalRevenue();
    }

    private void printTotalRevenue(){
        System.out.println("------------ Notification to all observers -------------");
        System.out.println("Current total revenue is: "+ this.totalRevenue + " kr");
        System.out.println("--------------------------------------------------------");
    } 
}
