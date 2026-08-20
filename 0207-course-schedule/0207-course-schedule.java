class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);  // bi → ai
        }

        // 0 = unvisited, 1 = visiting (in current path), 2 = visited (safe)
        int[] state = new int[numCourses];

        // Run DFS from every unvisited node
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(i, adj, state)) return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> adj, int[] state) {
        state[node] = 1;  // Mark as currently visiting

        for (int neighbor : adj.get(node)) {
            if (state[neighbor] == 1) return true;   // Cycle detected!
            if (state[neighbor] == 0) {               // Unvisited
                if (hasCycle(neighbor, adj, state)) return true;
            }
            // state == 2 means already verified safe — skip
        }

        state[node] = 2;  // Mark as fully processed (safe)
        return false;
    }
}