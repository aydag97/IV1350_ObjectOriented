package se.kth.iv1350.integration;

import org.junit.jupiter.api.*;
import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.exceptions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;



public class PrinterTest {

    private ByteArrayOutputStream output;
    private PrintStream originalOut;
    private Printer printer;
    private SalesLog salesLog;
    private Controller controller;
    private LocalDateTime dateTime;

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
        double paid = 300;
   
        controller.startSale();
        dateTime = LocalDateTime.now();

        try{
            controller.registerItem(1, 4);
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            fail(exception.getMessage());
        } 
        controller.endSale();
        controller.requestDiscount(1); 
        controller.pay(paid);
        String outputString = output.toString().replace("\r", "");

        assertAll(
            () -> assertTrue(outputString.contains("Receipt"), "Receipt message failed"),
            () -> assertTrue(outputString.contains(Integer.toString(dateTime.getYear())), "Start sale year is wrong"),
            () -> assertTrue(outputString.contains(Integer.toString(dateTime.getMonthValue())), "Start sale month is wrong"),
            () -> assertTrue(outputString.contains(Integer.toString(dateTime.getHour())), "Start sale hour is wrong"),
            () -> assertTrue(outputString.contains("Quantity"), "Quantity message failed"),
            () -> assertTrue(outputString.contains("4"), "Item quantity is wrong"),
            () -> assertTrue(outputString.contains("Egg"), "Item name message failed"),
            () -> assertTrue(outputString.contains("124,28"), "Total price message failed"),
            () -> assertTrue(outputString.contains("59,48"), "Total price after discount message failed"),
            () -> assertTrue(outputString.contains("300"), "Amount paid message failed")
        );
    }
}
