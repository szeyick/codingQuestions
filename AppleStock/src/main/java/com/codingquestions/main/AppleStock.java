package com.codingquestions.main;

/**
 * The AppleStock.
 * <p>
 * This class represents the solution for the
 * apple stock question.
 * <p>
 * <b>Warning: </b>Assumption that the stock price input
 * array is non-empty.
 * @author szeyick
 */
public class AppleStock {

	/**
	 * A naive implementation for the Apple Stock question.
	 * @param stockPricesYesterday - array for yesterday's stock price.
	 * @return the max profit.
	 */
	public int getMaxProfitNaive(int[] stockPricesYesterday) {
		int maxProfit = Integer.MIN_VALUE;
		for (int i = 0; i < stockPricesYesterday.length; i++) {
			int currentBuyPrice = stockPricesYesterday[i];
			for (int j = i + 1; j < stockPricesYesterday.length; j++) {
				int currentSalePrice = stockPricesYesterday[j];
				if ((currentSalePrice - currentBuyPrice) > maxProfit) {
					maxProfit = currentSalePrice - currentBuyPrice;
				}
			}
		}
		return maxProfit;
	}
	
	/**
	 * The optimal implementation for the Apple Stock question.
	 * @param stockPricesYesterday - array for yesterday's stock price.
	 * @return the max profit.
	 */
	public int getMaxProfitOptimal(int[] stockPricesYesterday) {
		int maxProfit = Integer.MIN_VALUE;
		int currentLowestBuyPrice = stockPricesYesterday[0];
		for (int i = 1; i < stockPricesYesterday.length; i++) {
			int currentSalePrice = stockPricesYesterday[i];
			if ((currentSalePrice - currentLowestBuyPrice) > maxProfit) {
				maxProfit = currentSalePrice - currentLowestBuyPrice;
			}
			// Update the current lowest if the sale price is lower.
			if (currentSalePrice < currentLowestBuyPrice) {
				currentLowestBuyPrice = currentSalePrice;
			}
		}
		return maxProfit;
	}
}
