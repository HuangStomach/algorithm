// 摆动排序
// 给你一个无序的数组 nums, 将该数字 原地 重排后使得 nums[0] <= nums[1] >= nums[2] <= nums[3]...。

#include <vector>

using std::vector;
using std::swap;

class Solution {
public:
    void wiggleSort(vector<int> &nums) {
        int size = nums.size();
        if (size <= 1) return;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (((i % 2 == 0) && nums[i] > nums[i + 1])
                || ((i % 2 == 1) && nums[i] < nums[i + 1])) {
                swap(nums[i], nums[i + 1]);
            }
        }
    }
};