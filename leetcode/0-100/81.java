/**
 * 搜索旋转排序数组 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 */
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            while (low < high && nums[low] == nums[low + 1]) low++;
            while (low < high && nums[high] == nums[high - 1]) high--;

            int mid = low + (high - low) / 2;
            int current = nums[mid];
            if (current == target) return true;

            if (current >= nums[low]) {
                if (target < current && target >= nums[low]) high = mid - 1;
                else low = mid + 1;
            }
            else {
                if (target > current && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            } 
        }
        return false;
    }
}