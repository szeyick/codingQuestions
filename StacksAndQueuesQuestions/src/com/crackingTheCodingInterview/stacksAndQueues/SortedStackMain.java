package com.crackingTheCodingInterview.stacksAndQueues;

import java.util.Random;

import com.crackingTheCodingInterview.stacksAndQueues.stack.SortedStack;

/**
 * The {@link SortedStackMain}.
 * <p>
 * Write a program to sort a stack in ascending order (the biggest
 * items on top). You may use at most one additional stack to hold items,
 * but you may not copy the elements into any other data structure (such as an 
 * array). The stack supports the following operations: push, pop, peek and isEmpty.
 * <p>
 * Solution - <br>
 * The solution here is to use the secondary stack as a buffer area. When we want to insert
 * an item we check against the existing items in the stack to its correct position. If the item
 * is smaller than the item at the top most value in the stack, we pop the top most item onto the 
 * secondary stack and continue this comparison with the rest of the items in the stack. We insert the
 * item onto the main stack when we hit a situation where the main stack is empty or if the value to 
 * insert is larger than the item that is currently on top.
 * <br>
 * Once we hit that situation we know that it is the correct spot as all the items below it must be smaller
 * than the item we want to insert and all the items that we have popped off onto the secondary stack must
 * be larger than the item we want to insert, preserving the order.
 * <p>
 * @author szeyick
 */
public class SortedStackMain {

	/**
	 * The sorted stack.
	 */
	private static SortedStack sortedStack;
	
	/**
	 * An unsorted order of the stack elements.
	 */
	private static int[] unsortedOrder;
	
	/**
	 * The program main.
	 * @param args - Command Line Arguments.
	 */
	public static void main(String[] args) {
		sortedStack = new SortedStack();
		unsortedOrder = new int[30];
		initialiseSortedStack();
		
		// Print the original and sorted order.
		printValues();
	}

	/**
	 * Initialise the stack with random values.
	 * @param sortedStack - The stack to initailise.
	 */
	private static void initialiseSortedStack() {
		for (int i = 0; i < 30; i++) {
			int value = generateRandomNumber();
			unsortedOrder[i] = value;
			sortedStack.push(value);
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
	
	/**
	 * Print the values in the stack and the
	 * original unsorted order.
	 */
	private static void printValues() {
		System.out.print("Original Order (unsorted): " );
		for (int i = 0; i < unsortedOrder.length; i++) {
			System.out.print(unsortedOrder[i] + " ");
		}
		System.out.println();
		System.out.print("Stack Order (sorted): " );
		while (sortedStack.peek() != -1) {
			System.out.print(sortedStack.pop() + " ");
		}
		System.out.println();
		System.out.println("Stack is empty: " + sortedStack.isEmpty());
	}
}
