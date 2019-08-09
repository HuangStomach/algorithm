/**
 * 字符串的编码与解码
 * 请你设计一个算法，可以将一个 字符串列表 编码成为一个 字符串。这个编码后的字符串是可以通过网络进行高效传送的，并且可以在接收端被解码回原来的字符串列表。
 */
#include <vector>
#include <string>
#include <sstream>

using std::vector;
using std::string;
using std::ostringstream;

class Codec {
public:

    // Encodes a list of strings to a single string.
    string encode(const vector<string>& strs) {
        ostringstream out;
        for (const auto& str: strs) {
          out << str.size() << ':' << str;
        }
        return out.str();
    }

    // Decodes a single string to a list of strings.
    vector<string> decode(const string& s) {
        vector<string> res;
        int idx = 0;
        while (idx < s.size()) {
          int len = 0;
          while (isdigit(s[idx])) {
            len = len * 10 + s[idx] - '0';
            ++idx;
          }
          ++idx;
          res.push_back(s.substr(idx, len));
          idx += len;
        }
        return res;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.decode(codec.encode(strs));