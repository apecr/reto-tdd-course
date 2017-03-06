package com.eyo.roman.numerals.service;

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
}
