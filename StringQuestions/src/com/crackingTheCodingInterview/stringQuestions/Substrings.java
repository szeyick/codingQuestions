package com.crackingTheCodingInterview.stringQuestions;

/**
 * The {@link Substrings}.
 * <p>
 * Assume you have a method isSubstring which checks if
 * one word is a substring of another. Given two strings
 * S1 and S2, write code to check if S2 is a rotation of 
 * S1 using only one call to isSubstring (e.g - waterbottle
 * is a rotation of erbottlwat".
 * <p>
 * Solution - Concatenating strings <br>
 * The solution for this involves concatenating a string S1
 * together with itself since the string S2 must exist somewhere
 * within it in a repetitive order. <br>
 * 
 * Eg. S1 = erbottlwat
 *     S2 = waterbottle
 *     
 * If you concatenate S1 together twice it will be "erbottlewat" + "erbottlewat"
 * which becomes - "erbottlewaterbottlewat". This means that the string even 
 * though it has been rotated, when repeated has to at least contain the string S2.
 * <p>
 * The solution lies with concatenating S1 and then doing a check with the isSubstring
 * method to see if S2 contains it.
 * 
 * @author szeyick
 *
 */
public class Substrings {

	/**
	 * Program Main
	 * @param args - Command Line Arguments.
	 */
	public static void main(String[] args) {
		boolean isSubstring = concatentateStrings("erbottlewat", "waterbottle");
		System.out.println("S2 is a substring of S1 - " + isSubstring);
	}
	
	/**
	 * Concatenate the strings then call isSubstring to see if
	 * s2 is a substring of another.
	 * @param s1 - The string to concatenate
	 * @param s2 - The string to see if it is a substring of.
	 */
	private static boolean concatentateStrings(String s1, String s2) {
		String concatenatedString = s1 + s1;
		// Only check the substring if s2 is the same size or smaller
		if (s2.length() <= s1.length()) {
			return concatenatedString.contains(s2); // Acts as the isSubstring method.
		}
		return false;
	}

}
