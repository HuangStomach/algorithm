/**
 * 路径总和 III
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;            
        sum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum); 
        return count;
    }

    public void sum(TreeNode root, int sum){
        if (root == null) return;
        sum -= root.val;
        if (sum == 0) count++;

        sum(root.left, sum);
        sum(root.right, sum);
    } 
}