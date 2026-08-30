class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int num = i, count = 0;
            while (num > 0) {
                count += num & 1; // check last bit
                num >>= 1;        // shift right
            }
            ans[i] = count;
        }

        return ans;
    }
}