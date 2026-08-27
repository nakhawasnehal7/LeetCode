class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;

        boolean[] isVisited = new boolean[n];
        for (int i = 0; i < n; i++) {

            if (!isVisited[i]) {
                dfs(isConnected, isVisited, i);
                count++;
            }

        }
        return count;

    }

    public void dfs(int[][] isConnected, boolean[] isVisited, int city) {
        isVisited[city] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[city][j] == 1 && !isVisited[j])
                dfs(isConnected, isVisited, j);

        }

    }

}