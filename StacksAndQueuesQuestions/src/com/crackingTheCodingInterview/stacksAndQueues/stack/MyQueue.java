package com.crackingTheCodingInterview.stacksAndQueues.stack;


/**
 * The {@link MyQueue}
 * <p>
 * Implement a MyQueue clas which implements a queue using two stacks.
 * <p>
 * A queue is a FIFO data structure, meaning elements that are placed in
 * first are first retrieved. A stack is where the first one is the last
 * out.
 * <p>
 * We use a secondary stack as a buffer area where we pop all the items 
 * in the main stack onto. We then push the new value onto the main stack
 * then pop all the items from the secondary stack back onto the main stack.
 * <p>
 * Eg. <br>
 * Main Stack - <br>
 * Secondary Stack - <br>
 * Push 1. <br>
 * Main Stack - 1 <br>
 * Secondary Stack -  <br>
 * Push 2. <br>
 * Move items from Main Stack to Secondary Stack <br>
 * Main Stack - <br>
 * Secondary Stack - 1 <br>
 * Push 2 onto Main Stack <br>
 * Main Stack - 2 <br>
 * Pop off Secondary Stack to Main <br>
 * Main Stack - 2 1 <br>
 * Secondayr Stack - <br>
 * <p>
 * @author szeyick
 */
public class MyQueue {

	/**
	 * The main stack that contains all the items.
	 */
	private static Stack mainStack;
	
	/**
	 * The secondary stack that acts as a buffer area.
	 */
	private static Stack secondaryStack;
	
	/**
	 * Constructor.
	 */
	public MyQueue() {
		mainStack = new Stack();
		secondaryStack = new Stack();
	}
	
	/**
	 * Add an item to the queue
	 * @param value - The value to add.
	 */
	public void enqueue(int value) {
		// When we add an item to the queue we need to push all the items
		// from the main stack off to the secondary stack.
		if (mainStack.peek() == -1) {
			// Stack is empty.
			mainStack.push(value);
		}
		else {
			while (mainStack.peek() != -1) {
				secondaryStack.push(mainStack.pop());
			}
			mainStack.push(value);
			while (secondaryStack.peek() != -1) {
				mainStack.push(secondaryStack.pop());
			}
		}
	}
	
	/**
	 * @return - The first item in the queue.
	 */
	public int dequeue() {
		return mainStack.pop();
	}
	
	/**
	 * @return - A look at the item at the head
	 * of the queue without removing it.
	 */
	public int head() {
		return mainStack.peek();
	}
}
