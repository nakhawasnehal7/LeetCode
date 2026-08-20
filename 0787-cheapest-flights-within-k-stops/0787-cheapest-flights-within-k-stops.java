class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                  int src, int dst, int k) {
        // prices[i] = cheapest cost to reach city i
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;

        // Relax K+1 times (K stops = K+1 edges)
        for (int i = 0; i <= k; i++) {
            // COPY prices to avoid using current round updates!
            int[] temp = Arrays.copyOf(prices, n);

            for (int[] flight : flights) {
                int from  = flight[0];
                int to    = flight[1];
                int price = flight[2];

                // Can we reach 'from'?
                if (prices[from] == Integer.MAX_VALUE) continue;

                // Update if cheaper!
                temp[to] = Math.min(temp[to],
                                    prices[from] + price);
            }

            prices = temp;
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}