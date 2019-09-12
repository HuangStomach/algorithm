// 整数拆分
// 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
// 令dp[i]表示整数i对应的最大乘积
// 那么dp[i]的值应是 dp[j] * (i-j), j属于[1, i - 1]的最大值
// 同时注意dp[i]对应的值是经过拆分了的，所以还应判断两个数拆分的情况，即j * (i-j) 的值，取最大即可。

#include <vector>
#include <algorithm>

using std::vector;
using std::max;

class Solution {
public:
    int integerBreak(int n) {
        vector<int> dp(n + 1, 0);
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = i - 1; j >= 1; j--) {
                dp[i] = max(dp[i], dp[j] * (i - j));
                dp[i] = max(dp[i], j * (i - j));
            }
        }
        return dp[n];
    }
};