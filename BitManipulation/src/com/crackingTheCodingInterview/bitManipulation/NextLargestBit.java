package com.crackingTheCodingInterview.bitManipulation;

/**
 * The {@link NextLargestBit}
 * <p>
 * Given a positive integer, print the next largest number that has the same
 * number of 1 bits in their binary representation.
 * <p>
 * @author szeyick
 */
public class NextLargestBit {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		System.out.println(getNextLargest(22));
	}
	
	/**
	 * Find the next largest value with the same number of bits.
	 * @param n - The value.
	 * @return - The next largest value.
	 */
	private static int getNextLargest(int n) {
		// Find C0 and C1
		int c = n;
		int c0 = 0;
		int c1 = 0;
		
		// Find the first occurrence of 1.
		while (((c & 1) == 0) && (c != 0)) {
			c0++;
			c >>= 1; // Shift c to the right by 1.
		}
		
		// Find the first occurrence of 0 after we've found the first 1.
		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		
		// Return error if there is no larger number with the same bits.
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		
		int p = c0 + c1; // The position of the right most non trailing 0
		
		// Step 1 - Flip the 0 bit at P to a 1
		n = n | (1 << p);
		
		// Step 2 - Clear all bits to the right of P
		n = clearBits(p, n);

		// Step 3 - Add ones back to the right of P.
		n = addOnes(p, c1, n);
		
		return n;
	}
	
	/**
	 * Clear all the bits from 0 => P
	 * @param p - The position of the right most non-trailing 0.
	 * @param n - The value.
	 * @return The updated value with all bits to the right of P changed to 0.
	 */
	private static int clearBits(int p, int n) {
		int a = 1 << p; // Create all 0's except for position P
		int b = a - 1; // Create all 1's except for position P.
		int mask = ~b; // Create all 1's followed by P 0's.
		
		return n & mask; // Change all bits to 0 except for bit P.
	}
	
	/**
	 * Add C1 - 1 ones to the right of P.
	 * @param p - The position of the right most non-trailing 0.
	 * @param c1 - The number of 1's to the right of P.
	 * @param n - The value.
	 * @return - The updated value with the 1's re-inserted.
	 */
	private static int addOnes(int p, int c1, int n) {
		int a = 1 << (c1 - 1); // All 0's except for 1 at position c1 - 1
		int b = a - 1; // All 0's with 1's at position 0 => C1 - 1
		
		return n | b;
	}

}
