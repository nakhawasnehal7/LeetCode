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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Found the node to delete — 3 cases:

            // Case 1: no left child → replace with right child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: no right child → replace with left child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: two children → find inorder successor
            // (smallest node in right subtree)
            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }

            // Replace current node's value with successor's value
            root.val = successor.val;

            // Delete the successor from the right subtree
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }
}