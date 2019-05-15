/**
 * 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int val = nums[i];
            if (val >= 0 && target < 0) break;
            
            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = val + nums[low] + nums[high];
                if (sum == target) return target;
                if (Math.abs(sum - target) < Math.abs(res - target)) res = sum;
                
                if (nums[low] + nums[high] + val > target) high--;
                else low++;
            }
        }

        return res;
    }
}