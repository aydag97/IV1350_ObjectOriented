package se.kth.iv1350.view;

import se.kth.iv1350.model.SaleObserver;

public class TotalRevenueView implements SaleObserver {

    private double totalRevenue;

    // anropas en gång i samband med controller
    public TotalRevenueView(){
        totalRevenue = 0;
    }
    // 100 kr första sale inkomst

    @Override
    public void updateRevenue(double totalPrice){
        // 100 kr totalREvenue
        totalRevenue += totalPrice;
        printTotalRevenue();
    }

    private void printTotalRevenue(){
        System.out.println("------------ Notification to all observers -------------");
        System.out.println("Current total revenue is: "+ this.totalRevenue + " kr");
        System.out.println("--------------------------------------------------------");
    } 
}
