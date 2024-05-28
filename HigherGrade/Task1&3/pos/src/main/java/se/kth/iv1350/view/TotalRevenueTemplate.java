package se.kth.iv1350.view;

import se.kth.iv1350.model.SaleObserver;

public abstract class TotalRevenueTemplate implements SaleObserver {
    protected double currentRevenue = 0;
    
    public void newSaleWasMade(double totalPriceOfNewSale) {
        updateRevenue(totalPriceOfNewSale);
        showTotalIncome();
    }

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

    protected abstract void doShowTotalIncome() throws Exception;
    protected abstract void handleErrors(Exception e); 
}
