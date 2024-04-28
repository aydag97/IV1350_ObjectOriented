package se.kth.iv1350.model;

public class ReceiptDTO {

    private SaleDTO saleInfo;
    private double change;

    public ReceiptDTO(SaleDTO saleInfo, double change){
      this.saleInfo = saleInfo;
      this.change = change;
    }

    public SaleDTO getSaleInfo(){
        return this.saleInfo;
    }

    public double getChange(){
        return this.change;
    }


}
