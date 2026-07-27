class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // sort for pruning!
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remaining,
                           int start, List<Integer> curr,
                           List<List<Integer>> result) {
        // Found valid combination!
        if (remaining == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Pruning: if candidate > remaining, skip rest
            if (candidates[i] > remaining) break;

            curr.add(candidates[i]);              // choose
            backtrack(candidates, remaining - candidates[i],
                      i, curr, result);           // explore (i not i+1!)
            curr.remove(curr.size() - 1);         // unchoose
        }
    }
}