package se.kth.iv1350.integration;
import se.kth.iv1350.dto.DiscountDTO;


/**
 * The DiscountCalculator interface defines a method for calculating discounts.
 * Implementations of this interface will provide specific discount calculation algorithms.
 */
public interface DiscountCalculator{

    /**
     * Calculates the discount based on the total amount and the provided discount details.
     *
     * @param totalAmount The total amount before applying the discount.
     * @param discount The DiscountDTO object containing the discount details.
     * @return The total amount after applying the discount.
     */
    double calculateTheDiscount(double totalAmount, DiscountDTO discount);
}