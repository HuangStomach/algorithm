/**
 * 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 */
import java.util.Arrays;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private int search(int[] inorder, int start, int end, int data) {
        for (int i = end; i >= start; i--) {
            if (inorder[i] == data) return i;
        }
        return -1;
    }

    private TreeNode build(int[] preorder, int[] inorder, int left, int right) {
        if (left > right || index >= inorder.length) return null;

        int j = search(inorder, left, right, preorder[index]);

        TreeNode root = new TreeNode(preorder[index]);
        index++;
        root.left = build(preorder, inorder, left, j - 1);
        root.right = build(preorder, inorder, j + 1, right);
        return root;
    }
}