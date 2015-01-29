package com.crackingTheCodingInterview.stacksAndQueues.stack;

/**
 * The {@link SetOfStacks}
 * <p>
 * Imagine a literal stack of plates. If the stack gets too high, it
 * might toppled. Therefore, in real life, we would likely start a new stack
 * when the previous stack exceeds some threshold. Implement a data structure
 * SetOfStacks that mimics this. SetOfStacks should be composed of several stacks
 * and should create a new stack once the previous one exceeds capacity. 
 * <p>
 * The push and pop methods on SetOfStacks should behave identically to a single stack.
 * <p>
 * Solution - <br>
 * The idea here would be that each stack could be stored into an array when it has reached
 * its capacity. 
 * <p>
 * [Stack_1][Stack_2][Stack_3][Stack_n]...
 * <p>
 * The top of each stack, must connect to the bottom of the next stack when we add items to it. Push will
 * need to check for capacity, and if it exceeds the threshold, a new stack must be started. Pop 
 * <p>
 * FOLLOW UP - Implement a function popAt(int index) which performs a pop operation on a specific
 * sub-stack. 
 * <p>
 * I suppose if you pop at, it would place the item at the bottom of the next stack onto the current so you 
 * would need to shift the items across. In addition to doing so, you'd also need to update to decrement the height
 * of the current stack the same as the pop would.
 * @author szeyick
 */
public class SetOfStacks {

	/**
	 * The maximum height of each stack.
	 */
	private int maxHeightOfStack;
	
	/**
	 * The height of the current stack.
	 */
	private int currentStackHeight;
	
	/**
	 * The index of the current stack that we 
	 * are stacking.
	 */
	private int currentStackIndex;
	
	/**
	 * The number of stacks that we can have.
	 */
	private StackNode[] stackArray;
	
	/**
	 * A reference to the top of the stack.
	 */
	private StackNode top;
	
	/**
	 * Constructor.
	 * @param capacityTmp - The maximum height of each stack.
	 */
	public SetOfStacks(int capacityTmp) {
		maxHeightOfStack = capacityTmp;
		stackArray = new StackNode[2];
		top = null;
		currentStackHeight = 0;
		currentStackIndex = 0;
	}
	
	/**
	 * Push a value onto the stack.
	 * @param value - The value to push onto the stack.
	 */
	public void push(int value) {
		// If 0 is the max height we cannot insert.
		if (maxHeightOfStack == 0) {
			return;
		}
		else {
			if (currentStackHeight == maxHeightOfStack) {
				// If we have reached the maximum then we need to start a new stack.
				if (currentStackIndex == stackArray.length) {
					// Resize the stack.
				}
				else {
					StackNode newNode = new StackNode(value);
					newNode.next = top;
					top = newNode;
					
					currentStackIndex++;
					currentStackHeight = 1;
					
					stackArray[currentStackIndex] = newNode;
				}
			}
			else {
				StackNode newNode = new StackNode(value);
				newNode.next = top;
				top = newNode;
				
				currentStackHeight++;
				stackArray[currentStackIndex] = newNode;
			}
		}
	}
	
	/**
	 * Pop an item off the stack.
	 * @return - The item that has just been popped.
	 */
	public int pop() {
		// Popping an item off the stack should be fine, but we need to
		// also update the current stack height values. If it reaches 0
		// then we need to also decrement the current stack index so that
		// we don't update the wrong index when we push items on again.
		if (top != null) {
			int topValue = top.value;
			top = top.next;
			
			currentStackHeight--;
			stackArray[currentStackIndex] = top;
			if (currentStackHeight == 0 && currentStackIndex > 0) {
				// If the current stack is empty, we go to the previous index
				// only if it is greater than 0, otherwise we are already on the
				// first stack.
				currentStackIndex--;
				currentStackHeight = maxHeightOfStack;
			}
			return topValue;
		}
		return -1;
	}
	
	/**
	 * @return the top most value of the stack.
	 */
	public int peek() {
		return top.value;
	}
	
	/**
	 * Pop an item from the top of a specific stack.
	 * @param index - The index to pop from.
	 * @return - The value of the item popped.
	 */
	public int popAt(int index) {
		if (index > currentStackIndex) {
			// Cannot pop if the index is larger than the number of stacks.
			return -1;
		}
		if (index == currentStackIndex) {
			// If the index is the current stack, then we call regular pop.
			return pop();
		}
		else {
			// The item at the top of the stack is already at the index.
			StackNode topOfStack = stackArray[index];
			
			// The item at the end of the next stack becomes the top of the
			// current stack all the way till the end.
			shiftLeft(index, topOfStack);
			return topOfStack.value;
		}
	}
	
	/**
	 * Shift all the items to the left in our stack.
	 */
	private void shiftLeft(int currentIndex, StackNode topOfStack) {
		// The top of stack is the top of the current stack.
		// We need to find the bottom of the next stack, and their next is
		// equal to the topOfStack.next.
		
		int nextStack = currentIndex + 1;
		StackNode bottomOfNextStack = findBottom(nextStack);
		bottomOfNextStack.next = topOfStack.next;
		
		stackArray[currentIndex] = bottomOfNextStack;
		currentStackHeight--;
		if (currentStackHeight == 0) {
			currentStackHeight = maxHeightOfStack;
			currentStackIndex--;
		}
	}
	
	/**
	 * Find the bottom of the stack.
	 * @param index - The index to find.
	 * @return
	 */
	private StackNode findBottom(int index) {
		StackNode currentNode = stackArray[index];
		int heightOfStack = maxHeightOfStack;
		if (index == currentStackIndex) {
			heightOfStack = currentStackHeight;
		}
		for (int i = 1; i < heightOfStack; i++) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}
	
	/**
	 * Print the items in the stack at each pile.
	 * Although this should be printed backwards to represent
	 * the actual stack.
	 */
	public void printStacks() {
		for (int i = 0; i < currentStackIndex; i++) {
			StackNode node = stackArray[i];
			System.out.print("Stack " + i + " : ");
			for (int j = 1; j <= maxHeightOfStack; j++) {
				System.out.print(node.value + "->");
				node = node.next;
			}
			System.out.println();
		}
		// Print the last stack.
		StackNode node = stackArray[currentStackIndex];
		System.out.print("Stack " + currentStackIndex + " : ");
		for (int j = 1; j <= currentStackHeight; j++) {
			System.out.print(node.value + "->");
			node = node.next;
		}
		System.out.println();
	}
	
	private int stackIndex;
	private int heightCount;
	/**
	 * 
	 * @param currentNode
	 * @param currentStackHeight
	 */
	private int printStackCorrectly(StackNode currentNode, int currentValue) {
		if (currentNode == null) {
			return ++currentValue;
		}
		else {
			int newCurrentValue = printStackCorrectly(currentNode.next, currentValue);
			System.out.print(currentNode.value + "->");
			heightCount++;
			
			if (heightCount == maxHeightOfStack && stackIndex < currentStackIndex) {
				heightCount = 0;
				stackIndex++;
				System.out.println();
				System.out.print("Stack " + stackIndex + " : ");
			}
			return ++newCurrentValue;
		}
	}
	
	/**
	 * Print the stack in the order in which it was intended.
	 */
	public void printStackCorrectly() {
		stackIndex = 0;
		heightCount = 0;
		System.out.print("Stack " + stackIndex + " : ");
		printStackCorrectly(top, 0);
	}
}
