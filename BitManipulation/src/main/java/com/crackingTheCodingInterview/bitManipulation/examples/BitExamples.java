package com.crackingTheCodingInterview.bitManipulation.examples;

/**
 * The {@link BitExamples}
 * <p>
 * This class provides examples of bit manipulation tasks.
 * <p>
 * @author szeyick
 */
public class BitExamples {
	
	/**
	 * The program main.
	 * @param args - The command line arguments.
	 */
	public static void demo() {
		// Return whether there is a 1 bit at a position.
		System.out.println("Is there a bit at position 2 - " + getBitAt(4, 2));
		System.out.println("Is there a bit at position 12 - " + getBitAt(4, 12));
		
		// Setting a new bit at a position.
		System.out.println("Original value - " + 12 + 
				" - Setting an additional bit at position " + 4 + " results in: " + setBitAt(12, 4));
		
		// Remove a bit from a position.
		System.out.println("Original value - " + 12 +
				" - Removing bit from position " + 2 + " results in: " + removeBitAt(12, 2));
		
		// Remove all the bits from the left to position.
		System.out.println("Original value - " + 13 +
				" - Removing all bits from left to position " + 1 + " results in: " + clearBitsLeftToRight(13, 1));
		
		// Remove all the bits from left to position.
		System.out.println("Original value - " + 15 +
				" - Removing all bits from right to position " + 1 + " results in: " + clearBitsRightToLeft(16, 1));
		
		// Update the bit at position with a value.
		System.out.println("Original value - " + 15 +
				" - Update bit at position " + 1 + " results in: " + updateBit(15, 1, 0));
	}
	
	/**
	 * Update the bit at position.
	 * @param num - The integer to update the bit from.
	 * @param position - The position to update the bit.
	 * @return - The new calculated value.
	 */
	private static int updateBit(int num, int position, int bitToSet) {
		int mask = ~(1 << position); // Clear (Remove) the bit at position.
		
		// Shift the bit to set across to the position and then OR the 
		// values together and update the bit at position with bitToSet.
		return (num & mask) | (bitToSet << position); 
	}
	
	/**
	 * Set all the bits to 0 from right to position.
	 * @param num - The integer to clear the bits from.
	 * @param position - The position to stop the removal.
	 * @return - The new calculated value.
	 */
	private static int clearBitsRightToLeft(int num, int position) {
		int mask = ~((1 << (position + 1)) -1);
		return num & mask;
	}
	
	/**
	 * Set all the bits to 0 from left to position.
	 * @param num - The integer to clear the bits from.
	 * @param position - The position to stop the removal.
	 * @return - The new calculated value.
	 * 
	 * NOTE - This will set all the values from the left most part
	 * of the num value (in binary) to 0, all the way to the specified
	 * position. 
	 * 
	 * Thus if num is 1101 and we want to clear all the bits to position 2
	 * we need to end up with 0001.
	 */
	private static int clearBitsLeftToRight(int num, int position) {
		int mask = (1 << position) - 1; // Left shift by the position and subtract 1.
		return num & mask;
	}
	
	/**
	 * Remove a bit from a position.
	 * @param num - The integer to remove the bit from.
	 * @param position - The position to remove the bit from the integer.
	 * @return - The new calculated value.
	 * 
	 * NOTE - To remove a bit, we perform the left shift on the position
	 * integer, and then negate it (flip the digits). If we then perform
	 * an AND evaluation with the original num, we will effectivly remove
	 * the bit. In addition, 1 & _ will be 1 as will 0 & _ will be 0. 
	 */
	private static int removeBitAt(int num, int position) {
		int shiftedValue = 1 << position;
		shiftedValue = ~shiftedValue; // Negate the value by using !
		
		return num & shiftedValue;
	}
	
	/**
	 * Set a bit at a position.
	 * @param num - The integer to set the bit to.
	 * @param position - The position to set the bit.
	 * @return The new calculated value.
	 * 
	 * NOTE - This code adds a bit (1) at a given position. To obtain
	 * the given position, we shift 1 << (left) a position number of
	 * times. To add the bit, we OR the result. The new value will only
	 * contain a 1 at the position to set, leaving all other values at 0. By
	 * OR'ing the values together, it will leave the original unchanged other than
	 * the bit at the position.
	 */
	private static int setBitAt(int num, int position) {
		int shiftedValue = 1 << position; // Left shift by position.
		return num | shiftedValue;
	}

	/**
	 * Is the bit at position a 1 or 0.
	 * @param num - The integer value to probe.
	 * @param position - Is the bit at this position a 1 or 0.
	 * @return <code>true</code>, if the value at the position is
	 * a 1, otherwise <code>false</code>.
	 * 
	 * NOTE - This code tests whether there is a 1
	 * at position, when num is converted into a binary value.
	 * 
	 */
	private static boolean getBitAt(int num, int position) {
		int shifted = 1 << position;
		// If the shifted value and original number AND'd together
		// is zero, it means that there is no 1 at the position. This
		// means that the bit at position is a 0.
		if ((num & shifted) == 0) {
			return false;
		}
		return true;
	}
}
