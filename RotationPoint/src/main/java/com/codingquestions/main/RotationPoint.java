package com.codingquestions.main;

/**
 * The RotationPoint.
 * <p>
 * This class represents the rotation point challenge
 * question that wraps the solution.
 * <p>
 * <b>Warning: </b>None.
 * <p>
 * @author szeyick
 */
public class RotationPoint {

	/**
	 * Find the rotation point given an integer array.
	 * @param input - The input array.
	 * @return - The index where the rotation occurs.
	 */
	public int findRotation(int[] input) {
		return rotation(0, input.length - 1, input);
	}

	/**
	 * Find the rotation point given an String array.
	 * @param input - The input array.
	 * @return - The index where the rotation occurs.
	 */
	public int findRotationString(String[] input) {
		return rotation(0, input.length - 1, input);
	}

	/**
	 * A modified binary search. The difference between this and a normal
	 * binary search is that we're always comparing the middle value with
	 * the index 0 value. We move left if the middle value is smaller than
	 * the start value.
	 * @param leftIndex - The left index.
	 * @param rightIndex - The right index.
	 * @param input - The input array.
	 * @return the index that the rotation occurs.
	 */
	private int rotation(int leftIndex, int rightIndex, int[] input) {
		if (leftIndex < rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;
			int startValue = input[0];
			if (input[middle] < startValue) {
				return rotation(leftIndex, middle, input);
			}
			else {
				return rotation(middle + 1, rightIndex, input);
			}
		}
		return leftIndex;
	}

	/**
	 * A modified binary search. The difference between this and a normal
	 * binary search is that we're always comparing the middle value with
	 * the index 0 value. We move left if the middle value is smaller than
	 * the start value.
	 * @param leftIndex - The left index.
	 * @param rightIndex - The right index.
	 * @param input - The input array.
	 * @return the index that the rotation occurs.
	 */
	private int rotation(int leftIndex, int rightIndex, String[] input) {
		if (leftIndex < rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;
			String startValue = input[0];
			if (input[middle].compareTo(startValue) < 0) {
				return rotation(leftIndex, middle, input);
			}
			else {
				return rotation(middle + 1, rightIndex, input);
			}
		}
		return leftIndex;
	}

	/**
	 * A naive linear time solution to the rotation problem.
	 * @param input - The input
	 * @return the index in which it rotates.
	 */
	public int naiveRotation(String[] input) {
		int rotationPoint = -1;
		boolean rotationPointFound = false;
		int currentIndex = 0;
		int adjacentIndex = 1;
		while (!rotationPointFound) {
			if (adjacentIndex >= input.length) {
				rotationPoint = 0;
				break;
			}
			if (input[currentIndex].compareTo(input[adjacentIndex]) <= 0) {
				currentIndex++;
				adjacentIndex++;
			}
			else {
				rotationPoint = adjacentIndex;
				rotationPointFound = true;
			}
		}
		return rotationPoint;
	}
}