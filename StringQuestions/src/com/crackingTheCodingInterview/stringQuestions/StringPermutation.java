package com.crackingTheCodingInterview.stringQuestions;

import java.util.HashMap;
import java.util.Map;

import com.crackingTheCodingInterview.stringQuestions.dataStructures.Node;

/**
 * The {@link StringPermutation} class.
 * <p>
 * Given two strings, write a method to decide if one
 * is a permutation of the other. <p>
 * 
 * A permutation is to say that you can make up the first
 * string with the characters in the second string. <p> 
 * 
 * Solution - <br>
 * - A solution would be to hash the second string
 *   and then parse the first string, if we parse the first 
 *   string and there is a non-match then it isn't a permutation.<br>
 * <b>  
 * - It would be a O(n + m), where n is the length of the string and
 *   m is the length of the second string to hash.</b><p>
 *   
 * - A second solution would be to use a byte-array or boolean array
 *   to mark the characters that have been visited. <br>
 * <b>
 * - It would be a O(n + m) solution to construct and loop through. 
 * </b><p>
 * - A third solution would be to construct a binary search tree with the
 *   characters in the second string, then parse in the first string and
 *   if we cannot find it then we break and return false.
 * <b>
 * - It would be a (m + log(n)) solution, where it would be m time to construct
 *   the binary search tree and then log(n) to search through it.
 * </b><p>  
 * 
 * @author szeyick
 *
 */
public class StringPermutation {

	/**
	 * The program main.
	 * @param args - command line arguments.
	 */
	public static void main(String[] args) {
		String string1 = "this";
		String string2 = "thslr84273489klfkjssdkf i";
		System.out.println("Is " + string2 + " a permutation of " + string1 + " - " + permutationWithHash(string1, string2));
		System.out.println("Is " + string2 + " a permutation of " + string1 + " - " + permutationWithBooleanArray(string1, string2));
		System.out.println("Is " + string2 + " a permutation of " + string1 + " - " + permutationWithBinarySearchTree(string1, string2));
	}
	
	/**
	 * Determining if string2 is a permutation of string1 with a hash map.
	 * The hash map holds the character string and whether it is found with
	 * a boolean. The map will return null if the character is not in the map.
	 * @param string1 - The input string to find the permutation of.
	 * @param string2 - The input string to build the map with.
	 * @return <code>true</code> if string2 is a permutation of string1, <code>false</code>
	 * otherwise.
	 */
	private static boolean permutationWithHash(String string1, String string2) {
		Map<String, Boolean> keys = new HashMap<String, Boolean>();
		boolean isPermutation = true;
		
		// Iterate through string2 and store the characters into the map
		for (int i = 0; i < string2.length(); i++) {
			keys.put(String.valueOf(string2.charAt(i)), Boolean.TRUE);
		}
		
		// Iterate through string1 to see if all the characters match
		for (int j = 0; j < string1.length(); j++) {
			Boolean characterExists = keys.get(String.valueOf(string1.charAt(j)));
			if (characterExists == null) {
				return false;
			}
		}
		return isPermutation;
	}

	/**
	 * Determine if string2 is a permutation of string1 by breaking up strin2 into
	 * a boolean array. The boolean array represents the ascii table, where all characters
	 * from string2 have been entered in. If the loop through of string1 yields a false then
	 * it means that a character is not present therefore we cannot make up string1 with the
	 * available characters from string2.
	 * @param string1 - The string to check.
	 * @param string2 - The string to break up.
	 * @return <code>true</code> if string2 is a permutation of string1, <code>false</code> otherwise.
	 */
	private static boolean permutationWithBooleanArray(String string1, String string2) {
		boolean[] asciiTable = new boolean[255];
		
		// Break up second string into the ascii table.
		for (int i = 0; i < string2.length(); i++) {
			asciiTable[string2.charAt(i)] = true;
		}
		
		// Loop through the first string to see if the characters match
		for (int j = 0; j < string1.length(); j++) {
			if (asciiTable[string1.charAt(j)] == false) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Determine if string2 is a permutation of string1 by using a binary search tree. The 
	 * idea here is to construct the BST with the contents of string2 and then search for
	 * the characters in string1. The construction might be a little heavier but we do not
	 * waste any space with this and the search is faster.
	 * @param string1 - The string to see if it is a permutation of.
	 * @param string2 - The string to build the BST with.
	 * @return <code>true</code> if string2 is a permutation of string1, <code>false</code>
	 * otherwise.
	 */
	private static boolean permutationWithBinarySearchTree(String string1, String string2) {
		// Create a binary search tree with the characters in string2
		char[] treeData = string2.toCharArray();
		
		// Assume string2 is non empty. (Construct the tree in O(m) time)
		int i = 0;
		Node head = new Node(treeData[i]);
		for (i = 1; i < treeData.length; i++) {
			head.insert(treeData[i]); // Insert the items into a BST.
		}
		
		// Perform a binary search on the contents of string1 in the tree made from string2.
		// Searches the tree in O(logn) time. This could be worse in the case that string2 was 
		// in alphabetical order since it would reduce to a linked list making the search O(n)
		for (int j = 0; j < string1.length(); j++) {
			if (!head.search(string1.charAt(j))) {
				return false;
			}
		}
		return true;
	}
}
