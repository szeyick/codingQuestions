package com.codingQuestions.main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The CycleDetectorTest.
 * <p>
 * This class is responsible for creating tests for
 * the {@link CycleDetector}.
 * <p>
 * @author szeyick
 */
public class CycleDetectorTest {

	/**
	 * Test that no cycle exists.
	 */
	@Test
	public void testNoCycle() {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		
		one.setNext(two);
		two.setNext(three);
		
		CycleDetector detector = new CycleDetector();
		assertFalse("Expected no cycle", detector.hasCycle(one));
	}
	
	/**
	 * Test that no cycle exists.
	 */
	@Test
	public void testCycle() {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		
		one.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(two);
		
		CycleDetector detector = new CycleDetector();
		assertTrue("Expected no cycle", detector.hasCycle(one));
	}
}
