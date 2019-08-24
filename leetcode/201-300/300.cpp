// 最长上升子序列
// 给定一个无序的整数数组，找到其中最长上升子序列的长度。

#include <vector>

using std::lower_bound;
using std::vector;

class Solution {
public:
    int lengthOfLIS(vector<int> &nums) {
        if (nums.size() == 0) return 0;

        int len = 0;
        int dp[nums.size()];
        dp[0] = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            }
            else {
                int j = lower_bound(dp, dp + len, nums[i]) - dp;
                dp[j] = nums[i];
            }
        }
        return len + 1;
    }
};