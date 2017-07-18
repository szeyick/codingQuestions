## Apple Stock.

Suppose we could access yesterday's stock prices as an array, where:

- The indices are the time in minutes past trade opening time, which was 9:30am local time.

- The values are the price in dollars of Apple stock at that time.
So if the stock cost $500 at 10:30am, stockPricesYesterday[60] = 500.

Write an efficient function that takes stockPricesYesterday and returns the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.

For example:

~~~
int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};

getMaxProfit(stockPricesYesterday);
// returns 6 (buying for $5 and selling for $11)
~~~

No "shorting"—you must buy before you sell. You may not buy and sell in the same time step (at least 1 minute must pass).

## Answer:

The idea here is to find two values where the difference between the two is the greatest. The catch here is that the sale price needs to come after the buy price.

Naive Solution: O(n^2)

Start at the buy price index, and iterate through all the values that come after it and find the max profit. Do that for each index, till you get to the end.

getMaxProfit(stockPricesYesterday)
	maxProfit = Integer.MIN_VALUE
	loop (stockPricesYesterday)
		buyPrice = stockPricesYesterday(i)
		loop (stockPricesYesterday)
			salePrice = stockPricesYesterday(i + 1)
			profit = salePrice - buyPrice
			if (profit > maxProfit)
				maxProfit = profit
	return maxProfit

Because we need to iterate through the input array twice, the runtime would be O(n^2). 

Optimal Solution:

The optimal solution would be to use a greedy algorithm, which means to find the local optimum first, using that as the best solution before continuing on for the rest of the input.

getMaxProfit(stockPricesYesterday)
	maxProfit = Integer.MIN_VALUE
	lowestBuyPrice = stockPricesYesterday[0];
	loop (stockPricesYesterday) // 1 to end
		currentSalePrice = stockPricesYesterday[i];
		profit = currentSalePrice - lowestBuyPrice
		if (profit > maxProfit)
			maxProfit = profit
		if (currentSalePrice < lowestBuyPrice)
			lowestBuyPrice = currentSalePrice
	return maxProfit

This solution can be done in O(n) linear time. It will be similar to the naive solution, except that we don't need to do the inner loop. The idea for this solution is to keep track of the lowest value currently found. This will be the buy price as we want the lowest value as the buy price.

In addition, rather than using an inner loop to find the sale price as with the naive solution, we can use the outer loop, where the current index is the sale price.
	