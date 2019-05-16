/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int[] res = {-1, -1};
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            
            if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        if (index == -1) return res;

        low = index;
        high = index;
        while (high + 1 < nums.length && nums[high + 1] == target) high++;
        while (low - 1 >= 0 && nums[low - 1] == target) low--;
        
        res[0] = low;
        res[1] = high;

        return res;
    }
}