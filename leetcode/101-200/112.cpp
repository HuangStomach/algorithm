/** 
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 */

#include <queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    bool hasPathSum(TreeNode* root, int targetSum) {
        if (root == nullptr) return false;

        queue<TreeNode*> q;
        root->val = targetSum - root->val;
        if (root->val == 0 && root->left == nullptr && root->right == nullptr) return true;
        q.push(root);

        while (!q.empty()) {
            TreeNode* node = q.front();
            q.pop();
            
            if (node->left != nullptr) {
                node->left->val = node->val - node->left->val;
                if (node->left->val == 0 && node->left->left == nullptr && node->left->right == nullptr) return true;
                q.push(node->left);
            }

            if (node->right != nullptr) {
                node->right->val = node->val - node->right->val;
                if (node->right->val == 0 && node->right->left == nullptr && node->right->right == nullptr) return true;
                q.push(node->right);
            }
        }

        return false;
    }
};
