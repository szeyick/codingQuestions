package com.codingQuestions.main;

/**
 * The PrintZigZag.
 * <p>
 * This class is wrapping the zig zag algorithm
 * to traverse and print a 2D array.
 * <p>
 * <b>Warning: </b>The trick to the algorithm is to
 * figure out at each cell, whether to move right and up
 * or down and left.
 * <p>
 * @author szeyick
 */
public class PrintZigZag {

	/**
	 * Traverse and print the array in a zig zag.
	 * @param a - The 2D array to print.
	 */
	public void zigZag(int[][] a) {
		int row = 1;
		int column = 1;
		for (int i = 0; i < (a.length * a.length); i++) {
			System.out.print(a[row - 1][column -1] + " ");
			int currentPosition = row + column;
			boolean isEven = (currentPosition % 2) == 0;
			if (isEven) {
				if (column < a.length) {
					column++;
				}
				else {
					row += 2;
				}
				if (row > 1) {
					row--;
				}
			}
			else {
				if (row < a.length) {
					row++;
				}
				else {
					column += 2;
				}
				if (column > 1) {
					column--;
				}
			}
		}
	}
}
