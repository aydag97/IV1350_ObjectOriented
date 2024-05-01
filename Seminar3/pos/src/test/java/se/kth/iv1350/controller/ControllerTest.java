package se.kth.iv1350.controller;

import se.kth.iv1350.integration.*;
import se.kth.iv1350.model.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControllerTest {
    private Controller controller;
    private Printer printer;
    private SalesLog salesLog;

    @BeforeEach
    public void setUp(){
        printer = new Printer();
        salesLog = new SalesLog();
        controller = new Controller(printer, salesLog);
        controller.startSale();
    }

    @AfterEach
    public void tearDown() {
        printer = null;
        salesLog = null;
        controller = null;
    }
        
    
    @Test
    public void registerItemTest() {
        ArrayList<ItemsInBag> shoppingBagWithUpdatedQuantity = controller.registerItem(1, 2);
        shoppingBagWithUpdatedQuantity = controller.registerItem(3, 1);
        shoppingBagWithUpdatedQuantity = controller.registerItem(1, 10);
        int expectedResult = 12;
        String expectedItemName = "Butter";
        assertEquals(expectedResult, shoppingBagWithUpdatedQuantity.get(0).getItemQuantity(), "The quantity doesn't match");
        assertEquals(expectedItemName, shoppingBagWithUpdatedQuantity.get(1).getItem().getItemName(), "Scanning failed");
    }

    @Test
    public void endSaleTest() {
        ArrayList<ItemsInBag> shoppingBagWithUpdatedQuantity = controller.registerItem(2, 3);
        shoppingBagWithUpdatedQuantity = controller.registerItem(3, 1);
        int finalBag = controller.endSale().get(0).getItemQuantity() + controller.endSale().get(1).getItemQuantity();
        int expectedResult = 4;
        assertEquals(expectedResult, finalBag, "The shopping bag does not contain all scanned items.");
    }

    
    @Test
    public void payTest(){
        ArrayList<ItemsInBag> shoppingBagWithUpdatedQuantity = controller.registerItem(2, 3);
        shoppingBagWithUpdatedQuantity = controller.registerItem(3, 1);
        controller.endSale();

        double change =  controller.pay(200);
        double expectedChange = 97;
        change = Math.ceil(change);
        assertEquals(expectedChange, change, "Wrongly calculated change");
    }

    @Test
    public void requestDiscountTest() {
        ArrayList<ItemsInBag> shoppingBagWithUpdatedQuantity = controller.registerItem(2, 3);
        shoppingBagWithUpdatedQuantity = controller.registerItem(3, 1);
        ArrayList<ItemsInBag> finalSale = controller.endSale();
        SaleDTO saleAfterDiscount = controller.requestDiscount(1, finalSale);
        double expectedDiscount = 0;
        assertEquals(expectedDiscount, saleAfterDiscount.getTotalDiscount(), "Discount amount doesn't match");
    }
}
