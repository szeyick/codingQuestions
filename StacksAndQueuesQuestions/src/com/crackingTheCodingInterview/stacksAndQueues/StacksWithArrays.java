package com.crackingTheCodingInterview.stacksAndQueues;

/**
 * The {@link StacksWithArrays}.
 * <p>
 * Describe how you could use a single array to
 * implement three stacks.
 * <p>
 * Solution: <br>
 * The solution here would be to divide the array into three
 * parts. There would be three pointers in the array that refer
 * to the start of each stack and the current top of each of those
 * stacks. When we run out of space in any of those stacks, we need
 * to create new space and shuffle everything else across.
 * <p>
 * For each stack we should only make it a small size to begin with so 
 * we don't over-allocate the space, if we pop to a threshold then we
 * should also re-allocate the array.
 * <p>
 * @author szeyick
 */
public class StacksWithArrays {
	
	private static int[] tripleStack = new int[10];
	private static StackInformation[] stackInfo = new StackInformation[3];
	
	private static int entireStackSize = tripleStack.length;
	private static  int numberOfStacks = 3;
	private static  int individualStackSize = entireStackSize / numberOfStacks; 
	
	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		initialiseStacks();
		// We will start with just an integer stack.
		push(12, 1);
		push(13, 2);
		System.out.println("Popped Value - " + pop(1));
		System.out.println("Popped Value - " + pop(2));
		System.out.println("Popped Value - " + pop(2));
	}
	
	/**
	 * Initialise each of the stack inner classes.
	 */
	private static void initialiseStacks() {
		
		for (int i = 0; i < numberOfStacks; i++) {
			int stackStartIndex = i * individualStackSize;
			StackInformation stackInformation = new StackInformation(stackStartIndex);
			stackInfo[i] = stackInformation;
		}
	}
	
	/**
	 * Push an item onto the top of a stack.
	 * @param value - The value to push.
	 * @param stackNumber - The stack to push on.
	 */
	private static void push(int value, int stackNumber) {
		// When we push, we need to check that we have the space to do so.
		// If we do not, then we need to re-allocate the array first which
		// means we need to update all its values and pointer locations.
		StackInformation currentStackInfo = stackInfo[stackNumber--];
		StackInformation nextStack = null;
		
		// Retrieve the information for the next stack.
		if (stackNumber != numberOfStacks) {
			nextStack = stackInfo[stackNumber];
		}
		else {
		}
		if ((nextStack != null && (currentStackInfo.availableIndex < nextStack.bottom))
				|| (currentStackInfo.availableIndex <= (entireStackSize - 1))) {
			
			// Push item onto stack.
			tripleStack[currentStackInfo.availableIndex] = value;
			currentStackInfo.top++;
			currentStackInfo.availableIndex++;
		}
		else {
			System.out.println("Stack Full!");
			// Out of space
		}
	}
	
	/**
	 * Pop an item from the top of a stack.
	 * @param stackNumber - The stack to pop from.
	 */
	private static int pop(int stackNumber) {
		int value = 0;
		StackInformation currentStackInfo = stackInfo[stackNumber--];
		value = tripleStack[currentStackInfo.top];
		currentStackInfo.top--;
		currentStackInfo.availableIndex--;
		
		// Will need to check if the stack is empty.
		return value;
	}
	
	/**
	 * The {@link StackInformation}.
	 * <p>
	 * This class contains information regarding each
	 * individual stack such as the top and start indices.
	 * <p>
	 * The array still maintains the stack values, this is a 
	 * helper class that holds the index information.
	 * <p>
	 * @author szeyick
	 */
	private static class StackInformation {
		
		/**
		 * Index of the top of the stack.
		 */
		public int top;
		
		/**
		 * Index of the bottom of the stack.
		 */
		public int bottom;
		
		/**
		 * Index of the available slot for the stack.
		 */
		public int availableIndex;
		
		/**
		 * The number of items in the stack.
		 */
		public int numberOfItemsInStack;
		
		/**
		 * Constructor.
		 */
		public StackInformation(int stackStartIndex) {
			top = stackStartIndex;
			bottom = stackStartIndex;
			availableIndex = stackStartIndex;
			numberOfItemsInStack = 0;
		}
	}
}
