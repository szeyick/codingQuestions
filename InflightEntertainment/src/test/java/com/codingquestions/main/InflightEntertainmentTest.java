package com.codingquestions.main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The InflightEntertainmentTest.
 * <p>
 * This class is responsible for testing the 
 * {@link InflightEntertainment}.
 * <p>
 * @author szeyick
 */
public class InflightEntertainmentTest {

	/**
	 * Test the naive solution.
	 */
	@Test
	public void testNaiveSolution() {
		InflightEntertainment inflightEntertainment = new InflightEntertainment();
		int[] movieLengths = new int[] {1, 2, 3, 4, 5};
		
		assertTrue("Expected movies to equal", inflightEntertainment.naiveSolution(4, movieLengths));
		assertFalse("Expected movies to equal", inflightEntertainment.naiveSolution(25, movieLengths));
	}
	
	/**
	 * Test the medium solution.
	 */
	@Test
	public void testMediumSolution() {
		InflightEntertainment inflightEntertainment = new InflightEntertainment();
		int[] movieLengths = new int[] {1, 2, 3, 4, 5};
		
		assertTrue("Expected movies to equal", inflightEntertainment.mediumSolution(4, movieLengths));
		assertFalse("Expected movies to equal", inflightEntertainment.mediumSolution(25, movieLengths));
	}
	
	/**
	 * Test the medium solution.
	 */
	@Test
	public void testOptimumSolution() {
		InflightEntertainment inflightEntertainment = new InflightEntertainment();
		int[] movieLengths = new int[] {1, 2, 3, 4, 5};
		
		assertTrue("Expected movies to equal", inflightEntertainment.optimalSolution(4, movieLengths));
		assertFalse("Expected movies to equal", inflightEntertainment.optimalSolution(25, movieLengths));
	}
}
