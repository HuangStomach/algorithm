// 列举单词的全部缩写
// 请你写出一个能够举单词全部缩写的函数。

#include <vector>
#include <string>

using std::vector;
using std::string;
using std::to_string;

class Solution {
public:
    vector<string> generateAbbreviations(string word) {
        vector<string> list;
        if (word.size() == 0) {
            list.push_back(word);
            return list;
        }
        string temp;
        generate(list, temp, word, 0, 0);
        return list;
    }

    void generate(vector<string> &list, string temp, string word, int start, int k) {
        int size = temp.size();
        if (start == word.size()) {
            if (k != 0) temp.append(to_string(k));
            list.push_back(temp.c_str());
        }
        else {
            generate(list, temp, word, start + 1, k + 1);

            // the branch that word.charAt(i) is kept
            if (k != 0) temp.append(to_string(k));
            temp.push_back(word.at(start));
            generate(list, temp, word, start + 1, 0);
        }

        temp.erase(size, temp.size());
    }
};