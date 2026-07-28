class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi]) {
                lo = mid + 1; // min in right half
            } else {
                hi = mid;     // min in left half (mid could be min!)
            }
        }

        return nums[lo]; // lo == hi == minimum
    }
}