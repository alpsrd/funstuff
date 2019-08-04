/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */


class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return isValidBranch(root.left, null, root.val) && isValidBranch(root.right, root.val, null);
    }

    public boolean isValidBranch(TreeNode node, Integer lowerBound, Integer upperBound) {
        if (node == null) {
            return true;
        }

        if ((upperBound != null && node.val >= upperBound) || (lowerBound != null && node.val <= lowerBound)) {
            return false;
        } else {
            return isValidBranch(node.left, lowerBound, node.val) && isValidBranch(node.right, node.val, upperBound);
        }

    }
}