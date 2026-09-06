class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        Set<Integer> cols     = new HashSet<>();
        Set<Integer> leftDiag  = new HashSet<>(); // row-col
        Set<Integer> rightDiag = new HashSet<>(); // row+col

        backtrack(0, n, board, cols, leftDiag, rightDiag, result);
        return result;
    }

    private void backtrack(int row, int n, char[][] board,
                           Set<Integer> cols,
                           Set<Integer> leftDiag,
                           Set<Integer> rightDiag,
                           List<List<String>> result) {
        // All rows filled → valid solution!
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            // Check if position is safe
            if (cols.contains(col) ||
                leftDiag.contains(row - col) ||
                rightDiag.contains(row + col)) {
                continue; // unsafe!
            }

            // Place queen
            board[row][col] = 'Q';
            cols.add(col);
            leftDiag.add(row - col);
            rightDiag.add(row + col);

            // Next row
            backtrack(row+1, n, board, cols,
                      leftDiag, rightDiag, result);

            // Remove queen (backtrack)
            board[row][col] = '.';
            cols.remove(col);
            leftDiag.remove(row - col);
            rightDiag.remove(row + col);
        }
    }
}