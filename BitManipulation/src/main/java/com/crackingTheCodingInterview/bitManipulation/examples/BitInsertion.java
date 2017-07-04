package com.crackingTheCodingInterview.bitManipulation.examples;

/**
 * The {@link BitInsertion}
 * <p>
 * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
 * Write a method to insert M into N such that M starts at bit j and ends at bit i.
 * <p>
 * You can assume that the bits j through i ahve enough space to fit all of M. That is, 
 * if M = 10011, you can assume that there at least 5 bits between j and i. You would not
 * for example, have j = 3 and i = 2, because M could not fully fit between 3 and bit 2.
 * <p>
 * Example <br>
 * Input: N = 10000000000, M = 10011, i = 2, j = 6 <br>
 * Output: N = 10001001100
 * <p>
 * The idea is to utilise the update bit mechanism. <br>
 * <ol>
 * <li> Clear the bits from j to i in N. </li>
 * <li> Shift M across so that it lines up with bits j to i </li>
 * <li> Merge M and N </li>
 * </ol>
 * <p>
 * @author szeyick
 */
public class BitInsertion {
	
	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void demo() {
		int updateBit = updateBits(227, 28, 2, 4);
		System.out.print("The updated bit is - " + updateBit);
	}
	
	/**
	 * Update the bits between positions i and j.
	 * @param n - The original bit.
	 * @param m - The bit to replace.
	 * @param i - The ith bit to start.
	 * @param j - The jth bit to end.
	 * @return - The updated bit.
	 */
	private static int updateBits(int n, int m, int i, int j) {
		int allOnes = ~0; // This will be an entire sequence of 1's.
		
		// Add 1's before position j, then 0's to the left (i.e - 11100000)
		int left = allOnes << (j + 1); // Shift all ones across by j + 1.
		
		// Add 1's after position i to the end (i.e 00000011)
		int right = ((1 << i) - 1);
		
		// Combine the left and right, to leave a gap of 0's between i and j (11100011)
		int mask = left | right;
		
		// Clear the bits j through i
		int n_cleared = n & mask;
		int m_shifted = m << i; // Move m into position (Shift it so it sits between i and j)
		
		return n_cleared | m_shifted; // OR the result.
	}
}
