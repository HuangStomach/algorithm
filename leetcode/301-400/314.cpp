// 二叉树的垂直遍历
// 给定一个二叉树，返回其结点 垂直方向（从上到下，逐列）遍历的值。
// 如果两个结点在同一行和列，那么顺序则为 从左到右。
#include <vector>
#include <queue>
#include <map>

using std::make_pair;
using std::map;
using std::pair;
using std::queue;
using std::vector;
/**
 * 因为需要一列一列的从左至右进行遍历，那么我的思想是，层序遍历每个节点，并记录每个节点相对于根节点来说向左或向右的偏移量，向左的话在当前节点相对于根节点的偏移* 量上-1，向右+1，这样最后按照偏移量由小到大统计每个偏移量对应的节点的值的集合即可；
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
    vector<vector<int>> verticalOrder(TreeNode *root) {
        vector<vector<int>> res;
        map<int, vector<int>> hash;
        queue<pair<TreeNode *, int>> Q;

        if (!root) return res;

        Q.push(make_pair(root, 1));
        while (!Q.empty()) {
            auto node = Q.front();
            Q.pop();
            hash[node.second].push_back(node.first->val);
            auto left = node.first->left, right = node.first->right;
            if (left) Q.push(make_pair(left, node.second - 1));
            if (right) Q.push(make_pair(right, node.second + 1));
        }
        for (auto val : hash) res.push_back(val.second);
        return res;
    }
};