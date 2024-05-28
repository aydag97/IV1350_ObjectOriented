package se.kth.iv1350.view;

import org.junit.jupiter.api.*;
import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class ViewTest {
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
    void simulateFakeSaleStoryTest(){
        view.simulateFakeSaleStory();
        String outputString = output.toString().replace("\r", "");
        assertAll(
            () -> assertTrue(outputString.contains("Welcome"), "Welcome message failed"),
            () -> assertTrue(outputString.contains("Starting"), "Start sale message failed"),
            () -> assertTrue(outputString.contains("1x Item 1"), "Adding item 1 message failed"),
            () -> assertTrue(outputString.contains("3x Item 2"), "Adding item 2 message failed"),
            () -> assertTrue(outputString.contains("wrong with server connection."), "Server connection message failed"),
            () -> assertTrue(outputString.contains("Item with item ID 6 not found!"), "Invalid item ID message failed"),
            () -> assertTrue(outputString.contains("Sale has been ended"), "End sale message failed"),
            () -> assertTrue(outputString.contains("Calculating the change"), "Calculate change message failed"),
            () -> assertTrue(outputString.contains("back to customer: 469.7 SEK"), "Amount of change message failed"),
            () -> assertTrue(outputString.contains("paid and ended"), "Sale paid and ended message failed")
        );
    }

    @Test
    void simulateAnotherFakeSaleStoryTest(){
        view.simulateAnotherFakeSaleStory();
        String outputString = output.toString().replace("\r", "");
        assertAll(
            () -> assertTrue(outputString.contains("Welcome"), "Welcome message failed"),
            () -> assertTrue(outputString.contains("Starting"), "Start sale message failed"),
            () -> assertTrue(outputString.contains("10x Item 3"), "Adding item 3 message failed"),
            () -> assertTrue(outputString.contains("2x Item 2"), "Adding item 2 message failed"),
            () -> assertTrue(outputString.contains("Sale has been ended"), "End sale message failed"),
            () -> assertTrue(outputString.contains("Calculating the change"), "Calculate change message failed"),
            () -> assertTrue(outputString.contains("back to customer: 39,39 SEK"), "Amount of change message failed"),
            () -> assertTrue(outputString.contains("paid and ended"), "Sale paid and ended message failed")
        );
    }
    
}
