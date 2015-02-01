package com.crackingTheCodingInterview.treesAndGraphs;

import com.crackingTheCodingInterview.treesAndGraphs.tree.Node;

/**
 * The {@link BalancedTree}.
 * <p>
 * Implement a function to check if a binary tree is balanced. For 
 * the purposes of this question, a balanced tree is defined to be a 
 * tree such that the heights of the two subtrees of any node never 
 * differ by more than one.
 * <p>
 * Tips - <br> 
 * A non empty tree is considered balanced if - <br>
 * <ol>
 * <li>The left subtree is balanced.</li>
 * <li>The right subtree is balanced.</li>
 * <li>The difference in height of the left and right subtree is no more
 *     than 1.</li>
 * </ol>
 * <p>
 * Please refer to treeBalancing file in resources folder for a description of the 
 * algorithm.
 * <p>
 * @author szeyick
 */
public class BalancedTree {

	
	/**
	 * The program main.
	 * @param args - Command line arguments
	 */
	public static void main(String[] args) {
		Node tree = buildTree();
		printTree(tree);
		
		System.out.println("The current height of the tree from the top is - " + findHeight(tree));
		
		System.out.println("Is the tree balanced - " + isBalanced(tree));
	}
	
	/**
	 * Evaluate to determine if a tree is balanced.
	 * @param currentNode - The current node visited.
	 * @return <code>true</code> if the tree is balanced, false otherwise.
	 */
	private static boolean isBalanced(Node currentNode) {
		// Base case - The current tree is balanced if empty.
		if (currentNode == null) {
			return true;
		}
		
		// Find the height of the current tree.
		int heightLeft = findHeight(currentNode.leftChild);
		int heightRight = findHeight(currentNode.rightChild);
		
		// Check to ensure that the difference in heights of the left
		// and right subtrees only differs by 1. Continue down the left
		// and right subtrees to make sure that they're balanced as well.
		if (getDifferenceInHeight(heightLeft, heightRight) && isBalanced(currentNode.leftChild)
				&& isBalanced(currentNode.rightChild)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Determine if the difference in height between the left and right
	 * subtrees is at most 1.
	 * @param left - The height of the left subtree.
	 * @param right - The height of the right subtree.
	 * @return <code>true</code> if the height difference is at most 1,
	 * <code>false</code> otherwise.
	 */
	private static boolean getDifferenceInHeight(int left, int right) {
		boolean balanced = false;
		if (left < right) {
			if ((right - left) <= 1) {
				balanced = true;
			}
		}
		else {
			if ((right - left) <= 1) {
				balanced = true;
			}
		}
		return balanced;
	}
	
	/**
	 * Find the height of the tree from the current node. The
	 * height of the tree is the length from the root to the
	 * longest node, either the left or right
	 * <p>.
	 * @param currentNode - The current root.
	 * @return the height of a tree.
	 */
	private static int findHeight(Node currentNode) {
		
		// Base case - The current tree height is empty if it is null.
		if (currentNode == null) {
			return 0;
		}
		
		// If tree is not empty, we add 1 and then continue the search down
		// the left and right subtree. We return the larger of the two found heights.
		return 1 + findMax(findHeight(currentNode.leftChild) , findHeight(currentNode.rightChild));
	}
	
	/**
	 * Return the larger height of the subtree.
	 * @param leftHeight - The height of the left subtree.
	 * @param rightHeight - The height of the right subtree.
	 * @return the height of the larger tree.
	 */
	private static int findMax(int leftHeight, int rightHeight) {
		
		// If the left subtree is larger than the right, then we return
		// the height of the left subtree.
		if (leftHeight > rightHeight) {
			return leftHeight;
		}
		else {
			// Otherwise the right subtree is larger.
			return rightHeight;
		}
	}
	
	/**
	 * Print the tree in-order.
	 * @param currentNode
	 */
	public static void printTree(Node currentNode) {
		if (currentNode != null) {
			printTree(currentNode.leftChild);
			System.out.println(currentNode.value);
			printTree(currentNode.rightChild);
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
}
