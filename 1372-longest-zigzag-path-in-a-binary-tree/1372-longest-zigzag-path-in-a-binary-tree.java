/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxLength = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);  // going left from root, count=0
        dfs(root, false, 0); // going right from root, count=0
        return maxLength;
    }

    private void dfs(TreeNode node, boolean goLeft, int length) {
        if (node == null) {
            return;
        }

        maxLength = Math.max(maxLength, length);

        if (goLeft) {
            dfs(node.left, false, length + 1);
            dfs(node.right, true, 1);
        } else {
            dfs(node.right, true, length + 1);
            dfs(node.left, false, 1);
        }
    }
}
