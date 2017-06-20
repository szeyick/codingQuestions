package com.codingQuestions.main;

/**
 * The ZigZagMain.
 * <p>
 * This class is the application main that 
 * is responsible for creating the array to
 * print the zig zag path through.
 * <p>
 * <b>Warning: </b>None.
 * <p>
 * @author szeyick
 */
public class ZigZagMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		int[][] array = createArray(4);
		PrintZigZag print = new PrintZigZag();
		
		print.zigZag(array);
	}
	
	/**
	 * @param size - The size of the 2D array to create.
	 * @return the 2D array intialised with values 1 -> n
	 */
	private static int[][] createArray(int size) {
		int count = 1;
		int[][] array = new int[size][size];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j] = count;
				count++;
			}
		}
		return array;
	}

}
