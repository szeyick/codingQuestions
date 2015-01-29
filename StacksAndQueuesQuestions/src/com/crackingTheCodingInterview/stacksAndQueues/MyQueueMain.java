package com.crackingTheCodingInterview.stacksAndQueues;

import com.crackingTheCodingInterview.stacksAndQueues.stack.MyQueue;

/**
 * The {@link MyQueueMain}.
 * <p>
 * This is the main program that demonstrates how to implement
 * a queue using two stacks. The basis of this is to use a second
 * stack as a staging area so we can always place the new item at the
 * bottom of the main stack. So when we "pop" from our stack it returns
 * the item at the front of the queue.
 * <p>
 * @author szeyick
 */
public class MyQueueMain {

	/**
	 * The queue implemented as two stacks.
	 */
	private static MyQueue myQueue;
	
	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		myQueue = new MyQueue();
		initialiseQueue();
		dequeueAll();
	}
	
	/**
	 * Initialise the values in the queue.
	 */
	private static void initialiseQueue() {
		for (int i = 0; i < 10; i++) {
			myQueue.enqueue(i);
		}
	}
	
	/**
	 * Dequeue all the items in the queue.
	 */
	private static void dequeueAll() {
		while (myQueue.head() != -1) {
			System.out.println("Item at the head of the queue is - " + myQueue.dequeue());
		}
	}
}
