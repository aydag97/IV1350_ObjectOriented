package se.kth.iv1350.controller;

import java.util.ArrayList;
import se.kth.iv1350.integration.*;
import se.kth.iv1350.model.*;


public class Controller {
    
    private Printer printer;
    private SalesLog saleslog;
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private DiscountCatalog discountCatalog;
    private Sale sale;

    /**
     * Constructs a new Controller instance.
     * Initializes the necessary systems for managing sales.
     * 
     * @param printer The printer used for printing receipts.
     * @param saleslog The sales log used for recording sales.
     */

    public Controller(Printer printer, SalesLog saleslog) {
        this.printer = printer;
        this.saleslog = saleslog;
        inventorySystem = new InventorySystem();
        accountingSystem = new AccountingSystem();
        discountCatalog = new DiscountCatalog();
    }

    /**
     * Initializes a new sale.
     * Starts the sale process by creating a new Sale object.
     */

    public void startSale() {
        sale = new Sale();
    }


    /**
     * Registers an item in the current sale.
     * 
     * @param itemID The ID of the item to be registered.
     * @param quantity The quantity of the item to be registered.
     */
    public void registerItem(int itemID, int quantity) {
        ItemDTO itemInfo = inventorySystem.getItemInfo(itemID);
        sale.addNewItem(itemInfo, quantity);
    }

    /*
     * Returns the final sale.
     */
    public ArrayList<ItemsInBagDTO> getFinalBag(){
        return this.sale.getFinalBag();
    }

    /**
     * Finalizes the current sale.
     * Records the sale in the sales log and updates the inventory.
     */

    public double endSale() {
        ArrayList<ItemsInBagDTO> finalSale = getFinalBag();
        saleslog.recordSale(finalSale);
        inventorySystem.updateItemInventory(finalSale);
        return this.sale.getTotalPrice();
    }

    /**
     * Processes the payment for the current sale.
     * Calculates the change to be returned to the customer, prints the receipt,
     * and returns the amount of change.
     * 
     * @param amountPaid The amount of money paid by the customer.
     * @return The amount of change to be returned.
     */

    public double pay(double amountPaid) {
        double change = sale.calculateChange(amountPaid);
        ReceiptDTO receiptToPrint = sale.getReceipt(change, amountPaid);
        printer.printReceipt(receiptToPrint);
        return change;
    }

    /** 
     * Requests a discount for the current sale.
     * Fetches discount information for the given customer and sale items,
     * applies the discount to the sale, updates accounting, and returns
     * information about the sale after discount.
     * 
     * @param customerID The ID of the customer requesting the discount.
     * @return Information about the sale after applying the discount.
     */

    public SaleDTO requestDiscount(int customerID) {
        ArrayList<ItemsInBagDTO> finalSale = getFinalBag();
        double amountDiscount = discountCatalog.fetchDiscountInfo(customerID, finalSale);
        SaleDTO saleAfterDiscount = sale.reduceSale(sale.getFinalBag(), amountDiscount);
        accountingSystem.updateAccounting(saleAfterDiscount);
        return saleAfterDiscount;
    }
}
