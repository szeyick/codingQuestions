package com.crackingTheCodingInterview.miscellanous;

/**
 * The {@link KadanesAlgorithm}
 * <p>
 * Implementation of Kadanes Algorithm that is used
 * to find the maximum sequence in a subset of integers.
 * <p>
 * The default implementation of the algorithm requires at
 * least one value in the input set to be non-negative.
 * <p>
 * The run-time of the algorithm is O(n).
 * <p>
 * @author szeyick
 */
public class KadanesAlgorithm {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		int[] input = {1, 2, -4, 1, 3, -2, 3, -1};
		int maxSum = kadanesAlgorithm(input);
		
		System.out.println("The maximum sum of the input sequence is - " + maxSum);
	}
	
	/**
	 * Implementation of Kadanes Algorithm to find the
	 * maximum sum of a sequence of integers in a input
	 * set.
	 * @param input - The input to search through.
	 * @return the maximum sum of the input set.
	 */
	private static int kadanesAlgorithm(int[] input) {
		
		// Initialise the current values.
		int currentValue = 0;
		int previousValue = 0;
		int currentMaximum = Integer.MIN_VALUE;
		
		// Loop through the input.
		for (int i = 0; i < input.length; i++) {
			currentValue = max(input[i], previousValue + input[i]); // Manage negatives
			// Update the maximum if the current value is larger than previous.
			currentMaximum = max(currentMaximum, currentValue);
			
			// If the calculated current value is less than 0, we reset it, otherwise
			// we update the previous value.
			if (currentValue < 0) {
				previousValue = 0;
			}
			else {
				previousValue = currentValue;
			}
		}
		return currentMaximum;
	}
	
	/**
	 * @param x - The first value to compare.
	 * @param y - The second value to compare.
	 * @return - The maximum of two values.
	 */
	private static int max(int x, int y) {
		return x > y ? x : y;
	}
}
