/**
 * 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        return binary(nums, 0, nums.length - 1, target);
    }

    public int binary(int[] nums, int low, int high, int target) {
        if (nums[low] > nums[high]) {
            int mid = low + (high - low) / 2;
            int left = binary(nums, low, mid, target);
            int right = binary(nums, mid + 1, high, target);
            return Math.max(left, right);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int current = nums[mid];
            if (current == target) return mid;

            if (current > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}