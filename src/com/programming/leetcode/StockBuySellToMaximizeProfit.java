package com.programming.leetcode;

import java.util.Arrays;

/**
 * Question:
 * http://www.programcreek.com/2014/02/leetcode-best-time-to-buy-and-sell-stock-java/
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i. If you were only permitted to complete at most one transaction (ie,
 * buy one and sell one share of the stock), design an algorithm to find the
 * maximum profit.
 * 
 * Example array = [7, 1, 5, 3, 6, 4] Buy = 1 Sell = 6 Profit = 5
 * 
 * Do this in O(n) time.
 * 
 * @author SW029693
 *
 */
public class StockBuySellToMaximizeProfit {

    public static void main(String[] args) throws Exception {
        int[] stockPrices = { 7, 1, 5, 3, 6, 4 };
        determineBuySellPoint(stockPrices);
    }

    private static void determineBuySellPoint(int[] stockPrices) throws IllegalArgumentException {
        if (stockPrices == null) {
            throw new IllegalArgumentException("stockPrices cannot be null");
        }

        if (stockPrices.length < 2) {
            throw new IllegalArgumentException("stockPrices should have ateast 2 elements");
        }

        System.out.println("Stock Prices: " + Arrays.toString(stockPrices));

        // Initialize
        int max    = stockPrices[0];
        int min    = stockPrices[0];
        int profit = max - min;

        // O(n) time
        for (int i = 1; i < stockPrices.length; i++) {
            int curStockPrice = stockPrices[i];

            if (curStockPrice > max) {
                max = curStockPrice;
            }

            if (curStockPrice < min) {
                min = curStockPrice;
                max = curStockPrice;
            }

            profit = max - min;
        }

        System.out.println("Buy at:  " + min);
        System.out.println("Sell at: " + max);
        System.out.println("Profit = " + profit);
    }
}

/**
 * Sample output:
 * 
 * Stock Prices: [7, 1, 5, 3, 6, 4] 
 * Buy at: 1 
 * Sell at: 6 
 * Profit = 5
 */
