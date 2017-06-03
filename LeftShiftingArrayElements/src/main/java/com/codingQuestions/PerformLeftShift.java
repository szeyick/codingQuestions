package com.codingQuestions;

/**
 * The PerformLeftShift.
 * <p>
 * This is a wrapper class that shifts all the 
 * elements in a given array across by defined number
 * of positions.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class PerformLeftShift {

	/**
	 * @param input - The input array.
	 * @param leftShift - The amount to shift left.
	 */
	public int[] performLeftShift(int[] input, int leftShift) {
		int[] shiftedArray = new int[input.length];
		for (int currentIndex = 0; currentIndex < input.length; currentIndex++) {
            int value = input[currentIndex];
            int shiftIndex = ((currentIndex + (input.length - leftShift)) % input.length);
            shiftedArray[shiftIndex] = value;
		}
		return shiftedArray;
	}
	
	/**
	 * @param input - The shifted array values.
	 */
	public void printArray(int[] input) {
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
}
