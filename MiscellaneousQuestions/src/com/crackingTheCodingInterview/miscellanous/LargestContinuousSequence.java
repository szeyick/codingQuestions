package com.crackingTheCodingInterview.miscellanous;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link LargestContinuousSequence}
 * <p>
 * Write a function that, given a list of integers
 * both positive and negative returns the sum of the
 * continuous sequence with the largest sum.
 * <p>
 * Example - <br>
 * Input - (1, 2, -4, 1, 3, -2, 3, -1) <br>
 * Output - 5 {1,3,-2,3}.
 * <p>
 * @author szeyick
 */
public class LargestContinuousSequence {

	/**
	 * The longest sequence.
	 */
	private static List<Integer> longestSequence;
	
	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		int[] input = {1,2,-4,1,3,-2,3,-1};
		longestSequence = new ArrayList<Integer>();
		int sum = longestSequenceSum(input);
		
		System.out.println("The sum of the largest sequence is - " + sum);
		System.out.print("The longest sequence is : ");
		for (Integer sequence : longestSequence) {
			System.out.print(sequence + ", ");
		}
	}
	
	/**
	 * Given an input sequence of integers both negative
	 * and positive, find the sum of the largest sequence
	 * of numbers from the input.
	 * @param input - The input.
	 * @return the sum of the longest sequence.
	 */
	private static int longestSequenceSum(int[] input) {
		int currentMaximum = Integer.MIN_VALUE; // Start with the smallest possible as being the min, any input should be larger.
		
		List<Integer> longestSequenceTmp = new ArrayList<Integer>(); // Store the current sequence.
		// Loop through the input and produce all the combinations
		for (int i = 0; i < input.length; i++) {
			int sum = input[i];
			longestSequenceTmp.add(input[i]);
			// Loop through the rest of the input to build the sequence 1 value at a time.
			for (int j = i + 1; j < input.length - 1; j++) {
				sum += input[j];
				longestSequenceTmp.add(input[j]);
				// Update the current max if the sum of the values in the current sequence is largest.
				if (sum > currentMaximum) {
					currentMaximum = sum;
					longestSequence = new ArrayList<Integer>(longestSequenceTmp);
				}
			}
			longestSequenceTmp.clear();
		}
		return currentMaximum;
	}
}
