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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        final List<List<Integer>> result = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void pathSum(TreeNode node, int currentSum, List<Integer> pathFromTheRoot, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        pathFromTheRoot.add(node.val);

        final int newSum = currentSum - node.val;
        if (newSum == 0
                && node.left == null && node.right == null) {
            result.add(new ArrayList<>(pathFromTheRoot));
        } else {
            pathSum(node.left, newSum, pathFromTheRoot, result);
            pathSum(node.right, newSum, pathFromTheRoot, result);
        }

        // remove current node
        pathFromTheRoot.remove(pathFromTheRoot.size() - 1);
    }
}