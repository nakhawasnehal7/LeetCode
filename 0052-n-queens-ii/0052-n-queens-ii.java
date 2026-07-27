class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        backtrack(n, 0,
                  new HashSet<>(),  // cols used
                  new HashSet<>(),  // left diag (row-col)
                  new HashSet<>()); // right diag (row+col)
        return count;
    }

    private void backtrack(int n, int row,
                           Set<Integer> cols,
                           Set<Integer> leftDiag,
                           Set<Integer> rightDiag) {
        // All queens placed!
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            // Check if position is under attack
            if (cols.contains(col) ||
                leftDiag.contains(row - col) ||
                rightDiag.contains(row + col)) {
                continue; // unsafe, skip!
            }

            // Place queen
            cols.add(col);
            leftDiag.add(row - col);
            rightDiag.add(row + col);

            backtrack(n, row + 1, cols, leftDiag, rightDiag);

            // Remove queen (backtrack)
            cols.remove(col);
            leftDiag.remove(row - col);
            rightDiag.remove(row + col);
        }
    }
}