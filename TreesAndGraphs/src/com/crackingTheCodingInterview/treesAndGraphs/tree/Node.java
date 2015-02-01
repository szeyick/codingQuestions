package com.crackingTheCodingInterview.treesAndGraphs.tree;

/**
 * The {@link Node}.
 * <p>
 * This class represents an individual node in
 * a binary tree. It contains three variables, 
 * the value that the node contains along with pointers
 * to its left and right subtree.
 * <p>
 * For simplicity, the variables are declared as public.
 * <p>
 * @author szeyick
 */
public class Node {

	/**
	 * The value stored in this node.
	 */
	public int value;
	
	/**
	 * A reference to this nodes left child.
	 */
	public Node leftChild;
	
	/**
	 * A reference to this nodes right child.
	 */
	public Node rightChild;
	
	/**
	 * Constructor.
	 * @param valueTmp - The value to assign to this
	 * node.
	 */
	public Node(int valueTmp) {
		value = valueTmp;
		leftChild = null;
		rightChild = null;
	}
}
