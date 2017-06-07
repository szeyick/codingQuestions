package com.codingQuestions.main;

/**
 * The Node.
 * <p>
 * This class is responsible for storing the data and pointer
 * for an individual node in a linked list.
 * <p>
 * @author szeyick
 */
public class Node {

	/**
	 * A reference to the next node in the list.
	 */
	public Node next;
	
	/**
	 * A reference to the data stored in the node.
	 */
	public int data;
	
	/**
	 * Constructor.
	 * @param data - The data to store.
	 */
	public Node(int data) {
		this.data = data;
	}
}
