// 和等于 k 的最长子数组长度
// 给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。
#include <vector>
#include <map>

using std::vector;
using std::map;
using std::max;

class Solution {
public:
    int maxSubArrayLen(vector<int>& nums, int k) {
        map<int, int> map;
        int sum = 0;
        int ans = 0;

        map[0] = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];

            if (!map.count(sum)) map[sum] = i + 1;
            if (map.count(sum - k)) {
                ans = max(ans, i + 1 - map[sum - k]);
            }
        }
        
        return ans;
    }
};