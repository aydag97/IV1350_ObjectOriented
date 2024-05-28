package se.kth.iv1350.view;


/**
 * The TotalRevenueView class represents a view that displays the total revenue.
 */
public class TotalRevenueView extends TotalRevenueTemplate {

    @Override
    public void doShowTotalIncome() throws Exception {
        printTotalRevenue();
    }

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
