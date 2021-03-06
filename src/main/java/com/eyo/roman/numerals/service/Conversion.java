package com.eyo.roman.numerals.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Conversion {

	public class NumberConverted implements Serializable {

		/**
		 * serial version UID
		 */
		private static final long serialVersionUID = -2648620583727417964L;

		private int number;
		private boolean skipNextValue;

		/**
		 * @return the number
		 */
		public int getNumber() {
			return number;
		}

		/**
		 * @param number
		 *            the numberConverted to set
		 */
		public void setNumber(int number) {
			this.number = number;
		}

		/**
		 * @return the skipNextValue
		 */
		public boolean isSkipNextValue() {
			return skipNextValue;
		}

		/**
		 * @param skipNextValue
		 *            the skipNextValue to set
		 */
		public void setSkipNextValue(boolean skipNextValue) {
			this.skipNextValue = skipNextValue;
		}

	}

	public enum RomanNumbers {

		I("I", 1), V("V", 5), X("X", 10), L("L", 50), C("C", 100), D("D", 500), M("M", 1000);

		private final String name;
		private final int value;

		private RomanNumbers(String s, int val) {
			name = s;
			value = val;
		}

		public boolean equalsName(String otherName) {
			return name.equals(otherName);
		}

		@Override
		public String toString() {
			return this.name;
		}

		public int getValue() {
			return this.value;
		}

	}

	public class RangeOfRomanNumeralsVO implements Serializable {

		/**
		 * Serial version UID
		 */
		private static final long serialVersionUID = 3554064724171308866L;

		private RomanNumbers ten;

		private RomanNumbers five;

		private RomanNumbers one;

		public RangeOfRomanNumeralsVO(RomanNumbers ten, RomanNumbers five, RomanNumbers one) {
			super();
			this.setTen(ten);
			this.setFive(five);
			this.setOne(one);
		}

		/**
		 * @return the ten
		 */
		public RomanNumbers getTen() {
			return ten;
		}

		/**
		 * @param ten
		 *            the ten to set
		 */
		public void setTen(RomanNumbers ten) {
			this.ten = ten;
		}

		/**
		 * @return the five
		 */
		public RomanNumbers getFive() {
			return five;
		}

		/**
		 * @param five
		 *            the five to set
		 */
		public void setFive(RomanNumbers five) {
			this.five = five;
		}

		/**
		 * @return the one
		 */
		public RomanNumbers getOne() {
			return one;
		}

		/**
		 * @param one
		 *            the one to set
		 */
		public void setOne(RomanNumbers one) {
			this.one = one;
		}

	}

	public Conversion() {
		MAP_RANGES.put(1, new RangeOfRomanNumeralsVO(RomanNumbers.X, RomanNumbers.V, RomanNumbers.I));
		MAP_RANGES.put(2, new RangeOfRomanNumeralsVO(RomanNumbers.C, RomanNumbers.L, RomanNumbers.X));
		MAP_RANGES.put(3, new RangeOfRomanNumeralsVO(RomanNumbers.M, RomanNumbers.D, RomanNumbers.C));
		MAP_RANGES.put(4, new RangeOfRomanNumeralsVO(RomanNumbers.M, RomanNumbers.M, RomanNumbers.M));
	}

	private static final Map<Integer, RangeOfRomanNumeralsVO> MAP_RANGES = new HashMap<>();

	
	public String solution(int naturalNumber) {
		StringBuilder romanNumeral = new StringBuilder();
		int lenghtString = String.valueOf(naturalNumber).length();
		for (int i = lenghtString; i > 0; i--) {
			romanNumeral.append(getRomanNumeralFromSimpleNumberMinusThanTen(MAP_RANGES.get(i),
					(int) (naturalNumber % Math.pow(10, i) / Math.pow(10, (double) i - 1))));
		}
		return romanNumeral.toString();
	}

	
	public int convertRomanNumeralToDecimalNumber(String romanNumeral) {
		int numberConverted = 0;
		if (romanNumeral != null && romanNumeral.length() > 0) {
			numberConverted = recorreNumerosRomanosYSumaCadaUno(romanNumeral, 0);
		}
		return numberConverted;
	}

	/**
	 * Obtiene el numero romano de un numero menor que diez. Sirve para
	 * cualquier numero siempre y cuando este sea una potencia de diez. Para
	 * saber el valor real en numeros romanos se le pasa lo que vale el multiplo
	 * de diez por arriba (ten), el cinco (five) y la unidad que estemos
	 * midiendo (one). Por ejemplo si queremos saber cuanto vale el 400, le
	 * pasaremos a la funcion los siguientes parametros<br>
	 * (ten --> M [1000], five --> D [500], one --> C [100], numberMinusThanTen
	 * --> 4) <br>
	 * La salida tiene que ser CD (500 -100)
	 * 
	 * @param rangeOfRomanNumerals
	 *            {@link RangeOfRomanNumeralsVO} con los siguientes
	 *            parametros:<br>
	 *            ten --> {@link String} con la potencia de diez por encima del
	 *            numero (si es el 9, X [10], p.e.)<br>
	 *            five --> {@link String} con el valor intermedio de la potencia
	 *            de diez por encima (si es el 90, L [50], p.e.)<br>
	 *            one --> {@link String} con el valor de la unidad que estamos
	 *            midiendo potencia de 10 (si el 900, C [100], p.e)
	 * @param numberMinusThanTen
	 *            El valor multiplicador de la potencia de 10 (si es 9 --> 9, si
	 *            es 90 --> 0, si es 900 --> 9)
	 * @return {@link String} Con el valor en numeros romanos del
	 *         numberMinusThanTen
	 */
	private String getRomanNumeralFromSimpleNumberMinusThanTen(RangeOfRomanNumeralsVO rangeOfRomanNumerals,
			int numberMinusThanTen) {
		String output = betweenOneAndThreeInclusives(rangeOfRomanNumerals.getOne(), numberMinusThanTen, null);
		output = fourSpecialCase(rangeOfRomanNumerals.getFive(), rangeOfRomanNumerals.getOne(), numberMinusThanTen,
				output);
		output = fiveSpecialCase(rangeOfRomanNumerals.getFive(), numberMinusThanTen, output);
		output = betweenSixAndEigthInclusives(rangeOfRomanNumerals.getFive(), rangeOfRomanNumerals.getOne(),
				numberMinusThanTen, output);
		return nineSpecialCase(rangeOfRomanNumerals.getTen(), rangeOfRomanNumerals.getOne(), numberMinusThanTen,
				output);
	}

	/**
	 * @param one
	 * @param numberMinusThanTen
	 * @param output
	 * @return
	 */
	private String betweenOneAndThreeInclusives(RomanNumbers one, int numberMinusThanTen, String output) {
		String romanNumber = output;
		if (numberMinusThanTen < 4) {
			romanNumber = repeatString(one.name(), numberMinusThanTen);
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
	private String betweenSixAndEigthInclusives(RomanNumbers five, RomanNumbers one, int numberMinusThanTen,
			String output) {
		String romanNumber = output;
		if (numberMinusThanTen > 5) {
			romanNumber = five.name() + repeatString(one.name(), numberMinusThanTen - 5);
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
	private String fourSpecialCase(RomanNumbers five, RomanNumbers one, int numberMinusThanTen, String output) {
		String romanNumber = output;
		if (numberMinusThanTen == 4) {
			romanNumber = one.name() + five.name();
		}
		return romanNumber;
	}

	/**
	 * @param five
	 * @param numberMinusThanTen
	 * @param output
	 * @return
	 */
	private String fiveSpecialCase(RomanNumbers five, int numberMinusThanTen, String output) {
		String romanNumber = output;
		if (numberMinusThanTen == 5) {
			romanNumber = five.name();
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
	private String nineSpecialCase(RomanNumbers ten, RomanNumbers one, int numberMinusThanTen, String output) {
		String romanNumber = output;
		if (numberMinusThanTen == 9) {
			romanNumber = one.name() + ten.name();
		}
		return romanNumber;
	}

	/**
	 * @param stringToRepeat
	 * @param numberOfTimes
	 * @return
	 */
	private String repeatString(String stringToRepeat, int numberOfTimes) {
		return new String(new char[numberOfTimes]).replace("\0", stringToRepeat);
	}

	/**
	 * @param romanNumeral
	 * @param numberConverted
	 * @return
	 */
	private int recorreNumerosRomanosYSumaCadaUno(String romanNumeral, int numberConverted) {
		NumberConverted number = new NumberConverted();
		number.setNumber(numberConverted);
		number.setSkipNextValue(false);
		for (int i = 0; i < romanNumeral.length(); i++) {
			executeOneIterationOfConversion(romanNumeral, number, i);
		}
		return number.getNumber();
	}

	/**
	 * @param romanNumeral
	 * @param number
	 * @param i
	 */
	private void executeOneIterationOfConversion(String romanNumeral, NumberConverted number, int i) {
		if (!number.isSkipNextValue()) {
			number.setSkipNextValue(false);
			allNumbersButLast(romanNumeral, number, i);
			lastNumber(romanNumeral, number, i);
		} else {
			number.setSkipNextValue(false);
		}
	}

	/**
	 * @param romanNumeral
	 * @param number
	 * @param i
	 */
	private void allNumbersButLast(String romanNumeral, NumberConverted number, int i) {
		if (i < romanNumeral.length() - 1) {
			int letter = RomanNumbers.valueOf(romanNumeral.substring(i, i + 1)).getValue();
			int nextLetter = RomanNumbers.valueOf(romanNumeral.substring(i + 1, i + 2)).getValue();
			numberWhenFirstLowerThanSecondAddOneToCounter(number, letter, nextLetter);
			numberWhenFirstBiggerOrEqualsToSecond(romanNumeral, number, i, letter, nextLetter);
		}
	}

	/**
	 * @param romanNumeral
	 * @param number
	 * @param i
	 */
	private void lastNumber(String romanNumeral, NumberConverted number, int i) {
		if (i == romanNumeral.length() - 1) {
			number.setNumber(addNextValueToRomanConversion(romanNumeral, number.getNumber(), i));
		}
	}

	/**
	 * @param romanNumeral
	 * @param number
	 * @param i
	 * @param letter
	 * @param nextLetter
	 */
	private void numberWhenFirstBiggerOrEqualsToSecond(String romanNumeral, NumberConverted number, int i, int letter,
			int nextLetter) {
		if (letter >= nextLetter) {
			number.setNumber(addNextValueToRomanConversion(romanNumeral, number.getNumber(), i));
		}
	}

	/**
	 * @param number
	 * @param letter
	 * @param nextLetter
	 */
	private void numberWhenFirstLowerThanSecondAddOneToCounter(NumberConverted number, int letter, int nextLetter) {
		if (letter < nextLetter) {
			number.setNumber(number.getNumber() + nextLetter - letter);
			number.setSkipNextValue(true);
		}
	}

	/**
	 * @param romanNumeral
	 * @param numberConverted
	 * @param positionOfTheNextElement
	 * @return
	 */
	private int addNextValueToRomanConversion(String romanNumeral, int numberConverted, int positionOfTheNextElement) {
		return numberConverted + RomanNumbers
				.valueOf(romanNumeral.substring(positionOfTheNextElement, positionOfTheNextElement + 1)).getValue();
	}

}
