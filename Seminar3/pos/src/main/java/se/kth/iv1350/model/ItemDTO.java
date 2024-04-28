package se.kth.iv1350.model;

public class ItemDTO {
    private int itemID;
    private String itemName;
    private double price;
    private double vatRate;

    //Constructor
    public ItemDTO(int itemID, String itemName, double price, double vatRate){
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price; 
        this.vatRate = vatRate;
    }    

    public int getItemID(){
        return this.itemID;
    }

    public String getItemName(){
        return this.itemName;
    }

    public double getItemPrice(){
        return this.price;
    }

    public double getItemVatRate(){
        return this.vatRate;
    }
    
}
