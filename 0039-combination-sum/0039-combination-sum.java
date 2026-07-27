class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining,
                           int start, List<Integer> curr,
                           List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) break; // pruning!

            curr.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i],
                      i, curr, result); // i not i+1 → allow reuse!
            curr.remove(curr.size() - 1);
        }
    }
}