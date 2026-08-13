class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int total = n * n;
        int[] count = new int[total + 1];

        // Count frequency of each number
        for (int[] row : grid) {
            for (int val : row) {
                count[val]++;
            }
        }

        int repeated = -1, missing = -1;

        for (int i = 1; i <= total; i++) {
            if (count[i] == 2) repeated = i; // appears twice!
            if (count[i] == 0) missing  = i; // never appears!
        }

        return new int[]{repeated, missing};
    }
}