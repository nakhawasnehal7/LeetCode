class Solution {
    public int[] sortArray(int[] nums) {
        mersgeSort(nums, 0, nums.length - 1);
        return nums;

    }

    public void mersgeSort(int[] nums, int left, int right){
        if (left >= right) return; // base case: 0 or 1 element, already sorted

        int mid = left+(right-left)/2;

        mersgeSort(nums, left, mid);
        mersgeSort(nums, mid+1, right);
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;

        int k = 0;

        while (i <= mid && j <= right) {

            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];

            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid)
            temp[k++] = nums[i++];
        while (j <= right)
            temp[k++] = nums[j++];

        System.arraycopy(temp, 0, nums, left, temp.length);

    }

}