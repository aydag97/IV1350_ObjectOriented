package se.kth.iv1350.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SaleDTO {
    private LocalDateTime time;
    private ArrayList<ItemsInBag> finalSale;
    private double totalPrice;
    private double totalDiscount;
    private double totalVAT;

    public SaleDTO(LocalDateTime time, ArrayList<ItemsInBag> finalSale, double totalPrice, double totalDiscount,
            double totalVAT) {
        this.time = time;
        this.finalSale = finalSale;
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
        this.totalVAT = totalVAT;
    }

    public LocalDateTime getSaleTime() {

        return this.time;
    }

    public ArrayList<ItemsInBag> getFinalSale(){
        return this.finalSale;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public double getTotalDiscount(){
        return this.totalDiscount;
    }
    
    public double getTotalVat(){
        return this.totalVAT;
    }

}
