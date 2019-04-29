/**
 * 除自身以外数组的乘积
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        right[0] = 1;
        int[] result = new int[n];

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[i] = right[i - 1] * nums[n - i];
        }
        
        for(int i = 0; i < n; i++){
            result[i] = left[i] * right[n - i - 1];
        }
        return result;
    }
}