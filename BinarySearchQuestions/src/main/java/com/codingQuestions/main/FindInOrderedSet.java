package com.codingQuestions.main;

/**
 * The FindInOrderedSet.
 * <p>
 * This class wraps the solution for using a binary
 * search to find an item in an ordered array.
 * <p>
 * <b>Warning: </b>The assumption here is that the input array to
 * search is already sorted.
 * <p>
 * @author szeyick
 */
public class FindInOrderedSet {

	/**
	 * Find an item in the ordered array.
	 * @param array - The input array.
	 * @param valueToFind - The value to find.
	 * @return <code>true</code> if the value exists, <code>false</code> otherwise.
	 */
	public boolean search(int[] array, int valueToFind) {
		return binarySearch(array, valueToFind, 0, array.length - 1);
	}
	
	/**
	 * @param array - The input array.
	 * @param valueToFind - The value to find.
	 * @param startIndex - The start index of the array/sub-array.
	 * @param endIndex - The end index of the array/sub-array.
	 * @return <code>true</code> if the value exists, <code>false</code> otherwise.
	 */
	private boolean binarySearch(int[] array, int valueToFind, int startIndex, int endIndex) {
		// Return not found if we cannot break our array down any further.
		if (startIndex > endIndex) {
			return false;
		}
		int midIndex = findMidIndex(startIndex, endIndex);
		int currentValue = array[midIndex];
		
		// Return the value as found if the middle value is the one we want.
		if (valueToFind == currentValue) {
			return true;
		}
		// Evaluate if we want to search the left or right side of the array given the value
		// we want to find.
		if (valueToFind < currentValue) {
			// Search the left side and change end index to mid - 1 (we don't need to include the mid value)
			return binarySearch(array, valueToFind, startIndex, midIndex - 1);
		}
		else {
			// Search the right side and change start index to mid + 1 (we don't need to include the mid value)
			return binarySearch(array, valueToFind, midIndex + 1, endIndex);
		}
	}
	
	/**
	 * @param startIndex - The start index.
	 * @param endIndex - The end index.
	 * @return the midpoint index.
	 */
	private int findMidIndex(int startIndex, int endIndex) {
		return (startIndex + endIndex) / 2;
	}
}
