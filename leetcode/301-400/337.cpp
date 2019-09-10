// 打家劫舍 III
// 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
#include <unordered_map>
#include <algorithm>

using std::unordered_map;
using std::max;

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
    unordered_map<TreeNode *, int> sums;
public:
    int rob(TreeNode* root) {
        return tryRob(root);
    }
    
    int tryRob(TreeNode* node) {
        if (!node) return 0;
        if (sums.count(node)) return sums[node];
        //偷取该节点
        int res1 = 0;
        if (node->left) {
            res1 += (tryRob(node->left->left) + tryRob(node->left->right));
        }
        if (node->right) {
            res1 += (tryRob(node->right->left) + tryRob(node->right->right));
        }
        res1 += node->val;
        //不偷取该节点
        int res2 = tryRob(node->left) + tryRob(node->right);
        sums[node] = max(res1, res2);
        return sums[node];
    }
};