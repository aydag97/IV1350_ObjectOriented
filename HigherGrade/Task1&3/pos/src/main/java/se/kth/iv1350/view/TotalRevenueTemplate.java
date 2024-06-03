package se.kth.iv1350.view;

import se.kth.iv1350.model.SaleObserver;

/**
 * Template class for observing and updating total revenue.
 * Implements the SaleObserver interface to receive notifications of new sales.
 */

public abstract class TotalRevenueTemplate implements SaleObserver {
    protected double currentRevenue = 0;
    
    /**
     * Invoked when a new sale is made. Updates the revenue and shows the total income.
     *
     * @param totalPriceOfNewSale The total price of the new sale.
     */
    public void newSaleWasMade(double totalPriceOfNewSale) {
        updateRevenue(totalPriceOfNewSale);
        showTotalIncome();
    }

    /**
     * Updates the current revenue with the total price of the new sale.
     *
     * @param totalPriceOfNewSale The total price of the new sale.
     */
    @Override
    public void updateRevenue(double totalPriceOfNewSale){
        this.currentRevenue += totalPriceOfNewSale;
    }

    private void showTotalIncome(){
        try{
            doShowTotalIncome();
        } catch(Exception e){
            handleErrors(e);
        }
    }

    /**
     * Abstract method to show total income. Must be implemented by subclasses.
     *
     * @throws Exception If there is an error showing the total income.
     */
    protected abstract void doShowTotalIncome() throws Exception;

    /**
     * Abstract method to handle errors. Must be implemented by subclasses.
     *
     * @param e The exception that was thrown.
     */
    protected abstract void handleErrors(Exception e); 
}
