// 翻转游戏 II
// 你和朋友玩一个叫做「翻转游戏」的游戏，游戏规则：给定一个只有 + 和 - 的字符串。你和朋友轮流将 连续 的两个 "++" 反转成 "--"。 当一方无法进行有效的翻转时便意味着游戏结束，则另一方获胜。
#include <string>
#include <unordered_map>

using std::string;
using std::unordered_map;

class Solution {
public:
    unordered_map<string, bool> map;

    bool canWin(string s) {
        if (map.count(s)) return map[s];

        for (int i = 0; i < s.size(); ++i) {
            if (i + 1 < s.size() && s[i] == '+' && s[i + 1] == '+') {
                string tmp = s;
                tmp[i] = '-', tmp[i + 1] = '-';
                if (!canWin(tmp)) {
                    return true;
                }
            }
        }
        map[s] = false;
        return false;
    }
};