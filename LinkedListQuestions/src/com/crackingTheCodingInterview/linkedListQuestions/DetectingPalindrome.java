package com.crackingTheCodingInterview.linkedListQuestions;

import java.util.Stack;

import com.crackingTheCodingInterview.linkedListQuestions.dataStructures.Node;

/**
 * The {@link DetectingPalindrome}
 * <p>
 * Implement a function that checks to see if a linked
 * list is a palindrome.
 * <p>
 * A palindrome is a when a word is the same forwards as
 * it is backwards, such as racecar, mum, dad.
 * <p>
 * Solution: </br>
 * The idea would be to get to the end of the list and then
 * check it against the start of the list one character at a time.
 * We could push all the values onto a stack which would provide the
 * reverse order of the list, then pop one off at a time and compare
 * it to the value at its associated node in the list. 
 * <p>
 * @author szeyick
 */
public class DetectingPalindrome {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		char[] wordArray = new char[] {'r', 'a', 'c', 'e', 'c', 'a', 'r'};
		char[] wordArray2 = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		Node wordList = buildList(wordArray);
		Node wordList2 = buildList(wordArray2);
		System.out.println(isPalindrome(wordList));
		System.out.println(isPalindrome(wordList2));
	}
	
	/**
	 * Determine if a linked list word is a palindrome.
	 * @param currentList - The linked list containing the word.
	 * @return <code>true</code> if the list is a palindrome, <code>false</code>
	 * otherwise.
	 */
	private static boolean isPalindrome(Node currentList) {
		boolean isPalindrome = true;
		Stack<String> wordStack = new Stack<String>();
		Node currentLetter = currentList;
		// Push words from the list onto the stack.
		while (currentLetter != null) {
			wordStack.push(String.valueOf(currentLetter.value));
			currentLetter = currentLetter.nextNode;
		}
		
		// Now iterate through the original list and if the
		// letter matches, then we pop off the stack.
		currentLetter = currentList;
		while (currentLetter != null) {
			String stackLetter = wordStack.pop();
			if (!String.valueOf(currentLetter.value).equals(stackLetter)) {
				isPalindrome = false;
				break;
			}
			currentLetter = currentLetter.nextNode;
		}
		// At the end of it, we should only need to compare half the letters 
		// since if it is a palindrome, the second half would be the same.
		return isPalindrome;
	}
	
	/**
	 * Build a linked list with an array of characters.
	 * @param word
	 * @return
	 */
	private static Node buildList(char[] word) {
		Node list = null;
		for (int i = 0; i < word.length; i++) {
			if (list == null) {
				list = new Node(word[i]);
			}
			else {
				list.add(word[i]);
			}
		}
		return list;
	}
}
