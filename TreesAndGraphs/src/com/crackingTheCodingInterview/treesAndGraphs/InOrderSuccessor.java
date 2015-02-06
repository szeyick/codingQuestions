package com.crackingTheCodingInterview.treesAndGraphs;

/**
 * The {@link InOrderSuccessor}
 * <p>
 * Write an algorithm to find the "next" node or its
 * in-order successor of a given node in a binary search
 * tree. You may assume that each node has a link to its
 * parent.
 * <p>
 * The link to its parent will allow us to determine if the
 * current node is a left or right child of its parent. If it
 * is the left child, its "next" is its parent, whereas if it
 * is the right child, its "next" will be the smallest child
 * of its grandparent. 
 * <p>
 * The inorder successor of a left child is its parent. <br>
 * The inorder successor of a right child, if it is on the right of its
 * grand parent will be the smallest value in its right child.
 * The inorder success of a right child, if it is on the left side of its
 * grandparent will be the smallest value in its grandparents right child.
 * <p>
 * @author szeyick
 */
public class InOrderSuccessor {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
