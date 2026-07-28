class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last  = findLast(nums, target);
        return new int[]{first, last};
    }

    // Find LEFTMOST position
    private int findFirst(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int result = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                result = mid;   // save position
                hi = mid - 1;  // keep searching LEFT!
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return result;
    }

    // Find RIGHTMOST position
    private int findLast(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int result = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) {
                result = mid;   // save position
                lo = mid + 1;  // keep searching RIGHT!
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return result;
    }
}