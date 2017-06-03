package com.codingQuestions;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * The PerformLeftShiftTest.
 * <p>
 * This class is responsible for testing {@link PerformLeftShift}
 * with various types of input and shifting.
 * <p>
 * <b>Warning: </b>None.
 * @author szeyick
 */
public class PerformLeftShiftTest {

	/**
	 * Test the left shifting.
	 */
	@Test
	public void testLeftShifting() {
		PerformLeftShift shift = new PerformLeftShift();
		
		assertArrayEquals(new int[] {3, 4, 5, 1, 2}, shift.performLeftShift(new int[] {1, 2, 3, 4, 5}, 2));
		assertArrayEquals(new int[] {2, 3, 4, 5, 1}, shift.performLeftShift(new int[] {1, 2, 3, 4, 5}, 1));
		assertArrayEquals(new int[] {5, 1, 2, 3, 4}, shift.performLeftShift(new int[] {1, 2, 3, 4, 5}, 4));
		assertArrayEquals(new int[] {1, 2, 3, 4, 5}, shift.performLeftShift(new int[] {1, 2, 3, 4, 5}, 0));
	}
}
