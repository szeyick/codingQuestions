package com.crackingTheCodingInterview.treesAndGraphs;

import com.crackingTheCodingInterview.treesAndGraphs.tree.Node;

/**
 * The {@link BinarySearchTree}
 * <p>
 * Given a sorted (increasing order) array with unique
 * integer elements, write an algorithm to create a
 * binary search tree with minimal height
 * <p>
 * The trick in this question is that the array is ordered.
 * Because of the structure of a BST, if we insert the items
 * in order, it will create a skewed tree as all items inserted
 * in order will be larger than its predecessor making the tree
 * essentially a linked list.
 * <p>
 * To create a tree with minimal height, the items selected to
 * be at the node of each tree should be the middle value of the
 * sub-array.
 * <p>
 * @author szeyick
 */
public class BinarySearchTree {
	
	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		int[] orderedArray = initialiseArray();
		
		Node rootNode = buildTree(orderedArray);
		printOrderedTree(rootNode);
		System.out.println();
		printPreOrderTree(rootNode);
	}
	
	/**
	 * Recursively print the tree in order.
	 * @param currentNode - The current node.
	 */
	private static void printOrderedTree(Node currentNode) {
		if (currentNode != null) {
			printOrderedTree(currentNode.leftChild);
			System.out.print(currentNode.value + " -> ");
			printOrderedTree(currentNode.rightChild);
		}
	}
	
	/**
	 * Recursively print the tree in pre-order which means to 
	 * print them in its tree structure.
	 * @param currentNode - The current node.
	 */
	private static void printPreOrderTree(Node currentNode) {
		if (currentNode != null) {
			System.out.print(currentNode.value + " -> ");
			printPreOrderTree(currentNode.leftChild);
			printPreOrderTree(currentNode.rightChild);
		}
	}
	
	/**
	 * Build a binary search tree.
	 * @param input - The input to insert into the tree.
	 * @return the root node of the tree.
	 */
	private static Node buildTree(int[] input) {
		return buildMinBST(input, 0, input.length - 1);
	}
	
	/**
	 * Recursively create the nodes of a binary search tree.
	 * @param input - The array that holds the input.
	 * @param low - The lowest index of the array.
	 * @param high - The highest index of the array.
	 * @return - a node of the binary search tree.
	 */
	private static Node buildMinBST(int[] input, int low, int high) {
		// Establish base case
		if (low > high) {
			return null; // We have reached the end of the array.
		}
		int middleIndex = (high + low) / 2;
		Node root = new Node(input[middleIndex]);
		// Do not include the middle index when we recurse since we have already
		// added that value.
		root.leftChild = buildMinBST(input, low, middleIndex - 1);
		root.rightChild = buildMinBST(input, middleIndex + 1, high);
		
		return root;
	}
	
	/**
	 * @return - Create an ordered array and return.
	 */
	private static int[] initialiseArray() {
		int[] array = new int[3];
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		return array;
	}
}
