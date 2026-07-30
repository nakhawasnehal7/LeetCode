class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Start or end blocked → 0 paths
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        // Fill first col (stop if obstacle!)
        for (int i = 1; i < m; i++) {
            dp[i][0] = (grid[i][0] == 1) ? 0 : dp[i-1][0];
        }

        // Fill first row (stop if obstacle!)
        for (int j = 1; j < n; j++) {
            dp[0][j] = (grid[0][j] == 1) ? 0 : dp[0][j-1];
        }

        // Fill rest
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0; // obstacle!
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}