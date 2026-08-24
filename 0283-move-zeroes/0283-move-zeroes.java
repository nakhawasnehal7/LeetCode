class Solution {
    public void moveZeroes(int[] nums) {

        int index = 0;
        // Move all non-zero elements to the front

        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }

        }
        // Fill remaining positions with 0

        for(int i = index; i < nums.length; i++){
            nums[i] = 0;
        }

    }
}