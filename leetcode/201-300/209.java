/**
 * 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int i = 0;
        int len = Integer.MAX_VALUE;
        int start = 0;

        while (i < nums.length) {
            if (nums[i] == s) return 1;

            if (sum + nums[i] < s) {
                sum = sum + nums[i];
                i++;
            } else {
                len = Math.min(len, i - start + 1);
                sum = sum - nums[start];
                start++;
            }
        }

        return len == Integer.MAX_VALUE ? 0 : len;
    }
}