class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;

        // BFS - minimum moves to reach target
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[target + 1];

        queue.add(1);
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all squares at current move level
            while (size-- > 0) {
                int curr = queue.poll();
                if (curr == target) return moves;

                // Roll dice: try all 6 possibilities
                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > target) break;

                    // Convert label → (row, col) in board
                    int[] pos = getPosition(next, n);
                    int row = pos[0], col = pos[1];

                    // Follow snake or ladder if present
                    if (board[row][col] != -1) {
                        next = board[row][col];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
            moves++;
        }

        return -1;  // Target unreachable
    }

    // Convert square label to board (row, col)
    // Labels go bottom-up, alternating left-right each row
    private int[] getPosition(int label, int n) {
        int row = (label - 1) / n;   // 0-indexed from bottom
        int col = (label - 1) % n;   // 0-indexed from left

        // Odd rows (from bottom) go right-to-left
        if (row % 2 == 1) col = n - 1 - col;

        // Convert to actual board indices (board[0] = top row)
        return new int[]{n - 1 - row, col};
    }
}