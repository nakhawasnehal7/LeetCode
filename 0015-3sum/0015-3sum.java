class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            int lo = i+1;
            int hi = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            if (0 < nums[i])
                break;

            while (lo < hi) {

                int sum = nums[i] + nums[lo] + nums[hi];

                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[lo], nums[hi]));

                    while (lo < hi && nums[lo] == nums[lo + 1])
                        lo++;
                    while (hi < hi && nums[hi] == nums[hi -1])
                        hi++;

                    lo++;
                    hi--;

                } else if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }

        }
        return list;
    }
}