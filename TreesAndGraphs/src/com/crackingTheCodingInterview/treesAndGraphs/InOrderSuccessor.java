package com.crackingTheCodingInterview.treesAndGraphs;

import com.crackingTheCodingInterview.treesAndGraphs.tree.Node;

/**
 * The {@link InOrderSuccessor}
 * <p>
 * Write an algorithm to find the "next" node or its
 * in-order successor of a given node in a binary search
 * tree. You may assume that each node has a link to its
 * parent.
 * <p>
 * This is similar to how a in-order tree traversal would
 * work.
 * <p>
 * <ol>
 * <li> If a node has no children and it a left child - its in-order successor is its parent. </li>
 * <li> If a node has a right child, its in-order successor is the smallest node in the right subtree. </li>
 * <li> If a node has no children and is a right child, its in-order successor is a the parent of one of
 *      its ancestor nodes that is a left child, otherwise it is the largest node in the tree. </li> 
 * </ol>
 * <p>  
 * @author szeyick
 */
public class InOrderSuccessor {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		Node root = buildRandomTree();

		Node currentNode = root.leftChild;
		Node inOrderSuccessor = findInOrderSuccessor(currentNode);
		printResult(currentNode, inOrderSuccessor);

		currentNode = root.leftChild.leftChild.leftChild;
		inOrderSuccessor = findInOrderSuccessor(currentNode);
		printResult(currentNode, inOrderSuccessor);

		currentNode = root.leftChild.leftChild.rightChild;
		inOrderSuccessor = findInOrderSuccessor(currentNode);
		printResult(currentNode, inOrderSuccessor);

		currentNode = root.rightChild;
		inOrderSuccessor = findInOrderSuccessor(currentNode);
		printResult(currentNode, inOrderSuccessor);

		currentNode = root.leftChild.rightChild.rightChild;
		inOrderSuccessor = findSmallestAncestorUpdated(currentNode);
		printResult(currentNode, inOrderSuccessor);	
	}

	/**
	 * Print the results.
	 * @param currentNode - The current node to find the successor of.
	 * @param inOrderSuccessor - The current nodes in-order successor.
	 */
	private static void printResult(Node currentNode, Node inOrderSuccessor) {
		if (inOrderSuccessor == null) {
			System.out.println(currentNode.value + " has no in-order successor");
		}
		else {
			System.out.println("The in order successor of " + currentNode.value + " is " + inOrderSuccessor.value);
		}
	}

	/**
	 * Find the in-order successor to the current node.
	 * @param currentNode - The node to find the successor of.
	 * @return - Its in-order successor or null if it is the
	 * largest item in the tree.
	 */
	private static Node findInOrderSuccessor(Node currentNode) {

		// If tree is empty
		if (currentNode == null) {
			return null;
		}
		if (currentNode.rightChild != null) {
			// Find the smallest item in its right subtree.
			return findSmallestItem(currentNode.rightChild);
		}
		else if (currentNode == currentNode.parent.leftChild) {
			// If the current node is the left child of its parent,
			// its in-order successor its the parent.
			return currentNode.parent;
		}
		else {
			// It has to be a right child of its parent.
			// Find where its ancestor is a left child and the it will be above.
			// Otherwise we should get to a null condition.
			return findSmallestAncestor(currentNode);
		}
	}

	/**
	 * Find the smallest item in a tree. Smallest item generally
	 * is the left most item in a tree.
	 * @param currentNode - The current root of the tree.
	 * @return The smallest item in the tree, null if it is
	 * empty.
	 */
	private static Node findSmallestItem(Node currentNode) {
		if (currentNode.leftChild != null) {
			return findSmallestItem(currentNode.leftChild);
		}
		return currentNode;
	}

	/**
	 * Find the smallest ancestor. The smallest ancestor
	 * will be a parent is a left child of its parent.
	 * @param currentNode - The current node 
	 * @return - The smallest ancestor or null of it is
	 * the largest item in the tree.
	 */
	private static Node findSmallestAncestor(Node currentNode) {
		if (currentNode.parent.parent != null) {
			// Check to see if its parent is a left child
			if (currentNode.parent == currentNode.parent.parent.leftChild) {
				return currentNode.parent.parent;
			}
			// Otherwise go up a step.
			else {
				return findSmallestAncestor(currentNode.parent);
			}
		}
		return null;
	}

	/**
	 * Find the smallest ancestor. The smallest ancestor will
	 * be a parent of the current node who is a left node of
	 * its own parent.
	 * @param currentNode - The current node.
	 * @return - The smallest ancestor or null if it is the largest item
	 * in the tree.
	 */
	private static Node findSmallestAncestorUpdated(Node currentNode) {
		if (currentNode.parent != null) {
			if (currentNode.parent.rightChild == currentNode) {
				// If the current node is still a right child of its parent then
				// we go up the tree again.
				return findSmallestAncestor(currentNode.parent);
			}
			else {
				// Otherwise it is a left node and we return its parent.
				return currentNode.parent;
			}
		}
		return null;
	}

	/**
	 * Build a binary search tree.
	 * @return - The built tree.
	 */
	private static Node buildRandomTree() {
		Node root = createNode(20, null);
		root.leftChild = createNode(10, root);
		root.rightChild = createNode(30, root);
		root.leftChild.leftChild = createNode(5, root.leftChild);
		root.leftChild.leftChild.rightChild = createNode(7, root.leftChild.leftChild);
		root.leftChild.leftChild.leftChild = createNode(3, root.leftChild.leftChild);
		root.leftChild.rightChild = createNode(15, root.leftChild);
		root.leftChild.rightChild.leftChild = createNode(12, root.leftChild.rightChild);
		root.leftChild.rightChild.rightChild = createNode(17, root.leftChild.rightChild);

		return root;
	}

	/**
	 * Create a new instance of the node with a parent pointer.
	 * @param value - The value to store in the node.
	 * @param parent - A reference to its parent.
	 * @return The created node.
	 */
	private static Node createNode(int value, Node parent) {
		Node node = new Node(value);
		node.parent = parent;
		return node;
	}
}
