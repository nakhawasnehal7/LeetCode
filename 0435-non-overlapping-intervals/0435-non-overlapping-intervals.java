class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int keep = 1;                       // always keep first interval
        int prevEnd = intervals[0][1];      // track end of last kept

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) {
                // No overlap → keep it!
                keep++;
                prevEnd = intervals[i][1];
            }
            // Overlap → skip it (remove)
        }

        return intervals.length - keep;     // removals = total - kept
    }
}