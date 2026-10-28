class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+'; // mark entrance as visited

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1], steps = curr[2];

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // check bounds
                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                    continue;
                }

                // skip walls and visited cells
                if (maze[newRow][newCol] == '+') {
                    continue;
                }

                // check if it's a border cell (exit)
                if (newRow == 0 || newRow == m-1 || newCol == 0 || newCol == n-1) {
                    return steps + 1;
                }

                // not an exit, keep exploring
                maze[newRow][newCol] = '+'; // mark visited
                queue.offer(new int[]{newRow, newCol, steps + 1});
            }
        }

        return -1;
    }
}