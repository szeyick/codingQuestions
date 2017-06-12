package com.airwallexChallenge.rpnCalculator.main.util;

/**
 * The NumberUtils.
 * <p>
 * This is a utilities class that is responsible for performing numeric actions
 * on a given string.
 * <p>
 * <b>Warning: </b>None.
 * <p>
 * @author szeyick
 */
public final class NumberUtils {

	/**
	 * The maximum length of the formatted output.
	 */
	private static final int MAX_FORMAT_LENGTH = 10;
	
	/**
	 * This method is responsible for formatting a given value to at most 10 decimal
	 * places. The output value is shortened further if there is no loss in precision
	 * (i.e. 90.899999)
	 * @param value - The value to print.
	 * @return the value to print, displayed to at most 10 decimal places.
	 */
	public static String formatNumber(Double value) {
		String valueString = value.toString();
		String characteristicString = valueString.substring(0, valueString.indexOf('.'));
		String mantissaString = valueString.substring(valueString.indexOf('.') + 1, valueString.length());

		StringBuilder builder = new StringBuilder();
		builder.append(characteristicString);
		if (!"0".equals(mantissaString)) {
			builder.append(".");
			// Compare each value after the decimal from its next index until the end. If
			// all subsequent values are the same as the current value, then we can break
			// the loop and append the current value to the formatted string and return since
			// we won't lose precision. If there are differences, then we continue with the next
			// decimal value.
			int currentIndex = 0;
			while (currentIndex < MAX_FORMAT_LENGTH && currentIndex < mantissaString.length()) {
				boolean append = false;
				int currentValue = Character.getNumericValue(mantissaString.charAt(currentIndex));
				for (int nextIndex = currentIndex + 1; nextIndex < mantissaString.length(); nextIndex++) {
					int nextValue = Character.getNumericValue(mantissaString.charAt(nextIndex));
					if (currentValue != nextValue) {
						append = true;
						break;
					}
				}
				builder.append(currentValue);
				if (!append) {
					break;
				}
				currentIndex++;
			}			
		}
		return builder.toString();
	}
	
	/**
	 * Evaluate if the input string is a numeric value. A numeric value can be a decimal or negative
	 * but aside from the '-' sign and '.' decimal point, it must contain all numeric values.
	 * <p>
	 * @param inputString - The input string to validate.
	 * @return <code>true</code> if the input string is a value, <code>false</code> otherwise.
	 */
	public static boolean isNumericValue(String inputString) {
		boolean isValue = false;
		if (inputString.isEmpty()) {
			return isValue;
		}
		else {
			for (int i = 0; i < inputString.length(); i++) {
				if (Character.isDigit(inputString.charAt(i)) 
						|| (inputString.charAt(i) == '.') 
						|| (i == 0 && inputString.charAt(0) == '-')) {
					isValue = true;
					continue;
				}
				isValue = false;
				break;
			}
		}
		return isValue;
	}
}
