package se.kth.iv1350.model;

/**
 * Represents an item data transfer object, containing all relevant information about an item
 * such as item ID, name, price, and VAT rate.
 */

public class ItemDTO {
    private int itemID;
    private String itemName;
    private double price;
    private double vatRate;

    /**
     * Constructs an {@code ItemDTO} with the specified item ID, name, price, and VAT rate.
     * 
     * @param itemID the item's unique identifier
     * @param itemName the name of the item
     * @param price the price of the item
     * @param vatRate the VAT rate applicable to the item
     */
    
    public ItemDTO(int itemID, String itemName, double price, double vatRate) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price; 
        this.vatRate = vatRate;
    }    

    /**
     * Retrieves the item ID.
     * 
     * @return the item ID
     */
    public int getItemID() {
        return this.itemID;
    }

    /**
     * Retrieves the name of the item.
     * 
     * @return the name of the item
     */
    public String getItemName() {
        return this.itemName;
    }

    /**
     * Retrieves the price of the item.
     * 
     * @return the price of the item
     */
    public double getItemPrice() {
        return this.price;
    }

    /**
     * Retrieves the VAT rate of the item.
     * 
     * @return the VAT rate
     */
    public double getItemVatRate() {
        return this.vatRate;
    }
    
}

