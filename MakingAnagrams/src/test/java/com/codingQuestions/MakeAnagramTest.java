package com.codingQuestions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The MakeAnagramTest.
 * <p>
 * This class is responsible for testing {@link MakeAnagram}.
 * <p>
 * <b>Warning: </b>None.
 * <p>
 * @author szeyick
 */
public class MakeAnagramTest {

	/**
	 * Test the anagram maker algorithm.
	 */
	@Test
	public void testAnagramMaker() {
		MakeAnagram anagram = new MakeAnagram();
		
		assertEquals("Expected 6 characters to remove", 6, anagram.numberNeeded("abc", "def"));
		assertEquals("Expected 0 characters to remove", 0, anagram.numberNeeded("abc", "abc"));
		assertEquals("Expected 4 characters to remove", 4, anagram.numberNeeded("abc", "cde"));
		assertEquals("Expected 5 characters to remove", 5, anagram.numberNeeded("abcdef", "a"));
	}
}