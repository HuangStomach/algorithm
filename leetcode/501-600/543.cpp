/** 
 * 543. 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    int res = 0;
    int diameterOfBinaryTree(TreeNode *root) {
        height(root);
        return res;
    }

    int height(TreeNode * node) {
        if (node == nullptr) return 0;
        int lh = height(node->left);
        int rh = height(node->right);
        if (lh + rh > res) res = lh + rh;
        return (lh > rh ? lh : rh) + 1;
    }
};