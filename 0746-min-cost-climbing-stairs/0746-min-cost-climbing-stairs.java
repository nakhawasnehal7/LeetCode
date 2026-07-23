class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int prev2 = cost[0];   // dp[i-2]
        int prev1 = cost[1];   // dp[i-1]

        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);  // pick cheaper path
            prev2 = prev1;
            prev1 = curr;
        }

        // Top is reached from either last or second-to-last step
        return Math.min(prev1, prev2);
    }
}