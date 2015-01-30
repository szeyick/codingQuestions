package com.crackingTheCodingInterview.linkedListQuestions.dataStructures;

/**
 * The {@link IntegerNode}.
 * <p>
 * This class represents a singly linked list
 * node. It holds an integer value.
 * <p>
 * @author szeyick
 */
public class IntegerNode {

	/**
	 * The value stored in this node.
	 */
	public int value;
	
	/**
	 * Pointer reference to the next node.
	 */
	public IntegerNode nextNode;
	
	/**
	 * Object constructor.
	 */
	public IntegerNode(int i) {
		value = i;
		nextNode = null;
	}
	
	/**
	 * Recursively add an item into the linked list.
	 * @param valueTmp - The value to add.
	 */
	public void add(int valueTmp) {
		if (nextNode == null) {
			nextNode = new IntegerNode(valueTmp);
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
	public void delete(IntegerNode previousNode, int valueTmp) {
		if (this.value == valueTmp) {
			previousNode.nextNode = nextNode;
		}
		else {
			nextNode.delete(this, valueTmp);
		}
	}
}
