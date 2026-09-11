class Solution {
    public int arrangeCoins(int n) {
        long lo = 1, hi = n;

        while (lo < hi) {
            long mid = lo + (hi - lo + 1) / 2;

            // Coins needed for mid rows
            long coins = mid * (mid + 1) / 2;

            if (coins <= n) {
                lo = mid;      // mid rows possible!
            } else {
                hi = mid - 1;  // too many rows
            }
        }

        return (int) lo;
    }
}