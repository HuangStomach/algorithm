
// 比特位计数
// 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
// 利用 / 2 的移位算法来复用其1的个数大小，并在最低位补充进位
#include <vector>

using std::vector;

class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> res(num + 1, 0);
        for (int i = 1; i <= num; ++i) {
            res[i] = res[i / 2] + (i & 1);
        }
        return res;
    }
};