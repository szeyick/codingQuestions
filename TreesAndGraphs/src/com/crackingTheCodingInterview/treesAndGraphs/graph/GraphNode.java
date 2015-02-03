package com.crackingTheCodingInterview.treesAndGraphs.graph;

/**
 * The {@link GraphNode}
 * <p>
 * This class represents a node in an adjacency list.
 * It functions much like a single linked list node.
 * <p>
 * @author szeyick
 */
public class GraphNode {

	/**
	 * The value stored in the node.
	 */
	public int value;
	
	/**
	 * The next node in the adjacency list.
	 */
	public GraphNode next;
	
	/**
	 * The number of adjacent nodes.
	 */
	public int numberOfNeighbours;
	
	/**
	 * Constructor.
	 * @param valueTmp - The value to assign to this node.
	 */
	public GraphNode(int valueTmp) {
		value = valueTmp;
	}
	
	/**
	 * Add an adjacent node to this node.
	 * @param adjacentNode - The adjacent node.
	 * @param value - The value to add.
	 */
	public void addNode(int value) {
		numberOfNeighbours++;
		if (next == null) {
			next = new GraphNode(value);
		}
		else {
			add(next, value);
		}
	}
	
	/**
	 * Append a node to the end of this graph node.
	 * @param currentNode - The next node.
	 * @param value - The value to insert.
	 */
	private void add(GraphNode currentNode, int value) {
		if (currentNode.next == null) {
			currentNode.next = new GraphNode(value);
		}
		else {
			add(currentNode.next, value);
		}
	}
}
