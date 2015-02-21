package com.crackingTheCodingInterview.bitManipulation;

/**
 * The {@link BinaryRepresentationLessThanOne}
 * <p>
 * Given a real number between 0 and 1 (e.g 0.72) that is passed in as a
 * double, print the binary representation. If the number cannot be represented
 * accurately in binary with at most 32 characters, print "Error".
 * <p>
 * When we're dealing with values less than 1, we have to multiply them by 1/2^n. 
 * <p>
 * For example, 0.75 represented in binary is 0.11 since <br>
 * 1/2^1 = 0.5
 * 1/2^2 = 0.25
 * <p>
 * So the idea would be to replace at each step and evaluate the remainder of what we have
 * before we continue, if it gets to 0 then return the value, if it gets to the 32nd digit
 * to replace then return "Error".
 * <p>
 * @author szeyick
 */
public class BinaryRepresentationLessThanOne {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		// Binary representation of 0.75
		System.out.println("Binary representation of 0.75 is  - " + decimalToBinary(0.75));
		
		// Binary representation of 1 is 1.
		System.out.println("Binary representation of 1 is  - " + decimalToBinary(1));
		
		// Cannot represent 0.1 within 32 bits.
		System.out.println("Binary representation of 1 is  - " + decimalToBinary(0.1));
	}
	
	/**
	 * Convert a decimal value between 0 and 1 to binary.
	 * @param value - The value to convert
	 * @return - The binary value as a string.
	 */
	private static String decimalToBinary(double value) {
		// Check if value is between 0 and 1
		if (value <= 1 && value >= 0) {
			// If values are 0 or 1 they don't need to be converted.
			if (value == 0) {
				return "0";
			}
			if (value == 1) {
				return "1";
			}
			// Declare variables for the calculation
			double remainder = value;
			boolean is32BitValue = true;
			int bitCount = 0;
			int exponent = -1;
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(".");
			
			while (remainder > 0) {
				// Terminate if we've exceeded 32 bit representation
				if (bitCount >= 32) {
					is32BitValue = false;
					break;
				}
				double bitValue = (double) Math.pow(2, exponent);
				// Add 1 to the bit if it fits within our current value.
				if (remainder - bitValue >= 0) {
					stringBuffer.append("1");
					remainder = remainder - bitValue; // Update the remainder
				}
				else {
					stringBuffer.append("0"); // Add 0 if it doesn't fit within the current value.
				}
				// Proceed to next bit.
				bitCount++;
				exponent--;
			}
			if (is32BitValue) {
				return stringBuffer.toString();
			}
			return "Error - Cannot be represented within 32 bits.";
		}
		return "Error - Value is not between 0 and 1";
	}
}
