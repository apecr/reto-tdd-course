package com.eyo.roman.numerals.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.eyo.roman.numerals.vo.RangeOfRomanNumeralsVO;

@Component
public class RomanNumeralsServiceImpl implements RomanNumeralsService {
    
    private static final Map<Integer, RangeOfRomanNumeralsVO> MAP_RANGES = new HashMap<>();
    
    static {
        MAP_RANGES.put( 1, new RangeOfRomanNumeralsVO( "X", "V", "I" ) );
        MAP_RANGES.put( 2, new RangeOfRomanNumeralsVO( "C", "L", "X" ) );
        MAP_RANGES.put( 3, new RangeOfRomanNumeralsVO( "M", "D", "C" ) );
    }
    
    @Override
    public String convertDecimalNumberToRomanNumeral(int naturalNumber) {
        StringBuilder romanNumeral = new StringBuilder();
        int lenghtString = String.valueOf( naturalNumber ).length();
        for (int i = lenghtString; i > 0; i--) {
            romanNumeral.append( getRomanNumeralFromSimpleNumberMinusThanTen( MAP_RANGES.get( i ), (int) ( naturalNumber % Math.pow( 10, i ) / Math.pow( 10, (double)i -1  ) ) ) );
        }
        return romanNumeral.toString();
    }
    
    /**
     * Obtiene el numero romano de un numero menor que diez. Sirve para cualquier numero siempre y cuando este sea una
     * potencia de diez. Para saber el valor real en numeros romanos se le pasa lo que vale el multiplo de diez por
     * arriba (ten), el cinco (five) y la unidad que estemos midiendo (one). Por ejemplo si queremos saber cuanto vale
     * el 400, le pasaremos a la funcion los siguientes parametros<br>
     * (ten --> M [1000], five --> D [500], one --> C [100], numberMinusThanTen --> 4) <br>
     * La salida tiene que ser CD (500 -100)
     * 
     * @param rangeOfRomanNumerals {@link RangeOfRomanNumeralsVO} con los siguientes parametros:<br>
     *      ten --> {@link String} con la potencia de diez por encima del numero (si es el 9, X [10], p.e.)<br>
     *      five --> {@link String} con el valor intermedio de la potencia de diez por encima (si es el 90, L [50], p.e.)<br>
     *      one --> {@link String} con el valor de la unidad que estamos midiendo potencia de 10 (si el 900, C [100], p.e)
     * @param numberMinusThanTen
     *        El valor multiplicador de la potencia de 10 (si es 9 --> 9, si es 90 --> 0, si es 900 --> 9)
     * @return {@link String} Con el valor en numeros romanos del numberMinusThanTen
     */
    private String getRomanNumeralFromSimpleNumberMinusThanTen(RangeOfRomanNumeralsVO rangeOfRomanNumerals,
            int numberMinusThanTen) {
        String output = betweenOneAndThreeInclusives( rangeOfRomanNumerals.getOne(), numberMinusThanTen, null );
        output = fourSpecialCase( rangeOfRomanNumerals.getFive(), rangeOfRomanNumerals.getOne(), numberMinusThanTen,
                output );
        output = fiveSpecialCase( rangeOfRomanNumerals.getFive(), numberMinusThanTen, output );
        output = betweenSixAndEigthInclusives( rangeOfRomanNumerals.getFive(), rangeOfRomanNumerals.getOne(),
                numberMinusThanTen, output );
        return nineSpecialCase( rangeOfRomanNumerals.getTen(), rangeOfRomanNumerals.getOne(), numberMinusThanTen,
                output );
    }
    
    /**
     * @param one
     * @param numberMinusThanTen
     * @param output
     * @return
     */
    private String betweenOneAndThreeInclusives(String one, int numberMinusThanTen, String output) {
        String romanNumber = output;
        if (numberMinusThanTen < 4) {
            romanNumber = repeatString( one, numberMinusThanTen );
        }
        return romanNumber;
    }
    
    /**
     * @param five
     * @param one
     * @param numberMinusThanTen
     * @param output
     * @return
     */
    private String betweenSixAndEigthInclusives(String five, String one, int numberMinusThanTen, String output) {
        String romanNumber = output;
        if (numberMinusThanTen > 5) {
            romanNumber = five + repeatString( one, numberMinusThanTen - 5 );
        }
        return romanNumber;
    }
    
    /**
     * @param five
     * @param one
     * @param numberMinusThanTen
     * @param output
     * @return
     */
    private String fourSpecialCase(String five, String one, int numberMinusThanTen, String output) {
        String romanNumber = output;
        if (numberMinusThanTen == 4) {
            romanNumber = one + five;
        }
        return romanNumber;
    }
    
    /**
     * @param five
     * @param numberMinusThanTen
     * @param output
     * @return
     */
    private String fiveSpecialCase(String five, int numberMinusThanTen, String output) {
        String romanNumber = output;
        if (numberMinusThanTen == 5) {
            romanNumber = five;
        }
        return romanNumber;
    }
    
    /**
     * @param ten
     * @param one
     * @param numberMinusThanTen
     * @param output
     * @return
     */
    private String nineSpecialCase(String ten, String one, int numberMinusThanTen, String output) {
        String romanNumber = output;
        if (numberMinusThanTen == 9) {
            romanNumber = one + ten;
        }
        return romanNumber;
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
        if (romanNumeral == "I"){
            return 1;
        }
        return 0;
    }
    
}
