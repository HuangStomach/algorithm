/**
 * 二叉搜索树中的顺序后继
 * 给你一个二叉搜索树和其中的某一个结点，请你找出该结点在树中顺序后继的节点。
 * 结点 p 的后继是值比 p.val 大的结点中键值最小的结点。
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
    TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
        TreeNode* res = NULL;
        while (root) {
            if (p->val < root->val) {
                res = root;
                root = root->left;
            } else {
                root = root->right;
            }
        }
        return res;
    }
};