/**
 * 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int k;
    public int kthSmallest(TreeNode root, int k) {
        int num = count(root.left);
        if (num == k - 1) return root.val;
        if (num > k - 1) return kthSmallest(root.left, k);
        return kthSmallest(root.right, k - num - 1);
    }

    public int count(TreeNode root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }
}
