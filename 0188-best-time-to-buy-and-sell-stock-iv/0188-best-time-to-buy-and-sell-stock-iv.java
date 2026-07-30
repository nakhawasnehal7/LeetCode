class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        // If k >= n/2, we can make unlimited transactions
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    profit += prices[i] - prices[i - 1];
            }
            return profit;
        }

        // buy[i]  = max cash after buying  in transaction i
        // sell[i] = max cash after selling in transaction i
        int[] buy  = new int[k + 1];
        int[] sell = new int[k + 1];

        Arrays.fill(buy, Integer.MIN_VALUE);  // Haven't bought yet

        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                buy[j]  = Math.max(buy[j],  sell[j - 1] - price); // Buy: use profit from prev transaction
                sell[j] = Math.max(sell[j], buy[j] + price);       // Sell: add current price to buy cost
            }
        }

        return sell[k];  // Max profit after at most k sells
    }
}