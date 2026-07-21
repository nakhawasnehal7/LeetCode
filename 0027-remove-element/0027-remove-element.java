class Solution {
    public int removeElement(int[] nums, int val) {
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast]; // keep this element
                slow++;
            }
            // if nums[fast] == val → just skip!
        }

        return slow; // count of valid elements
    }
}