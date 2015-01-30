package com.crackingTheCodingInterview.linkedListQuestions;

import com.crackingTheCodingInterview.linkedListQuestions.dataStructures.Node;

/**
 * The {@link PartitionLinkedList}.
 * <p>
 * Write code to partition a linked list around a value x, such 
 * that all nodes less than x come before all nodes greater than 
 * or equal to x.
 * <p>
 * Solution 1 - Make 2 Lists <br>
 * - The idea here is to create 2 lists, 1 with a list that contains
 *   all the nodes that are smaller than the value x and another list
 *   with all the nodes that contain values that are larger than x. <br>
 * - The idea is then to connect them both around the value x. <br>
 * - We break up the whole linked list into two parts, the first iterates 
 *   from head -> x and the other from x + 1 -> tail. <br> 
 * - This should run in linear time O(n), with an additional O(n) space since
 *   we need to copy the items into a new linkd list since if we use it in place
 *   we would copy the same nodes all over the place since we'd be using only
 *   references.
 * <p>
 * 
 * @author szeyick
 */
public class PartitionLinkedList {

	/**
	 * The head of the linked list.
	 */
	private static Node head;
	
	/**
	 * The program main.
	 * @param args - The command line arguments.
	 */
	public static void main(String[] args) {
		initialiseLinkedList("17529");
		printLinkedList(head);
		
		Node middleNode = findMiddle();
		
		// Rotate around the middle
		System.out.println("The middle node is - " + middleNode.value);
		System.out.println("The number of items in the list is - " + numberOfItems());
		Node rotatedList = rotateList(middleNode);
		printLinkedList(rotatedList);
	}
	
	/**
	 * Solution 1 - Rotate the list around the middle node.
	 * @return - The rotated list.
	 */
	private static Node rotateList(Node middleNode) {
		Node current = head;
		
		Node smallList = null;
		Node largeList = null;
		
		// Create a new set of small list nodes.
		while (current != null) {
			if (current.value == middleNode.value) {
				current = current.nextNode;
				continue;
			}
			if (current.value < middleNode.value) {
				if (smallList == null) {
					smallList = new Node(current.value);
				}
				else {
					smallList.add(current.value);
				}
			}
			else {
				if (largeList == null) {
					largeList = new Node(current.value);
				}
				else {
					largeList.add(current.value);
				}
			}
			current = current.nextNode;
		}

		// find the tail of the small list.
		current = smallList;
		Node tail = null;
		while (current != null) {
			if (current.nextNode == null) {
				tail = current;
			}
			current = current.nextNode;
		}
		
		tail.nextNode = middleNode;
		middleNode.nextNode = largeList;
		return smallList;
	}
	
	/**
	 * @return the number of items that are in the list.
	 */
	private static int numberOfItems() {
		int count = 0;
		Node currentNode = head;
		while (currentNode != null) {
			count++;
			currentNode = currentNode.nextNode;
		}
		return count;
	}
	
	/**
	 * Find the middle element in the linked list.
	 * @return - The middle element as a {@link Node}.
	 */
	private static Node findMiddle() {
		Node turtle = head;
		Node hare = head;
		
		// Hare jumps twice, turtle jumps once.
		while (hare != null) {
			hare = hare.nextNode;
			if (hare == null) {
				break;
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
	private static void printLinkedList(Node headTmp) {
		Node currentNode = headTmp;
		while (currentNode != null) {
			System.out.print(currentNode.value + " ");
			currentNode = currentNode.nextNode;
		}
		System.out.println();
	}

}
