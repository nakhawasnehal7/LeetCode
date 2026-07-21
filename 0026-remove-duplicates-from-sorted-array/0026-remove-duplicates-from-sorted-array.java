class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {  // found new unique!
                slow++;
                nums[slow] = nums[fast];     // place it next
            }
            // duplicate → just skip!
        }

        return slow + 1; // k = index + 1
    }
}