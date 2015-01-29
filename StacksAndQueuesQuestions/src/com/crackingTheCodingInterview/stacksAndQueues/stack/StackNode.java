package com.crackingTheCodingInterview.stacksAndQueues.stack;

/**
 * The {@link StackNode}.
 * <p>
 * This class represents the node used in
 * a stack. The node will contain the value
 * and a reference to the next node in the stack.
 * <p>  
 * @author szeyick
 */
public class StackNode {

	/**
	 * The value held by the node.
	 */
	public int value;
	
	/**
	 * Reference to the next node that
	 * the current node points to.
	 */
	public StackNode next;
	
	/**
	 * The object constructor.
	 * @param valueTmp - The value to store 
	 * in the node.
	 */
	public StackNode(int valueTmp) {
		value = valueTmp;
		next = null;
	}
}
