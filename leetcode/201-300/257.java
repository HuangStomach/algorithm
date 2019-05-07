import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        
        path(root, list, new StringBuilder());
        return list;
    }

    public void path(TreeNode root, List<String> list, StringBuilder sb) {
        sb.append(root.val + "->");
        int length = sb.length();

        if (root.left == null && root.right == null) {
            sb.setLength(sb.length() - 2);
            list.add(sb.toString());
            return;
        }

        if (root.left != null) path(root.left, list, sb);
        sb.setLength(length);
        if (root.right != null) path(root.right, list, sb);
    }
}