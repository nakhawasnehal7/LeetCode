class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];

            if (n < 0) {
                // swap when multiplying by a negative number
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }

            curMax = Math.max(n, curMax * n);
            curMin = Math.min(n, curMin * n);

            result = Math.max(result, curMax);
        }

        return result;
    }
}