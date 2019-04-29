/**
 * 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 */
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0]; 
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                max = Math.max(max * nums[i], nums[i]);
                min = Math.min(min * nums[i], nums[i]);
            }
            else {
                int max_temp = max;
                max = Math.max(min * nums[i], nums[i]);
                min = Math.min(max_temp * nums[i], nums[i]);
            }
            res = Math.max(max, res);
        }

        return res;
    }
}