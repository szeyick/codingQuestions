package com.crackingTheCodingInterview.stacksAndQueues;

import com.crackingTheCodingInterview.stacksAndQueues.stack.SetOfStacks;


/**
 * The {@link SetOfStacksMain}
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
 * @author szeyick
 */
public class SetOfStacksMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		SetOfStacks stackSet = new SetOfStacks(3);
		stackSet.push(1);
		stackSet.push(2);
		stackSet.push(3);
		stackSet.push(4);
		stackSet.push(5);
		stackSet.push(6);

		stackSet.printStacks();
		stackSet.printStackCorrectly();
	}

}
