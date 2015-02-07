package com.crackingTheCodingInterview.treesAndGraphs;

import com.crackingTheCodingInterview.treesAndGraphs.tree.Node;

/**
 * The {@link FirstCommonAncestor}
 * <p>
 * Design an algorithm and write code to find the first common
 * ancestor of two nodes in a binary tree. Avoid storing additional
 * nodes in a data structure. This is not neccessary in a BST.
 * <p>
 * This solution is for a binary tree, where the nodes are not placed
 * in any order. The idea here is to use a post-order traversal of the
 * binary tree so we pass what we've currently searched up, this results
 * in not having to search the tree repetitively if we do a top down search.
 * <p>
 * @author szeyick
 */
public class FirstCommonAncestorBinaryTree {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		Node root = buildRandomTree();
		
		Node node1 = root.leftChild.leftChild.leftChild;
		Node node2 = root.rightChild;
		Node commonAncestor = findFirstCommonAncestor(root, node1, node2);
		printResult(commonAncestor, node1, node2);
		
		node1 = root.leftChild.rightChild;
		node2 = root.leftChild.rightChild.rightChild;
		commonAncestor = findFirstCommonAncestor(root, node1, node2);
		printResult(commonAncestor, node1, node2);
		
		node1 = root.leftChild.leftChild.leftChild;
		node2 = root.leftChild.rightChild.rightChild;
		commonAncestor = findFirstCommonAncestor(root, node1, node2);
		printResult(commonAncestor, node1, node2);
		
		node1 = root.leftChild.leftChild.leftChild;
		node2 = null;
		commonAncestor = findFirstCommonAncestor(root, node1, node2);
		printResult(commonAncestor, node1, node2);
	}
	
	/**
	 * Print the results of the common ancestor.
	 * @param commonAncestor - The common ancestor
	 * @param node1 - The first node.
	 * @param node2 - The second node.
	 */
	private static void printResult(Node commonAncestor, Node node1, Node node2) {
		if (commonAncestor != null) {
			System.out.println("First common ancestor of " + node1.value + " and " + node2.value + " is : " + commonAncestor.value);
		}
		else if (node1 == null || node2 == null) {
			System.out.println("Invalid input.");
		}
		else {
			System.out.println(node1.value + " and "+ node2.value + " have no common ancestor.");
		}
	}
	
	/**
	 * Find the first common ancestor of two nodes in a binary tree.
	 * @param currentNode - The current node (sub-tree)
	 * @param node1 - The first node to find.
	 * @param node2 - The second node to find.
	 * @return - The common ancestor (where the two nodes first branch)
	 */
	private static Node findFirstCommonAncestor(Node currentNode, Node node1, Node node2) {
		if (node1 == null || node2 == null) {
			return null;
		}
		if (currentNode != null) {
			Node leftNode = findFirstCommonAncestor(currentNode.leftChild, node1, node2);
			Node rightNode = findFirstCommonAncestor(currentNode.rightChild, node1, node2);
			
			// If they are on either side then return the current node.
			if ((node1.equals(leftNode) || node2.equals(leftNode)) &&
					(node1.equals(rightNode) || node2.equals(rightNode))) {
				return currentNode;
			}
			if (currentNode.equals(node1)) {
				return node1;
			}
			if (currentNode.equals(node2)) {
				return node2;
			}
			if (leftNode != null) {
				return leftNode;
			}
			if (rightNode != null) {
				return rightNode;
			}
		}
		return null; // Reached the end of the tree.
	}
	
	/**
	 * Build a binary search tree.
	 * @return - The built tree.
	 */
	public static Node buildRandomTree() {
		Node root = createNode(15);
		root.leftChild = createNode(10);
		root.rightChild = createNode(4);
		root.leftChild.leftChild = createNode(25);
		root.leftChild.leftChild.rightChild = createNode(27);
		root.leftChild.leftChild.leftChild = createNode(13);
		root.leftChild.rightChild = createNode(25);
		root.leftChild.rightChild.rightChild = createNode(7);
		
		return root;
	}
	
	/**
	 * Create a new node.
	 * @param value - The value assigned to the node.
	 * @return a new instance of the node.
	 */
	private static Node createNode(int value) {
		return new Node(value);
	}
}
