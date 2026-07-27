class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true; // found!
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int i, int j, int idx) {
        // All characters matched!
        if (idx == word.length()) return true;

        // Out of bounds or wrong character or visited
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length ||
            board[i][j] != word.charAt(idx) ||
            board[i][j] == '#') return false;

        char temp = board[i][j];
        board[i][j] = '#'; // mark visited!

        // Explore all 4 directions
        boolean found = dfs(board, word, i+1, j, idx+1) ||
                        dfs(board, word, i-1, j, idx+1) ||
                        dfs(board, word, i, j+1, idx+1) ||
                        dfs(board, word, i, j-1, idx+1);

        board[i][j] = temp; // unmark (backtrack)
        return found;
    }
}