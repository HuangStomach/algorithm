/** 
 * 594. 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 */
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
    unordered_map<int, int> map;
    int findLHS(vector<int>& nums) {
        int res = 0;
        for (int num : nums) {
            map[num]++;

            if (map[num - 1] > 0) res = max(res, map[num - 1] + map[num]);
            if (map[num + 1] > 0) res = max(res, map[num + 1] + map[num]);
        }

        return res;
    }
};
