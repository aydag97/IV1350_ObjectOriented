package se.kth.iv1350.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemsInBagTest {
    private ItemsInBag itemsInBag;
    
    @BeforeEach
    public void setUp() {
        itemsInBag = new ItemsInBag(new ItemDTO(1, "Egg", 30.95, 12, 100), 1);
    }

    @AfterEach 
    public void tearDown() {
        itemsInBag = null;
    }

    @Test
    public void updatedQuantityTest() { 
        itemsInBag.updateQuantity(3);
        int expectedResult = 4;
        assertEquals(expectedResult, itemsInBag.getItemQuantity(), "Itembag updates quantity incorrectly");
    }
}
