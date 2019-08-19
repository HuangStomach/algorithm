// 单词的唯一缩写
// 一个单词的缩写需要遵循 <起始字母><中间字母数><结尾字母> 这样的格式。
// 假设你有一个字典和一个单词，请你判断该单词的缩写在这本字典中是否唯一。若单词的缩写在字典中没有任何 其他 单词与其缩写相同，则被称为单词的唯一缩写。

#include <vector>
#include <string>
#include <unordered_map>
#include <set>

using std::string;
using std::to_string;
using std::unordered_map;
using std::vector;

class ValidWordAbbr {
    unordered_map<string, string> map;
public:
    ValidWordAbbr(vector<string> &dictionary) {
        for (auto &w : dictionary) {
            int n = w.size();
            string ws = w[0] + to_string(n - 2) + w[n - 1];
            if (map.count(ws) && map[ws] != w) map[ws] = "";
            else map[ws] = w;
        }
    }

    bool isUnique(string word) {
        int n = word.size();
        string ws = word[0] + to_string(n - 2) + word[n - 1];

        if (!map.count(ws) || map[ws] == word) return true;
        else return false;
    }
};

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr* obj = new ValidWordAbbr(dictionary);
 * bool param_1 = obj->isUnique(word);
 */
