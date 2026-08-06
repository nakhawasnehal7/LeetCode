class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int row = 0;
        int col = cols - 1;   // start at top-right corner
        int count = 0;

        while (row < rows && col >= 0) {
            if (grid[row][col] < 0) {
                // everything below (row, col) in this column is also negative
                count += (rows - row);
                col--;        // move left to check a possibly non-negative value
            } else {
                row++;        // move down, no negative here
            }
        }

        return count;
    }
}