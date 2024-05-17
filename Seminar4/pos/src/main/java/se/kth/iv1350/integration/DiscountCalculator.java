package se.kth.iv1350.integration;
import se.kth.iv1350.dto.DiscountDTO;

public interface DiscountCalculator{
    // Amount 
    // Percentage
    // Discount DTO skapas.
    double calculateTheDiscount(double totalAmount, DiscountDTO discount);
}