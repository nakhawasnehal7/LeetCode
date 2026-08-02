class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // Right side is higher → peak must be on right
                lo = mid + 1;
            } else {
                // Left side is higher (or equal) → peak must be on left
                hi = mid;
            }
        }

        // lo == hi, converged to a peak
        return lo;
    }
}