package com.crackingTheCodingInterview.stringQuestions;

/**
 * The {@link ReplacingSpaces} class.
 * <p>
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end
 * of the string to hold additional characters, and that you are given the
 * "true" length of the string. (Use a character array in Java so the method
 * can be performed in place). <p>
 * Example - <br>
 * Input: "Mr John Smith      " <br>
 * Output:"Mr%201John%201Smith" <br>
 * <p>
 * The shift across would be -> (characters to insert - 1) * spaces remaining
 * Spaces remaining decrements by 1 each time a space is found.
 * Input:  "Mr John  "
 * Output: "Mr%20John"
 * 
 * Shift Across - (3 - 1) * 3 = 6
 * 
 * Input:  "Mr John Douglas Smith      "
 * Output: "Mr%20John%20Douglas%20Smith"
 * <p>
 * Solution - 2 Arrays <br>
 * - The naive solution would be have 2 arrays, and copy character by character
 * and when you run into a " " then replace with %20 however that would require
 * an additional array. <br>
 * <b> 
 * - The solution would be O(mn) but would require O(n + m) additional space. </b>
 * <p> 
 * Solution - In place replacement. <br>
 * - The solution here would be to count the number of spaces in the string with the first pass <br>
 * - With the number of spaces the shift across would be a multiple of those spaces <br>
 * - Since we already have the space, we need to free up another (n -1) spaces to insert all the characters we want. <br>
 * - We start from the back of the array since the last words have the most number of shifts to do. <br>
 * - We shift by (characters to insert - 1) * spaces remaining, if we iterate backwards through the array, we shift by 
 *   the count, and when we come across a space, we decrement the count remaining since the distance to shift reduces. <br>
 *   
 * - The solution would be O(mn) where n is the length of the string and m is the number of characters to shift, this would
 *   not make much difference if m is small which should be close to O(n) linear time.
 * @author szeyick
 *
 */
public class ReplacingSpaces {

	/**
	 * The program main.
	 * @param args - command line arguments.
	 */
	public static void main(String[] args) {
		String input = "Mr John Douglas Smith";
		String input2 = "Mr John Douglas Smith";
		char[] inputString = new char[35];
		char[] inputString2 = new char[35];
		char[] charactersToInsert = new char[] {37, 50, 48, 55};
		for (int i = 0; i < input.length(); i++) {
			inputString[i] = input.charAt(i);
			inputString2[i] = input2.charAt(i);
		}
		replacingSpaces(inputString, input.length(), charactersToInsert);
		replacingWithAdditionalArray(inputString2, input2.length(), charactersToInsert);
	}
	
	/**
	 * Implementation of solution 1, with an additional array.
	 * @param string - The input string.
	 * @param trueLength - The true length of the string, without the additional white space.
	 * @param charactersToInsert - The characters to replace the " " with.
	 */
	public static void replacingWithAdditionalArray(char[] string, int trueLength, char[] charactersToInsert) {
		char[] finalString = new char[string.length];
		int currentIndex = 0;
		// Iterate through the initial string and copy its contents into the secondary array.
		for (int i = 0; i < trueLength; i++) {
			char toInsert = string[i];
			if (toInsert == ' ') {
				// Insert the characters
				for (int j = 0; j < charactersToInsert.length; j++) {
					finalString[currentIndex] = charactersToInsert[j];
					currentIndex++;
				}
			}
			else {
				finalString[currentIndex] = string[i];
				currentIndex++;
			}
			
		}
		System.out.println(finalString);
	}
	
	/**
	 * Implementation of solution 2, in-place shuffle.
	 * @param string - The input string.
	 * @param trueLength - The length of the string minus the ending white space.
	 * @param charactersToInsert - The characters to replace the " " with.
	 */
	public static void replacingSpaces(char[] string, int trueLength, char[] charactersToInsert) {
		int numberOfSpaces = 0;
		// Count the number of spaces in the input string.
		for (int i = 0; i < trueLength; i++) {
			if (string[i] == ' ') {
				numberOfSpaces++;
			}
		}
		System.out.println("The number of spaces in this string is - " + numberOfSpaces);
		System.out.println("The length of the string is - "  + trueLength);
		System.out.println("The number of characters to insert is - " + charactersToInsert.length);
		
		// Shuffle the characters across from the back to the front.
		int numberOfCharactersToInsert = charactersToInsert.length;
		int shuffleLength = (numberOfCharactersToInsert - 1) * numberOfSpaces;
		for (int j = trueLength; j > 0; j--) {
			char c = string[j];
			if (c == ' ') {
				// The space will be replaced by the last character in the array of things to replace.
				int tmpIndex = j + shuffleLength;
				for (int i = charactersToInsert.length - 1; i >= 0; i--) {
					string[tmpIndex] = charactersToInsert[i];
					tmpIndex--;
				}
				numberOfSpaces--;
				shuffleLength = (numberOfCharactersToInsert - 1) * numberOfSpaces;
			}
			else {
				// Shift across by shuffle length.
				string[j + shuffleLength] = c;
			}
		}
		System.out.println(string);
	}
}
