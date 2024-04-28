package se.kth.iv1350.model;


public class ItemsInBag {

    private ItemDTO item;
    private int quantity;

    //Constructor
    public ItemsInBag(ItemDTO item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public ItemDTO getItem(){
        return this.item;
    }

    public int getItemQuantity(){
        return this.quantity;
    }

    public int getItemID(){
        return this.item.getItemID();
    }


    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    } 
    
}
