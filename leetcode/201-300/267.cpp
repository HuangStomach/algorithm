/**
 * 回文排列 II
 * 给定一个字符串 s ，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。
 * 如不能形成任何回文排列时，则返回一个空列表。
 */
#include <unordered_map>
#include <unordered_set>
#include <vector>
#include <string>

using std::string;
using std::swap;
using std::unordered_map;
using std::unordered_set;
using std::vector;

class Solution {
public:
    vector<string> generatePalindromes(string s) {
        unordered_set<string> res;
        unordered_map<char, int> m;
        string t = "", mid = "";

        for (auto a : s) m[a]++;

        for (auto it : m) {
            if (it.second % 2 == 1) mid += it.first;
            t += string(it.second / 2, it.first);
            if (mid.size() > 1) return {};
        }
        permute(t, 0, mid, res);
        return vector<string>(res.begin(), res.end());
    }

    void permute(string &t, int start, string mid, unordered_set<string> &res) {
        if (start >= t.size()) {
            res.insert(t + mid + string(t.rbegin(), t.rend()));
        }

        for (int i = start; i < t.size(); ++i) {
            if (i != start && t[i] == t[start]) continue;
            swap(t[i], t[start]);
            permute(t, start + 1, mid, res);
            swap(t[i], t[start]);
        }
    }
};