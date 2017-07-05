package com.codingQuestions.main;

/**
 * The FindRotationPoint.
 * <p>
 * This class wraps the solution to find the rotation point
 * for a partially sorted array of items. It uses a modified version
 * of a binary search, where we don't stop at the middle value and
 * we include the middle value when we break down into the sub-array.
 * <p>
 * <b>Warning: </b>None.
 * <p>
 * @author szeyick
 */
public class FindRotationPoint {

	/**
	 * @param array - The input array.
	 * @return the index of the rotation point.
	 */
	public int rotationIndex(String[] array) {
		return binarySearch(array, 0, array.length - 1);
	}
	
	/**
	 * A modified version of a binary search that will keep continue breaking the array down
	 * until we reach the base case (1 item). At each stage, we compare the start and end
	 * strings to decide which side to continue the search on.
	 * <p>
	 * @param array - The array to search.
	 * @param startIndex - The start index of the array.
	 * @param endIndex - The end index of the array.
	 * @return the index of the rotation point.
	 */
	private int binarySearch(String[] array, int startIndex, int endIndex) {
		int midIndex = findMidIndex(startIndex, endIndex);
		if (startIndex > endIndex) {
			return midIndex; // Return the middle value once we reach the base case.
		}
		String endValue = array[endIndex];
		String startValue = array[startIndex];
		if (startValue.compareTo(endValue) < 0 ) {
			// If the start string is less than the end string go left.
			return binarySearch(array, startIndex, midIndex - 1);
		}
		else {
			// If the start string is larger than the end string go right.
			return binarySearch(array, midIndex + 1, endIndex);
		}
	}
	
	/**
	 * @param startIndex - The start index.
	 * @param endIndex - The end index.
	 * @return the midpoint.
	 */
	private int findMidIndex(int startIndex, int endIndex) {
		return (startIndex + endIndex) / 2;
	}
}
