package com.crackingTheCodingInterview.miscellanous;

/**
 * Determine if a Binary Tree is a Binary Search Tree.
 * 
 * @author szeyick
 *
 */
public class IsBinarySearchTree {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.leftChild = new Node(5);
		root.rightChild = new Node(20);
		root.rightChild.leftChild = new Node(15);
		
		Node bst = isBinarySearchTree(root, null);
		if (bst == null) {
			System.out.println("Not a bst");
		}
		else {
			System.out.println("BST");
		}
	}

	/**
	 * @return true if the given tree is a binary search tree
	 */
	public static Node isBinarySearchTree(Node currentNode, Node parent)
	{
		if (currentNode != null) {
			Node leftNode = isBinarySearchTree(currentNode.leftChild, currentNode);
			Node rightNode = isBinarySearchTree(currentNode.rightChild, currentNode);
			
			// If both children are null we have hit the bottom of the tree.
			if (leftNode == null && rightNode == null) {
				return currentNode;
			}
			
			// Compare the left and right values with the current.
			if (leftNode != null && (leftNode.value > currentNode.value)) {
				return null;
			}
			if (rightNode != null && (rightNode.value < currentNode.value)) {
				return null;
			}
			// If we are in the left subtree, return the largest value.
			if (parent != null && (parent.leftChild == currentNode)) {
				Node largest = null;
				largest = getLargestNode(leftNode, rightNode);
				largest = getLargestNode(currentNode, largest);
				return largest;
			}
			else {
				// If we are in the right subtree, return the smallest value.
				Node smallest = null;
				smallest = getSmallestNode(leftNode, rightNode);
				smallest = getSmallestNode(currentNode, smallest);
				return smallest;
			}
		}
		return null;
	}
	
	public static Node getSmallestNode(Node nodeA, Node nodeB) {
		if (nodeA != null && nodeB != null) {
			return nodeA.value < nodeB.value ? nodeA : nodeB;
		}
		if (nodeA == null) {
			return nodeB;
		}
		return nodeA;
	}
	
	/**
	 * Return the largest node in the subtree.
	 * @param nodeA
	 * @param nodeB
	 * @return
	 */
	public static Node getLargestNode(Node nodeA, Node nodeB) {
		if (nodeA != null && nodeB != null) {
			return nodeA.value > nodeB.value ? nodeA : nodeB;
		}
		if (nodeA == null) {
			return nodeB;
		}
		return nodeA;
	}
	
	public static class Node {
		
		Node(int valueTmp) {
			value = valueTmp;
		}
		Node leftChild;
		Node rightChild;
		int value;
	}
}
