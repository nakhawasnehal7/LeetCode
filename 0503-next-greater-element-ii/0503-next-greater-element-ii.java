class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // default -1

        Deque<Integer> stack = new ArrayDeque<>(); // stores indices

        // Loop TWICE for circular effect
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];

            // Pop all elements smaller than current
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                int idx = stack.pop();
                result[idx] = num; // found next greater!
            }

            // Only push indices from first pass
            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}