package com.codingquestions.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The RotationPointTest.
 * <p>
 * This test class is responsible for testing the
 * {@link RotationPoint}.
 * <p>
 * <b>Warning: </b>None.
 * <p>
 * @author szeyick
 */
public class RotationPointTest {

	/**
	 * Test the integer rotation.
	 */
	@Test
	public void testIntegerRotation() {
		RotationPoint rotation = new RotationPoint();
		int[] input = new int[] {4, 5, 6, 7, 1, 2, 3};
		int[] input2 = new int[] {5, 1, 2, 3, 4};

		assertEquals("Expected rotation index to be 4", 4, rotation.findRotation(input));
		assertEquals("Expected rotation index to be 1", 1, rotation.findRotation(input2));
	}

	/**
	 * Test the string rotation.
	 */
	@Test
	public void testStringRotation() {
		RotationPoint rotation = new RotationPoint();
		String[] words = new String[]{
				"asymptote", // <-- rotates here!
				"babka",
				"banoffee",
				"engender",
				"karpatka",
				"othellolagkage",

		};
		assertEquals("Expected rotation index to be 5", 5, rotation.findRotationString(words));
	}
	
	/**
	 * Test the naive implementation of the rotate.
	 */
	@Test
	public void testNaiveRotation() {
		RotationPoint rotation = new RotationPoint();
		String[] words = new String[]{
				"ptolemaic",
				"retrograde",
				"supplant",
				"undulate",
				"xenoepist",
				"asymptote", // <-- rotates here!
				"babka",
				"banoffee",
				"engender",
				"karpatka",
				"othellolagkage",

		};
		assertEquals("Expected rotation index to be 5", 5, rotation.naiveRotation(words));
	}
}
