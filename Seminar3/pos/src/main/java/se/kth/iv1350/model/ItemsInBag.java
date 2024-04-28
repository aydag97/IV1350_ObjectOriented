package se.kth.iv1350.model;

/**
 * Represents a container for items, tracking both the item and its quantity within a bag.
 */
public class ItemsInBag {

    private ItemDTO item;
    private int quantity;

    /**
     * Constructs an {@code ItemsInBag} object with the specified item and its quantity.
     * 
     * @param item the item to be added to the bag
     * @param quantity the quantity of the item
     */
    
    public ItemsInBag(ItemDTO item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * Retrieves the {@code ItemDTO} object representing the item in the bag.
     * 
     * @return the item
     */
    public ItemDTO getItem(){
        return this.item;
    }

    /**
     * Retrieves the quantity of the item in the bag.
     * 
     * @return the quantity of the item
     */
    public int getItemQuantity(){
        return this.quantity;
    }

    /**
     * Retrieves the item ID from the {@code ItemDTO}.
     * 
     * @return the item ID
     */
    public int getItemID(){
        return this.item.getItemID();
    }

    /**
     * Updates the quantity of the item in the bag by adding the specified amount.
     * 
     * @param quantity the amount to add to the current quantity
     */
    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    } 
    
}
