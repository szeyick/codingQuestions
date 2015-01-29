package com.crackingTheCodingInterview.stacksAndQueues;

import java.util.Random;

import com.crackingTheCodingInterview.stacksAndQueues.stack.Stack;


/**
 * The {@link StacksWithMin}
 * <p>
 * How would you design a stack, which in addition to push, pop
 * also has a function min which returns the minimum element
 * in the stack. Push, pop and min should all operate in O(1)
 * time.
 * <p>
 * The idea here would be to have a secondary stack which maintains
 * the current minimum element. You could also have an internal array
 * which holds the minimum elements, however there could be an overhead
 * of resizing the array if it becomes full. 
 * <p>
 * There is a need for a secondary stack since there is a need to maintain
 * the order of the elements. 
 * <p>
 * @author szeyick
 *
 */
public class StacksWithMin {

	/**
	 * The main stack that holds the stored values.
	 */
	private static Stack mainStack;
	
	/**
	 * A secondary stack that holds the current min
	 * value.
	 */
	private static Stack minStack;
	
	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		initialiseStacks();
		populateStacks();
		
		System.out.println();
		System.out.println("Smallest value is - " + minStack.peek());
		
		// When values are popped off the main stack they need to be popped
		// off the min stack as well. 
	}
	
	/**
	 * Initialise the main and min stacks.
	 */
	private static void initialiseStacks() {
		mainStack = new Stack();
		minStack = new Stack();
	}
	
	/**
	 * Populate the stacks with 
	 */
	private static void populateStacks() {
		int[] stackInput = new int[50];
		
		// Populate the stacks with all the values.
		for (int i = 0; i < stackInput.length; i++) {
			int currentValue = generateRandomNumber();
			System.out.print(currentValue + " ");
			// Only push the current value onto the min stack if it is smaller
			// than the current smallest value in the min stack.
			if (minStack.peek() == -1) {
				minStack.push(currentValue);
			}
			if (currentValue <= minStack.peek()) {
				minStack.push(currentValue);
			}
			mainStack.push(currentValue);
		}
	}
	
	/**
	 * @return a randomly generated number between
	 * low and high ranges.
	 */
	private static int generateRandomNumber() {
		Random r = new Random();
		int low = 0;
		int high = 100;
		return r.nextInt(high-low) + low;
	}
}
