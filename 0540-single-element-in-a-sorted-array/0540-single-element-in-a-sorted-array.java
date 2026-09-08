class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            // Make mid even (start of pair)
            if (nums[mid] == nums[mid ^ 1]) {
                lo = mid + 1; // single is RIGHT
            } else {
                hi = mid;     // single is LEFT (or mid)
            }
        }

        return nums[lo];
    }
}