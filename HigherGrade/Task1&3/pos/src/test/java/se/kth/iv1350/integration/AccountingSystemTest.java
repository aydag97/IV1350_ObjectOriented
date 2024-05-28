package se.kth.iv1350.integration;

import org.junit.jupiter.api.*;
import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.exceptions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;


public class AccountingSystemTest {

    private ByteArrayOutputStream output;
    private PrintStream originalOut;
    private Printer printer;
    private SalesLog salesLog;
    private Controller controller;

    @BeforeEach
    void setUp(){
        output = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(output));
        printer = new Printer();
        salesLog = new SalesLog();
        controller = new Controller(printer, salesLog);
    }

    @AfterEach
    void tearDown(){
        output = null;
        System.setOut(originalOut);
        printer = null;
        salesLog = null;
        controller = null;
    }

    @Test
    void printReceiptTest(){
   
        controller.startSale();

        try{
            controller.registerItem(1, 4);
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            fail(exception.getMessage());
        } 
        controller.endSale();
        controller.requestDiscount(1); 

        String outputString = output.toString().replace("\r", "");
        assertAll(
            () -> assertTrue(outputString.contains("Accounting system updated..."), "Expected to update accounting system")
        );
    }
}
