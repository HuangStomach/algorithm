// 验证二叉树的前序序列化
// 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
// 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
// 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
// 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。

#include <string>

using std::string;

class Solution {
public:
    bool isValidSerialization(string preorder) {
        int n = preorder.size();
        int num = 0;

        for (int i = n - 1; i >= 0; i--) {
            char c = preorder.at(i);
            if (c == ',') continue;
            if (c == '#') num++;
            else {
                while(i >= 0 && preorder[i] != ',') i--; // 多位数字
                if (num >= 2) num--; // 一个数字两个# 则去掉两个子# 转换掉一个数字为# 总数 - 1
                else return false;
            }
        }

        if (num != 1) return false;
        return true;
    }
};