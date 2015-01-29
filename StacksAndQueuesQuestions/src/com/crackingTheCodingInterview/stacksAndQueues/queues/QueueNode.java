package com.crackingTheCodingInterview.stacksAndQueues.queues;

/**
 * The {@link QueueNode}.
 * <p>
 * This class represents a single node in a
 * queue. Each node will contain a value and
 * a reference to the next node in the queue.
 * <p>
 * @author szeyick
 */
public class QueueNode {

	/**
	 * The value associated to the node.
	 */
	public int value;
	
	/**
	 * A pointer reference to the next node
	 * in the queue.
	 */
	public QueueNode next;
	
	/**
	 * Constructor.
	 * @param valueTmp - The value to store in the node.
	 */
	public QueueNode(int valueTmp) {
		value = valueTmp;
		next = null;
	}
}
