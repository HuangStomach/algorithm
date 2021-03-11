/** 
 * 598. 范围求和 II
 * 给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
 * 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
 * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
 */
#include <vector>

using namespace std;

class Solution {
public:
    int maxCount(int m, int n, vector<vector<int>>& ops) {
        if (ops.size() == 0) return m * n;
        
        int a = INT32_MAX;
        int b = INT32_MAX;
        for (vector<int> op : ops) {
            a = a > op[0] ? op[0] : a;
            b = b > op[1] ? op[1] : b;
        }

        return a * b;
    }
};
