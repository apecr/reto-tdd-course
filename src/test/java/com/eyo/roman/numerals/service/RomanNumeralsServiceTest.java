package com.eyo.roman.numerals.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eyo.roman.numerals.config.ConfigRomanNumeralsContext;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConfigRomanNumeralsContext.class })
public class RomanNumeralsServiceTest {
    
    @Autowired
    private RomanNumeralsService romanNumeralsService;
    
    @Test
    public void notNull(){
        assertNotNull(this.romanNumeralsService);
    }
    
    @Test
    public void whenNumber1ReturnI(){
        //When
        String romanNumeral = this.romanNumeralsService.convertDecimalNumberToRomanNumeral( 1 );
        //Then
        assertEquals( "I", romanNumeral );
    }
    
    @Test
    public void whenNumber2ReturnII(){
        //When
        String romanNumeral = this.romanNumeralsService.convertDecimalNumberToRomanNumeral( 2 );
        //Then
        assertEquals( "II", romanNumeral );
    }
}
