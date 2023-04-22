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
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricTree(root.left, root.right);

    }

    private boolean isSymmetricTree(TreeNode leftTree, TreeNode rightTree) {
        final boolean isLeftTreeNull = leftTree == null;
        final boolean isRightTreeNull = rightTree == null;
        if (isLeftTreeNull || isRightTreeNull) {
            return isLeftTreeNull && isRightTreeNull;
        }

        return leftTree.val == rightTree.val
                && isSymmetricTree(leftTree.right, rightTree.left)
                && isSymmetricTree(leftTree.left, rightTree.right);
    }
}