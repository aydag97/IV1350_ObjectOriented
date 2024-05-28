package se.kth.iv1350.dto;

/**
 * DiscountDTO is a data transfer object that encapsulates information about a discount.
 * 
 * @param amount The amount or percentage of the discount.
 * @param discountType The type of discount, e.g., "Amount" or "Percent".
 * @param discountDescription A description of the discount.
 */
public record DiscountDTO(double amount, String discountType, String discountDescription) {
}
