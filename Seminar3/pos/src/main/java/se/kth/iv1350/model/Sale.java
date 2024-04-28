package se.kth.iv1350.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

// hur ska vi räkna ut total price med vat rate?!!
public class Sale {
    private ArrayList<ItemsInBag> shoppingBag;
    private Receipt receipt;
    private LocalDateTime saleStartTime;
    private SaleDTO saleAfterDiscount;
    private double totalPrice;
    private double totalVAT;
    private double totalRunningPrice;


    // Constructor
    public Sale() {
        saleStartTime = setSaleStartTime();
        shoppingBag = new ArrayList<ItemsInBag>();
        receipt = new Receipt();
        totalPrice = 0;
        totalVAT = 0;
        totalRunningPrice = 0;
    }

    // Start Sale communication diagram
    private LocalDateTime setSaleStartTime() {
        return LocalDateTime.now();
    }

    public ItemsInBag getItemInBag(int itemID) {
        ItemsInBag currentItemInBag;
        for (int i = 0; i < shoppingBag.size(); i++) {
            currentItemInBag = shoppingBag.get(i);
            if (itemID == currentItemInBag.getItemID()) {
                return currentItemInBag;
            }
        }
        return null;
    }

    // Register communication diagram
    public boolean containsItemID(int itemID) {
        if (getItemInBag(itemID) != null) {
            return true;
        } else {
            return false;
        }
    }

    // Register communicastion diagram
    public void updateItemInSale(int itemID, int quantity) {

        ItemsInBag itemToUpdate = getItemInBag(itemID);
        if (itemToUpdate != null) {
            itemToUpdate.updateQuantity(quantity);
            totalRunningPrice += (itemToUpdate.getItem().getItemPrice()*quantity);
            totalVAT += (itemToUpdate.getItem().getItemVatRate()*quantity);
        }

    }

    // Register communicastion diagram
    public void addNewItem(ItemDTO itemInfo, int quantity) {
        this.shoppingBag.add(new ItemsInBag(itemInfo, quantity));
        totalRunningPrice += (itemInfo.getItemPrice()*quantity);
        totalVAT += (itemInfo.getItemVatRate()*quantity);
    }

    public ArrayList<ItemsInBag> getFinalBag() {
        return this.shoppingBag;
    }


    private void getTotalPriceToPay() {
        this.totalPrice = totalRunningPrice + (totalVAT/100);
    }

    // Payment diagram
    public double calculateChange(double amountPaid) {
        return (amountPaid - this.totalPrice);
    }

    public ReceiptDTO getReceipt(double change){
        return receipt.createReceipt(saleAfterDiscount, change);
    }

    // discount diagram
    public SaleDTO reduceSale(ArrayList<ItemsInBag> finalSale, double discount) {
        double totalPriceAfterDiscount = totalPrice - discount;
        // update the amount to pay
        getTotalPriceToPay();
        saleAfterDiscount = new SaleDTO(this.saleStartTime, finalSale, this.totalPrice, totalPriceAfterDiscount, this.totalVAT);
    
        return saleAfterDiscount;
    }

}
