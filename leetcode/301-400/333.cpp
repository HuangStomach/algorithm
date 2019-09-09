// 最大 BST 子树
// 给定一个二叉树，找到其中最大的二叉搜索树（BST）子树，其中最大指的是子树节点数最多的。
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
#include <algorithm>

using std::max;

class Solution {
public:
    int largestBSTSubtree(TreeNode* root) {
        if (root == NULL) {
            return 0;
        }
        int minVal;
        int maxVal;
        BSTSubtree(root, minVal, maxVal);
        return result;
    } 
    
private:
    int result = 1;
    int BSTSubtree(TreeNode* root, int& minVal, int& maxVal) {
        if (root == NULL) {
            return 0;
        }
        if (root->left == NULL && root->right == NULL) {
            minVal = root->val;
            maxVal = root->val;
            return 1;
        }
        int lmin;
        int lmax;
        int rmin;
        int rmax;
        int ln = BSTSubtree(root->left, lmin, lmax);
        int rn = BSTSubtree(root->right, rmin, rmax);
        if (ln == -1 || rn == -1) {
            return -1;
        }
        if ((ln != 0 && root->val <= lmax) || (rn != 0 && root->val >= rmin)) {
            return -1;
        }
        minVal = ln != 0 ? lmin : root->val;
        maxVal = rn != 0 ? rmax : root->val;
        int n = ln + rn + 1;
        result = max(result, n);
        return n;
    }
};