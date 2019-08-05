#include <vector>

using std::vector;
using std::sort;

class Solution {
public:
    int threeSumSmaller(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int res = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1, k = nums.size() - 1; j < k;) {
                // 排序后 如果右指针和左指针在一起满足条件
                // 则当前数 左指针 和右指针向左所有数都满足条件
                if (nums[i] + nums[j] + nums[k] < target) {
                    res += k - j;
                    j++;
                }
                else k--;
            }
        }

        return res;
    }
};