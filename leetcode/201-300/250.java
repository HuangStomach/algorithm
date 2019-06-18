/**
 * 统计同值子树
 * 给定一个二叉树，统计该二叉树数值相同的子树个数。
 * 同值子树是指该子树的所有节点都拥有相同的数值。
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return 0;
        }
        if (isUnival(root)) {
            ans++;
        }
        ans += countUnivalSubtrees(root.left);
        ans += countUnivalSubtrees(root.right);
        return ans;
    }

    public boolean isUnival(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean ret = isUnival(root.left) && isUnival(root.right);
        if (root.left != null) {
            ret = ret && root.left.val == root.val;
        }
        if (root.right != null) {
            ret = ret && root.right.val == root.val;
        }
        return ret;
    }
}
