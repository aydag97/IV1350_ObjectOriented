package se.kth.iv1350.controller;

import se.kth.iv1350.integration.*;
import se.kth.iv1350.model.*;

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
        controller.registerItem(1, 2);
        controller.registerItem(3, 1);
        controller.registerItem(1, 10);
        int expectedResult = 12;
        String expectedItemName = "Butter";
        assertEquals(expectedResult, controller.getFinalBag().get(1).getItemQuantity(), "The quantity doesn't match");
        assertEquals(expectedItemName, controller.getFinalBag().get(0).getItem().getItemName(), "Scanning failed");
    }

    @Test
    public void endSaleTest() {
        controller.registerItem(2, 3);
        controller.registerItem(3, 1);
        int finalBagPrice = (int) controller.endSale();
        int expectedResult = 103;
        assertEquals(expectedResult, finalBagPrice, "The shopping bag does not contain all scanned items.");
    }

    
    @Test
    public void payTest(){
        controller.registerItem(2, 3);
        controller.registerItem(3, 1);
        controller.endSale();

        double change =  controller.pay(200);
        double expectedChange = 97;
        change = Math.ceil(change);
        assertEquals(expectedChange, change, "Wrongly calculated change");
    }

    @Test
    public void requestDiscountTest() {
        controller.registerItem(2, 3);
        controller.registerItem(3, 1);
        SaleDTO saleAfterDiscount = controller.requestDiscount(1);
        double expectedDiscount = 0;
        assertEquals(expectedDiscount, saleAfterDiscount.getTotalDiscount(), "Discount amount doesn't match");
    }
}
