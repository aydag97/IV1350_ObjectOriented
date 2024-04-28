package se.kth.iv1350.model;


// how to implement the receipt class?!
public class Receipt {

  public ReceiptDTO createReceipt(SaleDTO saleAfterDiscount, double change){
    return new ReceiptDTO(saleAfterDiscount, change);
  }

}
