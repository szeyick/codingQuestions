package com.crackingTheCodingInterview.stacksAndQueues.stack;

/**
 * The {@link Stack}.
 * <p>
 * This class represents a stack. It
 * contains a collection of {@link StackNode}
 * items and the push, pop and peek operations.
 * <p> 
 * New items that are added to the stack, are added
 * to the top of the {@link StackNode}, and when they
 * are popped, the item is removed and the item next
 * in the stack becomes the new top of the stack.
 * <p>
 * @author szeyick
 */
public class Stack {
	
	/**
	 * The {@link StackNode} that represents
	 * the item at the top of the stack.
	 */
	private StackNode top;
	
	/**
	 * Default constructor.
	 */
	public Stack() {
		top = null;
	}
	
	/**
	 * Push an item onto the stack.
	 * @param value - The value to push onto
	 * the stack.
	 */
	public void push(int value) {
		// When we add new value to the stack, we create
		// a new node. The previous item at the top of the stack
		// becomes the "next" item to our new node as it gets pushed
		// along in the stack. 
		StackNode newNode = new StackNode(value);
		newNode.next = top;
		top = newNode;
	}
	
	/**
	 * Pop an item from the stack.
	 */
	public int pop() {
		if (top != null) {
			StackNode poppedNode = top;
			top = top.next;
			return poppedNode.value;
		}
		return -1;
	}
	
	/**
	 * @return - A look at the item at the top
	 * of the list. 
	 */
	public int peek() {
		if (top == null) {
			return -1;
		}
		else {
			return top.value;
		}
	}
}
