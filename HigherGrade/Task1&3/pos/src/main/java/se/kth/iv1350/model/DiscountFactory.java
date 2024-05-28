package se.kth.iv1350.model;

import se.kth.iv1350.dto.DiscountDTO;

/**
 * The DiscountFactory class provides a factory method to create instances of 
 * DiscountCalculator based on discount type.
 */
public class DiscountFactory {
    private static final DiscountFactory DISCOUNT_FACTORY = new DiscountFactory();

    /**
     * Retrieves the singleton instance of DiscountFactory.
     *
     * @return The DiscountFactory instance.
     */
    public static DiscountFactory getFactoryInstance(){
        return DISCOUNT_FACTORY;
    }

    private DiscountFactory(){
    }
    
    /**
     * Creates an instance of DiscountCalculator based on the discount type.
     *
     * @param discount The DiscountDTO object containing the discount details.
     * @return The DiscountCalculator instance corresponding to the discount type.
     */
    public DiscountCalculator getDiscountAlgorithm(DiscountDTO discount){
        if(discount.discountType().equals("Amount")){
            return new DiscountAmount();
        }
        else if(discount.discountType().equals("Percent")){
            return new DiscountPercent();
        }
        else{
            return null;  
        }
    }
}
