class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];

      
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;

            while (stack.size() > 0 && stack.peek() <= nums[idx]) {
                stack.pop();
            }
            if (i < n) {
                if (stack.isEmpty()) {
                    ans[idx] = -1;
                } else {
                    ans[idx] = stack.peek();
                }
            }

            stack.push(nums[idx]);

        }
        return ans;

    }
}