class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            int[] last = result.get(result.size() - 1);

            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]); // merge!
            } else {
                result.add(curr); // no overlap, add new
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}