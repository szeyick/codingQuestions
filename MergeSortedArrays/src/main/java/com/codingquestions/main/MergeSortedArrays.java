package com.codingquestions.main;

import java.util.Scanner;

/**
 * The MergeSortedArrays.
 * <p>
 * This class is responsible for merging two
 * sorted arrays.
 * <p>
 * <b>Warning: </b>The input arrays are assumed to
 * be sorted.
 * <p>
 * @author szeyick
 */
public class MergeSortedArrays {

	/**
	 * @param array1 - The first array.
	 * @param array2 - The second array.
	 * @return the combined contents of both arrays.
	 */
	public int[] merge(int[] array1, int[] array2) {
		int[] combinedArray = new int[array1.length + array2.length];
		int currentCombinedArrayIndex = 0;
		int array1Index = 0;
		int array2Index = 0;
		
		// Loop until 1 of the arrays has reached the end.
		while ((array1Index < array1.length) && (array2Index < array2.length)) {
			int array1Value = array1[array1Index];
			int array2Value = array2[array2Index];
			if (array1Value < array2Value) {
				combinedArray[currentCombinedArrayIndex] = array1Value;
				array1Index++;
			}
			else {
				combinedArray[currentCombinedArrayIndex] = array2Value;
				array2Index++;
			}
			currentCombinedArrayIndex++;
		}
		
		// Only one of the two loops will execute.
		while(array1Index < array1.length) {
			combinedArray[currentCombinedArrayIndex] = array1[array1Index];
			array1Index++;
			currentCombinedArrayIndex++;
		}
		while(array2Index < array2.length) {
			combinedArray[currentCombinedArrayIndex] = array2[array2Index];
			array2Index++;
			currentCombinedArrayIndex++;			
		}
		System.out.println();
		return combinedArray;
	}
}
