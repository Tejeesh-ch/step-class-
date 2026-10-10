package week4.class_problems;

/**
 * Category C Practice - L2: Best Time to Buy and Sell Stock
 *
 * One pass from left to right, tracking the lowest price seen so far and
 * the largest profit obtainable by selling today. No profitable trade
 * means the answer is 0.
 */
public class BestTimeToBuyAndSellStock {

    /** Suggested signature: int maxProfit(int[] prices) */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int lowestSoFar = prices[0];
        int bestProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int profitIfSoldToday = prices[i] - lowestSoFar;
            if (profitIfSoldToday > bestProfit) {
                bestProfit = profitIfSoldToday;
            }
            if (prices[i] < lowestSoFar) {
                lowestSoFar = prices[i];
            }
        }
        return bestProfit;
    }

    public static void main(String[] args) {
        System.out.println("prices = [7, 1, 5, 3, 6, 4]  ->  "
                + maxProfit(new int[] { 7, 1, 5, 3, 6, 4 })
                + " (buy on day 2 at price 1, sell on day 5 at price 6)");
        System.out.println("prices = [7, 6, 4, 3, 1]     ->  "
                + maxProfit(new int[] { 7, 6, 4, 3, 1 })
                + " (prices only fall, so no trade is profitable)");
    }
}
