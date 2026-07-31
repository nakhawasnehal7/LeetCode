class WordDictionary {

    private TrieNode root;

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    // Same as standard Trie insert
    public void addWord(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    // DFS handles '.' wildcard by trying all 26 children
    private boolean dfs(String word, int index, TrieNode node) {
        if (index == word.length()) return node.isEndOfWord;

        char ch = word.charAt(index);

        if (ch == '.') {
            // Try every possible child for wildcard
            for (TrieNode child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // Normal character — go to that child
            int idx = ch - 'a';
            if (node.children[idx] == null) return false;
            return dfs(word, index + 1, node.children[idx]);
        }
    }
}