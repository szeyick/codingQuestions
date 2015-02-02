package com.crackingTheCodingInterview.treesAndGraphs;

import com.crackingTheCodingInterview.treesAndGraphs.tree.Node;

/**
 * The {@link BalancedTreeOptimised}
 * <p>
 * This class represents an optimised version of the
 * tree balancing algorithm. The idea in this version 
 * is to push both the height finding and checking onto
 * the same method checkHeight(...) rather than performing
 * them in two different methods. This reduces the overall 
 * time complexity of the algorithm to O(N) since we do not
 * need to additionally iterate through the tree to check
 * the height and balance each time
 * <p>
 * @author szeyick
 */
public class BalancedTreeOptimised {
	
	/**
	 * The program main.
	 * @param args - The command line arguments.
	 */
	public static void main(String[] args) {
		Node tree = buildTree();
		
		System.out.println("Is tree balanced - " + isBalanced(tree));
	}
	
	/**
	 * Check the height of the tree.
	 * <p>
	 * This method works by recursing through the tree and checking
	 * both the height and balance at the same time. The height is checked
	 * by calling checkHeight on its left and right children, where the balance
	 * is called by determining whether the difference in height of its left 
	 * and right children is greater than 1.
	 * @param currentNode - The current root of the tree/subtree.
	 * @return -1 if the tree is unbalanced, otherwise return its actual height.
	 */
	private static int checkHeight(Node currentNode) {
		
		// Base case (if tree is empty)
		if (currentNode == null) {
			return 0;
		}
		
		// Find the height of its left and right children and check if the subtrees are balanced.
		int leftHeight = checkHeight(currentNode.leftChild);
		if (leftHeight == -1) {
			return -1; // Immediately return -1 if the height is -1;
		}
		int rightHeight = checkHeight(currentNode.rightChild);
		if (rightHeight == -1) {
			return -1;
		}
		
		int heightDifference = 0; // Check to see if the current node is balanced.
		// This check is done to ensure that we're subtracting the smaller from the larger so
		// we don't have a negative height.
		if (leftHeight > rightHeight) {
			heightDifference = leftHeight - rightHeight;
		}
		else {
			heightDifference = rightHeight - leftHeight;
		}
		// Return the height if the difference is at most 1.
		if (heightDifference <= 1) {
			return Math.max(leftHeight, rightHeight) + 1;
		}
		else {
			return -1; // Returning -1 means the tree is unbalanced.
		}
	}
	
	/**
	 * Evaluate to determine if a tree is balanced.
	 * <p>
	 * The idea here would be to get the checkHeight() method to 
	 * do all the recursing through the tree. 
	 * <p>
	 * @param currentNode - The current node visited.
	 * @return <code>true</code> if the tree is balanced, false otherwise.
	 * The tree is unbalanced if the returned value from checkHeight is -1,
	 * otherwise any other value will be the actual height of the tree.
	 */
	private static boolean isBalanced(Node currentNode) {
		if(checkHeight(currentNode) == -1) {
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * Build a binary tree.
	 * @return - The built tree.
	 */
	public static Node buildTree() {
		Node root = createNode(5);
		root.leftChild = createNode(2);
		root.rightChild = createNode(6);
//		root.rightChild.rightChild = createNode(7);
		root.leftChild.leftChild = createNode(1);
		root.leftChild.rightChild = createNode(4);
		root.leftChild.rightChild.leftChild = createNode(3);
		
		return root;
	}
	
	/**
	 * Create a node to attach to the tree.
	 * @param value - The value to store in the node.
	 * @return The new node.
	 */
	private static Node createNode(int value) {
		return new Node(value);
	}
}
