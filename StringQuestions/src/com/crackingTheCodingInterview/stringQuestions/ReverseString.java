package com.crackingTheCodingInterview.stringQuestions;

/**
 * The {@link ReverseString} class.
 * <p>
 * Implement a function to reverse a null terminated
 * string. <p>
 * 
 * Solution - <br>
 * - The simplest solution would be to have two pointers
 *   to the first and last index in the string array and
 *   swap them at each iteration. The moment that the first
 *   index overlaps with the last index is when we finish the
 *   reverse. <p> 
 * - You could reverse in place without using the temporary
 *   pointer and calculating the ASCII values.
 * 
 * @author szeyick
 *
 */
public class ReverseString {

	/**
	 * The program main.
	 * @param args - The command line arguments.
	 */
	public static void main(String[] args) {
		String inputString = "abcdefgh";
		reverse(inputString.toCharArray());
	}
	
	/**
	 * Reversing a string with a pointer.
	 * @param str - The input string.
	 */
	private static void reverse(char[] str) {
		int startIndex = 0;
		int endIndex = (str.length - 1);
		
		// Loop from the start to end.
		while (startIndex < endIndex) {
			swap(startIndex, endIndex, str);
			inplaceSwap(startIndex, endIndex, str);
			startIndex++;
			endIndex--;
		}
		System.out.println(str);
	}
	
	/**
	 * Swap the characters in an array
	 * @param currentIndex - The start index.
	 * @param toSwap - The end index.
	 * @param str - The string array.
	 * 
	 */
	private static void swap(int currentIndex, int toSwap, char[] str) {
		char tmp = str[currentIndex];
		str[currentIndex] = str[toSwap];
		str[toSwap] = tmp;
	}
	
	/**
	 * Swap the characters in place from the array.
	 * @param currentIndex - The current index.
	 * @param toSwap - The index to swap.
	 * @param str - The string array.
	 */
	private static void inplaceSwap(int currentIndex, int toSwap, char[] str) {
		str[toSwap] = (char) (str[currentIndex] + str[toSwap]);
		str[currentIndex] = (char) (str[toSwap] - str[currentIndex]);
		str[toSwap] = (char) (str[toSwap] - str[currentIndex]);
	}
}
