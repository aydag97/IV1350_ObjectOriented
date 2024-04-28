package se.kth.iv1350.integration;

import java.util.ArrayList;

import se.kth.iv1350.model.*;
// ska vi ha en quantity för items i inventory system?!
public class InventorySystem {
    private ArrayList<ItemDTO> items;
    
    //Constructor 
    public InventorySystem(){
      items = new ArrayList<ItemDTO>();
      items.add(new ItemDTO(1, "Egg", 30.95, 10));
      items.add(new ItemDTO(2, "Milk", 17.50, 11));
      items.add(new ItemDTO(3, "Butter", 50.49, 15));
      items.add(new ItemDTO(4, "Bread", 15.99, 9.9));
    }

    //Register communicastion diagram
    public ItemDTO getItemInfo(int itemID){
      for(int i = 0; i < this.items.size(); i++){
        if(itemID == this.items.get(i).getItemID()){
          return this.items.get(i);
        }
      }
      return null;
    }


    //end sale diagram
    public void updateItemInventory(ArrayList<ItemsInBag> finalSale) {
      for(ItemsInBag itemInFinalSale : finalSale){
        items.remove(itemInFinalSale.getItem());
      }
    }
    
}
