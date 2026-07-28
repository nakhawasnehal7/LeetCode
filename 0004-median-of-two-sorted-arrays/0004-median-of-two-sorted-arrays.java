class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search on smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int lo = 0, hi = m;
        int half = (m + n + 1) / 2; // left half size

        while (lo <= hi) {
            int partition1 = lo + (hi - lo) / 2; // elements from nums1
            int partition2 = half - partition1;   // elements from nums2

            // Edge values (use ±infinity for boundaries)
            int maxLeft1  = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            int maxLeft2  = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Found correct partition!
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2); // odd total
                } else {
                    return (Math.max(maxLeft1, maxLeft2) +
                            Math.min(minRight1, minRight2)) / 2.0; // even
                }
            } else if (maxLeft1 > minRight2) {
                hi = partition1 - 1; // move left in nums1
            } else {
                lo = partition1 + 1; // move right in nums1
            }
        }

        return 0.0;
    }
}