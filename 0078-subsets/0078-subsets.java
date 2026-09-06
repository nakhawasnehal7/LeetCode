class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start,
                           List<Integer> curr,
                           List<List<Integer>> result) {
        // Add current subset (every state is valid!)
        result.add(new ArrayList<>(curr));

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);                    // include
            backtrack(nums, i + 1, curr, result); // explore
            curr.remove(curr.size() - 1);         // exclude
        }
    }
}