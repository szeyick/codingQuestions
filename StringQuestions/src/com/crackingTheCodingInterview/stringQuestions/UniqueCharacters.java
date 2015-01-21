package com.crackingTheCodingInterview.stringQuestions;

import java.util.Arrays;

/**
 * The {@link UniqueCharacters}.
 * <p>
 * Implement an algorithm to determine if a string has
 * all unique characters. What if you cannot use additional
 * data structures. <p>
 *
 * This question is split into two parts, however the questions
 * we have to ask here are whether there are either Unicode or ASCII
 * characters since the sets have different number of characters that
 * may need to be checked for uniqueness. <p>
 * 
 * Solution 1 - Additional Data Structure <br> 
 * - Initialise a byte array the size of the character set. <br>
 * - Iterate through the string, check to see if already visited, if so <br>
 *   then there are no unique characters. <br>
 * - <b>Solution would be O(m) where m is the size of the character set.</b>
 * <p>
 * Solution 2 - No Additional Data Structure <br>
 * - Without an additional structure we would need to sort the String in place.<br> 
 * - After the sort is completed, we would check each adjacent character to see if it
 *   is the same, if it is then the String isn't unique. <br>
 * - <b>Solution would be O(nlogn) where n is the size of the string and a fast sort. <b/>
 * <p>
 * 
 * <b>Note: If using the Java API for a boolean array, it is a faster data structure
 * to use over a byte array since all values by default are initialised to FALSE. We
 * therefore do not have the overhead of initialising it ourselves. Performance however
 * degrades if we need to create a byte array of the entire Unicode set of 1 million characters<br>
 * - It will also be useful to check to see if the string is larger than the character set,
 *   because if it is, then there definitely has to be duplicate values.</b>
 * 
 * @author szeyick
 *
 */
public class UniqueCharacters {

	/**
	 * To log the start time of a method.
	 */
	private static long startTime;
	
	/**
	 * Program Main.
	 * @param args - Command Line Arguments.
	 */
	public static void main(String[] args) {
		String stringToTest = "This is a string";
		System.out.println("Unique Characters with data structures");
		boolean unique = uniqueCharactersWithDataStructure(stringToTest);
		System.out.println("Is the string unique: " + unique);
		
		System.out.println();
		System.out.println("Unique Characters without data structures");
		unique = uniqueCharactersWithoutDataStructure(stringToTest);
		System.out.println("Is the string unique: " + unique);
		
		System.out.println();
		System.out.println("Unique Characters with boolean structures");
		unique = uniqueCharactersWithBooleanStructure(stringToTest);
		System.out.println("Is the string unique: " + unique);
	}
	
	/**
	 * Finding unique characters in a String with an
	 * additional data structure.
	 * @return <code>true</code> if string is unique, <code>false</code> otherwise.
	 */
	private static boolean uniqueCharactersWithDataStructure(String word) {
		startExecution();
		byte[] asciiCharacterSet = new byte[255];
		for (int i = 0; i < asciiCharacterSet.length; i++) {
			// Initialise all values to not found.
			asciiCharacterSet[i] = 0;
		}
		
		// Find the unique characters.
		for (int i = 0; i < word.length(); i++) {
			int value = (int) word.charAt(i);
			if (asciiCharacterSet[value] == 1) {
				stopExecutionTime();
				return false;
			}
			asciiCharacterSet[value] = 1;
		}
		stopExecutionTime();
		return true;
	}
	
	/**
	 * Finding unique characters in a String with an boolean array. It
	 * could be marginally faster since it is all initialised to false
	 * @param word - The word to evaluate
	 * @return <code>true</code> if the word contains unique characters
	 * <code>false</code> otherwise.
	 */
	private static boolean uniqueCharactersWithBooleanStructure(String word) {
		startExecution();
		boolean[] booleanCharacterSet = new boolean[255];
		
		// Find the unique characters.
		for (int i = 0; i < word.length(); i++) {
			int value = (int) word.charAt(i);
			if (booleanCharacterSet[value]) {
				stopExecutionTime();
				return false;
			}
			booleanCharacterSet[value] = true;
		}
		stopExecutionTime();
		return true;
	}
	
	/**
	 * Finding unique characters in a String without an additional
	 * data structure.
	 * @param word - The character string
	 * @return <code>true</code> if it contains unique characters
	 * <code>false</code> otherwise.
	 */
	private static boolean uniqueCharactersWithoutDataStructure(String word) {
		startExecution();
		char[] wordArray = word.toCharArray();
		Arrays.sort(wordArray);
		
		// Check adjacent characters for duplicates.
		for (int i = 0; i < (wordArray.length - 1); i++) {
			if (wordArray[i] == wordArray[i+1]) {
				stopExecutionTime();
				return false;
			}
		}
		stopExecutionTime();
		return true;
	}

	/**
	 * Start timing the method execution.
	 */
	private static void startExecution() {
		startTime = System.nanoTime();
	}
	
	/**
	 * Stop timing the method execution and output time.
	 */
	private static void stopExecutionTime() {
		final long duration = System.nanoTime() - startTime;
		final double seconds = ((double)duration / 1000000000);
		System.out.println("Execution Time: " + seconds + " seconds");
	}
}
