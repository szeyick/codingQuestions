package com.codingQuestions.main;

/**
 * The CycleDetector.
 * <p>
 * This class is responsible for wrapping the functionality
 * of detecting a cycle in a linked list.
 * <p>
 * This detector implements the Floyds algorithm for detecting cycles which
 * is also referred to as the Tortoise and the Hare algorithm.
 * @author szeyick
 */
public class CycleDetector {

	/**
	 * @param head - The head of the list to detect a cycle for.
	 * @return <code>true</code> if there is a cycle, <code>false</code>
	 * otherwise.
	 */
	public boolean hasCycle(Node head) {
		boolean hasCycle = false;
		
		Node tortoise = head;
		Node hare= head;
		while (hare != null) {
			hare = hare.next;
			if (hare == null) {
				break;
			}
			else if (tortoise == hare) {
				hasCycle = true;
				break;
			}
			hare = hare.next;
			tortoise = tortoise.next;
		}
		return hasCycle;
	}
}
