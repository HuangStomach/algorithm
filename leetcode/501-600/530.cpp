/** 
 * 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 */
#include <math.h>

using namespace std;

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    int pre = -1;
    int res = __INT32_MAX__;
    int getMinimumDifference(TreeNode *root) {
        find(root);
        return res;
    }

    void find(TreeNode * node) {
        if (node == nullptr) return;
        find(node->left);

        if (pre < 0) pre = node->val;
        else if (pre != node->val) {
            res = abs(node->val - pre) < res ? abs(node->val - pre) : res;
            pre = node->val;
        }
        
        find(node->right);
    }
};
