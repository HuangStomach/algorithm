/**
 * 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode root, int val) {
        if (root == null) return val;
        if (root.left != null) val = sum(root.left, root.left.val);
        if (root.left == null && root.right != null) val = 0;
        if (root.right != null) val += sum(root.right, 0);
        return val;
    }
}