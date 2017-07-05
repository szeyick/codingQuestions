package com.codingQuestions.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The FindDuplicateTest.
 * <p>
 * This test class is responsible for testing the {@link FindDuplicate}.
 * This test and implementation code needs to be corrected since there is an
 * incorrect assumption made regarding the input values.
 * <p>
 * <b>Warning: </b>None.
 * <p>
 * @author szeyick
 */
public class FindDuplicateTest {
	
	/**
	 * Test the find duplicate.
	 */
	@Test
	public void testDuplicateTest() {
		FindDuplicate findDuplicate = new FindDuplicate();
		int[] inputArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
		assertEquals("Expected duplicate 9", 9, findDuplicate.search(inputArray));
	}
	
}
