package com.codingQuestions;

/**
 * The MakingAnagramsMain.
 * <p>
 * This class represents the program main that will
 * demonstrate the number of characters to remove that
 * will allow one string to be an anagram of the other.
 * <p>
 * <b>Warning: </b>None.
 * <p>
 * @author szeyick
 */
public class MakingAnagramsMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		MakeAnagram anagram = new MakeAnagram();
		System.out.println("The number of characters need to make cde into abc is: " + anagram.numberNeeded("cde", "abc"));
	}
}
