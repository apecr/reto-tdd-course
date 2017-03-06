package com.eyo.roman.numerals.service;

import org.springframework.stereotype.Component;

@Component
public class RomanNumeralsServiceImpl implements RomanNumeralsService {
    
    
    @Override
    public String convertDecimalNumberToRomanNumeral(int naturalNumber) {
        String romanNumeral = "I";
        if (naturalNumber == 2){
            romanNumeral = "II";
        }
        return romanNumeral;
    }
    
    @Override
    public int convertRomanNumeralToDecimalNumber(String romanNumeral) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
