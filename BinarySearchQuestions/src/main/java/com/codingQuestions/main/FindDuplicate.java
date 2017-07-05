package com.codingQuestions.main;

/**
 * The FindDuplicate.
 * <p>
 * This class contains a wrapped binary search that will find duplicates in a 
 * sorted array.
 * <p>
 * <b>Warning: </b>The trick here is to iterate over the input set, and perform a
 * binary search for that value in the rest of the input array. If the value exists
 * it is a duplicate. 
 * <p>
 * @author szeyick
 */
public class FindDuplicate {

	/**
	 * @param array - The input array.
	 * @return the duplicated value. (there will always be a duplicate value)
	 */
	public int search(int[] array) {
		return array[binarySearch(array, 0, array.length)];
	}
	
	/**
	 * Modified binary search to find a duplicate in an array. The main step here is that
	 * we use the mid value and its index to determine whether to go left or right in the 
	 * subsequent search. If the index and value are equal, it means that the duplicate value
	 * will be in the right side of the array since the left side is all ordered correctly without
	 * duplicate. The opposite is applied if the index and value are not equal.
	 * @param array - The input array.
	 * @param startIndex - The start index.
	 * @param endIndex - The end index.
	 * @return the index of the duplicate value.
	 */
	private int binarySearch(int[] array, int startIndex, int endIndex) {
		int midIndex = (startIndex + endIndex) / 2;
		if (startIndex > endIndex) {
			return midIndex;
		}
		int midValue = array[midIndex];
		if (midValue != (midIndex + 1)) {
			// If the value doesn't equal the index, the duplicate is in the left side.
			return binarySearch(array, startIndex, midIndex - 1);
		}
		else {
			return binarySearch(array, midIndex + 1, endIndex);
		}
	}
}
