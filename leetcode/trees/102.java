import java.util.ArrayList;

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
    public List<List<Integer>> list;

    public List<List<Integer>> levelOrder(TreeNode root) {
        list = new ArrayList<>();
        order(root, 0);
        return list;
    }

    public void order(TreeNode root, int level) {
        if (root == null) return;

        if (list.size() <= level) list.add(level, new ArrayList<Integer>());
        List<Integer> sub = list.get(level);
        sub.add(root.val);

        order(root.left, level + 1);
        order(root.right, level + 1);
    }
}