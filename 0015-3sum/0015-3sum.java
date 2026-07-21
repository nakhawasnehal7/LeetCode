class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate for i
            if (i > 0 && nums[i] == nums[i-1]) continue;

            // All positive → can't sum to 0
            if (nums[i] > 0) break;

            int lo = i + 1;
            int hi = nums.length - 1;

            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

                    // Skip duplicates for lo and hi
                    while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi-1]) hi--;

                    lo++;
                    hi--;

                } else if (sum < 0) {
                    lo++;  // need larger sum
                } else {
                    hi--;  // need smaller sum
                }
            }
        }

        return result;
    }
}