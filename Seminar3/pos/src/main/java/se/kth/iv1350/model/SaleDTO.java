package se.kth.iv1350.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The SaleDTO class represents a Data Transfer Object (DTO) for sale information.
 * It contains information about a sale, including the time of sale, the items in the sale,
 * the total price, total discount, and total VAT.
 */
public class SaleDTO {
    private LocalDateTime time;
    private ArrayList<ItemsInBag> finalSale;
    private double totalPrice;
    private double totalDiscount;
    private double totalVAT;

    /**
     * Constructs a SaleDTO object with the specified sale information.
     * 
     * @param time The time of the sale.
     * @param finalSale The list of items in the sale.
     * @param totalPrice The total price of the sale.
     * @param totalDiscount The total discount applied to the sale.
     * @param totalVAT The total value-added tax (VAT) of the sale.
     */
    public SaleDTO(LocalDateTime time, ArrayList<ItemsInBag> finalSale, double totalPrice, double totalDiscount,
            double totalVAT) {
        this.time = time;
        this.finalSale = finalSale;
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
        this.totalVAT = totalVAT;
    }

    /**
     * Retrieves the time of the sale.
     * 
     * @return The time of the sale.
     */
    public LocalDateTime getSaleTime() {
        return this.time;
    }

    /**
     * Retrieves the list of items in the sale.
     * 
     * @return The list of items in the sale.
     */
    public ArrayList<ItemsInBag> getFinalSale(){
        return this.finalSale;
    }

    /**
     * Retrieves the total price of the sale.
     * 
     * @return The total price of the sale.
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }

    /**
     * Retrieves the total discount applied to the sale.
     * 
     * @return The total discount applied to the sale.
     */
    public double getTotalDiscount(){
        return this.totalDiscount;
    }

    /**
     * Retrieves the total value-added tax (VAT) of the sale.
     * 
     * @return The total VAT of the sale.
     */
    public double getTotalVat(){
        return this.totalVAT;
    }
}
