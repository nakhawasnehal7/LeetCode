class Solution {
    public void nextPermutation(int[] nums) {

        // Find pivot: rightmost index where nums[i] < nums[i+1]
        int pivot = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        // Entire array is in descending order -> it's the last permutation
        if (pivot == -1) {
            reverse(nums, 0, nums.length - 1);
            return; // don't fall through!
        }

        // Find rightmost element greater than nums[pivot], swap it in
        for (int i = nums.length - 1; i > pivot; i--) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, pivot);
                break; // stop after the first (correct) match
            }
        }

        // Reverse the suffix after pivot to get the smallest possible order
        reverse(nums, pivot + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}