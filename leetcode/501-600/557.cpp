/** 
 * 557. 反转字符串中的单词 III
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
#include <string>

using namespace std;

class Solution {
public:
    string reverseWords(string s) {
        s.push_back(' ');
        for (int i = 0, start = 0; i < s.size(); i++) {
            if (s.at(i) == ' ') {
                reverse(s.begin() + start, s.begin() + i);
                start = i + 1;
            }
        }
        s.pop_back();
        return s;
    }
};
