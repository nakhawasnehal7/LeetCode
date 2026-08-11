class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();

        for (int num : nums) {
            // Binary search for first tail >= num
            int lo = 0, hi = tails.size();

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (tails.get(mid) < num) lo = mid + 1;
                else hi = mid;
            }

            if (lo == tails.size()) {
                tails.add(num);      // extend LIS!
            } else {
                tails.set(lo, num);  // replace with smaller tail
            }
        }

        return tails.size();
    }
}