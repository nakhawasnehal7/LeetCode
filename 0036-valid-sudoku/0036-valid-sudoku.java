class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char val = board[row][col];

                if (val == '.') continue; // skip empty cells

                int boxIndex = (row / 3) * 3 + (col / 3);

                String rowKey = "row" + row + val;
                String colKey = "col" + col + val;
                String boxKey = "box" + boxIndex + val;

                if (seen.contains(rowKey) || 
                    seen.contains(colKey) || 
                    seen.contains(boxKey)) {
                    return false; // duplicate found!
                }

                seen.add(rowKey);
                seen.add(colKey);
                seen.add(boxKey);
            }
        }

        return true;
    }
}