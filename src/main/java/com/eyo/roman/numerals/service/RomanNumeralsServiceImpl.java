package com.eyo.roman.numerals.service;

import org.springframework.stereotype.Component;

@Component
public class RomanNumeralsServiceImpl implements RomanNumeralsService {
    
    
    @Override
    public String convertDecimalNumberToRomanNumeral(int naturalNumber) {
        return getRomanNumeralFromSimpleNumberMinusThanTen( "X", "V", "I", naturalNumber );
    }
    
    /**
     * Obtiene el numero romano de un numero menor que diez. Sirve para cualquier numero siempre y cuando este sea una
     * potencia de diez. Para saber el valor real en numeros romanos se le pasa lo que vale el multiplo de diez por
     * arriba (ten), el cinco (five) y la unidad que estemos midiendo (one). Por ejemplo si queremos saber cuanto vale
     * el 400, le pasaremos a la funcion los siguientes parametros<br>
     * (ten --> M [1000], five --> D [500], one --> C [100], numberMinusThanTen --> 4) <br>
     * La salida tiene que ser CD (500 -100)
     * 
     * @param ten
     *        {@link String} con la potencia de diez por encima del numero (si es el 9, X [10], p.e.)
     * @param five
     *        {@link String} con el valor intermedio de la potencia de diez por encima (si es el 90, L [50], p.e.)
     * @param one
     *        {@link String} con el valor de la unidad que estamos midiendo potencia de 10 (si el 900, C [100], p.e)
     * @param numberMinusThanTen
     *        El valor multiplicador de la potencia de 10 (si es 9 --> 9, si es 90 --> 0, si es 900 --> 9)
     * @return {@link String} Con el valor en numeros romanos del numberMinusThanTen
     */
    private String getRomanNumeralFromSimpleNumberMinusThanTen(String ten, String five, String one,
            int numberMinusThanTen) {
        String output = "";
        if (numberMinusThanTen < 4) {
            output = repeatString( one, numberMinusThanTen );
        }
        if (numberMinusThanTen == 4) {
            output = one + five;
        }
        if (numberMinusThanTen == 5) {
            output = five;
        }
        if (numberMinusThanTen > 5) {
            output = five + repeatString( one, numberMinusThanTen - 5 );
        }
        if (numberMinusThanTen == 9) {
            output = one + ten;
        }
        return output;
    }
    
    /**
     * @param stringToRepeat
     * @param numberOfTimes
     * @return
     */
    private String repeatString(String stringToRepeat, int numberOfTimes) {
        return new String( new char[numberOfTimes] ).replace( "\0", stringToRepeat );
    }
    
    @Override
    public int convertRomanNumeralToDecimalNumber(String romanNumeral) {
        return 0;
    }
    
}
