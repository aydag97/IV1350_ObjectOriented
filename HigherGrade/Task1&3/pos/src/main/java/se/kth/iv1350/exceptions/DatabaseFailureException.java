package se.kth.iv1350.exceptions;

/**
 * This exception is thrown when a specific (hardcoded) item ID cannot be fetched from DB.
 */

public class DatabaseFailureException extends Exception {

    public DatabaseFailureException(String exceptionMessage){
        super(exceptionMessage);
    }
}
