package se.kth.iv1350.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {


    @BeforeEach
    public void setUp() {
    
    
    }


    @AfterEach
    public void tearDown() {

    }

  






    // public ItemsInBag getItemInBag(int itemID) {
    //     ItemsInBag currentItemInBag;
    //     for (int i = 0; i < shoppingBag.size(); i++) {
    //         currentItemInBag = shoppingBag.get(i);
    //         if (itemID == currentItemInBag.getItemID()) {
    //             return currentItemInBag;
    //         }
    //     }
    //     return null;
    // }

  // public boolean containsItemID(int itemID) {
  //       if (getItemInBag(itemID) != null) {
  //           return true;
  //       } else {
  //           return false;
  //       }
  //   }


  // public void updateItemInSale(int itemID, int quantity) {

  //       ItemsInBag itemToUpdate = getItemInBag(itemID);
  //       if (itemToUpdate != null) {
  //           itemToUpdate.updateQuantity(quantity);
  //           totalRunningPrice += (itemToUpdate.getItem().getItemPrice()*quantity);
  //           totalVAT += (itemToUpdate.getItem().getItemVatRate()*quantity);
  //       }
  // }

//   public void addNewItem(ItemDTO itemInfo, int quantity) {
//         this.shoppingBag.add(new ItemsInBag(itemInfo, quantity));
//         totalRunningPrice += (itemInfo.getItemPrice()*quantity);
//         totalVAT += (itemInfo.getItemVatRate()*quantity);
//     }
// 

    // public double calculateChange(double amountPaid) {
    //     return (amountPaid - this.totalPrice);
    // }


  // public SaleDTO reduceSale(ArrayList<ItemsInBag> finalSale, double discount) {
  //       double totalPriceAfterDiscount = totalPrice - discount;
  //       // update the amount to pay
  //       getTotalPriceToPay();
  //       saleAfterDiscount = new SaleDTO(this.saleStartTime, finalSale, this.totalPrice, totalPriceAfterDiscount, this.totalVAT);
  //       return saleAfterDiscount;
  //   }

}
