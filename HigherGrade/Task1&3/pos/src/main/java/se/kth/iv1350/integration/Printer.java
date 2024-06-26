package se.kth.iv1350.integration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import se.kth.iv1350.dto.*;


/**
 * The Printer class is responsible for printing receipts.
 * It formats and prints the receipt information based on the provided ReceiptDTO.
 */

public class Printer {

    /**
     * Prints the receipt based on the provided ReceiptDTO.
     * 
     * @param receiptToPrint The receipt information to be printed.
     */

    public void printReceipt(ReceiptDTO receiptToPrint) {


        SaleDTO saleInfoFromReceipt = receiptToPrint.getSaleInfo();
        if(saleInfoFromReceipt == null){
            System.out.println("Nothing to print");
            return;
        }
        System.out.println("****************************************************");
        System.out.println("\t\t Receipt\n");

        LocalDateTime saleTime = saleInfoFromReceipt.getSaleTime();
        String formattedDateTime = saleTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("Date & Time of the sale: " + formattedDateTime + "\n");

        System.out.println("Quantity \tItem \t\t Price Per Item");
        System.out.println("------------------------------------------------");
        for(ItemsInBagDTO item : saleInfoFromReceipt.getFinalSale()){
            System.out.printf("%dx \t\t%s\t\t %.2f SEK\n", item.getItemQuantity(), item.getItem().getItemName(), item.getItem().getItemPrice());
        }
        
        System.out.printf("\nTotal price(incl. VAT): %.2f SEK\n\n", (saleInfoFromReceipt.getTotalPrice()));
        System.out.println(saleInfoFromReceipt.getAllAppliedDiscounts().get(0).discountDescription());
        System.out.println(saleInfoFromReceipt.getAllAppliedDiscounts().get(1).discountDescription());
        System.out.println(saleInfoFromReceipt.getAllAppliedDiscounts().get(2).discountDescription());
        System.out.printf("\nTotal price after discount: %.2f SEK" , saleInfoFromReceipt.getTotalPriceAfterDiscount());
        System.out.printf("\nThe amount paid: %.2f SEK", (receiptToPrint.getAmountPaid()));
        System.out.println("\n****************************************************\n");
    }
}
