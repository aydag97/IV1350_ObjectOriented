package se.kth.iv1350.view;


/**
 * The TotalRevenueView class represents a view that displays the total revenue.
 * It extends TotalRevenueTemplate to update and display the revenue when notified.
 */
public class TotalRevenueView extends TotalRevenueTemplate {


    /**
     * Displays the total revenue by printing it to the standard output.
     * This method is called by the parent class when a new sale is made.
     *
     * @throws Exception If there is an error while printing the total revenue.
     */

    @Override
    public void doShowTotalIncome() throws Exception {
        printTotalRevenue();
    }

    /**
     * Handles any errors by printing them to the standard output.
     *
     * @param e The exception that was thrown.
     */
    @Override
    public void handleErrors(Exception e){
        System.out.println("An exception was thrown while printing the total revenue: " + e.getCause());
    }

    private void printTotalRevenue(){
        System.out.println("------------ Notification to all observers -------------");
        System.out.printf("Current total revenue is: %.2f kr\n", this.currentRevenue);
        System.out.println("--------------------------------------------------------");
    } 
}
