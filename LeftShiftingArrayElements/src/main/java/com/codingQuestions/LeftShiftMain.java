package com.codingQuestions;

/**
 * The LeftShiftMain.
 * <p>
 * This class represents the application main that
 * demonstrates the shifting of array elements to the
 * left by a defined number of positions.
 * <p>
 * <b>Warning: </b>None
 * 
 * @author szeyick
 */
public class LeftShiftMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		int[] inputArray = new int[]{1, 2, 3, 4, 5};
		PerformLeftShift shift = new PerformLeftShift();
		
		int[] shiftedArray = shift.performLeftShift(inputArray, 12);
		System.out.print("Original Array: ");
		shift.printArray(inputArray);
		
		System.out.println();
		System.out.print("Shifted Array: ");
		shift.printArray(shiftedArray);
	}
}