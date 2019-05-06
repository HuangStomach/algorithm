/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, root, k);
    }

    public boolean findTarget(TreeNode root, TreeNode node, int k) {
        if (node == null) return false;
        int val = k - node.val;
        if (val == node.val) return findTarget(root, node.left, k) || findTarget(root, node.right, k);

        return get(root, val) || findTarget(root, node.left, k) || findTarget(root, node.right, k);
    }

    private boolean get(TreeNode node, int val) {
        if (node == null) return false;
        int cmp = val - node.val;
        if (cmp < 0) return get(node.left, val);
        else if (cmp > 0) return get(node.right, val);
        else return true;
    }

}