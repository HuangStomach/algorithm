// 累加数
// 累加数是一个字符串，组成它的数字可以形成累加序列。
// 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
// 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
#include <string>
#include <climits>

using std::max;
using std::string;

class Solution {
public:
    bool isAdditiveNumber(string num) {
        if (num.size() <= 2) return false;
        for (int i = 1; 2 * i <= num.size(); i++) {
            for (int j = 1; i + 2 * j <= num.size(); j++) {
                if (i + j >= num.size()) break;
                if (dfs(num, str(num.substr(0, i)), str(num.substr(i, j)), i + j, j)) return true;
            }
            if (num[0] == '0') break;
        }
        return false;
    }

    bool dfs(const string &num, long pre, long prepre, int i, int len) {
        if (i == num.size()) return true;
        if (i > num.size()) return false;
        for (int j = len; j <= num.size(); j++) {
            long cur = str(num.substr(i, j));
            if (cur == -1) return false;
            if (cur == pre + prepre && dfs(num, prepre, cur, i + j, j)) return true;
        }
        return false;
    }

    long str(string s) {
        if (s.size() > 1 && s[0] == '0') return -1;
        long sum = 0;
        for (auto c : s) {
            if (sum >= LONG_MAX / 10) return -1;
            sum = sum * 10 + c - '0';
        }
        return sum;
    }
};