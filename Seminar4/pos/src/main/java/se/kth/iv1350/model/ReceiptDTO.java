package se.kth.iv1350.model;

/**
 * Represents a data transfer object for a receipt, encapsulating details about a sale
 * and the change given during the transaction.
 */
public class ReceiptDTO {

    private SaleDTO saleInfo;
    private double change;
    private double amountPaid;

    /**
     * Constructs a {@code ReceiptDTO} with specified information about the sale and the change given.
     * 
     * @param saleInfo the detailed information about the sale
     * @param change the amount of change given to the customer
     */
    public ReceiptDTO(SaleDTO saleInfo, double change, double amountPaid) {
        this.saleInfo = saleInfo;
        this.change = change;
        this.amountPaid = amountPaid;
    }

    /**
     * Retrieves the sale information associated with this receipt.
     * 
     * @return the sale information as a {@code SaleDTO}
     */
    public SaleDTO getSaleInfo() {
        return this.saleInfo;
    }

    /**
     * Retrieves the change given during the transaction.
     * 
     * @return the amount of change
     */
    public double getChange() {
        return this.change;
    }

    /**
     * Retrieves the amount paid by customer during the transaction.
     * 
     * @return the amount of paid by customer
     */
    public double getAmountPaid(){
        return this.amountPaid;
    }
}
