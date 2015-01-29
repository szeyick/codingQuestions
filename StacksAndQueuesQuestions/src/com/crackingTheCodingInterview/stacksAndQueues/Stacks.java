package com.crackingTheCodingInterview.stacksAndQueues;

import com.crackingTheCodingInterview.stacksAndQueues.stack.Stack;

/**
 * The {@link Stacks}
 * <p>
 * This class represents how a stack functions with the
 * push and pop values.
 * <p>
 * @author szeyick
 */
public class Stacks {

	/**
	 * The Program Main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		Stack stack = new Stack();
		initialiseStack(stack);
		
		// See the values.
		System.out.println("Top most value is - " + stack.peek());
		stack.pop();
		System.out.println("Popping Value");
		System.out.println("Top most value is - " + stack.peek());
	}

	/**
	 * Initialise the stack with some values.
	 * @param stack - The stack.
	 */
	private static void initialiseStack(Stack stack) {
		for (int i = 0; i < 10; i++) {
			stack.push(i);
		}
	}
}
