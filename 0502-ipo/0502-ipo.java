class Solution {
    public int findMaximizedCapital(int k, int w,
                                    int[] profits,
                                    int[] capital) {
        int n = profits.length;

        // Min heap by capital requirement
        PriorityQueue<int[]> minCap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // Max heap by profit
        PriorityQueue<int[]> maxProfit = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        // Add all projects to min capital heap
        for (int i = 0; i < n; i++) {
            minCap.offer(new int[]{capital[i], profits[i]});
        }

        // Do at most k projects
        for (int i = 0; i < k; i++) {
            // Unlock all affordable projects
            while (!minCap.isEmpty() && minCap.peek()[0] <= w) {
                maxProfit.offer(minCap.poll());
            }

            // No affordable projects left
            if (maxProfit.isEmpty()) break;

            // Pick most profitable project
            w += maxProfit.poll()[1];
        }

        return w;
    }
}