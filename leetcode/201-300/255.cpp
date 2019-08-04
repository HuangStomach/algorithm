/**
 * 验证前序遍历序列二叉搜索树
 * 给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。
 */
#include <vector>
#include <stack>

using std::max;
using std::stack;
using std::vector;

class Solution {
public:
    bool verifyPreorder(vector<int> &preorder) {
        if (!preorder.size()) return true;

        stack<int> st;
        st.push(preorder[0]);
        int lst = -1e10;

        for (int i = 1; i < preorder.size(); i++) {
            if (preorder[i] < lst) return false; // 超过下界代表不符合平衡二叉树

            while (!st.empty() && preorder[i] > st.top()) { 
                // 进入循环说明发现了右子树(比栈顶大) 
                // 将右子树的值重新设置为下界 并将小于下界的数全部推出
                lst = max(lst, st.top());
                st.pop();
            }
            st.push(preorder[i]);
        }
        return true;
    }
};