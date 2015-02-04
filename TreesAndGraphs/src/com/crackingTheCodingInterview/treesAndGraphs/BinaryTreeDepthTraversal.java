package com.crackingTheCodingInterview.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.crackingTheCodingInterview.treesAndGraphs.tree.Node;

/**
 * The {@link BinaryTreeDepthTraversal}
 * <p>
 * Given a binary tree, design an algorithm which creates a
 * linked list of all the nodes at each height/level (i.e. If 
 * you have a tree with height H, you will have H linked lists).
 * <p>
 * This question is asking to build a linked list of nodes for each
 * level. So in a binary tree with 1 node, you're expected to have
 * 1 linked list, if we have a binary tree with 3 nodes (root, left 
 * and right child), you would have 2 linked lists.
 * <p>
 * An idea here is to perform a pre-order traversal that passes the
 * level in which we're currently on to its successors. As pre-order
 * traversals go layer by layer, we can create a linked list and
 * link it to the level as an index in an array.
 * <p>
 * @author szeyick
 */
public class BinaryTreeDepthTraversal {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		Node root = buildTree();
				
		List<LinkedList<Integer>> linkedListsList = new ArrayList<LinkedList<Integer>>();
		createLinkedLists(root, 0, linkedListsList);
		
		System.out.println("Number of Linked Lists - " + linkedListsList.size());
		// Print out the linked list by level.
		int level = 0;
		for (LinkedList<Integer> linkedList : linkedListsList) {
			System.out.print("Level - " + level + ": ");
			for (Integer value : linkedList) {
				System.out.print(value + "->");
			}
			System.out.println();
			level++;
		}
	}
	
	/**
	 * Create a linked list for each level.
	 * @param currentNode - The current node.
	 * @param level - The level that the node is on.
	 */
	private static void createLinkedLists(Node currentNode, int level, List<LinkedList<Integer>> linkedListsList) {
		if (currentNode != null) {			
			// Check to see if the linked list has been created for this level.
			LinkedList<Integer> linkedList = null;
			if (linkedListsList.size() == level) {
				linkedList = new LinkedList<Integer>();
				linkedList.add(currentNode.value);
				linkedListsList.add(level, linkedList);
			}
			else {
				linkedList = linkedListsList.get(level);
				linkedList.add(currentNode.value);
			}
			createLinkedLists(currentNode.leftChild, level + 1, linkedListsList);
			createLinkedLists(currentNode.rightChild, level + 1, linkedListsList);
		}
	}
	
	/**
	 * Build a binary tree.
	 * @return - The built tree.
	 */
	public static Node buildTree() {
		Node root = createNode(2);
		root.leftChild = createNode(1);
		root.rightChild = createNode(3);
		root.rightChild.rightChild = createNode(7);
		root.leftChild.leftChild = createNode(1);
		root.leftChild.rightChild = createNode(4);
		root.leftChild.rightChild.leftChild = createNode(3);
		
		return root;
	}
	
	/**
	 * Create a new node.
	 * @param value - The value to insert into the node.
	 * @return - The created node.
	 */
	private static Node createNode(int value) {
		return new Node(value);
	}
}