package se.kth.iv1350.integration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import se.kth.iv1350.model.*;


public class Printer {
    
    //payment diagram
    public void printReceipt(ReceiptDTO receiptToPrint) {

        SaleDTO saleInfoFromReceipt = receiptToPrint.getSaleInfo();
        System.out.println("****************************************************");
        System.out.println("\t\t Receipt\n");

        LocalDateTime saleTime = saleInfoFromReceipt.getSaleTime();
        String formattedDateTime = saleTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("Date & Time of the sale: " + formattedDateTime + "\n");

        System.out.println("Quantity \tItem \t\t Price");
        System.out.println("-------------------------------------------");
        for(ItemsInBag item : saleInfoFromReceipt.getFinalSale()){
            System.out.printf("%dx \t\t%s\t\t %.2f SEK\n", item.getItemQuantity(), item.getItem().getItemName(), item.getItem().getItemPrice());
        }
        
        System.out.printf("\nTotal price(incl. VAT): %.2f SEK", (saleInfoFromReceipt.getTotalPrice()));
        System.out.println("\nDiscount amount: " + saleInfoFromReceipt.getTotalDiscount());
        System.out.println("****************************************************\n");
    }
}
