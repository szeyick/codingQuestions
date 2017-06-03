package com.codingQuestions;

/**
 * The MakeAnagram.
 * <p>
 * This class wraps the functionality of the number of
 * characters to remove, so that one string is an anagram
 * of the other.
 * <p> 
 * <b>Warning: </b>It should be noted that if neither string contains
 * the same characters, then to make them anagrams we need to remove every
 * character, resulting them both to be empty strings.
 * <p>
 * @author szeyick
 */
public class MakeAnagram {

	/**
	 * @param first - The first input string.
	 * @param second - The second input string.
	 * @return number of characters to remove to make the strings
	 * anagrams of each other.
	 */
	public int numberNeeded(String first, String second) {
		int[] characterCount = new int[26];

		// Count the number of characters in the first string and add them to the count.
		for (int i = 0; i < first.length(); i++) {
			int charValue = first.charAt(i);
			int charIndex = charValue - 'a';
			characterCount[charIndex]++;
		}

		// Count the number of characters in the second string and decrement them from the count.
		for (int i = 0; i < second.length(); i++) {
			int charValue = second.charAt(i);
			int charIndex = charValue - 'a';
			characterCount[charIndex]--;
		}

		// Count the number of characters to remove by iterating through the character array.
		// Here we will have negative values if String 2 is bigger than String 1, however we
		// can flip the sign and add the result.
		int charsToRemove = 0;
		for (int i = 0; i < characterCount.length; i++) {
			int value = characterCount[i];
			if (value < 0) {
				value *= -1;
			}
			charsToRemove += value;
		}
		return charsToRemove;
	}
}
