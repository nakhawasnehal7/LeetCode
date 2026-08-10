import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        // Pair each start value with its original index
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0]; // start value
            starts[i][1] = i;               // original index
        }
        
        // Sort by start value
        Arrays.sort(starts, (a, b) -> a[0] - b[0]);
        
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int pos = binarySearch(starts, end);
            result[i] = (pos == n) ? -1 : starts[pos][1];
        }
        
        return result;
    }
    
    // Finds the leftmost index where starts[index][0] >= target
    private int binarySearch(int[][] starts, int target) {
        int lo = 0, hi = starts.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (starts[mid][0] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}