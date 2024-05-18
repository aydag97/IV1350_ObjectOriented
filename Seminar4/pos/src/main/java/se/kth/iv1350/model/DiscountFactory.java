package se.kth.iv1350.model;

import se.kth.iv1350.dto.DiscountDTO;
import se.kth.iv1350.integration.DiscountCalculator;

public class DiscountFactory {
    private static final DiscountFactory DISCOUNT_FACTORY = new DiscountFactory();

    public static DiscountFactory getFactoryInstance(){
        return DISCOUNT_FACTORY;
    }

    private DiscountFactory(){
    }
    
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
