package se.kth.iv1350.model;


/**
 * The Receipt class is responsible for creating receipts.
 * It creates a ReceiptDTO based on the provided SaleDTO and change amount.
 */
public class Receipt {
  /**
   * Creates a receipt based on the provided SaleDTO and change amount.
   * 
   * @param saleAfterDiscount The sale information after applying discounts.
   * @param change The amount of change to be returned to the customer.
   * @return The receipt containing sale information and change.
   */
  public ReceiptDTO createReceipt(SaleDTO saleAfterDiscount, double change, double amountPaid){
    return new ReceiptDTO(saleAfterDiscount, change, amountPaid);
  }
}
