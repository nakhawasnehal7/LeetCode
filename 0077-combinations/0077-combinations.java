class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int n, int k, int start,
                           List<Integer> curr,
                           List<List<Integer>> result) {
        // Base case: combination complete!
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // Pruning: enough numbers remaining?
        for (int i = start; i <= n - (k - curr.size()) + 1; i++) {
            curr.add(i);                          // choose
            backtrack(n, k, i + 1, curr, result); // explore
            curr.remove(curr.size() - 1);         // unchoose
        }
    }
}