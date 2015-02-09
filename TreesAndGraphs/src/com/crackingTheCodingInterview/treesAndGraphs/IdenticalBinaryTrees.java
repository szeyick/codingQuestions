package com.crackingTheCodingInterview.treesAndGraphs;

import com.crackingTheCodingInterview.treesAndGraphs.tree.Node;

/**
 * The {@link IdenticalBinaryTrees}
 * <p>
 * You have two very large binary trees: T1, with millions of 
 * nodes and T2 with hundreds of nodes. Create an algorithm to
 * decide if T2 is a subtree of T1.
 * 
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such
 * that the subtree of n is identical to T2. That is, if you cut off 
 * the tree at node n, the two trees would be identical.
 * <p>
 * @author szeyick
 */
public class IdenticalBinaryTrees {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		Node T1 = buildRandomTree();
		Node T2 = buildSmallerTree();
		
		Node matchingNode = search(T1, T2);
		if (isSameTree(matchingNode, T2)) {
			System.out.println("There is a subtree that matches.");
		}
		else {
			System.out.println("There is no subtree that matches.");
		}
	}
	
	/**
	 * Search the tree for a node.
	 * @param currentNode - The current node to search.
	 * @param nodeToFind - The node to find.
	 * @return The found node in the tree, null otherwise.
	 */
	private static Node search(Node currentNode, Node nodeToFind) {
		if (currentNode != null) {
			Node leftNode = search(currentNode.leftChild, nodeToFind);
			Node rightNode = search(currentNode.rightChild, nodeToFind);
			
			// If either node is not null it means that the matching node has
			// been found in a previous recursion.
			if (leftNode != null || rightNode != null) {
				return leftNode == null ? rightNode : leftNode; 
			}
			// Otherwise we compare the current node values.
			if (currentNode.value == nodeToFind.value) {
				return currentNode;
			}
			else {
				return null; // Return null if no match.
			}
		}
		return null;
	}
	
	/**
	 * Compare the two binary trees to determine if they are the same.
	 * @param currentT1Node - The current node in T1 tree.
	 * @param currentT2Node - The current node in T2 tree.
	 * @return <code>true</code> if the trees are the same, <code>false</code>
	 * otherwise.
	 */
	private static boolean isSameTree(Node currentT1Node, Node currentT2Node) {
		if (currentT1Node != null && currentT2Node != null) {
			boolean isLeftSame = isSameTree(currentT1Node.leftChild, currentT2Node.leftChild);
			boolean isRightSame = isSameTree(currentT1Node.rightChild, currentT2Node.rightChild);

			// If either is false it means that the trees differ so we return immediately
			if (!isLeftSame || !isRightSame) {
				return false;
			}
			// Otherwise we compare the nodes in the current value.
			if (currentT1Node.value == currentT2Node.value) {
				return true;
			}
			return false;
		}
		// If one current Tn node is null and the other isn't then the trees are not the same.
		if ((currentT1Node == null && currentT2Node != null) || (currentT1Node != null && currentT2Node == null)) {
			return false;
		}
		return true; // We have hit the bottom of both trees, both T1 and T2 are null therefore it still matches.
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
	 * Build a smaller binary tree.
	 * @return - The build tree.
	 */
	private static Node buildSmallerTree() {
		Node root = createNode(10);
		root.leftChild = createNode(25);
		root.rightChild = createNode(25);
		root.leftChild.leftChild = createNode(13);
		root.rightChild.rightChild = createNode(7);
		root.leftChild.rightChild = createNode(27);
		
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
