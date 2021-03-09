/** 
 * 589. N 叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的 前序遍历 。
 * N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 */
#include <vector>
#include <stack>

using namespace std;
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node *> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node *> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
public:
    stack<Node *> S;
    vector<int> preorder(Node *root) {
        vector<int> res;
        if (root == nullptr) return res;
        S.push(root);

        while (!S.empty()) {
            Node *cur = S.top();
            S.pop();
            res.push_back(cur->val);
            int n = cur->children.size();
            for (int i = n - 1; i >= 0; i--) {
                if (cur->children[i] != nullptr) S.push(cur->children[i]);
            }
        }

        return res;
    }
};
