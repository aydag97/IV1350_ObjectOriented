package se.kth.iv1350.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import se.kth.iv1350.dto.*;

/**
 * The Sale class represents a sale transaction.
 */
public class Sale {
    private ArrayList<ItemsInBag> shoppingBag;
    private Receipt receipt;
    private LocalDateTime saleStartTime;
    private ArrayList<DiscountDTO> appliedDiscounts;
    private SaleDTO saleAfterDiscount;
    private double totalPrice;
    private double totalVAT;
    private double totalRunningPrice;
    private double totalPriceAfterDiscount;
    private ArrayList<SaleObserver> observers = new ArrayList<SaleObserver>();

    /**
     * Constructs a Sale object with initial values.
     */
    public Sale() {
        saleStartTime = setSaleStartTime();
        shoppingBag = new ArrayList<ItemsInBag>();
        appliedDiscounts = new ArrayList<DiscountDTO>();
        receipt = new Receipt();
        totalPrice = 0;
        totalVAT = 0;
        totalRunningPrice = 0;
        totalPriceAfterDiscount = totalPrice;
    }

    public double getTotalPrice(){
        return this.totalPrice;
    }

    // Start Sale communication diagram
    private LocalDateTime setSaleStartTime() {
        return LocalDateTime.now();
    }

    public DiscountDTO getAppliedDiscountInfo(int discountIndex){
        return this.appliedDiscounts.get(discountIndex);
    }

    /**
     * Retrieves the item in the shopping bag with the specified item ID.
     * 
     * @param itemID The ID of the item to retrieve.
     * @return The ItemsInBag object corresponding to the specified item ID, or null if not found.
     */
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

    /**
     * Checks if the shopping bag contains an item with the specified item ID.
     * 
     * @param itemID The ID of the item to check for.
     * @return true if the shopping bag contains the item, false otherwise.
     */
    public boolean containsItemID(int itemID) {
        if (getItemInBag(itemID) != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Updates the quantity of an item in the sale.
     * 
     * @param itemID   The ID of the item to update.
     * @param quantity The new quantity of the item.
     */
    public ArrayList<ItemsInBag> updateItemQuantityInSale(int itemID, int quantity) {

        ItemsInBag itemToUpdate = getItemInBag(itemID);
        if (itemToUpdate != null) {
            itemToUpdate.updateQuantity(quantity);
            totalRunningPrice += (itemToUpdate.getItem().getItemPrice()*quantity);
            totalVAT += (itemToUpdate.getItem().getItemVatRate()*quantity);
            this.totalPrice = totalRunningPrice + (totalVAT/100);
            this.totalPriceAfterDiscount = this.totalPrice;
        }
        return this.shoppingBag;
    }

    /**
     * Adds a new item to the sale.
     * 
     * @param itemInfo The ItemDTO object containing information about the item to add.
     * @param quantity The quantity of the item to add.
     */
    public ArrayList<ItemsInBag> addNewItem(ItemDTO itemInfo, int quantity) {
        this.shoppingBag.add(new ItemsInBag(itemInfo, quantity));
        totalRunningPrice += (itemInfo.getItemPrice()*quantity);
        totalVAT += (itemInfo.getItemVatRate()*quantity);
        this.totalPrice = totalRunningPrice + (totalVAT/100);
        this.totalPriceAfterDiscount = this.totalPrice;
        return this.shoppingBag;
    }

    /**
     * Retrieves the items in the final shopping bag.
     * 
     * @return The ArrayList of ItemsInBag objects representing the final shopping bag.
     */
    public ArrayList<ItemsInBag> getFinalBag() {
        return this.shoppingBag;
    }


    /**
     * Calculates the change to be returned to the customer based on the amount paid.
     *
     * @param amountPaid The total amount paid by the customer.
     * @return The amount of change to be returned to the customer.
     */
    public double calculateChange(double amountPaid) {
        return (amountPaid - this.totalPriceAfterDiscount);
    }

    /**
     * Generates a receipt based on the sale data and the calculated change.
     *
     * @param change The change to be included in the receipt.
     * @return A data transfer object representing the receipt.
     */
    
    public ReceiptDTO getReceipt(double change, double amountPaid){
        notifyObservers();
        return receipt.createReceipt(saleAfterDiscount, change, amountPaid);
    }

    /**
     * Reduces the sale by applying a discount and updating the sale information.
     * 
     * @param finalSale The list of items in the final sale.
     * @param discount  The discount amount to apply.
     * @return The SaleDTO object representing the sale after applying the discount.
     */
    
    public SaleDTO reduceSale(DiscountDTO discount) {
        this.appliedDiscounts.add(discount);
        this.totalPriceAfterDiscount = DiscountFactory.getFactoryInstance().getDiscountAlgorithm(discount).calculateTheDiscount(totalPriceAfterDiscount, discount);

        this.saleAfterDiscount = new SaleDTO(this.saleStartTime, getFinalBag(), this.totalPrice, discount.amount(), this.appliedDiscounts, totalPriceAfterDiscount, this.totalVAT);
        return saleAfterDiscount;
    }

    private void notifyObservers(){
        for(SaleObserver observer: observers){
            observer.updateRevenue(totalPrice);
        }
    }

    public void addMultipleSaleObservers(ArrayList<SaleObserver> observerList){
        observers.addAll(observerList);
    }
}
