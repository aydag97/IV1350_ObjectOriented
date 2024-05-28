package se.kth.iv1350.model;

import se.kth.iv1350.dto.DiscountDTO;

/**
 * The DiscountPercent class implements the DiscountCalculator interface.
 * It calculates the discount amount based on a percentage of the total amount.
 */
public class DiscountPercent implements DiscountCalculator{

    /**
     * Calculates the discount amount based on the total amount and the percentage discount.
     *
     * @param totalAmount The total amount before applying the discount.
     * @param discount The DiscountDTO object containing the discount details.
     * @return The updated total amount after applying the discount.
     */
    @Override
    public double calculateTheDiscount(double totalAmount, DiscountDTO discount){

        double updatedAmount = totalAmount - (totalAmount*discount.amount());
        return updatedAmount;
    }
}