class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum   = nums[0], currMax = nums[0];
        int minSum   = nums[0], currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Kadane's for maximum
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum  = Math.max(maxSum, currMax);

            // Kadane's for minimum
            currMin = Math.min(nums[i], currMin + nums[i]);
            minSum  = Math.min(minSum, currMin);

            totalSum += nums[i];
        }
        totalSum += nums[0];

        // If all negative → can't use circular (minSum=totalSum)
        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, totalSum - minSum);
    }
}