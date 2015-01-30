package com.crackingTheCodingInterview.linkedListQuestions;

import com.crackingTheCodingInterview.linkedListQuestions.dataStructures.Node;

/**
 * The {@link FindingKthToLastElement}.
 * <p>
 * Implement an algorithm to find the kth to last element
 * of a singly linked list. 
 * <p>
 * Solution 1 - Iterate twice <br>
 * - To iterate twice, in the first iteration we loop from
 *   the start till the end, so we get the number of items
 *   that the list contains, then in our second iteration we
 *   loop until counter - k and when we reach that node we 
 *   return. 
 * <p>
 * Solution 2 - 2 pointers, jumping by k. <br>
 * - This algorithm is similar to the finding substring algorithm
 *   (Rabin Karp), where the idea is to create the window the size
 *   of the substring on the main string and then slide over. <br> 
 * - To use it in this, we need 2 pointers, one starting at the start
 *   and the other jumping ahead by k nodes. Then we slide across until
 *   the second pointer hits null (the end). We then return the first 
 *   pointer. <br>
 * - <b> This will yield the kth last node and be done in O(n - k) time where
 *   k is the size of the jump and n is the total size, since we would only 
 *   need to slide across k items in the worst case. 
 * <p>
 * Solution 2 should be faster since the first loop only needs to loop to
 * (n - k) where solution 1 needs to loop to n. The second part loops to
 * (n - k) for both algorithms, so since we take the largest, the first
 * algorithm performs in O(n) time, whereas the second takes O(n - k) time.
 * 
 * @author szeyick
 */
public class FindingKthToLastElement {

	/**
	 * The head of the linked list.
	 */
	private static Node head;
	
	/**
	 * The program main
	 * @param args - Command Line Arguments
	 */
	public static void main(String[] args) {
		initialiseLinkedList("abcdefghijklmnopqrstuvwxyz");
		printLinkedList();
		countListNumberSolution(15);
		jumpingByKElements(15);
	}
	
	/**
	 * Implementation of solution 1, the first loop
	 * will count the number of items and the second
	 * will find the kth to last.
	 */
	private static void countListNumberSolution(int kthToLast) {
		int numberOfNodes = 0; // The number of nodes in the list.
		
		Node currentNode = head;
		while (currentNode != null) {
			numberOfNodes++;
			currentNode = currentNode.nextNode;
		}
		
		int currentNodeNumber = 0; // The number of the node in the list
		int nodeToFind = numberOfNodes - kthToLast;
		currentNode = head;
		while (nodeToFind != currentNodeNumber) { 
			currentNode = currentNode.nextNode;
			currentNodeNumber++;
			
		}
		
		System.out.println("The " + kthToLast + "th last node is - " + currentNode.value);
	}
	
	/**
	 * Implementation of solution 2, the outer loop goes from
	 * start to end, whilst the inner loop jumps k times, if we reach 
	 * where the fast pointer is null we break and return the slow
	 * pointer.
	 * @param kthToLast
	 */
	private static void jumpingByKElements(int kthToLast) {
		Node slowPointer = head;
		Node fastPointer = head;

		// Jump the fast pointer k elements
		int count = 0;
		while (fastPointer != null) {
			if (count == kthToLast) {
				break;
			}
			fastPointer = fastPointer.nextNode;
			count++;
		}
		
		// Loop until fast pointer gets to the end of the list.
		while (fastPointer != null) {
			slowPointer = slowPointer.nextNode;
			fastPointer = fastPointer.nextNode;
		}
		System.out.println("The " + kthToLast + "th last node is - " + slowPointer.value);
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
