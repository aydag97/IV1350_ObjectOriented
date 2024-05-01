package se.kth.iv1350.integration;

import se.kth.iv1350.model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventorySystemTest {

    private InventorySystem inventorySystem;
    private Sale sale;

    @BeforeEach
    public void setUp() {
        inventorySystem = new InventorySystem();
        sale = new Sale();
    }

    @AfterEach
    public void tearDown() {
        inventorySystem = null;
        sale = null;
    }

    @Test
    public void getEggInformationTest() {
        ItemDTO actualEggItem = inventorySystem.getItemInfo(1);
        String expectedResult = "Egg";
        assertEquals(expectedResult, actualEggItem.getItemName(), "Wrong Item - Not in the inventory");
    }

    @Test
    public void getMilkInformationTest() {
        ItemDTO actualMilkItem = inventorySystem.getItemInfo(2);
        String expectedResult = "Milk";
        assertEquals(expectedResult, actualMilkItem.getItemName(), "Wrong Item - Not in the inventory");
    }

    @Test
    public void getButterInformationTest() {
        ItemDTO actualButterItem = inventorySystem.getItemInfo(3);
        String expectedResult = "Butter";
        assertEquals(expectedResult, actualButterItem.getItemName(), "Wrong Item - Not in the inventory");
    }

    @Test
    public void getBreadInformationTest() {
        ItemDTO actualBreadItem = inventorySystem.getItemInfo(4);
        String expectedResult = "Bread";
        assertEquals(expectedResult, actualBreadItem.getItemName(), "Wrong Item - Not in the inventory");
    }

    @Test
    public void updateInventoryTest() {
        createShoppingBag();
        inventorySystem.updateItemInventory(sale.getFinalBag());
        int expectedResult = 47;
        assertEquals(expectedResult, inventorySystem.getItemInfo(2).getItemQuantity(), "Quantity not updated");
    }
    
    @Test
    public void updateNothingInventoryTest(){
        inventorySystem.updateItemInventory(sale.getFinalBag());
        int expectedResult = 50;
        assertEquals(expectedResult, inventorySystem.getItemInfo(2).getItemQuantity(), "Quantity wrongly updated");
    }

    private void createShoppingBag() {
        sale.addNewItem(inventorySystem.getItemInfo(2), 3);
    }

}
