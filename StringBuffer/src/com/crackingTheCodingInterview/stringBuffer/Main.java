package com.crackingTheCodingInterview.stringBuffer;

/**
 * The {@link Main} class.
 * <p>
 * This class demonstrates the functionality
 * of the String Buffer.
 * <p>
 * StringBuffer is useful when there is a need to concatenate
 * strings together.<p>
 * 
 * When we usually concatenate strings together
 * using String1 + String2 method, we create a new copy of the string
 * where the characters of the string are copied character by character
 * into the new array. This is not efficient when we wish to concatenate
 * large numbers of strings together since the number of characters to copy
 * over each time gets larger each time eventually reducing to O(n^2). <p>
 * 
 * This is where we can use the StringBuffer. It creates an array of all the 
 * strings and only copies them back to a string when we request to do so.
 * 
 * @author szeyick
 *
 */
public class Main {

	/**
	 * Program Main
	 * @param args - command line arguments.
	 */
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		String[] words = new String[5];
		words[0] = "There ";
		words[1] = "is a ";
		words[2] = "cat in ";
		words[3] = "the hat";
		words[4] = "!!";
		
		System.out.println(joinWords(words));
		System.out.println(joinWordsCustom(words));
		
		final long duration = System.nanoTime() - startTime;
		final double seconds = ((double)duration / 1000000000);
		System.out.println("Execution Time: " + seconds);
	}
	
	/**
	 * Join an array of words together using the 
	 * {@link StringBuffer}.
	 * @param words - An array of words to join.
	 */
	private static String joinWords(String[] words) {
		StringBuffer sentence = new StringBuffer();
		for (String word: words) {
			sentence.append(word);
		}
		return sentence.toString();
	}
	
	/**
	 * Join an array of words together using the 
	 * {@link MyStringBuffer}.
	 * @param words - An array of words to join.
	 */
	private static String joinWordsCustom(String[] words) {
		MyStringBuffer sentence = new MyStringBuffer();
		for (String word: words) {
			sentence.append(word);
		}
		return sentence.toString();
	}
}
