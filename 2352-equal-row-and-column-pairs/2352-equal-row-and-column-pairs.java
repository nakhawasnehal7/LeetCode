class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowCount = new HashMap<>();

        for (int[] row : grid) {
            rowCount.put(Arrays.toString(row), rowCount.getOrDefault(Arrays.toString(row), 0) + 1);
        }

        int result = 0;

        for (int col = 0; col < n; col++) {
            int[] column = new int[n];
            for (int row = 0; row < n; row++) {
                column[row] = grid[row][col];
            }
            result += rowCount.getOrDefault(Arrays.toString(column), 0);
        }

        return result;
    }
}