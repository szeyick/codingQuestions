package com.crackingTheCodingInterview.treesAndGraphs;

import com.crackingTheCodingInterview.treesAndGraphs.tree.Node;

/**
 * The {@link IsBinaryTreeABinarySearchTree}
 * <p>
 * Implement a function to check if a binary tree is
 * a binary search tree.
 * <p>
 * A binary tree will be a BST if it satisfies the conditions <br>
 * <ol>
 * <li> All children in its left subtree are smaller than the root. </li>
 * <li> All children in its right subtree are larger than the root. </li> 
 * </ol>
 * <p>
 * This means that we need to pass the values in the left and right subtrees
 * back to the current node and compare the values. If they do not satisfy
 * the BST conditions, then we need to terminate immediately and return.
 * <p>
 * A solution would be to perform a post-order traversal so we go bottom up
 * to pass the values back to the current node to evaluate. Refer to the
 * binaryTreeIsABinarySearchTree text file in resources for algorithm.
 * <p>
 * @author szeyick
 */
public class IsBinaryTreeABinarySearchTree {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		Node binaryTree1 = buildBinaryTree();
		Node binaryTree2 = buildBinarySearchTree();
		Node binaryTree3 = buildRandomTree();
		Node binaryTree4 = buildATree();
		
		System.out.println("Is binary tree a BST - " + isBST(binaryTree1));
		System.out.println("Is binary tree a BST - " + isBST(binaryTree2));
		System.out.println("Is binary tree a BST - " + isBST(binaryTree3));
		System.out.println("Is binary tree a BST - " + isBST(binaryTree4));
	}
	
	/**
	 * @param root - The root of the tree to evaluate.
	 * @return <code>true</code> if the tree is a BST,
	 * <code>false</code> otherwise.
	 */
	private static boolean isBST(Node root) {
		return evaluateTree(root) != -1 ? true : false;
	}
	
	/**
	 * The recursive method that performs a post order
	 * traversal of the tree to determine if it is a 
	 * BST or not. This recursion will go all the way to the 
	 * bottom of the tree then work its way back up to the top.
	 * <p.
	 * @param currentNode - The current tree node.
	 * @return -1 if the tree is not a BST, 0 if we have
	 * reached a leaf (no children/null) or return the
	 * highest value found (left, current, right) of the
	 * tree.
	 */
	private static int evaluateTree(Node currentNode) {
		// Iterate to the bottom.
		if (currentNode != null) {
			// Obtain the values in the left and right subtrees
			int leftChildValue = evaluateTree(currentNode.leftChild);
			int rightChildValue = evaluateTree(currentNode.rightChild);
			
			// Check if the tree is a BST once we've come back from the children.
			if (leftChildValue == -1 || rightChildValue == -1) {
				// Immediately return to the top if it is already been evaluated in the
				// child nodes that the tree is not a BST.
				return -1; 
			}
			// If the current node is not a leaf (0) and its children violate the BST
			// conditions, then we return -1 to indicate that it is not a BST.
			if ((leftChildValue > currentNode.value && leftChildValue != 0) ||
				(rightChildValue < currentNode.value && rightChildValue != 0)) {
				return -1;
			}
			// Otherwise we return the largest value we've found in either child or node
			return findMax(leftChildValue, rightChildValue, currentNode.value);
		}
		return 0; // We have reached a leaf (null)
	}
	
	/**
	 * Find the largest value of the node.
	 * @param leftValue - The value in the left child.
	 * @param rightValue - The value in the right child.
	 * @param currentValue - The current value in the node.
	 * @return the largest value.
	 */
	private static int findMax(int leftValue, int rightValue, int currentValue) {
		return Math.max(currentValue, Math.max(leftValue, rightValue));
	}
	
	/**
	 * Build a binary tree.
	 * @return - The built tree.
	 */
	private static Node buildBinaryTree() {
		Node root = createNode(5);
		root.leftChild = createNode(12);
		root.rightChild = createNode(6);
		root.rightChild.rightChild = createNode(9);
		root.leftChild.leftChild = createNode(3);
		root.leftChild.rightChild = createNode(5);
		root.leftChild.rightChild.leftChild = createNode(8);
		
		return root;
	}
	
	/**
	 * Build a binary search tree.
	 * @return - The built tree.
	 */
	private static Node buildBinarySearchTree() {
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
	 * Build a binary search tree.
	 * @return - The built tree.
	 */
	public static Node buildRandomTree() {
		Node root = createNode(20);
		root.leftChild = createNode(10);
		root.rightChild = createNode(30);
		root.leftChild.leftChild = createNode(5);
		root.leftChild.leftChild.rightChild = createNode(7);
		root.leftChild.leftChild.leftChild = createNode(3);
		root.leftChild.rightChild = createNode(15);
		root.leftChild.rightChild.rightChild = createNode(17);
		
		return root;
	}
	
	/**
	 * Build a binary search tree.
	 * @return - The built tree.
	 */
	public static Node buildATree() {
		Node root = createNode(20);
		root.leftChild = createNode(10);
		root.rightChild = createNode(30);
		root.leftChild.rightChild = createNode(25);
		
		return root;
	}

	/**
	 * Create a new node.
	 * @param value - The value assigned to the node.
	 * @return - A initialised instance of the node.
	 */
	private static Node createNode(int value) {
		return new Node(value);
	}
}
