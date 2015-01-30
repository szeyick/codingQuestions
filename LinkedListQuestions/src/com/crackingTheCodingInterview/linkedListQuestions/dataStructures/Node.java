package com.crackingTheCodingInterview.linkedListQuestions.dataStructures;

/**
 * The {@link Node}.
 * <p>
 * This node class represents an individual
 * link within a linked list data structure.
 * 
 * @author szeyick
 *
 */
public class Node {

	/**
	 * The value stored in this node.
	 */
	public char value;
	
	/**
	 * Pointer reference to the next node.
	 */
	public Node nextNode;
	
	/**
	 * Object constructor.
	 */
	public Node() {
		value = '\0';
		nextNode = null;
	}
	
	public Node (char c) {
		value = c;
	}
	
	/**
	 * Recursively add an item into the linked list.
	 * @param valueTmp - The value to add.
	 */
	public void add(char valueTmp) {
		if (nextNode == null) {
			nextNode = new Node();
			nextNode.value = valueTmp;
		}
		else {
			nextNode.add(valueTmp);
		}
	}
	
	/**
	 * Recursively search the list to delete a node.
	 * @param previousNode - A reference to the previous node.
	 * @param valueTmp - The value to find and delete.
	 */
	public void delete(Node previousNode, char valueTmp) {
		if (this.value == valueTmp) {
			previousNode.nextNode = nextNode;
		}
		else {
			nextNode.delete(this, valueTmp);
		}
	}
}
