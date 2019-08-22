// 二叉树最长连续序列
// 给你一棵指定的二叉树，请你计算它最长连续序列路径的长度。
// 该路径，可以是从某个初始结点到树中任意结点，通过「父 - 子」关系连接而产生的任意路径。
// 这个最长连续的路径，必须从父结点到子结点，反过来是不可以的。

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int length = 0;

    int longestConsecutive(TreeNode* root) {
        if (!root) return 0;
        longest(1, root);
        return length;
    }

    void longest(int l, TreeNode* root) {
        if (l > length) length = l;
        if (root->left) longest(root->left->val == root->val + 1 ? l + 1 : 1, root->left);
        if (root->right) longest(root->right->val == root->val + 1 ? l + 1 : 1, root->right);
    }
};