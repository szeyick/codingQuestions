package com.codingquestions.main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The MergeSortedArraysTest.
 * <p>
 * This test class is responsible for testing the
 * {@link MergeSortedArrays}.
 * <p>
 * <b>Warning: </b>None.
 * <p>
 * @author szeyick
 */
public class MergeSortedArraysTest {

	/**
	 * Test that the arrays can be merged correctly.
	 */
	@Test
	public void testMergeSortedArrays() {
		MergeSortedArrays mergeArrays = new MergeSortedArrays();
		  int[] myArray     = new int[]{3, 4, 6, 10, 11, 15};
		  int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};

		  int[] mergedArrays = mergeArrays.merge(myArray, alicesArray);
		  int[] output = new int[] {1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19};
		  for (int i = 0; i < mergedArrays.length; i++) {
			  assertEquals("Expected values to be the same", output[i], mergedArrays[i]);
		  }
	}
}
