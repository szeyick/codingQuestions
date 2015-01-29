package com.crackingTheCodingInterview.stacksAndQueues.stack;

/**
 * The {@link SortedStack}.
 * <p>
 * This sorted stack class will sort items pushed onto it in
 * ascending order. It supports, push, pop, peek as per usual
 * stack operations along with isEmpty to determine if the stack
 * itself is empty.
 * <p>
 * @author szeyick
 */
public class SortedStack {

	/**
	 * The main stack that contains the items in ascending
	 * order.
	 */
	private Stack mainStack;
	
	/**
	 * The secondary stack that is used to hold items for
	 * sorting.
	 */
	private Stack secondaryStack;
	
	/**
	 * Constructor.
	 */
	public SortedStack() {
		mainStack = new Stack();
		secondaryStack = new Stack();
	}
	
	/**
	 * Push an item onto the stack, the item will be pushed
	 * onto the stack in ascending order meaning that even though
	 * it is pushed onto the stack, it may not necessarily be the 
	 * top most item. The top is maintained by the main stack whenever
	 * we push/pop items.
	 * <br>
	 * @param value - The item to push onto the stack.
	 */
	public void push(int value) {
		if (mainStack.peek() == -1) {
			mainStack.push(value);
		}
		else {
			// Iterate through the stack and compare the value with the current item
			// on top, keep on popping till the value on top is larger or we have reached -1
			while (value > mainStack.peek() && mainStack.peek() != -1) {
				secondaryStack.push(mainStack.pop());
			}
			// When this breaks it should have the correct position to insert into the stack
			// then just push everything from the secondary stack back on.
			mainStack.push(value);
			while (secondaryStack.peek() != -1) {
				mainStack.push(secondaryStack.pop());
			}
		}
	}
	
	/**
	 * @return - The top most item from the stack.
	 */
	public int pop() {
		return mainStack.pop();
	}
	
	/**
	 * @return - The top most item from the stack without
	 * removing it.
	 */
	public int peek() {
		return mainStack.peek();
	}
	
	/**
	 * @return <code>true</code> if the stack is empty, false 
	 * otherwise.
	 */
	public boolean isEmpty() {
		return mainStack.peek() == -1;
	}
}
