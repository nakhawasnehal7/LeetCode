import java.util.PriorityQueue;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        
        // Min-heap: [cost, index]
        // Sort by cost first, then by index for tie-breaking
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]
        );
        
        int left = 0;
        int right = n - 1;
        
        // Pre-load first `candidates` workers
        for (int i = 0; i < candidates && left <= right; i++) {
            minHeap.offer(new int[]{costs[left], left});
            left++;
        }
        
        // Pre-load last `candidates` workers (avoid duplicates)
        for (int i = 0; i < candidates && right >= left; i++) {
            minHeap.offer(new int[]{costs[right], right});
            right--;
        }
        
        long totalCost = 0;
        
        // Hire k workers
        for (int session = 0; session < k; session++) {
            int[] worker = minHeap.poll();
            int cost = worker[0];
            int idx  = worker[1];
            
            totalCost += cost;
            
            // Refill from the side this worker came from
            if (idx < left) {          // came from left window
                if (left <= right) {
                    minHeap.offer(new int[]{costs[left], left});
                    left++;
                }
            } else {                   // came from right window
                if (right >= left) {
                    minHeap.offer(new int[]{costs[right], right});
                    right--;
                }
            }
        }
        
        return totalCost;
    }
}