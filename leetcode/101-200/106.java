/**
 * 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int index = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return build(postorder, inorder, 0, inorder.length - 1);
    }

    private int search(int[] inorder, int start, int end, int data) {
        for (int i = end; i >= start; i--) {
            if (inorder[i] == data) return i;
        }
        return -1;
    }

    private TreeNode build(int[] postorder, int[] inorder, int left, int right) {
        if (left > right || index < 0) return null;

        int j = search(inorder, left, right, postorder[index]);

        TreeNode root = new TreeNode(postorder[index]);
        index--;
        root.right = build(postorder, inorder, j + 1, right);
        root.left = build(postorder, inorder, left, j - 1);
        return root;
    }
}