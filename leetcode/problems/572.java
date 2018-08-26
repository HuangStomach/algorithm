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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;

        if ((s == null && t != null)
        || (s != null && t == null)) return false;
        
        if (s.val == t.val) {
            boolean result = subtree(s, t);
            if (result) return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean subtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;

        if ((s == null && t != null)
        || (s != null && t == null)) return false;

        if (s.val != t.val) return false;

        return subtree(s.left, t.left) && subtree(s.right, t.right);
    }
}
