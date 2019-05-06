/**
 * 摆动排序 II
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 */

import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int[] array = nums.clone();
        Arrays.sort(array);
        int i = (nums.length + 1) / 2;
        int j = nums.length;
        for (int k = 0; k < nums.length; k++) {
            nums[k] = k % 2 == 0 ? array[--i] : array[--j];
        }
    }
}