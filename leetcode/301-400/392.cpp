/** 
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
#include <string>

using namespace std;

class Solution {
public:
    bool isSubsequence(string s, string t) {
        int ssize = s.size();
        int tsize = t.size();
        int j = 0;
        for (int i = 0; i < tsize && j < ssize; i++) {
            if (s.at(j) == t.at(i)) j++;
        }
        
        return j == ssize;
    }
};
