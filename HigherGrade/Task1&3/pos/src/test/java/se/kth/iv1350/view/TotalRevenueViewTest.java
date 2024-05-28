package se.kth.iv1350.view;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.*;
import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.*;


public class TotalRevenueViewTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Controller contr;
    private View view;

    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(output));
        contr = new Controller(new Printer(), new SalesLog());
        view = new View(contr);
    }

    @AfterEach
    void tearDown(){
        System.setOut(originalOut);
        contr = null;
        view = null;
    }

    @Test
    void doShowTotalIncomeTest(){
        view.simulateFakeSaleStory();
        String outputString = output.toString().replace("\r", "");
        assertAll(
            () -> assertTrue(outputString.contains("Notification to all observers"), "Notification message failed"),
            () -> assertTrue(outputString.contains("Current total revenue is: 83,75 kr"), "Start sale message failed")
        );
    }
    
}
