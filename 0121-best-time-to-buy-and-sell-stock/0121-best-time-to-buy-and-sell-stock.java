class Solution {
    public int maxProfit(int[] prices) {
        int minIndex = 0;
        int maxIndex = minIndex;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[minIndex]) {
                minIndex = i;
                maxIndex = i;
            } else if (prices[i] >= prices[maxIndex]) {
                maxIndex = i;
                int profit = prices[maxIndex] - prices[minIndex];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }
}