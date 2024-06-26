package se.kth.iv1350.dto;

/**
 * Represents a container for items, tracking both the item and its quantity within a bag.
 */
public class ItemsInBagDTO {

    final private ItemDTO item;
    final private int quantity;

    /**
     * Constructs an {@code ItemsInBag} object with the specified item and its quantity.
     * 
     * @param item the item to be added to the bag
     * @param quantity the quantity of the item
     */
    
    public ItemsInBagDTO(ItemDTO item, int quantity){
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
}
