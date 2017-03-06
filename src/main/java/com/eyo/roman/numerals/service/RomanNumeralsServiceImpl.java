package com.eyo.roman.numerals.service;

import org.springframework.stereotype.Component;

@Component
public class RomanNumeralsServiceImpl implements RomanNumeralsService {
    
    
    @Override
    public String convertDecimalNumberToRomanNumeral(int naturalNumber) {
        return "I";
    }
    
    @Override
    public int convertRomanNumeralToDecimalNumber(String romanNumeral) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
