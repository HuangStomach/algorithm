// 超级丑数
// 编写一段程序来查找第 n 个超级丑数。
// 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。

#include <vector>

using std::vector;

class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int> &primes) {
        int k = primes.size();
        int *res = new int[n];
        res[0] = 1;
        int **pos = new int *[k];
        for (int i = 0; i < k; i++) {
            pos[i] = res; //初始化指针数组
        }
        int next = 1; //下一个存放位置
        while (next < n) {
            int min1 = INT_MAX;
            for (int i = 0; i < k; i++) {
                min1 = (min1 < (*pos[i] * primes[i])) ? min1 : (*pos[i] * primes[i]); //找出下一个该存放的丑数
            }
            res[next] = min1;
            //找到指针的位置
            for (int i = 0; i < k; i++) {
                while (*pos[i] * primes[i] <= res[next]) {
                    pos[i]++;
                }
            }
            next++;
        }
        return res[n - 1];
    }
};