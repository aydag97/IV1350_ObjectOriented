package se.kth.iv1350.exceptions;

/**
 * This exception is thrown when an item is not found in the inventory.
 */

public class ItemNotFoundException extends Exception{
    
    public ItemNotFoundException(String exceptionMessage){
        super(exceptionMessage);
    }
}