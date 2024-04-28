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

    // Constructor
    public Controller(Printer printer, SalesLog saleslog) {
        this.printer = printer;
        this.saleslog = saleslog;
        inventorySystem = new InventorySystem();
        accountingSystem = new AccountingSystem();
        discountCatalog = new DiscountCatalog();
    }

    // Start sale communication diagram
    public void startSale() {
        sale = new Sale();
    }

    public void registerItem(int itemID, int quantity) {
        boolean itemFound = sale.containsItemID(itemID);

        if (itemFound) {
            sale.updateItemInSale(itemID, quantity);
        } else {
            // what happens if itemInfo is null. exception handling? or is it to seminar 3?
            ItemDTO itemInfo = inventorySystem.getItemInfo(itemID);
            if (itemInfo != null) {
                sale.addNewItem(itemInfo, quantity);
            }
        }
    }

    // End sale
    public ArrayList<ItemsInBag> endSale() {
        ArrayList<ItemsInBag> finalSale = this.sale.getFinalBag();
        saleslog.recordSale(finalSale);
        inventorySystem.updateItemInventory(finalSale);
        return finalSale;
    }

    // payment diagram
    public double pay(double amountPaid) {
        double change = sale.calculateChange(amountPaid);
        ReceiptDTO receiptToPrint = sale.getReceipt(change);
        printer.printReceipt(receiptToPrint);
        return change;
    }

    // discount diagram

    public SaleDTO requestDiscount(int customerID, ArrayList<ItemsInBag> saleInfo) {
        double amountDiscount = discountCatalog.fetchDiscountInfo(customerID, saleInfo);
        SaleDTO saleAfterDiscount = sale.reduceSale(sale.getFinalBag(), amountDiscount);
        accountingSystem.updateAccounting(saleAfterDiscount);
        return saleAfterDiscount;
    }
    
}
