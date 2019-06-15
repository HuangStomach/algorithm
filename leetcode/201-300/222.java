/**
 * 完全二叉树的节点个数
 * 给出一个完全二叉树，求出该树的节点个数。
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int res = 0;

    public int countNodes(TreeNode root) {
        preOrder(root);
        return res;
    }

    private void preOrder(TreeNode root) {
        if (root == null) return;
        res++;
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }
}