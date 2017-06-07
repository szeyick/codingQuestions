package com.codingQuestions.main;

/**
 * The CycleDetectorMain.
 * <p>
 * This class is the application main for cycle detector. It
 * provides the entry point into the application.
 * <p>
 * @author szeyick
 */
public class CycleDetectorMain {

	/**
	 * The program main.
	 * @param args - Command line arguments.
	 */
	public static void main(String[] args) {
		CycleDetector detector = new CycleDetector();
		Node head = buildLinkedList();
		
		System.out.println("Cycle Detected: " + detector.hasCycle(head));
	}
	
	/**
	 * @return a linked list.
	 */
	private static Node buildLinkedList() {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = two;
		return one;
	}
}