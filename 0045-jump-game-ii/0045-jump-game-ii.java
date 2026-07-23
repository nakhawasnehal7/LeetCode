class Solution {
    public int jump(int[] nums) {
        int jumps    = 0;
        int curEnd   = 0;  // end of current jump range
        int maxReach = 0;  // farthest reachable index

        for (int i = 0; i < nums.length - 1; i++) {
            // Update farthest reach from current position
            maxReach = Math.max(maxReach, i + nums[i]);

            // Reached end of current jump range → must jump!
            if (i == curEnd) {
                jumps++;
                curEnd = maxReach;

                if (curEnd >= nums.length - 1) break; // reached end!
            }
        }

        return jumps;
    }
}