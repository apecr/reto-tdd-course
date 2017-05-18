package com.eyo.roman.numerals.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.eyo.roman.numerals.service.Conversion;

public class ConversionTest {

	private Conversion conversion = new Conversion();

	@Test
	public void shouldCovertToRoman() {
		assertEquals("solution(1) should equal to I", "I", conversion.solution(1));
		assertEquals("solution(4) should equal to IV", "IV", conversion.solution(4));
		assertEquals("solution(6) should equal to VI", "VI", conversion.solution(6));
	}
	
	@Test
	public void shouldCovertToRomanRest() {
		assertEquals("solution(1) should equal to XIV", "XIV", conversion.solution(14));
		assertEquals("solution(4) should equal to XXI", "XXI", conversion.solution(21));
		assertEquals("solution(6) should equal to LXXXIX", "LXXXIX", conversion.solution(89));
		assertEquals("solution(6) should equal to XCI", "XCI", conversion.solution(91));
		assertEquals("solution(6) should equal to CMLXXXIV", "CMLXXXIV", conversion.solution(984));
		
	}
	
	@Test
	public void case1000(){
		assertEquals("solution(6) should equal to M", "M", conversion.solution(1000));
	}
}
