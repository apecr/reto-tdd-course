package com.eyo.roman.numerals.service;


public interface RomanNumeralsService {
    
    /**
     * Convierte un numero decimal mayor que cero (la Kata llegara hasta el 100) en un numero romano <br>
     *  - 1 --> I<br>
     *  - 2 --> II<br>
     *  - etc...
     * @param naturalNumber Entero mayor que cero a convertir
     * @return {@link String} Valor del numero romano
     */
    String convertDecimalNumberToRomanNumeral(int naturalNumber);
    
    /**
     * Convierte un numero romano (I, V, VII, XI, etc...) en un numero natural.
     * @param romanNumeral {@link String} Valor del numero romano
     * @return Entero con el valor decimal
     */
    int convertRomanNumeralToDecimalNumber(String romanNumeral);
    
}
