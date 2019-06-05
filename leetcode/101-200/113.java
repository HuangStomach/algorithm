/**
 * 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        dfs(root, sum, list, new ArrayList<>());
        return list;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> list, List<Integer> temp) {
        if (root == null) return;

        temp.add(root.val);
        sum -= root.val;

        if (root.left == null && root.right == null) {
            if (sum == 0) list.add(new ArrayList<>(temp));
        } 
        else {
            dfs(root.left, sum, list, temp);
            dfs(root.right, sum, list, temp);
        }

        temp.remove(temp.size() - 1);
    }
}
