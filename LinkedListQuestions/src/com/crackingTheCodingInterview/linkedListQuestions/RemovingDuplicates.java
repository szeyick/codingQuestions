package com.crackingTheCodingInterview.linkedListQuestions;

import com.crackingTheCodingInterview.linkedListQuestions.dataStructures.Node;

/**
 * The {@link RemovingDuplicates}.
 * <p>
 * Write code to remoe duplicates from an unsorted linked list. <br>
 * E.g - FOLLOW UP <br><br>
 * 
 * How would you solve this problem if a temporary buffer is not allowed? <p>
 * 
 * Solution 1 - Iterate from beginning to end O(n^2). <br>
 * - This solution at each stage, checks the occurence of the current letter
 *   with the rest of the linked list. The outer loop holds the current part  
 *   of the list we are up to, and the inner loop goes through the rest, if
 *   a duplicate is found then we will remove. <br>
 *   <b>
 * - This solution is O(n^2) since we need to iterate through the linked list
 *   each time for each letter.
 *   </b>
 * <p>
 * Solution 2 - Temporary buffer containing visited letters. <br>
 * - This solution creates a temporary buffer of all possible values initially set
 *   to FALSE. Iterating through the linked list, we check each letter against what
 *   is set in the buffer, if it is an undiscovered letter we set its value in the 
 *   buffer to TRUE, otherwise it is a duplicate and we remove the entry. <br>
 *   <b>
 * - This is a O(n) time solution where n is the length of the linked list. We also
 *   require O(m) time to initialise the temporary buffer where m is the size of the
 *   valid inputs (ASCII or UTF-8).  
 *  </b>
 * @author szeyick
 *
 */
public class RemovingDuplicates {

	/**
	 * The head of a linked list.
	 */
	private static Node head;
	
	/**
	 * Program Main
	 * @param args - Command Line Arguments.
	 */
	public static void main(String[] args) {
		initialiseLinkedList("THIS WILL NOW REMOVE ALL DUPLICATES FROM THE SENTENCE");
		printLinkedList();

		iterateEachCharacter();
		iterateWithABooleanArray();
		printLinkedList();
	}
	
	/**
	 * The code for Solution 1, we iterate from each character
	 * and remove. 
	 */
	private static void iterateEachCharacter() {
		Node currentHead = head;
		// Iterate from the start to end, check the next for dupliates.
		while (currentHead != null) {
			Node currentNode = currentHead;
			Node adjacentNode = currentNode.nextNode;
			while (adjacentNode != null) {
				if (adjacentNode.value == currentHead.value) {
					currentNode.nextNode = adjacentNode.nextNode;
					adjacentNode = adjacentNode.nextNode;
					// If we remove, the current doesn't change.
				}
				else {
					currentNode = adjacentNode;
					adjacentNode = adjacentNode.nextNode;
				}
			}
			currentHead = currentHead.nextNode;
		}
	}
	
	/**
	 * The code for Solution 2, we iterate through the linked
	 * list once, and keep a track of the values we have visited.
	 * If the value has already been visited, we remove.
	 */
	private static void iterateWithABooleanArray() {
		boolean[] asciiTable = new boolean[256];
		
		// Iterate through the linked list once.
		Node currentNode = head;
		Node previousNode = null;
		while (currentNode != null) {
			// Compare with the array.
			if (asciiTable[currentNode.value]) {
				// Then remove the current.
				previousNode.nextNode = currentNode.nextNode;
			}
			else {
				asciiTable[currentNode.value] = true;
				previousNode = currentNode;
			}
			currentNode = currentNode.nextNode;
		}
	}
	
	/**
	 * Initialise the linked list.
	 * @param value - The input value.
	 */
	private static void initialiseLinkedList(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (head == null) {
				head = new Node();
				head.value = value.charAt(i);
			}
			else {
				head.add(value.charAt(i));
			}
		}
	}
	
	/**
	 * Print the contents of the linked list.
	 */
	private static void printLinkedList() {
		Node currentNode = head;
		while (currentNode != null) {
			System.out.print(currentNode.value + " ");
			currentNode = currentNode.nextNode;
		}
		System.out.println();
	}

}
