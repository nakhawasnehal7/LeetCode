class Solution {
    public int maxSubArray(int[] nums) {
        int curr    = nums[0]; // current subarray sum
        int maxSum  = nums[0]; // best sum found

        for (int i = 1; i < nums.length; i++) {
            // Either extend or start fresh
            curr = Math.max(nums[i], curr + nums[i]);

            // Update best
            maxSum = Math.max(maxSum, curr);
        }

        return maxSum;
    }
}