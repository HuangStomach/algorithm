// 最大单词长度乘积
// 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
// 用二进制的一位表示某一个字母是否出现过，0表示没出现，1表示出现。"abcd"二进制表示00000000 00000000 00000000 00001111、"bc"二进制表示00000000 00000000 00000000 00000110。当两个字符串没有相同的字母时，二进制数与的结果为0。
#include <vector>
#include <string>

using std::vector;
using std::string;

class Solution {
public:
    int str2int(const string& s) {
        int res = 0;
        for (auto c : s) res |= 1 << (c - 'a');
        return res;
    }
    int maxProduct(vector<string>& words) {
        int N = words.size();
        vector<int> m(N, 0);
        for (int i = 0; i < N; ++i) m[i] = str2int(words[i]);
        int res = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < i; ++j) {
                if ((m[i] & m[j]) == 0 && words[i].size() * words[j].size() > res) {
                    res = words[i].size() * words[j].size();
                }
            }
        }
        return res;
    }
};