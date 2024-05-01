package se.kth.iv1350.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    // public void registerItem(int itemID, int quantity) {
    //     boolean itemFound = sale.containsItemID(itemID);

    //     if (itemFound) {
    //         sale.updateItemInSale(itemID, quantity);
    //     } else {
    //         // what happens if itemInfo is null. exception handling? or is it to seminar 3?
    //         ItemDTO itemInfo = inventorySystem.getItemInfo(itemID);
    //         if (itemInfo != null) {
    //             sale.addNewItem(itemInfo, quantity);
    //         }
    //     }
    // }

    // public ArrayList<ItemsInBag> endSale() {
    //     ArrayList<ItemsInBag> finalSale = this.sale.getFinalBag();
    //     saleslog.recordSale(finalSale);
    //     inventorySystem.updateItemInventory(finalSale);
    //     return finalSale;
    // }

    // public double pay(double amountPaid) {
    //     double change = sale.calculateChange(amountPaid);
    //     ReceiptDTO receiptToPrint = sale.getReceipt(change);
    //     printer.printReceipt(receiptToPrint);
    //     return change;
    // }

    //   public SaleDTO requestDiscount(int customerID, ArrayList<ItemsInBag> saleInfo) {
    //     double amountDiscount = discountCatalog.fetchDiscountInfo(customerID, saleInfo);
    //     SaleDTO saleAfterDiscount = sale.reduceSale(sale.getFinalBag(), amountDiscount);
    //     accountingSystem.updateAccounting(saleAfterDiscount);
    //     return saleAfterDiscount;
    // }

}
