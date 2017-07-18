package com.codingquestions.main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The AppleStockTest.
 * <p>
 * This class is the test of the {@link AppleStock}.
 * <p>
 * <b>Warning: </b>None.
 * <p>
 * @author szeyick
 */
public class AppleStockTest {

	/**
	 * Test the Apple Stock.
	 */
	@Test
    public void testAppleStock() {
		int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};
		AppleStock stockCalculator = new AppleStock();
		int naiveProfit = stockCalculator.getMaxProfitNaive(stockPricesYesterday);
		int optimumProfit = stockCalculator.getMaxProfitOptimal(stockPricesYesterday);
		
		assertEquals("Expected answers to be the same", 6, naiveProfit);
		assertEquals("Expected answers to be the same", 6, optimumProfit);
	}
}
