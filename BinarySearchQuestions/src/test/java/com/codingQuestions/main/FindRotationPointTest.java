package com.codingQuestions.main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The FindRotationPointTest.
 * <p>
 * This test class tests the {@link FindRotationPoint}. 
 * <p>
 * <b>Warning: </b>None.
 * <p>
 * @author szeyick
 */
public class FindRotationPointTest {

	/**
	 * Test the ordered set.
	 */
	@Test
	public void testFindInOrderedSet() {
		FindRotationPoint rotationPoint = new FindRotationPoint();
		assertEquals("Expected duplicate 5", 5, rotationPoint.rotationIndex(initArray()));
	}

	/**
	 * @return an initialised array with values.
	 */
	private String[] initArray() {
		String[] words = new String[] {
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
		return words;
	}
}
