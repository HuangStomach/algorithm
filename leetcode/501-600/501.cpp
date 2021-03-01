/** 
 * 501. 二叉搜索树中的众数
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 */
#include <vector>

using namespace std;

//  Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    int pre = 0;
    int maxCount = 0;
    int count = 0;
    vector<int> res;
    vector<int> findMode(TreeNode * root) {
        if (root == nullptr) return res;
        find(root);
        return res;
    }

    void find(TreeNode * node) {
        if (node == nullptr) return;
        find(node->left);
        
        if (pre == node->val) count++;
        else count = 1;

        if (count > maxCount) {
            maxCount = count;
            res.clear();
            res.push_back(node->val);
        }
        else if (count == maxCount) {
            res.push_back(node->val);
        }
        pre = node->val;
        find(node->right);
    }
};