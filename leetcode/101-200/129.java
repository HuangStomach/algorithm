/**
 * 求根到叶子节点数字之和
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int pre) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return pre * 10 + root.val;
        } else {
            return dfs(root.left, pre * 10 + root.val) + dfs(root.right, pre * 10 + root.val);
        }
    }
}