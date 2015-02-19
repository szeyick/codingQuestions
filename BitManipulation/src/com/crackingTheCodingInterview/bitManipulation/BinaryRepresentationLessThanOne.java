package com.crackingTheCodingInterview.bitManipulation;

/**
 * The {@link BinaryRepresentationLessThanOne}
 * <p>
 * Given a real number between 0 and 1 (e.g 0.72) that is passed in as a
 * double, print the binrary representation. If the number cannot be represented
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
 *
 */
public class BinaryRepresentationLessThanOne {

	/**
	 * The program main.
	 * @param args - Command line arguements.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double value = 1 * (1 / Math.pow(2, 2));
		System.out.println(value);
	}
}
