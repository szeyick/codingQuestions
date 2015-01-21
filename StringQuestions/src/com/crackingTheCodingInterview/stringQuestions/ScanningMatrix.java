package com.crackingTheCodingInterview.stringQuestions;

import java.util.Random;

/**
 * The {@link ScanningMatrix}.
 * <p>
 * Write an algorithm such that if an element in an 
 * MxN matrix is 0, its entire row and column are set
 * to 0. 
 * <p>
 * Solution - Brute Force <br>
 * The idea for this solution is to scan each row and look
 * for 0's, if it finds one then we set the entire row back to
 * 0 and go down the columns starting from the top.
 * <p>
 * Solution - Set everything to 0 once a zero is found.
 * The question implies that we set the entire row and
 * column to 0 if we find one. This would imply that so long
 * as we find a 0 in the matrix we could just break then set
 * the entire matrix to 0.
 * 
 * @author szeyick
 *
 */
public class ScanningMatrix {

	/**
	 * The data input.
	 */
	private static int[][] matrix;
	
	/**
	 * The program main
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		initialiseMatrix(10, 5);
		printMatrix(10, 5);
		
		System.out.println();
		
		bruteForceScan(10, 5);
		printMatrix(10, 5);
		
		System.out.println();
		initialiseMatrix(10, 5);
		printMatrix(10, 5);
		
		System.out.println();
		
		findZero(10, 5);
		printMatrix(10, 5);
	}
	
	/**
	 * Search the matrix for a 0, once one is found, break
	 * the loop and scan through the matrix again setting
	 * it all to 0.
	 * @param m - The row
	 * @param n - The column
	 */
	private static void findZero(int m, int n) {
		// Scan through the rows
		boolean zeroFound = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int num = matrix[i][j];
				if (num == 0) {
					zeroFound = true;
					break;
				}
			}
			if (zeroFound) {
				break;
			}
		}
		// If a zero is found somewhere in the matrix then
		// set all the values to zero.
		if (zeroFound) {
			// Scan through the rows
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	/**
	 * Solution - Scan through each item in the matrix
	 * and find the 0's, then set the column and row to 0.
	 */
	private static void bruteForceScan(int m, int n) {
		// Scan through each row and find 0's.
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int num = matrix[i][j];
				if (num == 0) {
					// Set entire row to 0
					setRowToZero(i, n);
					setColumnToZero(j, m);
				}
			}
		}
	}
	
	/**
	 * Set a columns contents to 0
	 * @param column
	 * @param columnLength
	 */
	private static void setColumnToZero(int column, int columnLength) {
		// Set the entire column to 0
		for (int i = 0; i < columnLength; i++) {
			matrix[i][column] = 0;
		}
	}
	
	/**
	 * Set a rows contents to 0
	 * @param row - The row
	 * @param rowLength - The length of the row.
	 */
	private static void setRowToZero(int row, int rowLength) {
		// Set the row to 0
		for (int i = 0; i < rowLength; i++) {
			matrix[row][i] = 0;
		}
	}
	
	/**
	 * Initialise a m x n matrix.
	 * @param m - The number of rows.
	 * @param n - The number of columns.
	 */
	private static void initialiseMatrix(int m, int n) { 
		matrix = new int[m][n];
		
		// Scan through the rows
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int num = generateRandomNumber(0, 8);
				matrix[i][j] = num;
			}
		}
	}

	/**
	 * Generate a random number between the upper and lower limit (inclusive).
	 * @param lowerLimit - The minimum number.
	 * @param upperLimit - The maximum number.
	 * @return - A number between the lower and upper limit.
	 */
	private static int generateRandomNumber(int lowerLimit, int upperLimit) {
		Random random = new Random();
		return random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
	}

	/**
	 * Print the contents of the 2d array.
	 * @param m - The number of rows.
	 * @param n - The number of columns.
	 */
	private static void printMatrix(int m, int n) {
		// Print each row first.
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int number = matrix[i][j];
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}
}
