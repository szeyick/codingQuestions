package com.crackingTheCodingInterview.treesAndGraphs;

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
 * be inserted, must be the middle items in each side of the 
 * array.
 * <p>
 * @author szeyick
 */
public class BinarySearchTree {
	
	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
