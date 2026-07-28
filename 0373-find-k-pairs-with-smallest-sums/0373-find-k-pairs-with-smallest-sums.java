class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1,
                                              int[] nums2,
                                              int k) {
        List<List<Integer>> result = new ArrayList<>();

        // Min heap: [sum, i, j]
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        // Initialize with first element of nums2 paired with each nums1
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            heap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (!heap.isEmpty() && result.size() < k) {
            int[] curr = heap.poll();
            int i = curr[1];
            int j = curr[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // Push next pair from same nums1[i]
            if (j + 1 < nums2.length) {
                heap.offer(new int[]{nums1[i] + nums2[j+1], i, j+1});
            }
        }

        return result;
    }
}