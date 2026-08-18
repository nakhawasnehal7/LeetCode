class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int island = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1') {
                    island++;
                    dsf(grid, i, j);
                }

            }
        }
        return island;
    }

    private void dsf(char[][] grid, int i, int j){

     if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] != '1') return;

        grid[i][j] ='0';

        dsf(grid, i+1, j);
        dsf(grid, i-1, j);
        dsf(grid, i, j+1);
        dsf(grid, i, j-1);


    }

}