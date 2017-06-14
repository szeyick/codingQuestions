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
	private Node next;
	
	/**
	 * A reference to the data stored in the node.
	 */
	private int data;
	
	/**
	 * Constructor.
	 * @param data - The data to store.
	 */
	public Node(int data) {
		this.data = data;
	}
	
	/**
	 * @return the next node in the list.
	 */
	public Node getNext() {
		return next;
	}
	
	/**
	 * @param next - The next node to connect to.
	 */
	public void setNext(Node next) {
		this.next = next;
	}
	
	/**
	 * @return the data held by this node.
	 */
	public int getData() {
		return data;
	}
}
