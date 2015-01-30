package com.crackingTheCodingInterview.linkedListQuestions;

import com.crackingTheCodingInterview.linkedListQuestions.dataStructures.Node;

/**
 * The {@link DeletingFromMiddle}
 * <p>
 * Implement an algorithm to delete a node in the middle
 * of a singly linked list, given only access to that
 * node.
 * <p.
 * Solution 1 - Copying Elements. <br>
 * - In a singly linked list, we do not have access to the
 *   predecessor node meaning that we cannot link the 
 *   predecessor with the successor of the current node. <br>
 * - The solution is to modify the current node by copying
 *   all the information in the next node to the current node
 *   and deleting the next node instead of the current one. <br>
 * - We can use the current node as a temporary store since we
 *   do not need any of the information in it given that we are
 *   deleting it anyway. 
 * <p>
 * Delete c <br>
 * Input: a -> b -> c -> d -> e <br>
 * Result: a -> b -> d -> e <br>
 * 
 * @author szeyick
 *
 */
public class DeletingFromMiddle {

	/**
	 * The head of the linked list.
	 */
	private static Node head;
	
	/**
	 * The program main.
	 * @param args - Command Line Arguments.
	 */
	public static void main(String[] args) {
		initialiseLinkedList("abcde");
		printLinkedList();
		Node middle = findMiddle();
		deleteCurrentNode(middle);
		printLinkedList();
	}
	
	/**
	 * Solution 1, delete the current node by copying everything
	 * over from the next node to the current node.
	 * @param currentNode - The node to delete.
	 */
	private static void deleteCurrentNode(Node currentNode) {
		// Copy the data from the next node to the current.
		Node nextNode = currentNode.nextNode;
		currentNode.nextNode = nextNode.nextNode;
		currentNode.value = nextNode.value;
		
		nextNode.nextNode = null;
	}
	
	/**
	 * @return the middle element of the linked list.
	 */
	private static Node findMiddle() {
		Node turtle = head;
		Node hare = head;
		
		// The hare skips 2 ahead whilst the turtle skips 1
		while (hare != null) {
			hare = hare.nextNode;
			if (hare == null) {
				return turtle;
			}
			hare = hare.nextNode;
			turtle = turtle.nextNode;
		}
		return turtle;
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
