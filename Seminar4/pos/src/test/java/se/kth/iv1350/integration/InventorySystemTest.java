package se.kth.iv1350.integration;

import se.kth.iv1350.dto.ItemDTO;
import se.kth.iv1350.exceptions.*;
import se.kth.iv1350.model.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

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
        ItemDTO actualEggItem = null;
        try{
            actualEggItem = inventorySystem.getItemInfo(1);
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            fail(exception.getMessage());
        }  
        String expectedResult = "Egg";
        assertEquals(expectedResult, actualEggItem.getItemName(), "Wrong Item - Not in the inventory");
    }

    @Test
    public void getMilkInformationTest() {
        ItemDTO actualMilkItem = null;
        try{
            actualMilkItem = inventorySystem.getItemInfo(2);
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            fail(exception.getMessage());
        } 
        String expectedResult = "Milk";
        assertEquals(expectedResult, actualMilkItem.getItemName(), "Wrong Item - Not in the inventory");
    }

    @Test
    public void getButterInformationTest() {
        ItemDTO actualButterItem = null;
        try{
            actualButterItem = inventorySystem.getItemInfo(3);
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            fail(exception.getMessage());
        } 
        String expectedResult = "Butter";
        assertEquals(expectedResult, actualButterItem.getItemName(), "Wrong Item - Not in the inventory");
    }

    @Test
    public void getInformationWithDatabaseFailureExceptionTest() {
        Executable expectedResult = () -> inventorySystem.getItemInfo(4);
        assertThrows(DatabaseFailureException.class, expectedResult, "Expected to throw a DatabaseFailureException, but failed."); 
    }

    @Test
    public void getInformationWithItemNotFoundExceptionTest() {
        Executable expectedResult = () -> inventorySystem.getItemInfo(100);
        assertThrows(ItemNotFoundException.class, expectedResult, "Expected to throw a DatabaseFailureException, but failed.");
    }

    @Test
    public void updateInventoryTest() {
        createShoppingBag();
        inventorySystem.updateItemInventory(sale.getFinalBag());
        ItemDTO itemInBag = null;
        try{
            itemInBag = inventorySystem.getItemInfo(2);
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            fail(exception.getMessage());
        } 
        int expectedResult = 47;
        assertEquals(expectedResult, itemInBag.getItemQuantity(), "Quantity not updated");
    }
    
    @Test
    public void updateNothingInventoryTest(){
        inventorySystem.updateItemInventory(sale.getFinalBag());
        ItemDTO itemInBag = null;
        try{
            itemInBag = inventorySystem.getItemInfo(2);
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            fail(exception.getMessage());
        } 
        int expectedResult = 50;
        assertEquals(expectedResult, itemInBag.getItemQuantity(), "Quantity wrongly updated");
    }

    private void createShoppingBag() {
        ItemDTO itemInBag = null;
        try{
            itemInBag = inventorySystem.getItemInfo(2);
        }catch(ItemNotFoundException | DatabaseFailureException exception){
            fail(exception.getMessage());
        } 
        sale.addNewItem(itemInBag, 3);
    }
}
