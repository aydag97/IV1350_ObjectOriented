package se.kth.iv1350.model;

import se.kth.iv1350.dto.DiscountDTO;
import se.kth.iv1350.integration.DiscountCalculator;

public class DiscountFactory {
    
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
