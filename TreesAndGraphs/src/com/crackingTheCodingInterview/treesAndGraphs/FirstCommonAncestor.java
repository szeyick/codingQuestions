package com.crackingTheCodingInterview.treesAndGraphs;

import com.crackingTheCodingInterview.treesAndGraphs.tree.Node;

/**
 * The {@link FirstCommonAncestor}
 * <p>
 * Design an algorithm and write code to find the first common
 * ancestor of two nodes in a binary tree. Avoid storing additional
 * nodes in a data structure. This is not neccessary in a BST.
 * <p>
 * @author szeyick
 */
public class FirstCommonAncestor {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		Node root = buildTree();
		
		int value1 = 3;
		int value2 = 17;
		Node firstCommonAncestor = findFirstCommonAncestor(root, value1, value2);
		if (firstCommonAncestor != null) {
			System.out.println("First common ancestor of " + value1 + " and " + value2 + " is : " + firstCommonAncestor.value);
		}
		else {
			System.out.println(value1 + " and " + value2 + " have no common ancestor.");
		}
	}
	
	/**
	 * Find the first common ancestor. The first common ancestor is defined as the
	 * node where the values we want to find do not go down the same path (one goes
	 * left and the other goes right).
	 * @param currentNode - The current node.
	 * @param value1 - The first value.
	 * @param value2 - The second value.
	 * @return the first common ancestor, null otherwise.
	 */
	private static Node findFirstCommonAncestor(Node currentNode, int value1, int value2) {
		if (currentNode != null) {
			// Check to see if the current node contains either of the two values we want.
			if (currentNode.value == value1 || currentNode.value == value2) {
				// If it does, then the current node is the first common ancestor.
				// Verify that the other values exist first.
				int valueToSearch = currentNode.value == value1 ? value2 : value1;
				boolean exists = valueExists(currentNode, valueToSearch);
				if (exists) {
					return currentNode;
				}
				else {
					return null;
				}
			}
			// Pick a direction to go in the tree.
			if (value1 < currentNode.value && value2 < currentNode.value) {
				return findFirstCommonAncestor(currentNode.leftChild, value1, value2);
			}
			else if (value1 > currentNode.value && value2 > currentNode.value) {
				return findFirstCommonAncestor(currentNode.rightChild, value1, value2);
			}
			else {
				// The values will separate. Verify that they both exist in the tree
				boolean value1Exists = valueExists(currentNode, value1);
				boolean value2Exists = valueExists(currentNode, value2);
				if (value1Exists && value2Exists) {
					return currentNode;
				}
				return null;
			}
		}
		return null;
	}
	
	/**
	 * Search a tree for a value.
	 * @param currentNode - The current node.
	 * @param value - The value to find.
	 * @return <code>true</code> if the value exists, <code>false</code>
	 * otherwise.
	 */
	private static boolean valueExists(Node currentNode, int value) {
		if (currentNode != null) {
			if (currentNode.value == value) {
				return true;
			}
			if (value < currentNode.value) {
				return valueExists(currentNode.leftChild, value);
			}
			else {
				return valueExists(currentNode.rightChild, value);
			}
		}
		return false;
	}
	
	/**
	 * Build a binary search tree.
	 * @return - The built tree.
	 */
	private static Node buildTree() {
		Node root = createNode(20);
		root.leftChild = createNode(10);
		root.rightChild = createNode(30);
		root.leftChild.leftChild = createNode(5);
		root.leftChild.leftChild.rightChild = createNode(7);
		root.leftChild.leftChild.leftChild = createNode(3);
		root.leftChild.rightChild = createNode(15);
		root.leftChild.rightChild.leftChild = createNode(12);
		root.leftChild.rightChild.rightChild = createNode(17);

		return root;
	}

	/**
	 * Create a new instance of the node with a parent pointer.
	 * @param value - The value to store in the node.
	 * @param parent - A reference to its parent.
	 * @return The created node.
	 */
	private static Node createNode(int value) {
		return new Node(value);
	}
}
