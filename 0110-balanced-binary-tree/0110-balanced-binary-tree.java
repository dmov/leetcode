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
    private boolean isHeightBalanced = true;

    public boolean isBalanced(TreeNode root) {
        calculateBalancedTreeHeight(root);
        return isHeightBalanced;
    }

    private int calculateBalancedTreeHeight(TreeNode tree) {
        if (!isHeightBalanced) {
            return 0;
        }

        if (tree == null) {
            return 0;
        }

        final int leftTreeHeight = calculateBalancedTreeHeight(tree.left);
        final int rightTreeHeight = calculateBalancedTreeHeight(tree.right);

        if (Math.abs(leftTreeHeight - rightTreeHeight) > 1) {
            isHeightBalanced = false;
        }

        return 1 + Math.max(leftTreeHeight, rightTreeHeight);
    }
}