/**
 * 删除排序数组中的重复项 II
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int left = 0;
        int times = 1;
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == num) {
                if (times == 1) {
                    nums[++left] = nums[i];
                    times++;
                }
            }
            else {
                nums[++left] = nums[i];
                times = 1;
                num = nums[i];
            }
        }

        return left + 1;
    }
}