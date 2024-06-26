package se.kth.iv1350.controller;

import se.kth.iv1350.dto.*;
import se.kth.iv1350.exceptions.*;
import se.kth.iv1350.integration.*;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;


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
        try{
            controller.registerItem(1, 2);
            controller.registerItem(3, 1);
            controller.registerItem(1, 10);

        }catch(ItemNotFoundException | DatabaseFailureException exception){
            fail(exception.getMessage());
        }  
        int expectedResult = 12;
        String expectedItemName = "Butter";
        assertEquals(expectedResult, controller.getFinalBag().get(1).getItemQuantity(), "The quantity doesn't match");
        assertEquals(expectedItemName, controller.getFinalBag().get(0).getItem().getItemName(), "Scanning failed");
    }

    @Test
    public void registerItemWithItemNotFoundExceptionTest(){
        Executable expectedResult = () -> controller.registerItem(100, 1);
        assertThrows(ItemNotFoundException.class, expectedResult, "Expected to throw an exception of ItemNotFound, but failed.");
    }

    @Test
    public void registerItemWithDatabaseFailureExceptionTest(){
        Executable expectedResult = () -> controller.registerItem(4, 1);
        assertThrows(DatabaseFailureException.class, expectedResult, "Expected to throw an exception of DatabaseFailure, but failed.");
    }

    @Test
    public void endSaleTest() {
        try{
            controller.registerItem(2, 3);
            controller.registerItem(3, 1);
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            fail(exception.getMessage());
        }
        int finalBag = controller.getFinalBag().get(0).getItemQuantity() + controller.getFinalBag().get(1).getItemQuantity();
        int expectedResult = 4;
        assertEquals(expectedResult, finalBag, "The shopping bag does not contain all scanned items.");
    }

    
    @Test
    public void payTest(){
        try{
            controller.registerItem(2, 3);
            controller.registerItem(3, 1);
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            fail(exception.getMessage());     
        }
        controller.endSale();
        double change =  controller.pay(200);
        double expectedChange = 97;
        change = Math.ceil(change);
        assertEquals(expectedChange, change, "Wrongly calculated change");
    }

    @Test
    public void requestDiscountTest() {
        try{
        controller.registerItem(2, 3);
        controller.registerItem(3, 1);
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            fail(exception.getMessage());
        }
        SaleDTO saleAfterDiscount = controller.requestDiscount(1);
        double expectedDiscount = 30;
        assertEquals(expectedDiscount, saleAfterDiscount.getTotalDiscount(), "Discount amount doesn't match");
    }
}
