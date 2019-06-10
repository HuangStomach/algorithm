/**
 * 上下翻转二叉树
 * 给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，要么为空，将此二叉树上下翻转并将它变成一棵树， 原来的右节点将转换成左叶节点。返回新的根。
 */

import java.util.Stack;

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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;
    
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right; // node 2 left children
        root.left.right = root; // node 2 right children
        root.left = null;
        root.right = null;
        return newRoot;
    }
}