package com.crackingTheCodingInterview.stacksAndQueues.queues;

/**
 * The {@link Queue}.
 * <p>
 * The class that represents a queue.
 * <p>
 * A queue contains a collection of {@link QueueNode}.
 * A queue contains the operations, enqueue, dequeue.
 * <p>
 * When we enqueue an item we add it to the back of the 
 * queue, and when we dequeue, we remove the item from
 * the front of the queue.
 * <p>
 * @author szeyick
 */
public class Queue {

	/**
	 * Node pointer to the front of the queue. 
	 */
	private QueueNode front;
	
	/**
	 * Node pointer to the last of the queue.
	 */
	private QueueNode last;
	
	/**
	 * Constructor.
	 */
	public Queue() {
		front = null;
		last = front;
	}
	
	/**
	 * Add an item to the queue. We add it to
	 * the back of the queue.
	 */
	public void enqueue(int value) {
		if (front == null) {
			last = new QueueNode(value);
			front = last;
		}
		else {
			last.next = new QueueNode(value);
			last = last.next;
		}
	}
	
	/**
	 * Remove an item from the queue. We remove
	 * the item at the front of the queue.
	 * @return - The item at the front of the queue.
	 */
	public int dequeue() {
		if (front != null) {
			QueueNode nodeToDequeue = front;
			front = front.next; // New front is the next item in the list
			return nodeToDequeue.value;
		}
		return -1;
	}
}
