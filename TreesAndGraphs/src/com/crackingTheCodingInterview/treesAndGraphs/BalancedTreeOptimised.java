package com.crackingTheCodingInterview.treesAndGraphs;

import com.crackingTheCodingInterview.treesAndGraphs.tree.Node;

/**
 * The {@link BalancedTreeOptimised}
 * <p>
 * This is an extension on the {@link BalancedTree}
 * where we optimise the isBalanced() method to
 * record the height of each subtree as we go along
 * rather than calling a height() method separately.
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
		
		isBalanced(tree, new HeightCount());
	}
	
	/**
	 * Evaluate to determine if a tree is balanced.
	 * <p>
	 * The idea here is to maintain references to the current height of
	 * the tree as we recurse along. 
	 * <p>
	 * @param currentNode - The current node visited.
	 * @param height - The current aggregate height of the tree.
	 * @return <code>true</code> if the tree is balanced, false otherwise.
	 */
	private static boolean isBalanced(Node currentNode, HeightCount height) {
		
		if (currentNode == null) {
			return false;
		}
		
		// How to know
		// Increment the count for the left
		isBalanced(currentNode.leftChild, height);
		isBalanced(currentNode.rightChild, height);
		
		return false;
	}

	/**
	 * Build a binary tree.
	 * @return - The built tree.
	 */
	public static Node buildTree() {
		Node root = createNode(5);
		root.leftChild = createNode(2);
		root.rightChild = createNode(6);
		root.rightChild.rightChild = createNode(7);
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
	
	/**
	 * 
	 * @author szeyick
	 *
	 */
	private static class HeightCount {
		
		int leftHeight;
		
		int rightHeight;
	}
}
