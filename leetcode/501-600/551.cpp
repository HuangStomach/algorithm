/** 
 * 551. 学生出勤记录 I
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 * 'A' : Absent，缺勤
 * 'L' : Late，迟到
 * 'P' : Present，到场
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 */
#include <string>

using namespace std;

class Solution {
public:
    bool checkRecord(string s) {
        int a = 0;
        int l = 0;

        for (int i = 0; i < s.size(); i++) {
            if (s.at(i) == 'A' && ++a > 1) return false;
            else if (s.at(i) == 'L' && ++l > 2) return false;

            if (s.at(i) != 'L') l = 0;
        }
        return true;
    }
};
