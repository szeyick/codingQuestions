package com.codingQuestions.main;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * The FindInOrderedSetTest.
 * <p>
 * This test class tests the {@link FindInOrderedSet}.
 * <p>
 * <b>Warning: </b>None.
 * <p>
 * @author szeyick
 */
public class FindInOrderedSetTest {

	/**
	 * Test the calculator.
	 */
	@Test
    public void testFindInOrderedSet() {
		FindInOrderedSet binarySearch = new FindInOrderedSet();
		int[] inputArray = initArray();
		
		assertTrue("Expected value to be found", binarySearch.search(inputArray, 10));
		assertFalse("Expected value to not be found", binarySearch.search(inputArray, 100));
		assertTrue("Expected value to be found", binarySearch.search(inputArray, 99));
		assertFalse("Expected value to not be found", binarySearch.search(inputArray, -20));
	}
	
	/**
	 * @return an initialised sorted array.
	 */
	private static int[] initArray() {
		int[] inputArray = new int[100];
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = i;
		}
		return inputArray;
	}
}