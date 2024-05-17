package se.kth.iv1350.model;

import se.kth.iv1350.dto.DiscountDTO;
import se.kth.iv1350.integration.DiscountCalculator;

public class DiscountPercent implements DiscountCalculator{

    @Override
    public double calculateTheDiscount(double totalAmount, DiscountDTO discount){

        double updatedAmount = totalAmount - (totalAmount*discount.amount());
        return updatedAmount;
    }
}