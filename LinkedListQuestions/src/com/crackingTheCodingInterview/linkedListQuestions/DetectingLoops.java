package com.crackingTheCodingInterview.linkedListQuestions;

import com.crackingTheCodingInterview.linkedListQuestions.dataStructures.Node;

/**
 * The {@link DetectingLoops}
 * <p>
 * Given a circular linked list, implement an algorithm which returns 
 * the node at the beginning of the loop.
 * <p>
 * Definition: <br>
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier
 * node, so as to make a loop in the linked list.
 * <p>
 * Example: <br>
 * Input: A -> B -> C -> D -> E -> C [The same as C as earlier]
 * Output: C
 * <p>
 * Solution: <br>
 * This is a cycle detection algorithm that is split into two parts.
 * We begin by having a tortoise and hare pointer, whereby one pointer moves across one node at 
 * a time (tortoise) and the other jumps two nodes at a time (hare). If we have a cycle, the hare
 * will always come back around and catch the tortoise, otherwise the hare will just get to the end
 * and there will be no cycle. The first step is to find the point where the hare catches the tortoise.
 * <p>
 * Once we have found this, the second part of the algorithm involves setting on of the pointers to
 * begin at this cross over point and the other at the beginning of the list, we then move each pointer
 * across by 1 and the point where they meet again will show the point at where the loop has been deteced.
 * <p>
 * @author szeyick
 */
public class DetectingLoops {

	/**
	 * The program main.
	 * @param args - Command Line Arguments.
	 */
	public static void main(String[] args) {
		Node input = buildLoopedList();
		findLoop(input);
	}

	/**
	 * Given an input list, find the loop
	 * @param input - The input list.
	 */
	private static void findLoop(Node input) {
		Node tortoise = input;
		Node hare = input;
		
		// If the hare ever reaches null it means there is no loop
		while (hare != null) {
			hare = hare.nextNode;
			if (hare == null) {
				break;
			}
			hare = hare.nextNode;
			tortoise = tortoise.nextNode;
			if (hare == tortoise) {
				// Loop detected.
				break;
			}
		}
		// Means we have detected a loop
		if (hare != null) {
			// Reset the tortoise and jump 1 at a time.
			tortoise = input;
			while (hare != tortoise) {
				hare = hare.nextNode;
				tortoise = tortoise.nextNode;
			}
			System.out.println("Loop detected at - " + hare.value);
		}
		else {
			System.out.println("No loop found");
		}
	}
	
	/**
	 * @return - A linked list that contains a cycle.
	 */
	private static Node buildLoopedList() {
		Node a = new Node('A');
		Node b = new Node('B');
		Node c = new Node('C');
		Node d = new Node('D');
		Node e = new Node('E');
		
		a.nextNode = b;
		b.nextNode = c;
		c.nextNode = d;
		d.nextNode = e;
		e.nextNode = null;
		
		return a;
	}
}
