package com.crackingTheCodingInterview.stringQuestions.dataStructures;

/**
 * The {@link Node} class.
 * <p>
 * This class represents a single node
 * in a binary search tree.
 * <p>
 * <b>Note: For the sake of the example question, this
 * node will only perform insertion and search </b>
 * 
 * @author szeyick
 *
 */
public class Node {

	/**
	 * The current value held by this node
	 */
	public char value;
	
	/**
	 * The left child as a {@link Node}.
	 */
	public Node leftChild;
	
	/**
	 * The right child as a {@link Node}.
	 */
	public Node rightChild;
	
	/**
	 * Constructor
	 * @param value - The value to assign to the node.
	 * @return - An instance of the node.
	 */
	public Node (char value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	/**
	 * Print the contents of the tree.
	 */
	public void print() {
		printTree(this);
	}
	
	/**
	 * Print the nodes in the tree. (Inorder Traversal)
	 * @param node - The current node.
	 */
	public void printTree(Node node) {
		if (node != null) {
			printTree(node.leftChild);
			System.out.print(node.value);
			printTree(node.rightChild);
		}
	}
	
	/**
	 * Search the node for a given value.
	 * @param value - The search value.
	 * @return <code>true</code> if the value exists in the tree
	 * <code>false</code> otherwise.
	 */
	public boolean search(char value) {
		if (this.value == value) {
			return true;
		}
		if (this.value < value) {
			// If the search value is greater than current we go search the right child.
			if (rightChild != null) {
				return rightChild.search(value);
			}
			else {
				// We have reached the bottom of the tree so no value is found
				return false;
			}
		}
		else {
			if (leftChild != null) {
				return leftChild.search(value); // If the left child exists we go that direction.
			}
			else {
				return false; // We have reached the bottom of the tree so the value is not found.
			}
		}
	}
	
	/**
	 * Insert a value into the binary search tree.
	 * @param valueTmp - The value to insert.
	 */
	public void insert(char valueTmp) {
		if (this.value < valueTmp) {
			// Has to be inserted into the right subtree.
			if (rightChild != null) {
				rightChild.insert(valueTmp); // The right child exists so we need to continue to find a free slot
			}
			else {
				rightChild = new Node(valueTmp);
			}
		}
		else if (this.value > valueTmp) {
			if (leftChild != null) {
				leftChild.insert(valueTmp);
			}
			else {
				leftChild = new Node(valueTmp);
			}
		}
	}
}
