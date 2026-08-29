class Solution {
    private int[] prefixSums;
    private int totalSum;
    private Random random;

    public Solution(int[] w) {
        this.prefixSums = new int[w.length];
        this.random = new Random();

        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            prefixSums[i] = sum;
        }
        this.totalSum = sum;
    }

    public int pickIndex() {
        // random target in [1, totalSum]
        double target = random.nextDouble() * totalSum;

        int lo = 0, hi = prefixSums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (prefixSums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */