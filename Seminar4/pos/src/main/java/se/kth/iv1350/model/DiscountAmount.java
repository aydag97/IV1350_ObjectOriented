package se.kth.iv1350.model;

import se.kth.iv1350.dto.DiscountDTO;
import se.kth.iv1350.integration.DiscountCalculator;

/**
 * The DiscountAmount class implements the DiscountCalculator interface.
 * It calculates the discount amount based on a fixed discount value.
 */
public class DiscountAmount implements DiscountCalculator{

    /**
     * Calculates the discount amount based on the total amount and the discount value.
     *
     * @param totalAmount The total amount before applying the discount.
     * @param discount The DiscountDTO object containing the discount details.
     * @return The updated total amount after applying the discount.
     */
    @Override
    public double calculateTheDiscount(double totalAmount, DiscountDTO discount){
        double updatedAmount = totalAmount - discount.amount();
        return updatedAmount;
    }
}
