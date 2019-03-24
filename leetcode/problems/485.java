/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) return 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        String[] strs = sb.toString().split("0");

        int max = 0;
        for (int i = 0; i < strs.length; i++) {
            if (max < strs[i].length()) max = strs[i].length();
        }
        return max;
    }
}