class Solution {
    public void sortColors(int[] nums) {

        int lo  = 0;
        int mid = 0;
        int hi = nums.length-1;

        while (mid<= hi) {

            if (nums[mid] == 0) {
            swap(nums, lo , mid);
            mid++;
            lo++;

            }else if (nums[mid] ==1){
                mid++;

            }else{
             swap(nums, mid, hi);
             hi--;

            }

        }

    }

    private void swap(int []nums, int lo , int hi){

        int tmp = nums[lo];
         nums[lo]=nums[hi];
        nums[hi]=tmp;
    }
}