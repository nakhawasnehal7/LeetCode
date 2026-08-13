class Solution {
    public int maxSubArray(int[] nums) {
        int curr    = 0; // current subarray sum
        int maxSum  =  Integer.MIN_VALUE; // best sum found

        for (int i = 0; i < nums.length; i++) {
            // Either extend or start fresh
        curr += nums[i];
            // Update best
            maxSum = Math.max(maxSum, curr);
               if(curr < 0){
            curr=0;
        }
        }

     

        return maxSum;
    }
}