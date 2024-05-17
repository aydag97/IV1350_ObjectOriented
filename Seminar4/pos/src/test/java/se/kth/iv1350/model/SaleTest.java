package se.kth.iv1350.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.dto.DiscountDTO;
import se.kth.iv1350.dto.ItemDTO;
import se.kth.iv1350.dto.SaleDTO;

import static org.junit.jupiter.api.Assertions.*;

public class SaleTest {
  private Sale sale;

    @BeforeEach
    public void setUp() {
      sale = new Sale();
    }

    @AfterEach
    public void tearDown() {
      sale = null;
    }

    @Test
    public void containsItemIDTest() {
      createShoppingBag();
      assertTrue(sale.containsItemID(1), "Item not found in the bag");
    }

    @Test
    public void containsNoItemIDTest() {
      createShoppingBag();
      assertFalse(sale.containsItemID(2), "Item found in the bag");
    }

    @Test
    public void updateQuantityOfAlreadyScannedItem() {
      createShoppingBag();
      sale.updateItemQuantityInSale(3, 2);
      int expectedResult = 3;
      assertEquals(expectedResult, sale.getItemInBag(3).getItemQuantity(), "Item quantity didn't updated correctly");
    }
      
    @Test
    public void addNewItemTest(){
      createShoppingBag();
      sale.addNewItem(new ItemDTO(2, "Milk", 17.50, 6, 50), 1);
      int expectedResult = 3;
      assertEquals(expectedResult, sale.getFinalBag().size(), "New Item was not added correctly");
    }

    @Test
    public void calculateChangeTest(){
      createShoppingBag();
      double amountChange = sale.calculateChange(200);
      double expectedResult = 87.12;
      assertEquals(expectedResult, amountChange, "Amount change is not calculated correctly");
    }

    @Test
    public void reduceSaleTest() {
      createShoppingBag();
      double expectedResult = 101.592;
      SaleDTO saleAfterDiscount = sale.reduceSale(new DiscountDTO(0.1, "Percent", "10% off on items"));
      assertEquals(expectedResult, saleAfterDiscount.getTotalPriceAfterDiscount(), "Price didn't reduce with discount"); 
    }
    
    
    private void createShoppingBag(){
      sale.addNewItem(new ItemDTO(1, "Egg", 30.95, 12, 100), 2);
      sale.addNewItem(new ItemDTO(3, "Butter", 50.49, 25, 35), 1);
    }
}
