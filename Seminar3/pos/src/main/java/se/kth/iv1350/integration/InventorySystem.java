package se.kth.iv1350.integration;
import java.util.ArrayList;
import se.kth.iv1350.model.*;
// ska vi ha en quantity för items i inventory system?!

/**
 * The InventorySystem class manages the inventory of items available for sale.
 */
public class InventorySystem {
    private ArrayList<ItemDTO> items;
    
    /**
     * Constructs an InventorySystem object and initializes it with some sample items.
     */
    public InventorySystem(){
      items = new ArrayList<ItemDTO>();
      items.add(new ItemDTO(1, "Egg", 30.95, 10));
      items.add(new ItemDTO(2, "Milk", 17.50, 11));
      items.add(new ItemDTO(3, "Butter", 50.49, 15));
      items.add(new ItemDTO(4, "Bread", 15.99, 9.9));
    }

    /**
     * Retrieves information about an item based on its ID.
     * 
     * @param itemID The ID of the item to retrieve information for.
     * @return An ItemDTO object containing information about the item, or null if the item is not found.
     */
    public ItemDTO getItemInfo(int itemID){
      for(int i = 0; i < this.items.size(); i++){
        if(itemID == this.items.get(i).getItemID()){
          return this.items.get(i);
        }
      }
      return null;
    }

    /**
     * Updates the inventory system to reflect items sold in a completed sale.
     * 
     * @param finalSale The list of items sold in the completed sale.
     */
    public void updateItemInventory(ArrayList<ItemsInBag> finalSale) {
      for(ItemsInBag itemInFinalSale : finalSale){
        items.remove(itemInFinalSale.getItem());
      }
    } 
}
