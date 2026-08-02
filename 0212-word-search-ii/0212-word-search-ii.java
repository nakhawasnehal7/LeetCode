class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        // Build Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word; // mark end of word
        }

        List<String> result = new ArrayList<>();
        int m = board.length, n = board[0].length;

        // DFS from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j,
                     TrieNode node, List<String> result) {
        // Out of bounds or visited
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length ||
            board[i][j] == '#') return;

        char c = board[i][j];
        TrieNode next = node.children[c - 'a'];

        // No word starts with this prefix → prune!
        if (next == null) return;

        // Found a word!
        if (next.word != null) {
            result.add(next.word);
            next.word = null; // avoid duplicates!
        }

        board[i][j] = '#'; // mark visited

        dfs(board, i+1, j, next, result);
        dfs(board, i-1, j, next, result);
        dfs(board, i, j+1, next, result);
        dfs(board, i, j-1, next, result);

        board[i][j] = c; // restore
    }
}